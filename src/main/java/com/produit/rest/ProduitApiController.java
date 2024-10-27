package com.produit.rest;


import com.produit.models.Produit;
import com.produit.services.ProduitFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
// import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProduitApiController {

    @Autowired
    ProduitFactory produitService;

    @GetMapping
    List<Produit> getAllProduit()
    {
        return produitService.getProduits();
    }

    @GetMapping(value = "/{id}")
    Produit getProduitById(@PathVariable Long id)
    {

        return produitService.getProduit(id);
    }

    @PostMapping
    String saveProduit(@RequestBody Produit produit)
    {
        produitService.saveProduit(produit);
        return "Produits saved successfully";
    }

    @PutMapping
    String updateProduit(@RequestBody Produit produit)
    {
        produitService.updateProduit(produit);
        return "Produits updated successfully";
    }

    @DeleteMapping(value = "/{id}")
    String deleteProduit(@PathVariable Long id)
    {
        produitService.deleteProduitById(id);

        return String.format("Produits %d deleted successfully", id);
    }

    @GetMapping(value = "prodsCat/{idCat}")
    List<Produit> getByCatId(@PathVariable Long idCat)
    {
        return produitService.findByCategorieIdCategorie(idCat);
    }
}
