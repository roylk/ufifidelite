/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.dao;

import com.ufi.fidelite.entities.UfRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author R. KOUANI
 */
public interface UfRoleRepository extends JpaRepository<UfRole, Integer> {
    
    @Query("SELECT r FROM UfRole r WHERE r.libele = ?1")
    UfRole getOneByCode(String libele); 
    
    
    
    
}
