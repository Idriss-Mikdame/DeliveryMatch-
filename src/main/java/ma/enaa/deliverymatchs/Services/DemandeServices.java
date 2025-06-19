package ma.enaa.deliverymatchs.Services;

import ma.enaa.deliverymatchs.Dto.DemandeDto;
import ma.enaa.deliverymatchs.Mapper.DeamndeMapper;
import ma.enaa.deliverymatchs.Model.Annonce;
import ma.enaa.deliverymatchs.Model.Demande;
import ma.enaa.deliverymatchs.Model.Expediteur;
import ma.enaa.deliverymatchs.Model.User;
import ma.enaa.deliverymatchs.Repo.AnnonceRepository;
import ma.enaa.deliverymatchs.Repo.DemandeRepository;
import ma.enaa.deliverymatchs.Repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemandeServices {
    private final DemandeRepository demandeRepository;
    private final DeamndeMapper demandeMapper;
    private  final UserRepository userRepository;
    private final AnnonceRepository annonceRepository;


    public DemandeServices(DemandeRepository demandeRepository, DeamndeMapper demandeMapper, UserRepository userRepository, AnnonceRepository annonceRepository) {
        this.demandeRepository = demandeRepository;
        this.demandeMapper = demandeMapper;
        this.userRepository = userRepository;
        this.annonceRepository = annonceRepository;
    }

    public DemandeDto AjouterDemande(Long expideteurid, DemandeDto demandeDto) {
        User user = userRepository.findById(expideteurid)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable avec l’ID : " + expideteurid));

        if (!(user instanceof Expediteur)) {
            throw new RuntimeException("L'utilisateur avec l’ID " + expideteurid + " n'est pas un expéditeur");
        }

        Demande demande = demandeMapper.toEntity(demandeDto);
        demande.setDateDemande(new Date());
        demande.setExpediteur((Expediteur) user);

        return demandeMapper.toDto(demandeRepository.save(demande));
    }
    public List<DemandeDto> ListDemande(){
        return demandeRepository.findAll().stream()
                .map(demandeMapper::toDto)
                .collect(Collectors.toList());
    }

        public DemandeDto ObtenirParid(Long id){
            return demandeRepository.findById(id)
                    .map(demandeMapper::toDto)
                    .orElseThrow(()-> new RuntimeException("Demande Non trouvé"));
        }

    public  List<DemandeDto> ObtenirExpediteurparId(Long expediteur){
        return demandeRepository.findByExpediteurId(expediteur).stream()
                .map(demandeMapper::toDto).collect(Collectors.toList());
    }

    public void Supprimer(Long id){
        demandeRepository.deleteById(id);
    }

    public DemandeDto AssignerAnnonce(Long demandeId ,Long annonceId){
        Demande demande = demandeRepository.findById(demandeId).orElseThrow(()-> new RuntimeException("Deamnde introuvable"));
        Annonce annonce = annonceRepository.findById(annonceId).orElseThrow(()-> new RuntimeException("Annonce introuvable"));
        demande.setAnnonce(annonce);
        return demandeMapper.toDto(demandeRepository.save(demande));
    }

    public List<DemandeDto> OptenirParAnnonce(Long annonceId){
        return demandeRepository.findByAnnonceId(annonceId).stream()
                .map(demandeMapper::toDto)
                .collect(Collectors.toList());
    }
}