package ma.enaa.deliverymatchs.Controller;

import ma.enaa.deliverymatchs.Dto.AnnonceDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Annonces")
@CrossOrigin(origins = "*") // Autorise les requêtes CORS (à adapter si besoin)
public class AnnonceController {

  private final ma.enaa.deliverymatchs.Services.AnnonceService annonceService;

    public AnnonceController(ma.enaa.deliverymatchs.Services.AnnonceService annonceService) {
        this.annonceService = annonceService;
    }


    @PostMapping("/{conducteurId}")
    public ResponseEntity<AnnonceDto> createAnnonce(
            @PathVariable Long conducteurId,
            @RequestBody AnnonceDto annonceDto
    ) {
        AnnonceDto created = annonceService.createAnnonce(conducteurId, annonceDto);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<AnnonceDto>> getAllAnnonces() {
        List<AnnonceDto> list = annonceService.getAllAnnonces();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/conducteur/{conducteurId}")
    public ResponseEntity<List<AnnonceDto>> getAnnoncesByConducteurId(@PathVariable Long conducteurId) {
        List<AnnonceDto> list = annonceService.getAnnoncesByConducteurId(conducteurId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnonceDto> getAnnonceById(@PathVariable Long id) {
        AnnonceDto annonce = annonceService.getAnnonceById(id);
        return ResponseEntity.ok(annonce);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnonce(@PathVariable Long id) {
        annonceService.deleteAnnonce(id);
        return ResponseEntity.noContent().build();
    }
}
