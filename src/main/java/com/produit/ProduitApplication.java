package com.produit;

/*
import com.produit.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
*/

import com.produit.models.Categorie;
import com.produit.models.Produit;
import com.produit.repository.CategorieRepository;
import com.produit.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ProduitApplication{

//	@Autowired
//	CategorieRepository repo;

	@Autowired
	private ProduitRepository produitRepository;

	public static void main(String[] args) {

		SpringApplication.run(ProduitApplication.class, args);

	}

}
