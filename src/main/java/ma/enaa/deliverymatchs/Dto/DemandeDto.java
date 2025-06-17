package ma.enaa.deliverymatchs.Dto;

import lombok.Value;
import ma.enaa.deliverymatchs.Model.Demande;
import ma.enaa.deliverymatchs.Model.Status;

import java.util.Date;


public class DemandeDto  {
    Long id;
    Status status;
    Date dateDemande;
    String dimension;
    double poids;
    String type;

    public DemandeDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}