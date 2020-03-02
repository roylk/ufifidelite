/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.web.rest.authenfication;

import com.ufi.fidelite.dao.Reponse;
import com.ufi.fidelite.entities.UfPrivilege;
import com.ufi.fidelite.entities.UfRole;
import com.ufi.fidelite.entities.UfUtilisateur;
import com.ufi.fidelite.entities.mirrors.ConnexionMirror;
import com.ufi.fidelite.entities.mirrors.UtilisateurMirror;
import com.ufi.fidelite.service.authentification.IAuthentificationService;
import com.ufi.fidelite.service.commercant.ICommercantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
            user.setPrenom(userM.getPrenom()); 
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
        
        
        @RequestMapping(value = "/role", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse saveRole(@RequestBody UfRole role) {
            UfRole r;
            boolean exists=authentificationService.searchExistsRole(role.getLibele());
            if(exists){
                return new Reponse (2, "le role existe déjà ", null);
            }else{
            r= authentificationService.saveRole(role);}
            if (r!= null) {

			return new Reponse(1, "enregistré  avec succes", role);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
	}
        
        @RequestMapping(value = "/rolesR", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllRoles(){
            
           Reponse rep=null; 
            try{
               rep=authentificationService.getAllRoles();
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	
	}
        
        @RequestMapping(value = "/privilege", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse savePrivilege(@RequestBody UfPrivilege privilege) {
            UfPrivilege p;
            boolean exists=authentificationService.searchExistsPrivilege(privilege.getCode());
            if(exists){
                return new Reponse (2, "le privilège existe déjà ", null);
            }else{
            p= authentificationService.savePrivilege(privilege);}
            if (p!= null) {

			return new Reponse(1, "enregistré  avec succes", privilege);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
	}
        
         @RequestMapping(value = "/privilegesR", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse getAllPrivileges(){
            
           Reponse rep=null; 
            try{
               rep=authentificationService.getAllPrivilege();
            }catch(Exception e){
                rep =new Reponse();
                rep.setStatus(0);
                rep.setMessage(e.getMessage());
            }
            return rep;	
	}
        
        @RequestMapping(value = "/utilisateurs/{id}", method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse updateRegion(@RequestBody UtilisateurMirror u, @PathVariable("id") Integer id) {
            
            UfUtilisateur user = new UfUtilisateur();
            
            user.setId(id);
            user.setNom(u.getNom());
            user.setPrenom(u.getPrenom()); 
            user.setTelephone(u.getTelephone());
            user.setEmail(u.getEmail());
            user.setLogin(u.getLogin());
            String encPassWord=authentificationService.stringToBcrypt(u.getMotDePasse());
            user.setMotDePasse(encPassWord);
            user.setSexe(u.getSexe());
            user.setStatut(u.getStatut());
            user.setCommercant(commercantService.searchCommercant(u.getCommercant()));
            user.setRole(authentificationService.getOneRole(u.getRole()));
//            boolean exists1=authentificationService.searchExistLogin(u.getLogin());
//            boolean exists2=authentificationService.searchExistEmail(u.getEmail());
//             if(exists1){
//                        return new Reponse(3, "Login déjà utilisé...", null);
//              }else if(exists2){
//                        return new Reponse(2, "Email  déjà utilisé...", null);   
//              }else{
                     user= authentificationService.updateUser(user);
                            if(user!=null){
                                return new Reponse(1, "Mis à  avec succes", user);}
                            else {
                                return new Reponse(0, "Une erreur s'est produite pendant la mise à jour", null);
		}
              
	}
        
        @RequestMapping(value = "/roles/{id}", method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse updateRole(@RequestBody UfRole role, @PathVariable("id") Integer id) {
            
            role.setId(id);
            
            UfRole r;
            r= authentificationService.updateRole(role);

		if (r != null) {

			return new Reponse(1, "mis à jour avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
              
        }
        
        @RequestMapping(value = "/privileges/{code}", method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
	public Reponse updateRole(@RequestBody UfPrivilege privilege, @PathVariable("code") String code) {
            
            privilege.setCode(code);
            
            UfPrivilege p;
            p= authentificationService.updatePrivilege(privilege);

		if (p != null) {

			return new Reponse(1, "mis à jour avec succes", null);
		} else {

			return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		}
            
        }
        
         @RequestMapping(value = "/utilisateurs/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("id") Integer id) {
		authentificationService.deleteUser(id);
	}
        
         @RequestMapping(value = "/roles/{id}", method = RequestMethod.DELETE)
	public void deleteRole(@PathVariable("id") Integer id) {
		authentificationService.deleteRole(id);
	}
        
         @RequestMapping(value = "/privileges/{code}", method = RequestMethod.DELETE)
	public void deletePrivilege(@PathVariable("code") String code) {
		authentificationService.deletePrivilege(code);
	}
        
        
        
        

 
    public AuthentificationRestController() {
        
    }
    
    
}
