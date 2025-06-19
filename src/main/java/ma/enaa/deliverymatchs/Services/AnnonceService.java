package ma.enaa.deliverymatchs.Services;

import ma.enaa.deliverymatchs.Dto.AnnonceDto;
import ma.enaa.deliverymatchs.Mapper.AnnonceMapper;
import ma.enaa.deliverymatchs.Model.Annonce;
import ma.enaa.deliverymatchs.Model.Conducteur;
import ma.enaa.deliverymatchs.Repo.AnnonceRepository;
import ma.enaa.deliverymatchs.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnonceService {


    private  final  AnnonceRepository annonceRepository;


    private  final  UserRepository userRepository;

      private  final AnnonceMapper annonnceMapper;

    public AnnonceService(AnnonceRepository annonceRepository, UserRepository userRepository, AnnonceMapper annonnceMapper) {
        this.annonceRepository = annonceRepository;
        this.userRepository = userRepository;
        this.annonnceMapper = annonnceMapper;
    }


    public AnnonceDto createAnnonce(Long conducteurId, AnnonceDto annonceDto) {
        Conducteur conducteur = (Conducteur) userRepository.findById(conducteurId)
                .orElseThrow(() -> new RuntimeException("Conducteur non trouvé"));

        Annonce annonce = annonnceMapper.toEntity(annonceDto);
        annonce.setConducteur(conducteur);

        Annonce saved = annonceRepository.save(annonce);
        return annonnceMapper.toDto(saved);
    }

    public List<AnnonceDto> getAllAnnonces() {
        return annonceRepository.findAll()
                .stream()
                .map(annonnceMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<AnnonceDto> getAnnoncesByConducteurId(Long conducteurId) {
        return annonceRepository.findByConducteurId(conducteurId)
                .stream()
                .map(annonnceMapper::toDto)
                .collect(Collectors.toList());
    }

    public AnnonceDto getAnnonceById(Long id) {
        Annonce annonce = annonceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Annonce non trouvée"));
        return annonnceMapper.toDto(annonce);
    }

    public void deleteAnnonce(Long id) {
        annonceRepository.deleteById(id);
    }
}
