/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.dao;


import com.ufi.fidelite.entities.UfPalier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



/**
 *
 * @author R. KOUANI
 */
public interface UfPalierRepository extends JpaRepository<UfPalier, Integer> {
    
    /*@Query("select p from UfPalier p where p.code=:x")
	public UfPalier findbyCode(@Param("x") String code);*/
    
}
