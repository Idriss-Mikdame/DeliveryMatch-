package ma.enaa.deliverymatchs.Auth;

import lombok.Builder;
import ma.enaa.deliverymatchs.Model.Role;
@Builder
public class RegisterRequest {

    private String prenom;
    private String nom;
    private String email;
    private String motDePasse;
    private Role role;

    public RegisterRequest(String prenom, String nom, String email, String motDePasse, Role role) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
