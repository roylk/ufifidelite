/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.service.authentification;

import com.ufi.fidelite.dao.Reponse;
import com.ufi.fidelite.dao.UfCarteRepository;
import com.ufi.fidelite.dao.UfClientRepository;
import com.ufi.fidelite.dao.UfPrivilegeRepository;
import com.ufi.fidelite.dao.UfRoleRepository;
import com.ufi.fidelite.dao.UfTransactionRepository;
import com.ufi.fidelite.dao.UfUtilisateurRepository;
import com.ufi.fidelite.entities.UfPrivilege;
import com.ufi.fidelite.entities.UfRole;
import com.ufi.fidelite.entities.UfUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author R. KOUANI
 */
@Service
@Transactional
public class AuthentificationServiceImpl implements IAuthentificationService {

    @Autowired
    UfClientRepository clientRepository;

    @Autowired
    UfCarteRepository carteRepository;

    @Autowired
    UfTransactionRepository transactionRepository;

    @Autowired
    UfUtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired 
    private UfRoleRepository roleRepository;
    
     @Autowired 
    private UfPrivilegeRepository privilegeRepository;

    @Override
    public boolean searchExistsUser(String login, String motDePasse) {
        UfUtilisateur user;
        System.out.println("utilisateur.........."+login);
        System.out.println("utilisateur.........."+motDePasse);
        user = utilisateurRepository.findbyLogin(login);
        System.out.println("utilisateur.........."+user);
        
        if (user != null) {
            System.out.println("mot de passe.........."+user.getMotDePasse());
            String cryptMotDePasse=passwordEncoder.encode(motDePasse);
           System.out.println("mot de passe encodé.........."+cryptMotDePasse);
            //boolean b=passwordEncoder.encode(motDePasse).equals(user.getMotDePasse());
//            boolean b=passwordEncoder.matches(motDePasse,user.getMotDePasse());
//            //return b=passwordEncoder.encode(motDePasse).equals(user.getMotDePasse());
//             if(b){
//                 System.out.println(b);
//                 return true;   
//             }else{
//                 return false;
//             }  
            return passwordEncoder.matches(motDePasse,user.getMotDePasse());  
        } else {
            return false;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean searchExistUserById(Integer id) {
        return utilisateurRepository.existsById(id);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfUtilisateur searchUserByLogin(String code) {
        return utilisateurRepository.findbyLogin(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String stringToBcrypt(String input) {
        return passwordEncoder.encode(input);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfUtilisateur saveUser(UfUtilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse getAllUsers() {
         return new Reponse(1, "liste des utilisateurs", utilisateurRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Page<UfUtilisateur> listeUser(Pageable pageable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse getAllUserPages(Pageable pageable) {
        return new Reponse(1, "pages des utilisateurs", utilisateurRepository.findAll(pageable));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfRole getOneRole(Integer id) {
        return roleRepository.getOne(id);
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean searchExistLogin(String login) {
        UfUtilisateur user=utilisateurRepository.findbyLogin(login);
        if (user != null){
            return true;
        }else{
            return false;
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean searchExistEmail(String email) {
         UfUtilisateur user=utilisateurRepository.findbyEmail(email);
        if (user != null){
            return true;
        }else{
            return false;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfRole saveRole(UfRole role) {
        return roleRepository.save(role);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse getAllRoles() {
         return new Reponse(1, "liste des roles", roleRepository.findAll());
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean searchExistsRole(String libele) {
         UfRole role=roleRepository.getOneByCode(libele);
        if (role != null){
            return true;
        }else{
            return false;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfPrivilege savePrivilege(UfPrivilege privilege) {
        return privilegeRepository.save(privilege);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfPrivilege getOnePrivilege(String code) {
        return privilegeRepository.getOne(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reponse getAllPrivilege() {
        return new Reponse(1, "liste des privilèges", privilegeRepository.findAll());
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean searchExistsPrivilege(String code) {
        return privilegeRepository.existsById(code);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfUtilisateur updateUser(UfUtilisateur user) {
        return utilisateurRepository.saveAndFlush(user);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfRole updateRole(UfRole role) {
        return roleRepository.saveAndFlush(role);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UfPrivilege updatePrivilege(UfPrivilege privilege) {
        return privilegeRepository.saveAndFlush(privilege);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser(Integer id) {
        utilisateurRepository.deleteById(id);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePrivilege(String code) {
        privilegeRepository.deleteById(code);
        //throw new UnsupportedOperationException("Not supported yet.");  //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
