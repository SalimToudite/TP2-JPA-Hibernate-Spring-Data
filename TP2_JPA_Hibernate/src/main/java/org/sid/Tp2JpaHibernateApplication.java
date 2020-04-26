package org.sid;

import java.util.List;

import org.sid.Dao.CategorieRepository;
import org.sid.Dao.ProduitRepository;
import org.sid.entities.Categorie;
import org.sid.entities.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Tp2JpaHibernateApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Tp2JpaHibernateApplication.class, args);
		CategorieRepository categorieDao = ctx.getBean(CategorieRepository.class);
		ProduitRepository produitDao = ctx.getBean(ProduitRepository.class);
		
		Categorie c1 = categorieDao.save(new Categorie("Computer"));
		Categorie c2 = categorieDao.save(new Categorie("Souris"));
		Categorie c3 = categorieDao.save(new Categorie("Imprimante"));
		produitDao.save(new Produit("LX213",9000,7,c1));
		produitDao.save(new Produit("Dell XPS",2000,5,c3));
		produitDao.save(new Produit("HP Amone",100,4,c2));
		
		System.out.println("Produit:***************************");
		List<Produit> produits = produitDao.produitsParMC("%H%");
		for (Produit p : produits) {
			System.out.println("Des: "+p.getDesignation());
			System.out.println("Prix: "+p.getPrix());
			System.out.println("Quantite: "+p.getQuantite());
		
		}
		System.out.println("Categorie:***************************");
		List<Categorie> categories = categorieDao.findAll();
		for (Categorie c : categories) {
			System.out.println("Nom Categorie: "+c.getNomCategorie());
		}
		
		
	}

}
