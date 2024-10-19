package com.produit.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long idCat;

    private String nomCat;
    private String descriptionCat;

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Produit> produits;

}
