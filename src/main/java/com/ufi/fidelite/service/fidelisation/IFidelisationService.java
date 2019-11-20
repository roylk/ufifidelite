/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.service.fidelisation;

import com.ufi.fidelite.dao.Reponse;
import com.ufi.fidelite.entities.UfOffre;
import com.ufi.fidelite.entities.UfPalier;
import com.ufi.fidelite.entities.UfTypeOffre;
import com.ufi.fidelite.service.*;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author R. KOUANI
 */
public interface IFidelisationService {
    
   public  List<UfTypeOffre> listeTypeOffre();
    
   public UfTypeOffre saveTypeOffre(UfTypeOffre type );
   public UfTypeOffre searchTypeOffre (String code);
   public UfTypeOffre updateTypeOffre(UfTypeOffre type);
   public void deleteTypeOffre(String code);
   
   
  public  List<UfOffre> listeOffre();
  public Reponse listeOffre(Pageable pageable);
    
   public UfOffre saveOffre(UfOffre offre );
   public UfOffre searchOffre (Integer id);
   public UfOffre updateOffre(UfOffre offre);
   public void deleteOffre(Integer id);
   
   public  List<UfPalier> listePalier();
  public Reponse listePalier(Pageable pageable);
    
   public UfPalier savePalier(UfPalier palier );
   public UfPalier searchPalier (Integer id);
   public UfOffre getOneOffre(String code); 
   public UfPalier updatePalier(UfPalier palier);
   public void deletePalier(Integer id);
   public Reponse getAllOffre();
   public Reponse getAllTypeOffre();
   public Reponse getAllPallier();
   
   
    
}
