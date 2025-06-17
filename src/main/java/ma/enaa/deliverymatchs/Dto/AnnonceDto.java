package ma.enaa.deliverymatchs.Dto;

import lombok.Value;
import ma.enaa.deliverymatchs.Model.Annonce;

import java.io.Serializable;
import java.util.Date;


public class AnnonceDto implements Serializable {
    Long id;
    String lieuDepart;
    String etapes;
    String destination;
    String dimensionMax;
    String typeDeMarchandise;
    String capaciteDisponible;
    Date date;

    public AnnonceDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLieuDepart() {
        return lieuDepart;
    }

    public void setLieuDepart(String lieuDepart) {
        this.lieuDepart = lieuDepart;
    }

    public String getEtapes() {
        return etapes;
    }

    public void setEtapes(String etapes) {
        this.etapes = etapes;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDimensionMax() {
        return dimensionMax;
    }

    public void setDimensionMax(String dimensionMax) {
        this.dimensionMax = dimensionMax;
    }

    public String getTypeDeMarchandise() {
        return typeDeMarchandise;
    }

    public void setTypeDeMarchandise(String typeDeMarchandise) {
        this.typeDeMarchandise = typeDeMarchandise;
    }

    public String getCapaciteDisponible() {
        return capaciteDisponible;
    }

    public void setCapaciteDisponible(String capaciteDisponible) {
        this.capaciteDisponible = capaciteDisponible;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}