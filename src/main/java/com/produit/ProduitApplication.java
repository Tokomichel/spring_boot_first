package com.produit;

import com.produit.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProduitApplication implements CommandLineRunner {

	@Autowired
    ProduitService produitService;

	public static void main(String[] args) {
		SpringApplication.run(ProduitApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception
	{
//		produitService.saveProduit(new Produit("Smartphone haut de gamme", 800, new Date()));
//		produitService.saveProduit(new Produit("Ordinateur portable gamer", 1200, new Date()));
//		produitService.saveProduit(new Produit("Tablette tactile", 300, new Date()));
//		produitService.saveProduit(new Produit("Montre connectée", 250, new Date()));
//		produitService.saveProduit(new Produit("Enceinte Bluetooth", 50, new Date()));
//		produitService.saveProduit(new Produit("Console de jeux vidéo", 400, new Date()));
//		produitService.saveProduit(new Produit("Appareil photo numérique", 600, new Date()));
//		produitService.saveProduit(new Produit("Drone de loisir", 200, new Date()));
//		produitService.saveProduit(new Produit("Casque de réalité virtuelle", 350, new Date()));
//		produitService.saveProduit(new Produit("Imprimante 3D", 500, new Date()));
//		produitService.saveProduit(new Produit("Robot aspirateur", 300, new Date()));
//		produitService.saveProduit(new Produit("Vélo électrique", 1500, new Date()));

	}
}
