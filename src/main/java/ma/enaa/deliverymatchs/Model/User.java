package ma.enaa.deliverymatchs.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom;
    private String prenom;
    private String email;
    private String motDepass;
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean estVerifie;


}
