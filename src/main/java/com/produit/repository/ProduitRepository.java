package com.produit.repository;

import com.produit.models.Produit;
import com.produit.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProduitRepository extends JpaRepository<Produit, Long> {

    List<Produit> findByNomProduit(String name);
    List<Produit> findByNomProduitContains(String name);

    // queries methods with JPQL
    @Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
    List<Produit> findByPrixProduit (@Param("nom") String nomProduit, @Param("prix") double prixProduit);

    @Query("select p  from Produit p where p.categorie = :cat")
    List<Produit> findByCategorie(@Param("cat") Categorie cat);

    List<Produit> findByCategorieIdCat(long idCategorie);

}
