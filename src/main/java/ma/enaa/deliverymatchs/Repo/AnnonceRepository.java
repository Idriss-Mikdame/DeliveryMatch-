package ma.enaa.deliverymatchs.Repo;

import ma.enaa.deliverymatchs.Model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
    List<Annonce> findByConducteurId(Long conducteurId);
}
