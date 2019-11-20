/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.dao;

import com.ufi.fidelite.entities.UfOffre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author R. KOUANI
 */
public interface UfOffreRepository extends JpaRepository<UfOffre , Integer>{
    
    @Query("select o from UfOffre o where o.code=?1")
	public UfOffre findbyCode(String code);
    
    
    
    
}
