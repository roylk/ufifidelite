/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.service.authentification;

import com.ufi.fidelite.entities.UfUtilisateur;

/**
 *
 * @author R. KOUANI
 */
public interface IAuthentificationService {
    
    public boolean searchExistsUser(String login, String motDePasse);
    
    public boolean searchExistUserByString(String code);
    
    public UfUtilisateur searchUserByLogin(String code);
    
    
        
    
    
    
    
}
