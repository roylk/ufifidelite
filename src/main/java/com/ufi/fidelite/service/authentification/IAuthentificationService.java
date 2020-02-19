/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.service.authentification;

import com.ufi.fidelite.dao.Reponse;
import com.ufi.fidelite.entities.UfRole;
import com.ufi.fidelite.entities.UfUtilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author R. KOUANI
 */
public interface IAuthentificationService {
    
    public boolean searchExistsUser(String login, String motDePasse);
    
    public boolean searchExistUserByString(String code);
    
    public boolean searchExistLogin(String login);
    
    public boolean searchExistEmail(String email);
    
    
    
    public UfUtilisateur searchUserByLogin(String code);
    
    public UfUtilisateur saveUser(UfUtilisateur utilisateur);
    public Reponse getAllUsers();
    public Page<UfUtilisateur> listeUser (Pageable pageable);
    public Reponse getAllUserPages(Pageable pageable);
    
    
    public UfRole getOneRole(Integer id);
    
    
    
    public String stringToBcrypt(String input);
    
    
    
        
    
    
    
    
}
