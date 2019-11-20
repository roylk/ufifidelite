/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.dao;

import com.ufi.fidelite.entities.UfPays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author R. KOUANI
 */
public interface UfPaysRepository extends JpaRepository<UfPays, String>{
    
    @Query("select p from UfPays p where p.code = ?1")
    UfPays findByCodePays(String code);
    
}
