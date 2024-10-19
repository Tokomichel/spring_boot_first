package com.produit.services;

import com.produit.models.Categorie;
import com.produit.models.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ProduitFactory {

    Produit saveProduit(Produit produit);
    Produit updateProduit(Produit produit);
    Produit getProduit(Long id);

    List<Produit> getProduits();
    void deleteProduitById(Long id);
    void deleteProduit(Produit produit);

    //pagination
    Page<Produit> getProduitsPerPage(int page, int size);

    // Ajout des machins trucs là

    List<Produit> findByNomProduit(String name);
    List<Produit> findByNomProduitContains(String name);

    // queries methods with JPQL
    @Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
    List<Produit> findByPrixProduit (@Param("nom") String nomProduit, @Param("prix") double prixProduit);

    @Query("select p  from Produit p where p.categorie = :cat")
    List<Produit> findByCategorie(@Param("cat") Categorie cat);

    List<Produit> findByCategorieIdCategorie(long idCategorie);

}
