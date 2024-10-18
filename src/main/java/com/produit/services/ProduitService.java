package com.produit.services;

import com.produit.models.Produit;
import com.produit.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService implements ProduitFactory{

    @Autowired
    ProduitRepository produitRepository;

    @Override
    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit updateProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit getProduit(Long id) {
        return produitRepository.findById(id).get();
    }

    @Override
    public List<Produit> getProduits() {
        return produitRepository.findAll();
    }

    @Override
    public void deleteProduitById(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public void deleteProduit(Produit produit) {
        Long id = produit.getIdProduit();
        produitRepository.deleteById(id);
    }

    @Override
    public Page<Produit> getProduitsPerPage(int page, int size) {
        return produitRepository.findAll(PageRequest.of(page, size));
    }
}
