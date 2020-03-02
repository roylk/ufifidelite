/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.dao;

import com.ufi.fidelite.entities.UfUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author R. KOUANI
 */
public interface UfUtilisateurRepository extends JpaRepository<UfUtilisateur, Integer> {
    
     @Query("select u from UfUtilisateur u where u.login=:x")
	public UfUtilisateur findbyLogin(@Param("x") String code);
        
        
     @Query("select u from UfUtilisateur u where u.email=:x")
	public UfUtilisateur findbyEmail(@Param("x") String code);
    
}
