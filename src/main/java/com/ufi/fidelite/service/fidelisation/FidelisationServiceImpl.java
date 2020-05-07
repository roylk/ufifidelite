/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.service.fidelisation;

import com.ufi.fidelite.dao.ConversionRepository;
import com.ufi.fidelite.dao.Reponse;
import com.ufi.fidelite.dao.UfOffreRepository;
import com.ufi.fidelite.dao.UfPalierRepository;
import com.ufi.fidelite.dao.UfTransactionRepository;
import com.ufi.fidelite.dao.UfTypeOffreRepository;
import com.ufi.fidelite.entities.Conversion;
import com.ufi.fidelite.entities.UfCarte;
import com.ufi.fidelite.entities.UfOffre;
import com.ufi.fidelite.entities.UfPalier;
import com.ufi.fidelite.entities.UfTransaction;
import com.ufi.fidelite.entities.UfTypeOffre;
import com.ufi.fidelite.service.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    
    @Autowired 
    UfTransactionRepository transactionRepository;
    
    @Autowired 
    ConversionRepository conversionRepository;

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

    @Override
    public void upDateCompteurs(UfTransaction transaction) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate =new Date();
        short statut=2;
        int control=1;
        while(transaction.getMontantReduit()<transaction.getMontantInitial()&&control==1){
            transaction.getCarte().setCompteurPoint(BigInteger.ZERO);
            //transaction.getCarte().setNombreTransaction(0);
            //transaction.getCarte().setMontantAcumule(0.0);
            transaction.setStatut(true);
            control=0;
        }
        transaction.getCarte().setNombreTransaction(transaction.getCarte().getNombreTransaction()+1);
        transaction.getCarte().setMontantAcumule(transaction.getCarte().getMontantAcumule()+transaction.getMontantInitial());
        List<UfPalier> listePaliers=palierRepository.findAll();
        BigInteger pointsGagnes=BigInteger.ZERO;
        BigInteger  compteurPoints=BigInteger.ZERO;
        for(UfPalier palier :listePaliers){
            int ctrl_offre=1;
            while(palier.getOffre().getDateFin().before(currentDate)&& ctrl_offre==1){ 
                    palier.getOffre().setStatut(statut);
                    ctrl_offre=0;
                }
            if(transaction.getCarte().getCategorieCarte().getCode().equals(palier.getOffre().getCategorieCarte().getCode())){
                
               if(transaction.getMontantInitial()>=palier.getMontantInf()&&transaction.getMontantInitial()<=palier.getMontantSup()&&palier.getOffre().getTypeOffre().getCode().equals("ACHT001")
                       &&palier.getOffre().getOrientation()==1&&palier.getOffre().getStatut()==1){
                   pointsGagnes=BigDecimal.valueOf((transaction.getMontantInitial()*palier.getUnitePoint())/palier.getUniteDevise()).toBigInteger();      
               }else{
                   pointsGagnes=BigInteger.ZERO;
               }
               
            }else{
                pointsGagnes=BigInteger.ZERO;
            }
               compteurPoints=transaction.getCarte().getCompteurPoint().add(pointsGagnes);
               transaction.getCarte().setCompteurPoint(compteurPoints);
               
               //BigInteger k = BigDecimal.valueOf(doublevalue).toBigInteger()
            }
        
             
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double evaluateTransaction(Double montant, String carte) {
        List<UfTransaction>listeTransactions = transactionRepository.findAllByAmount(montant, carte);
        Double reduction=0.0;
        
        for(UfTransaction transaction :listeTransactions){
            
            if(transaction.getCarte().getCategorieCarte().getPolitiqueEvaluation().getCode().equals("PL00001")){
                String commercant=transaction.getCarte().getCategorieCarte().getCommercant().getCode();
                List<Conversion> listeConversions=conversionRepository.getConversionByCom(commercant);
                BigInteger compteurPoints=transaction.getCarte().getCompteurPoint();
                for(Conversion conversion:listeConversions){
                    if((compteurPoints.intValue()>=conversion.getNbpointInf())&&(compteurPoints.intValue()<=conversion.getNbpointSup())){
                        switch (conversion.getType()) {
                            case 1:
                                reduction=conversion.getReduction();
                                break;
                            case 2:
                                reduction=(transaction.getMontantInitial()*conversion.getReduction())/100;
                                break;
                            default:
                                reduction=0.0;
                                break;
                        }    
                    }else{
                        reduction=0.0;
                    }
                    
                }   
            }else{
                reduction=0.0;
            }  
        }
        return reduction;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double evaluationGain(UfCarte carte,Double montant) {
        Double reduction=0.0;
        
       if(carte.getCategorieCarte().getPolitiqueEvaluation().getCode().equals("PL00001")){
                String commercant=carte.getCategorieCarte().getCommercant().getCode();
                List<Conversion> listeConversions=conversionRepository.getConversionByCom(commercant);
                BigInteger compteurPoints=carte.getCompteurPoint();
                for(Conversion conversion:listeConversions){
                    if((compteurPoints.intValue()>=conversion.getNbpointInf())&&(compteurPoints.intValue()<=conversion.getNbpointSup())){
                        switch (conversion.getType()) {
                            case 1:
                                reduction=conversion.getReduction();
                                break;
                            case 2:
                                reduction=(montant*conversion.getReduction())/100;
                                break;
                            default:
                                reduction=0.0;
                                break;
                        }    
                    }else{
                        reduction=0.0; 
                    }
                    
                }   
            }else{
                reduction=0.0;
            }  
        
        return reduction;
       
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
