package org.sid.Dao;

import java.util.List;

import org.sid.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProduitRepository extends JpaRepository<Produit,Long>{
	@Query("select p from Produit p where p.designation like :x")
	public List<Produit> produitsParMC(@Param("x")String mc);
}
