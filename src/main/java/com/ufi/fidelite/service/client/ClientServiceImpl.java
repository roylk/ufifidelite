/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.service.client;

import com.ufi.fidelite.dao.Reponse;
import com.ufi.fidelite.dao.UfCarteRepository;
import com.ufi.fidelite.dao.UfClientRepository;
import com.ufi.fidelite.dao.UfTransactionRepository;
import com.ufi.fidelite.entities.UfCarte;
import com.ufi.fidelite.entities.UfClient;
import com.ufi.fidelite.entities.UfTransaction;
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
public class ClientServiceImpl implements IClientService{
    @Autowired
    UfClientRepository clientRepository;
    
    @Autowired
    UfCarteRepository carteRepository;
    
    @Autowired
    UfTransactionRepository transactionRepository;
    
    

    @Override
    public List<UfClient> listeClient() {
        return clientRepository.findAll();
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<UfClient> listeClient(Pageable pageable) {
        return clientRepository.findAll(pageable);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfClient saveClient(UfClient client) {
        return clientRepository.save(client);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfClient searchClient(String code) {
        return clientRepository.getOne(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<UfClient> searchClients(String mc, Pageable pageable) {
        return clientRepository.findClient(mc, pageable);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfClient updateClient(UfClient client) {
        return clientRepository.saveAndFlush(client);
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteClient(String code) {
        clientRepository.deleteById(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UfCarte> listeCarte() {
        return carteRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse listeCarte(Pageable pageable) {
        //return carteRepository.findAll(pageable);
        return new Reponse (1,"liste des cartes", carteRepository.findAll(pageable));
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfCarte saveCarte(UfCarte carte) {
        return carteRepository.save(carte);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfCarte searchCarte(String code) {
        return carteRepository.getOne(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<UfCarte> searchCartes(String mc, Pageable pageable) {
        return carteRepository.findCarte(mc, pageable);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfCarte updateCarte(UfCarte carte) {
        return carteRepository.saveAndFlush(carte);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCarte(String code) {
        carteRepository.deleteById(code);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UfTransaction> listeTransation() {
        return transactionRepository.findAll();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse listeTransaction(Pageable pageable) {
        return new Reponse (1, "pages des transactions", transactionRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfTransaction saveTransaction(UfTransaction transaction) {
        return transactionRepository.save(transaction);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfTransaction searchTransaction(String code) {
        return transactionRepository.getOne(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose To.ols | Templates.
    }

    @Override
    public Page<UfTransaction> searchTranactions(String mc, Pageable pageable) {
        return transactionRepository.findTransaction(mc, pageable);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfTransaction updateTransaction(UfTransaction transaction) {
        return transactionRepository.saveAndFlush(transaction);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteTransaction(String code) {
        transactionRepository.deleteById(code);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse getAllClient() {
        return new Reponse(1, "liste des clients", clientRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse getAllCarte() {
        return new Reponse(1, "liste des cartes", carteRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse getAllClientPages(Pageable pageable) {
        return new Reponse(1,"liste des cartes",clientRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse getAllTransaction() {
        return new Reponse(1, "liste Transactions", transactionRepository.findAll());
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean searchExistTrx(String code) {
        return transactionRepository.existsById(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
