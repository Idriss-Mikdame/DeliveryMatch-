package ma.enaa.deliverymatchs.Controller;

import ma.enaa.deliverymatchs.Dto.AnnonceDto;
import ma.enaa.deliverymatchs.Dto.DemandeDto;
import ma.enaa.deliverymatchs.Services.DemandeServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demande")
@CrossOrigin(origins = "*")
public class DemandeController {

    private final DemandeServices demandeServices;

    public DemandeController(DemandeServices demandeServices) {
        this.demandeServices = demandeServices;
    }

    @PostMapping
    public ResponseEntity<DemandeDto> AjouterDemande(@RequestBody DemandeDto demandeDto){
        DemandeDto ajouter = demandeServices.AjouterDemande(demandeDto);
        return new ResponseEntity<>(ajouter, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<DemandeDto>> ListDemande(){
        return ResponseEntity.ok(demandeServices.ListDemande());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DemandeDto> updateDemande(
            @PathVariable Long id,
            @RequestBody DemandeDto dto) {
        return ResponseEntity.ok(demandeServices.update(id, dto));
    }
        @GetMapping("/{id}")
        public  ResponseEntity<DemandeDto> getDemandeById(@PathVariable Long id){
            return  ResponseEntity.ok(demandeServices.ObtenirParid(id));
        }
    @GetMapping("/expediteur/{id}")
    public  ResponseEntity<List<DemandeDto>> AfficherDemandesByExpediteur(@PathVariable Long id){
        return ResponseEntity.ok(demandeServices.ObtenirExpediteurparId(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDemande(@PathVariable Long id) {
        demandeServices.Supprimer(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{demandeId}/annonce/{annonceId}")
    public ResponseEntity<DemandeDto> assignerAnnonce(@PathVariable Long demandeId,@PathVariable Long annonceId){
        DemandeDto demandeDto = demandeServices.AssignerAnnonce(demandeId,annonceId);
        return ResponseEntity.ok(demandeDto);
    }
    @GetMapping("/annonce/{annonceId}")
    public ResponseEntity<List<DemandeDto>> AfficherDeamndeParAnnonce(@PathVariable Long annonceId){
        return ResponseEntity.ok(demandeServices.OptenirParAnnonce(annonceId));
    }

}