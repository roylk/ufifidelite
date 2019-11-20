/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.dao;


import com.ufi.fidelite.entities.UfTerminal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;





/**
 *
 * @author R. KOUANI
 */
public interface UfTerminalRepository extends JpaRepository<UfTerminal, String> {
    
    @Query("select t from UfTerminal t where t.designation like :x")
	public Page<UfTerminal> findTerminal(@Param("x") String mc, Pageable pageable);
        
        @Query("select t from UfTerminal t where t.code=:x")
	public UfTerminal findbyId(@Param("x") String code);
    
}
