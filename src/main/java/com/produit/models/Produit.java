package com.produit.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Getter
@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long idProduit;
    @Setter
    @NotNull
    private String nomProduit;

    @Setter
    @Min(1)
    @Max(1000)
    private double prixProduit;

    @Setter
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
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

    @Override
    public String toString() {
        return String.format("Id: %d,\nnom: %s \nPrix: %.2f", idProduit, nomProduit, prixProduit);
    }

}
