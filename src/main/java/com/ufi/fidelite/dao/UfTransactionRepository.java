/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.dao;

import com.ufi.fidelite.entities.UfTransaction;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author R. KOUANI
 */
public interface UfTransactionRepository extends JpaRepository<UfTransaction, String>{
    
    @Query("select t from UfTransaction t where t.transactionId like :x")
	public Page<UfTransaction> findTransaction(@Param("x") String mc, Pageable pageable);
        
        @Query("select t from UfTransaction t where t.transactionId=:x")
	public UfTransaction findbyId(@Param("x") String code);
        
       @Query("select t from UfTransaction t where t.montantInitial=:x and t.carte.numero=:y and t.statut=false")
        public List<UfTransaction> findAllByAmount(@Param("x")Double montant,@Param("y")String carte); 
        
         
}
