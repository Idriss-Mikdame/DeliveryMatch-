package ma.enaa.deliverymatchs.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Conducteur extends User{
    public Conducteur() {
        this.setRole(Role.CONDUCTEUR);
    }
    @OneToMany(mappedBy = "conducteur")
    private List<Annonce> annonces;

    public List<Annonce> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }
}
