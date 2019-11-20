/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.service.client;

import com.ufi.fidelite.dao.Reponse;
import com.ufi.fidelite.entities.UfCarte;
import com.ufi.fidelite.entities.UfClient;
import com.ufi.fidelite.entities.UfTransaction;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author R. KOUANI
 */
public interface IClientService {
    
    public List<UfClient> listeClient();
    public Reponse getAllClient();
    public Page<UfClient> listeClient (Pageable pageable);
    public Reponse getAllClientPages(Pageable pageable);
    
    public UfClient saveClient(UfClient client);
    
    public UfClient searchClient (String code);
    public Page<UfClient> searchClients(String mc, Pageable pageable);
    public UfClient updateClient(UfClient client);
    public void deleteClient(String code);
    
    public List<UfCarte> listeCarte();
    public Reponse listeCarte (Pageable pageable);
    public Reponse getAllCarte();
    
    
    
    public UfCarte saveCarte(UfCarte carte);
    
    public UfCarte searchCarte (String code);
    public Page<UfCarte> searchCartes(String mc, Pageable pageable);
    public UfCarte updateCarte(UfCarte carte);
    public void deleteCarte(String code);
    
     public List<UfTransaction> listeTransation();
    public Reponse listeTransaction (Pageable pageable);
    public Reponse getAllTransaction();
    
    public UfTransaction saveTransaction(UfTransaction transaction);
    
    public UfTransaction searchTransaction (String code);
    public boolean searchExistTrx(String code);
    
    public Page<UfTransaction> searchTranactions(String mc, Pageable pageable);
    public UfTransaction updateTransaction(UfTransaction transaction);
    public void deleteTransaction(String code);
    
    
    
    
    
    
    
    
}
