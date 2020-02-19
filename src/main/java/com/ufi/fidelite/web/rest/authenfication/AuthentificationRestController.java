/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.web.rest.authenfication;

import com.ufi.fidelite.dao.Reponse;
import com.ufi.fidelite.entities.UfUtilisateur;
import com.ufi.fidelite.entities.mirrors.ConnexionMirror;
import com.ufi.fidelite.entities.mirrors.UtilisateurMirror;
import com.ufi.fidelite.service.authentification.IAuthentificationService;
import com.ufi.fidelite.service.commercant.ICommercantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author R. KOUANI
 */
@CrossOrigin(origins = "*")
// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ufifidelite/api")
public class AuthentificationRestController {
    
     @Autowired
    private IAuthentificationService authentificationService;
     
     @Autowired
    private ICommercantService commercantService;
     
     
       @RequestMapping(value = "/convertToBcrypt", method = RequestMethod.GET)
     public String convertToBcrypt(String input){
         String output;
         return output = authentificationService.stringToBcrypt(input);
         
     }
     
     
   /* @RequestMapping(value = "/login", method = RequestMethod.POST)
    Reponse connexion(@RequestParam(name = "login")String login, @RequestParam(name = "motDePasse")String motDePasse) {
            boolean exists = authentificationService.searchExistsUser(login, motDePasse);
            if (exists) {
                return new Reponse(1, "auth réussie", null);
            } else {
                return new Reponse(0, "echec auth", null);
            }
        } */
    
     @RequestMapping(value = "/login", method = RequestMethod.POST)
    Reponse connexion(@RequestBody ConnexionMirror connexionObject) {
            boolean exists = authentificationService.searchExistsUser(connexionObject.getLogin(), connexionObject.getMotDePasse());
            if (exists) {
                return new Reponse(1, "auth réussie", null);
            } else {
                return new Reponse(0, "echec auth", null);
            }
        } 
    
    
     @RequestMapping(value = "/utilisateur", method = RequestMethod.POST ,produces = MediaType.APPLICATION_JSON_VALUE)
            public Reponse saveUser(@RequestBody UtilisateurMirror userM ) {
            
            UfUtilisateur user = new UfUtilisateur();
            
            user.setNom(userM.getNom());
            user.setNom(userM.getPrenom()); 
            user.setTelephone(userM.getTelephone());
            user.setEmail(userM.getEmail());
            user.setLogin(userM.getLogin());
            String encPassWord=authentificationService.stringToBcrypt(userM.getMotDePasse());
            user.setMotDePasse(encPassWord);
            user.setSexe(userM.getSexe());
            user.setStatut(userM.getStatut());
            user.setCommercant(commercantService.searchCommercant(userM.getCommercant()));
            user.setRole(authentificationService.getOneRole(userM.getRole()));
            boolean exists1=authentificationService.searchExistLogin(user.getLogin());
            boolean exists2=authentificationService.searchExistEmail(user.getEmail());
             if(exists1){
                        return new Reponse(3, "Login déjà utilisé...", null);
              }else if(exists2){
                        return new Reponse(2, "Email  déjà utilisé...", null);   
              }else{
                     user= authentificationService.saveUser(user);}
                            if(user!=null){
                                return new Reponse(1, "Enregistré avec succes", user);}
                            else {
                                return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
         
        } 
            
         @RequestMapping(value = "/utilisateursR", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllUsers(){
            
           Reponse rep=null; 
            try{
               rep=authentificationService.getAllUsers();
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	
	}

 

    public AuthentificationRestController() {
        
    }
    
    
}
