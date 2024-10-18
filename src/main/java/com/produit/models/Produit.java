package com.produit.models;


import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Produit {

    @Id

    private Long idProduit;
    private String nomProduit;
    private double prixProduit;
    private Date dateCreation;

    @ManyToOne
    private Categorie categorie;

    //Constructors
    public Produit() {
        // Empty constructor
    }

    public Produit(String nomProduit, double prixProduit, Date dateCreation) {

        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.dateCreation = dateCreation;
    }


    //Getters


    public Long getIdProduit() {
        return idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public double getPrixProduit() {
        return prixProduit;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    // Setters
    // There is no setter for idProduit

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public void setPrixProduit(double prixProduit) {
        this.prixProduit = prixProduit;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return String.format("Id: %d,\nnom: %s \nPrix: %.2f", idProduit, nomProduit, prixProduit);
    }

}
