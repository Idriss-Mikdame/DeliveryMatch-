package ma.enaa.deliverymatchs.Repo;

import ma.enaa.deliverymatchs.Model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {
    List<Demande> findByExpediteurId(Long expediteurId);
    List<Demande> findByAnnonceId(Long annonceId);
}
