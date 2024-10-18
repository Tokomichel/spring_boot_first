package com.produit.controllers;


import com.produit.models.Produit;
import com.produit.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProduitController {

    @Autowired
    ProduitService produitService;

    @GetMapping(path = "/first")
    public String viewHandler() {
        return "apple";
    }

    @RequestMapping(path = "/listeProduit")
    public String listeProduit(ModelMap modelMap,
                               @RequestParam (name = "page", defaultValue = "3") int page,
                               @RequestParam (name = "size", defaultValue = "4") int size
    ) {
//        List<Produit> produits = produitService.getProduits();
//        System.out.println(produits.getFirst());
//        modelMap.addAttribute("produits", produits);
//        return "listeProduit";



        Page<Produit> prods = produitService.getProduitsPerPage(page, size);

        modelMap.addAttribute("produits", prods);
        modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);

        return "listeProduit";
    }

    @RequestMapping(path = "/deleteProduit")
    public String deleteProduit(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "page") String page
    ) {
        System.out.println("Suppresion de: " + produitService.getProduit(id).getNomProduit() + " effectué");
        produitService.deleteProduitById(id);

        return String.format("redirect:/listeProduit?page=%s&size=", page);
    }


}