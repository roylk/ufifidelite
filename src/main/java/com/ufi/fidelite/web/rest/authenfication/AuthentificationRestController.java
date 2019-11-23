/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.web.rest.authenfication;

import com.ufi.fidelite.dao.Reponse;
import com.ufi.fidelite.entities.mirrors.ConnexionMirror;
import com.ufi.fidelite.service.authentification.IAuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
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

 

    public AuthentificationRestController() {
    }
    
    
}
