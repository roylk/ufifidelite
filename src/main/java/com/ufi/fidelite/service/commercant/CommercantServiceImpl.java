/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.service.commercant;

import com.ufi.fidelite.dao.ConversionRepository;
import com.ufi.fidelite.dao.Reponse;
import com.ufi.fidelite.dao.UfCategorieCarteRepository;
import com.ufi.fidelite.dao.UfCommercantRepository;
import com.ufi.fidelite.dao.UfPointDeVenteRepository;
import com.ufi.fidelite.dao.UfPolitiqueEvaluationRepository;
import com.ufi.fidelite.dao.UfTerminalRepository;
import com.ufi.fidelite.dao.UfVilleRepository;
import com.ufi.fidelite.entities.Conversion;
import com.ufi.fidelite.entities.UfCategorieCarte;
import com.ufi.fidelite.entities.UfCommercant;
import com.ufi.fidelite.entities.UfPointDeVente;
import com.ufi.fidelite.entities.UfPolitiqueEvaluation;
import com.ufi.fidelite.entities.UfTerminal;
import com.ufi.fidelite.entities.UfVille;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author R. KOUANI
 */
@Service
@Transactional
public class CommercantServiceImpl implements ICommercantService{
    @Autowired
    UfVilleRepository villeRepository ;
    @Autowired
    UfCommercantRepository commercantRepository;
    
    @Autowired
    UfTerminalRepository terminalRepository;
    
    @Autowired
    UfPointDeVenteRepository pointDeVenteRepository;
    @Autowired
    ConversionRepository conversionRepository;
    
    @Autowired
    UfPolitiqueEvaluationRepository politiqueEvaluationRepository;
    
    @Autowired
    UfCategorieCarteRepository categorieCarteRepository;
    

    @Override
    public List<UfCommercant> listeCommercant() {
        return commercantRepository.findAll();
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse listeCommercant(Pageable pageable) {
        return new Reponse(1,"liste des commerçants", commercantRepository.findAll(pageable));
        //return commercantRepository.findAll(pageable);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UfPointDeVente> listePointDeVente() {
        return pointDeVenteRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse listePointDeVente(Pageable pageable) {
        return new Reponse(1,"liste des points de ventes", pointDeVenteRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UfTerminal> listeTerminal() {
        return terminalRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse listeTerminal(Pageable pageable) {
        return new Reponse(1, "liste des terminaux", terminalRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Conversion> listeConversion() {
        return conversionRepository.findAll();
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfCommercant saveCommercant(UfCommercant commercant) {
        return commercantRepository.save(commercant);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfPointDeVente savePointDeVente(UfPointDeVente pointDeVente) {
        return pointDeVenteRepository.save(pointDeVente); 
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfTerminal saveTerminal(UfTerminal terminal) {
        return terminalRepository.save(terminal);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conversion saveConversion(Conversion conversion) {
      return  conversionRepository.save(conversion);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfVille getOneVille(Integer id) {
        
        return villeRepository.getOne(id);
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfCommercant searchCommercant(String code) {
        return commercantRepository.findbyId(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<UfCommercant> SearchCommercants(String mc, Pageable pageable) {
        return commercantRepository.findCommercant(mc, pageable);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfCommercant updateCommercant(UfCommercant commercant) {
        return commercantRepository.saveAndFlush(commercant);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCommercant(String code) {
        commercantRepository.deleteById(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfPointDeVente searchPointDeVente(String code) {
        return pointDeVenteRepository.getOne(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<UfPointDeVente> searchPointsDeVente(String mc, Pageable pageable) {
        return pointDeVenteRepository.findPointDeVente(mc, pageable);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfPointDeVente updatePointsDeVente(UfPointDeVente pointDeVente) {
        return pointDeVenteRepository.saveAndFlush(pointDeVente);
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePointsDeVente(String code) {
        pointDeVenteRepository.deleteById(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfTerminal searchTerminal(String code) {
        if(code.isEmpty()){
            throw new UnsupportedOperationException("le code est null"); //To change body of generated methods, choose Tools | Templates.
        }
        else
            return terminalRepository.findbyId(code);
        //throw new UnsupportedOperationException("le code est null"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<UfTerminal> searchTerminal(String mc, Pageable pageable) {
        return terminalRepository.findTerminal(mc, pageable);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfTerminal updateTerminal(UfTerminal terminal) {
      return  terminalRepository.saveAndFlush(terminal);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTerminal(String code) {
        terminalRepository.deleteById(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteConversion(Integer id) {
         conversionRepository.deleteById(id);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conversion searchConversion(Integer id) {
        return conversionRepository.getOne(id);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conversion updateConversion(Conversion conversion) {
        return conversionRepository.saveAndFlush(conversion);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfPolitiqueEvaluation savePolitiqueEvaluation(UfPolitiqueEvaluation politique) {
        return politiqueEvaluationRepository.save(politique);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfPolitiqueEvaluation searchPolitiqueEvaluation(String code) {
        return politiqueEvaluationRepository.getOne(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfPolitiqueEvaluation updatePolitiqueEvaluation(UfPolitiqueEvaluation politique) {
        return politiqueEvaluationRepository.saveAndFlush(politique);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePolitiqueEvaluation(String Code) {
        politiqueEvaluationRepository.deleteById(Code);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UfPolitiqueEvaluation> listePolitiqueEvaluation() {
        return politiqueEvaluationRepository.findAll();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UfCategorieCarte> listeCategorieCarte() {
        return categorieCarteRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfCategorieCarte saveCategorieCarte(UfCategorieCarte categorie) {
        return categorieCarteRepository.save(categorie);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfCategorieCarte searchCategorieCarte(String code) {
        return categorieCarteRepository.getOne(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfCategorieCarte updateCategorieCarte(UfCategorieCarte categorie) { 
       return categorieCarteRepository.saveAndFlush(categorie);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCategorieCarte(String code) {
        categorieCarteRepository.deleteById(code);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfVille getOneVilleByCode(String code) {
        return villeRepository.getOneByCode(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse getAllCategorieCarte() {
         return new Reponse(1, "liste de catégories cartes", categorieCarteRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse getAllCommercant() {
        return new Reponse(1, "liste des commerçant", commercantRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse getAllPointDeVente() {
        return new Reponse(1, "liste des points de vente", pointDeVenteRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse getAllTerminal() {
        return new Reponse(1, "liste des terminaux", terminalRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse getAllConversion() {
        return new Reponse(1, "table des conversions", conversionRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse getAllPolitiqueEvaluation() {
        return new Reponse(1, "liste des politiques d'évaluation", politiqueEvaluationRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse listeCategorieCarte(Pageable pageable) {
        return new Reponse (1, "liste des categories", categorieCarteRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean searchExistsCom(String code) {
        return commercantRepository.existsById(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean searchExistTerm(String code) {
        return terminalRepository.existsById(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse listeConversion(Pageable pageable) {
        return new Reponse(1,"liste des conversions", conversionRepository.findAll(pageable));
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
