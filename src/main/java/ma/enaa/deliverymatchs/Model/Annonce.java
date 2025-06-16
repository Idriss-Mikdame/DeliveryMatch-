package ma.enaa.deliverymatchs.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lieuDepart;
    private String etapes;
    private String destination;
    private String dimensionMax;
    private String typeDeMarchandise;
    private String capaciteDisponible;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "conducteur_id")
    private Conducteur conducteur;

    @OneToMany(mappedBy = "annonce")
    private List<Demande> demandes;
}