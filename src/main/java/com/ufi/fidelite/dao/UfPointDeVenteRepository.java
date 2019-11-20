/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.dao;


import com.ufi.fidelite.entities.UfPointDeVente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author R. KOUANI
 */
public interface UfPointDeVenteRepository extends JpaRepository<UfPointDeVente, String>{
    
    @Query("select p from UfPointDeVente p where p.nom like :x")
	public Page<UfPointDeVente> findPointDeVente(@Param("x") String mc, Pageable pageable);
        
        @Query("select p from UfPointDeVente p where p.code=:x")
	public UfPointDeVente findbyId(@Param("x") String code);
    
}
