/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.dao;

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
public interface UfClientRepository extends JpaRepository<UfClient, String>{
    
    @Query("select c from UfClient c where c.nom like :x")
	public Page<UfClient> findClient(@Param("x") String mc, Pageable pageable);
        
        @Query("select c from UfClient c where c.code=:x")
	public UfClient findbyId(@Param("x") String code);
        
        
         @Query("delete from UfClient c where c.code=:x")
	public void deleteByCode(@Param("x") String code);
    
    
}
