/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.web.rest.fidAPI;

import com.ufi.fidelite.config.Constantes;
import com.ufi.fidelite.config.ReponseRest;
import com.ufi.fidelite.config.Utils;
import com.ufi.fidelite.dao.RepConsultation;
import com.ufi.fidelite.dao.Reponse;
import com.ufi.fidelite.entities.UfCarte;
import com.ufi.fidelite.entities.UfClient;
import com.ufi.fidelite.entities.UfCommercant;
import com.ufi.fidelite.entities.UfTerminal;
import com.ufi.fidelite.entities.UfTransaction;
import com.ufi.fidelite.entities.mirrors.CarteMirror;
import com.ufi.fidelite.entities.mirrors.ClientMirror;
import com.ufi.fidelite.entities.mirrors.CommercantMirror;
import com.ufi.fidelite.entities.mirrors.SecureTransactionMirror;
import com.ufi.fidelite.entities.mirrors.TerminalMirror;
import com.ufi.fidelite.entities.mirrors.transactionMirror;
import com.ufi.fidelite.service.authentification.IAuthentificationService;

import com.ufi.fidelite.service.client.IClientService;
import com.ufi.fidelite.service.commercant.ICommercantService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author R. KOUANI
 */
@CrossOrigin(origins = "*")
// @CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ufifidelite/api")
public class FidApiRestController {

    @Autowired
    private ICommercantService commercantService;

    @Autowired
    private IClientService clientService;

    @Autowired
    private IAuthentificationService authentificationService;

    @Autowired
    private Utils utilitaire;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    //Version 1
   /* @RequestMapping(value = "/consultationAPI", method = RequestMethod.GET)
    public RepConsultation consultation(@RequestParam(name = "carte") String carte, @RequestParam(name = "terminal") String terminal, double montant) {
        UfCommercant commercant;
        double reduction = 0;
        double montantReduit;
        UfTerminal t;
        Object config;
        UfCarte c;
        t = commercantService.searchTerminal(terminal);
        c = clientService.searchCarte(carte);
        montantReduit = montant - reduction;
        commercant = t.getPointDeVente().getCommercantCode();
        config = commercant.getConfig();
        return new RepConsultation(config, montant, montantReduit);
    }*/
    
    //Version 2
    @RequestMapping(value = "/consultationAPI", method = RequestMethod.GET)
    public RepConsultation consultation(@RequestParam(name = "carte") String carte, @RequestParam(name = "terminal") String terminal, double montant) {
        UfCommercant commercant;
        double reduction = 0;
        double montantReduit;
        UfTerminal t;
        Object config;
        UfCarte c;
        if(terminal.isEmpty()){
            return new RepConsultation(Constantes.CODE_TERMINAL_NOT_SET, false, "code terminal pas défini", null, 0,0);}
        else {
             t = commercantService.searchTerminal(terminal);
          if(t==null){
                 return new RepConsultation(Constantes.CODE_TERMINAL_NOT_SET, false,"terminal inexistant", null, 0,0);
           }else{
             commercant = t.getPointDeVente().getCommercantCode();
             if(carte.isEmpty())
                 return new RepConsultation(Constantes.CODE_CARTE_NOT_SET, false, "code carte non défini", null, 0, 0);
             else{
                c = clientService.searchCarte(carte);}
            if(c==null||c.getStatut()==1){
                return new RepConsultation(Constantes.CODE_CARTE_ABSENT_OR_NOT_ALLOCATED, false, "carte absente ou non encore allouée", null, 0,0);
            }else if(commercant==null){
                return new RepConsultation(Constantes.CODE_MERCHANT_ABSENT_OR_NOT_ACTIVE, false, "commercant absent ou pas actif", null,0,0);
            }else if(!(commercant.getCode().equals(c.getCategorieCarte().getCommercant().getCode()))){
                return new RepConsultation(Constantes.CODE_MERCHANT_CARTE_MATCH_ERROR, false,"Erreur correspondance, carte/commercant", null,0,0 );
            }else {
                config = commercant.getConfig();
                montantReduit = montant - reduction;
                return new RepConsultation(Constantes.CODE_SUCCES, true, "success",config, montant, montantReduit);}   
            }
        
        }
    }
    
        //version 1
      /*@RequestMapping(value = "/infoTransactionAPI", method = RequestMethod.GET)
      Reponse infoTransaction(String transactionId, @RequestParam(name="carte")String carte, @RequestParam(name="terminal") String terminal, double montantInitial, double montantReduit, Date dateTransaction, Date dateEnregistrement){
          
          UfTransaction trx = new UfTransaction();
          trx.setTransactionId(transactionId);
          trx.setDateTransaction(dateTransaction);
          trx.setMontantInitial(montantInitial);
          trx.setMontantReduit(montantReduit);
          trx.setDateEnregistrement(dateEnregistrement);
          trx.setCarte(clientService.searchCarte(carte));
          trx.setTerminal(commercantService.searchTerminal(terminal));
          trx.setStatut(false);
          trx.setCommentaire("transaction réussie à " +dateEnregistrement );
          
         //System.out.println("......."+clientService.searchTransaction(transactionId));
         boolean exists=clientService.searchExistTrx(transactionId);
          
        if (exists)
                       return new Reponse(2, "la transaction existe déjà", clientService.searchTransaction(transactionId));
         else{
                trx= clientService.saveTransaction(trx);
                            if(trx!=null)
                                return new Reponse(1, "Enregistré avec succes", trx);
                            else 
                                return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
		    
      }
        
   }*/
      
      //version 2
    @RequestMapping(value = "/infoTransactionAPI", method = RequestMethod.POST)
    ReponseRest infoTransaction(@RequestBody SecureTransactionMirror secureTrx ) {
        ReponseRest repRest = secureTrx.checkInput();
        if(repRest.isStatut()) {
        UfTerminal term = commercantService.searchTerminal(secureTrx.getTerminal());
        UfCommercant comFromTerm = term.getPointDeVente().getCommercantCode();
        UfCommercant comFromUser = authentificationService.searchUserByLogin(secureTrx.getLogin()).getCommercant();
        String input = secureTrx.getTransactionId() + secureTrx.getCarte() + secureTrx.getTerminal() + secureTrx.getMontantInitial() + secureTrx.getMontantReduit() + "UFI_FIDELITE";
        String hashRep = Utils.sha1(input);
        if (comFromTerm.getCode().equals(comFromUser.getCode())) {
            boolean existsAuth = authentificationService.searchExistsUser(secureTrx.getLogin(), secureTrx.getMotDePasse());
            if (!existsAuth) {
                return new ReponseRest(Constantes.CODE_AUTHENTIFICATION_ERROR, false, "erreur d'authentification", null);
            } else {
                boolean integrity = secureTrx.getHash().equals(hashRep);
                if (!integrity) {
                    return new ReponseRest(Constantes.CODE_DATA_INTEGRITY_ERROR, false,  "données reçues douteuses", null);
                } else {
                    UfTransaction trx = new UfTransaction();
                    trx.setTransactionId(secureTrx.getTransactionId());
                    trx.setDateTransaction(secureTrx.getDateTransaction());
                    trx.setMontantInitial(secureTrx.getMontantInitial());
                    trx.setMontantReduit(secureTrx.getMontantReduit());
                    trx.setDateEnregistrement(secureTrx.getDateEnregistrement());
                    trx.setCarte(clientService.searchCarte(secureTrx.getCarte()));
                    trx.setTerminal(commercantService.searchTerminal(secureTrx.getTerminal()));
                    trx.setCommentaire("transaction réussie à " + secureTrx.getDateEnregistrement());
                    trx.setStatut(false);
                    //System.out.println("......."+clientService.searchTransaction(transactionId));

                    boolean exists = clientService.searchExistTrx(secureTrx.getTransactionId());

                    if (exists) {
                        return new ReponseRest(Constantes.CODE_IDENTIC_ENTITY, false, "la transaction existe déjà", clientService.searchTransaction(secureTrx.getTransactionId()));
                    } else {
                        trx = clientService.saveTransaction(trx);
                        if (trx != null) {
                            return new ReponseRest(Constantes.CODE_SUCCES,true, "Enregistré avec succes", trx);
                        } else {
                            return new ReponseRest(Constantes.CODE_ERREUR_INITIALISATION, false, "Une erreur s'est produite pendant l'enregistrement", null);
                        }
                    }
                }

            }
            //return new Reponse (3, "erreur correspondance terminal/commercant",null);
        } else {
            return new ReponseRest(Constantes.CODE_MERCHAND_TERMINAL_MATCH_ERROR,false, "erreur correspondance terminal/commercant", null);
        }
     }else{
            return repRest;
        
        }
    }
    

    @RequestMapping(value = "/infoAuthentificationAPI", method = RequestMethod.GET)
    ReponseRest infoAuthentification(String terminal, String login, String motDePasse) {
       if(terminal.isEmpty()){
           return new ReponseRest(Constantes.CODE_TERMINAL_NOT_SET, false, "code terminal non defini", null);
       }
       else{
            UfTerminal term = commercantService.searchTerminal(terminal);
            if(term==null){
                return new ReponseRest(Constantes.CODE_TERMINAL_NOT_SET, false, "terminal non défini ou inexistant", null);
            }else{
                UfCommercant comFromTerm = term.getPointDeVente().getCommercantCode();
                 if(login.isEmpty()||motDePasse.isEmpty()){
                     return new ReponseRest(Constantes.CODE_LOGIN_OR_PASSWORD_NOT_SET, false, "login et/ou motDePasse non défini(s)", null);
                 }else{
                     UfCommercant comFromUser = authentificationService.searchUserByLogin(login).getCommercant();
                     if (comFromTerm.getCode().equals(comFromUser.getCode())) {
                            boolean exists = authentificationService.searchExistsUser(login, motDePasse);
                            if (exists) {
                                 return new ReponseRest(Constantes.CODE_SUCCES,true, "auth réussie", terminal);
                            } else {
                             return new ReponseRest(Constantes.CODE_AUTHENTIFICATION_ERROR, false, "echec auth", null);
                             }
                      } else {
                         return new ReponseRest(Constantes.CODE_MERCHAND_TERMINAL_MATCH_ERROR, false, "erreur de correspondance terminal", null);
                    }
                 }
                     
             }
                
            }
        
    }

    public FidApiRestController() {
    }

}
