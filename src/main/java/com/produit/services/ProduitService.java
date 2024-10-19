package com.produit.services;

import com.produit.models.Categorie;
import com.produit.models.Produit;
import com.produit.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.ClassUtils.isPresent;

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

        if (produitRepository.existsById(id)) {
            return produitRepository.findById(id).get();
        }
        return null;
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

    // Ajout des machins là
    @Override
    public List<Produit> findByNomProduit(String name) {
        return produitRepository.findByNomProduit(name);
    }

    @Override
    public List<Produit> findByNomProduitContains(String name) {
        return produitRepository.findByNomProduitContains(name);
    }

    @Override
    public List<Produit> findByPrixProduit(String nomProduit, double prixProduit) {
        return produitRepository.findByPrixProduit(nomProduit, prixProduit);
    }

    @Override
    public List<Produit> findByCategorie(Categorie cat) {
        return produitRepository.findByCategorie(cat);
    }

    @Override
    public List<Produit> findByCategorieIdCategorie(long idCategorie) {
        return produitRepository.findByCategorieIdCategorie(idCategorie);
    }
}
