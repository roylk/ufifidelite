/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.service.regionalisation;

import com.ufi.fidelite.dao.Reponse;
import com.ufi.fidelite.dao.UfPaysRepository;
import com.ufi.fidelite.dao.UfRegionRepository;
import com.ufi.fidelite.dao.UfVilleRepository;
import com.ufi.fidelite.entities.UfPays;
import com.ufi.fidelite.entities.UfRegion;
import com.ufi.fidelite.entities.UfVille;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author R. KOUANI
 */
@Service
@Transactional
public class RegionalisationServiceImpl implements IRegionalisationService{
    @Autowired
    private UfPaysRepository paysRepository;
    
    @Autowired 
    private UfRegionRepository regionRepository;
    
     @Autowired 
    private UfVilleRepository villeRepository;

    @Override
    public List<UfVille> listeVille() {
        return villeRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UfRegion> listeRegion() {
        return regionRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UfPays> listePays() {
        return paysRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfPays SavePays(UfPays pays) {
       return paysRepository.save(pays);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfVille saveVille(UfVille ville) {
        return villeRepository.save(ville);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfRegion saveRegion(UfRegion region) {
        return regionRepository.save(region);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfVille getOneVille(Integer id) {
        
        return villeRepository.getOne(id);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfRegion getOneRegion(Integer id) {
        return regionRepository.getOne(id);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfPays getOnePays(String code) {
        
        return paysRepository.getOne(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfPays updatePays(UfPays pays) {
        return paysRepository.saveAndFlush(pays);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfVille updateVille(UfVille ville) {
        return villeRepository.saveAndFlush(ville);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfRegion updateRegion(UfRegion region) {
        return regionRepository.saveAndFlush(region);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePays(String code) {
        paysRepository.deleteById(code);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteVille(Integer id) {
        villeRepository.deleteById(id);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRegion(Integer id) {
        regionRepository.deleteById(id);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UfRegion> getAllRegionByPays(String codeP) {
        return regionRepository.findAllRegionByPays(codeP);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UfVille> getAllVilleByRegion(String codeR) {
        return villeRepository.findAllVilleByRegion(codeR);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfVille getOneVilleByCode(String code) {
        return villeRepository.getOneByCode(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse GetAllPays() {
        return new Reponse (1, "liste des pays", paysRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse getAllRegion() {
        return new Reponse(1,"liste des régions", regionRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse getAllVille() {
        return new Reponse(1,"liste des villes", villeRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse listeVille(Pageable pageable) {
        return new Reponse(1,"liste des villes", villeRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse listeRegion(Pageable pageable) {
        return new Reponse(1,"liste des Régions",regionRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse listePays(Pageable pageable) {
        return new Reponse(1,"liste des Pays",paysRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    

    
    
}
