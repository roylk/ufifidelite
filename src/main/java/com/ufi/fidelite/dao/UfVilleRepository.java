/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.dao;

import com.ufi.fidelite.entities.UfVille;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author R. KOUANI
 */
public interface UfVilleRepository extends JpaRepository<UfVille, Integer>{
    
    @Query("SELECT u FROM UfVille u WHERE u.id = :id")
    UfVille findByIdVille(Integer id);
    
    @Query("SELECT u FROM UfVille u WHERE u.code = ?1")
    UfVille getOneByCode(String code); 
    
//      //@Query("select g from Personne p Gerant g where g.code=p.code AND g.type_pers ='GER'")
   @Query("select v, r from UfVille v, UfRegion r   where v.region=r.id AND r.code =?1 ")        
//   // @Query("select g from Gerant g, Personne p where g.code=p.code AND p.g.type_pers='GER'")
    List<UfVille> findAllVilleByRegion(String codeR); 
}
