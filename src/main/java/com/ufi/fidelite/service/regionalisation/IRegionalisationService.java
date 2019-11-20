/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.service.regionalisation;

import com.ufi.fidelite.dao.Reponse;
import com.ufi.fidelite.entities.UfPays;
import com.ufi.fidelite.entities.UfRegion;
import com.ufi.fidelite.entities.UfVille;
import java.util.List;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author R. KOUANI
 */
public interface IRegionalisationService {
    
    public List<UfVille> listeVille();
    public List<UfRegion> listeRegion();
    public List<UfPays> listePays();
    public Reponse listeVille(Pageable pageable);
    public Reponse listeRegion(Pageable pageable);
    public Reponse listePays(Pageable pageable);
    
    public List<UfRegion> getAllRegionByPays(String codeP);
    
    public List<UfVille> getAllVilleByRegion(String codeR);
    
    
    public UfPays SavePays(UfPays pays);
    
    public UfVille saveVille(UfVille ville);
    
    public UfRegion saveRegion(UfRegion region);
    
    public UfVille getOneVille(Integer id);
    
    public UfRegion getOneRegion(Integer id);
    
    public UfPays getOnePays(String code);
    
    public UfVille getOneVilleByCode(String code);
    
    
    
    public UfPays updatePays(UfPays pays);
    public UfVille updateVille(UfVille ville);
    public UfRegion updateRegion(UfRegion region);
    
    
    public void deletePays(String  code);
    public void  deleteVille(Integer id);
    public void deleteRegion(Integer id);
    public Reponse GetAllPays();
    public Reponse getAllRegion();
    public Reponse getAllVille();
    
  
    
    
    
    
    
    
}
