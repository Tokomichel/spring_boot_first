package com.produit.rest;


import com.produit.models.Produit;
import com.produit.services.ProduitFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
