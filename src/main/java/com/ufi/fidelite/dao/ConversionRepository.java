/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.dao;

import com.ufi.fidelite.entities.Conversion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author R. KOUANI
 */
public interface ConversionRepository extends JpaRepository<Conversion, Integer> {
    
    @Query("SELECT c FROM Conversion c WHERE c.id = :id")
    Conversion findByIdConversion(Integer id);
    
     @Query("SELECT c FROM Conversion c WHERE c.commercant.code = :x")
      List<Conversion> getConversionByCom(@Param("x")String commercant);
    
}
