package ma.enaa.deliverymatchs.Controller;

import ma.enaa.deliverymatchs.Dto.AnnonceDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Annonces")
@CrossOrigin(origins = "*")
public class AnnonceController {

  private final ma.enaa.deliverymatchs.Services.AnnonceService annonceService;

    public AnnonceController(ma.enaa.deliverymatchs.Services.AnnonceService annonceService) {
        this.annonceService = annonceService;
    }


    @PostMapping
    public ResponseEntity<AnnonceDto> createAnnonce(@RequestBody AnnonceDto annonceDto) {
        AnnonceDto created = annonceService.createAnnonce( annonceDto);
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
    @PutMapping("/{id}")
    public ResponseEntity<AnnonceDto> UpdateAnnonce(@PathVariable Long id, @RequestBody AnnonceDto annonceDto)
    {
        return ResponseEntity.ok(annonceService.updatAnnonce(id,annonceDto));
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
