/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.service.fidelisation;

import com.ufi.fidelite.dao.Reponse;
import com.ufi.fidelite.dao.UfOffreRepository;
import com.ufi.fidelite.dao.UfPalierRepository;
import com.ufi.fidelite.dao.UfTypeOffreRepository;
import com.ufi.fidelite.entities.UfOffre;
import com.ufi.fidelite.entities.UfPalier;
import com.ufi.fidelite.entities.UfTypeOffre;
import com.ufi.fidelite.service.*;
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
public class FidelisationServiceImpl implements IFidelisationService {
    
    @Autowired 
    UfTypeOffreRepository typeOffreRepository;
    
    @Autowired 
    UfOffreRepository offreRepository;
    
    @Autowired 
    UfPalierRepository palierRepository;
    

    @Override
    public List<UfTypeOffre> listeTypeOffre() {
        return typeOffreRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfTypeOffre saveTypeOffre(UfTypeOffre type) {
         return typeOffreRepository.save(type);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfTypeOffre searchTypeOffre(String code) {
         return typeOffreRepository.getOne(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfTypeOffre updateTypeOffre(UfTypeOffre type) {
         return typeOffreRepository.saveAndFlush(type);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTypeOffre(String code) {
         typeOffreRepository.deleteById(code);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UfOffre> listeOffre() {
        return offreRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse listeOffre(Pageable pageable) {
        return new Reponse(1,"liste des offres", offreRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfOffre saveOffre(UfOffre offre) {
        return offreRepository.save(offre);
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfOffre searchOffre(Integer id) {
        return offreRepository.getOne(id);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfOffre updateOffre(UfOffre offre) {
        return offreRepository.saveAndFlush(offre);
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteOffre(Integer id) {
        offreRepository.deleteById(id);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UfPalier> listePalier() {
        return palierRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse listePalier(Pageable pageable) {
        return new Reponse( 1,"liste des paliers", palierRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfPalier savePalier(UfPalier palier) {
        return palierRepository.save(palier);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public UfPalier updatePalier(UfPalier palier) {
        return palierRepository.saveAndFlush(palier);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePalier(Integer id) {
        palierRepository.deleteById(id);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfPalier searchPalier(Integer id) {
        return palierRepository.getOne(id);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfOffre getOneOffre(String code) {
        return offreRepository.findbyCode(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse getAllOffre() {
        return new Reponse(1, "Liste des offres", offreRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse getAllTypeOffre() {
        return new Reponse(1,"liste des types d'offre", typeOffreRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse getAllPallier() {
        return new Reponse(1, "liste des palliers ", palierRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
