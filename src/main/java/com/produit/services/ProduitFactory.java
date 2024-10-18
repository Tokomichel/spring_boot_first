package com.produit.services;

import com.produit.models.Produit;
import org.springframework.data.domain.Page;



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
}
