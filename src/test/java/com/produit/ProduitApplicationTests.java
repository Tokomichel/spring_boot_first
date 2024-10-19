package com.produit;

import com.produit.models.Categorie;
import com.produit.models.Produit;
import com.produit.repository.CategorieRepository;
import com.produit.repository.ProduitRepository;
import com.produit.services.ProduitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProduitApplicationTests {

	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	CategorieRepository rep;
    @Autowired
    private ProduitService produitService;

	@Test
	void addProductTest()
	{
		Produit prod = new Produit("Ordinateur hp", 549.99, new Date());
		var t = produitRepository.save(prod);

		assertEquals(prod, t);
	}

	@Test
	void findById()
	{
		Produit prod = produitRepository.findById(1L).get();
		System.out.println(prod);

	}

	@Test
	void updateProduit()
	{
		Produit p = produitRepository.findById(1L).get();
		p.setPrixProduit(500.0);

		produitRepository.save(p);
	}

	@Test
	void deleteProduit()
	{
		produitRepository.deleteById(1L);
	}

	@Test
	void getAllProduit()
	{
		List<Produit> produits = produitRepository.findAll();

		for (Produit p : produits) {
			System.out.println(p);
		}
	}

//	@Test
//	public void testFindByName()
//	{
//		Page<Produit> prods = produitService.getProduitsPerPage(0, 2);
//		System.out.println(prods.getSize());
//		System.out.println(prods.getTotalElements());
//		System.out.println(prods.getTotalPages());
//		prods.getContent().forEach(System.out::println);
//	}

	@Test
	void testFindByName()
	{
		List<Produit> p = produitRepository.findByNomProduit("Ordinateur hp");

		System.out.println(p);
	}

	@Test
	void testFindByNameContains()
	{
		List<Produit> p = produitRepository.findByNomProduitContains("Ordinateur");

		System.out.println(p);
	}

	@Test
	void testJavaQueryMaethod()
	{
		List<Produit> ps = produitRepository.findByPrixProduit("Ordinateur hp", 200.0);
		System.out.println(ps);
	}

	@Test
	void testFindByCategorie()
	{

		Categorie c = new Categorie();
		c.setIdCat(1L);

		List<Produit> prods = produitRepository.findByCategorie(c);

		for(Produit p : prods)
		{
			System.out.println(p);
		}
	}
}
