/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.service.commercant;

import com.ufi.fidelite.dao.Reponse;
import com.ufi.fidelite.entities.Conversion;
import com.ufi.fidelite.entities.UfCategorieCarte;
import com.ufi.fidelite.entities.UfCommercant;
import com.ufi.fidelite.entities.UfPointDeVente;
import com.ufi.fidelite.entities.UfPolitiqueEvaluation;
import com.ufi.fidelite.entities.UfTerminal;
import com.ufi.fidelite.entities.UfVille;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author R. KOUANI
 */
public interface ICommercantService {
    
    public List<UfCommercant> listeCommercant();
    public Reponse listeCommercant(Pageable pageable);
    
    
    public List<UfPointDeVente> listePointDeVente();
    public Reponse listePointDeVente(Pageable pageable);
    
    public List<UfTerminal> listeTerminal();
    public Reponse listeTerminal(Pageable pageable);
    
    public List<Conversion> listeConversion();
    public Reponse listeConversion(Pageable pageable);
    
    public List<UfPolitiqueEvaluation> listePolitiqueEvaluation();
    
    public List<UfCategorieCarte> listeCategorieCarte();
    
    public Reponse listeCategorieCarte(Pageable pageable);
    
    
    
    
    
    public UfCommercant saveCommercant(UfCommercant commercant);
    public UfPointDeVente savePointDeVente(UfPointDeVente pointDeVente);
    public UfTerminal saveTerminal(UfTerminal terminal);
   
    public Conversion saveConversion(Conversion conversion);
    
    public UfPolitiqueEvaluation savePolitiqueEvaluation(UfPolitiqueEvaluation politique);
    
    public UfCategorieCarte saveCategorieCarte(UfCategorieCarte categorie);
    
    
    
    public UfVille getOneVille(Integer id);
    
    public UfVille getOneVilleByCode(String code);
    
    public UfCommercant searchCommercant(String code);
    
    public Page<UfCommercant> SearchCommercants(String mc, Pageable pageable);
    
    public UfCommercant updateCommercant(UfCommercant commercant);
    
    public void deleteCommercant(String code);
    
    public UfPointDeVente searchPointDeVente(String code);
    
    public UfPolitiqueEvaluation searchPolitiqueEvaluation(String code);
    
    public UfCategorieCarte searchCategorieCarte(String code);
    
    
    public Page<UfPointDeVente> searchPointsDeVente(String mc, Pageable pageable);
    
    public UfPointDeVente updatePointsDeVente(UfPointDeVente pointDeVente);
    
    public UfPolitiqueEvaluation updatePolitiqueEvaluation(UfPolitiqueEvaluation politique);
    
    public UfCategorieCarte updateCategorieCarte(UfCategorieCarte categorie);
    
    
    
    public void deletePointsDeVente(String code);
    
    public UfTerminal searchTerminal(String code);
    
    public Page<UfTerminal> searchTerminal(String mc, Pageable pageable);
    
    public UfTerminal updateTerminal(UfTerminal terminal);
    
    public void deleteTerminal(String code);
    
   public void deletePolitiqueEvaluation(String Code);
   
   public void deleteCategorieCarte(String code);
    
    public void deleteConversion(Integer id);
    public Conversion searchConversion(Integer id);
    public Conversion updateConversion(Conversion conversion);
    public Reponse getAllCommercant();
    public Reponse getAllCategorieCarte();
    public Reponse getAllPointDeVente();
    public Reponse getAllTerminal();
    public Reponse getAllConversion();
    public Reponse getAllPolitiqueEvaluation();
    public boolean searchExistsCom(String code);
    public boolean searchExistTerm(String code);
    
 
    
    
    
    
     
     
   
   
    
    
    
    
    
    
    
}
