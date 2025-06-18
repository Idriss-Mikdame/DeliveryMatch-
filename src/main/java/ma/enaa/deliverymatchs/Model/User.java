package ma.enaa.deliverymatchs.Model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String motDepass;

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

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean estVerifie;

    // 🔧 Constructeur vide requis par JPA
    public User() {}

    // ✅ Constructeur complet
    public User(Long id, String nom, String prenom, String email, String motDepass, Role role, boolean estVerifie) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDepass = motDepass;
        this.role = role;
        this.estVerifie = estVerifie;
    }

    // ✅ Builder manuel
    public static class Builder {
        private Long id;
        private String nom;
        private String prenom;
        private String email;
        private String motDepass;
        private Role role;
        private boolean estVerifie;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public Builder prenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder motDepass(String motDepass) {
            this.motDepass = motDepass;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public Builder estVerifie(boolean estVerifie) {
            this.estVerifie = estVerifie;
            return this;
        }

        public User build() {
            return new User(id, nom, prenom, email, motDepass, role, estVerifie);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    // Spring Security
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return motDepass;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
