/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.dao;

import com.ufi.fidelite.entities.UfCarte;
import com.ufi.fidelite.entities.UfClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author R. KOUANI
 */
public interface UfCarteRepository extends JpaRepository<UfCarte, String> {
    
    @Query("select c from UfCarte c where c.numero like :x")
	public Page<UfCarte> findCarte(@Param("x") String mc, Pageable pageable);
        
        @Query("select c from UfCarte c where c.numero=:x")
	public UfCarte findbyId(@Param("x") String code);
    
}
