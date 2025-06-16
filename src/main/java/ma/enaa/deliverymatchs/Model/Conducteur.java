package ma.enaa.deliverymatchs.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Conducteur extends User{

    @OneToMany(mappedBy = "conducteur")
    private List<Annonce> annonces;
}
