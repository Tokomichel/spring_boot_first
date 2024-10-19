package com.produit.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
public class Produit {

    @Getter
    @Id

    private Long idProduit;
    @Setter
    @Getter
    private String nomProduit;
    @Setter
    @Getter
    private double prixProduit;
    @Setter
    @Getter
    private Date dateCreation;

    @ManyToOne
    @Getter
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

    @Override
    public String toString() {
        return String.format("Id: %d,\nnom: %s \nPrix: %.2f", idProduit, nomProduit, prixProduit);
    }

}
