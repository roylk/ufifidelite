/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.service.authentification;

import com.ufi.fidelite.dao.Reponse;
import com.ufi.fidelite.entities.UfPrivilege;
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
    
    public boolean searchExistUserById(Integer id);
    
    public boolean searchExistLogin(String login);
    
    public boolean searchExistEmail(String email);
    
    
    
    public UfUtilisateur searchUserByLogin(String code);
    
    public UfUtilisateur saveUser(UfUtilisateur utilisateur);
    public Reponse getAllUsers();
    public Page<UfUtilisateur> listeUser (Pageable pageable);
    public Reponse getAllUserPages(Pageable pageable);
    
    public UfRole saveRole(UfRole role);
    public UfRole getOneRole(Integer id);
    public Reponse getAllRoles();
    public boolean searchExistsRole(String libele);
    
    public UfPrivilege savePrivilege(UfPrivilege privilege);
    public UfPrivilege getOnePrivilege(String code);
    public Reponse getAllPrivilege();
    public boolean searchExistsPrivilege(String code);
    
    public UfUtilisateur updateUser(UfUtilisateur user);
    public UfRole updateRole(UfRole role);
    public UfPrivilege updatePrivilege(UfPrivilege privilege); 
    
    public void deleteUser(Integer id);
    public void deleteRole(Integer id);
    public void deletePrivilege(String code);
     
    public String stringToBcrypt(String input);
    
    
    
        
    
    
    
    
}
