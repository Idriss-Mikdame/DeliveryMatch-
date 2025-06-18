package ma.enaa.deliverymatchs.Dto;

import ma.enaa.deliverymatchs.Model.Role;

import java.io.Serializable;


public class UserDto  {
    Long id;
    String nom;
    String prenom;
    String email;
    String motDepass;
    Role role;

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
}