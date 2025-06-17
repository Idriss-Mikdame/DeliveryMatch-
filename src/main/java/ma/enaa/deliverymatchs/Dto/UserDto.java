package ma.enaa.deliverymatchs.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import ma.enaa.deliverymatchs.Model.Role;
import ma.enaa.deliverymatchs.Model.User;

import java.io.Serializable;

public class UserDto  {
    Long id;
    String nom;
    String prenom;
    String email;
    String motDepass;
    Role role;
    boolean estVerifie;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDepass() {
        return motDepass;
    }

    public void setMotDepass(String motDepass) {
        this.motDepass = motDepass;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isEstVerifie() {
        return estVerifie;
    }

    public void setEstVerifie(boolean estVerifie) {
        this.estVerifie = estVerifie;
    }
}