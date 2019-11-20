/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.dao;

import com.ufi.fidelite.entities.UfRegion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author R. KOUANI
 */
public interface UfRegionRepository extends JpaRepository<UfRegion, Integer>{
    
     //@Query("select g from Personne p Gerant g where g.code=p.code AND g.type_pers ='GER'")
    @Query("select r,p from UfRegion r, UfPays p where r.pays=p.code AND p.code =?1 ")        
   // @Query("select g from Gerant g, Personne p where g.code=p.code AND p.g.type_pers='GER'")
    List<UfRegion> findAllRegionByPays(String codeP); 
    
//    @Query("select c from ConseillerClient c, Personne p where c.code=p.code")
//    List<Personne> findAllConseiller();
//    
    
}
