/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.dao;

import com.ufi.fidelite.entities.UfCategorieCarte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author R. KOUANI
 */
public interface UfCategorieCarteRepository extends JpaRepository<UfCategorieCarte, String>{
    
    @Query("select c from UfCommercant c where c.nom like :x")
	public Page<UfCategorieCarte> findCategorieCarte(@Param("x") String mc, Pageable pageable);
        
    @Query("select c from UfCommercant c where c.code=:x")
	public UfCategorieCarte findbyId(@Param("x") String code);
    
}
