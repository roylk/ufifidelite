/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.web.rest.fidAPI;

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

    @RequestMapping(value = "/consultationAPI", method = RequestMethod.GET)
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
    }

    /*     @RequestMapping(value = "/infoTransactionAPI", method = RequestMethod.GET)
      Reponse infoTransaction(String transactionId, @RequestParam(name="carte")String carte, @RequestParam(name="terminal") String terminal, double montantInitial, double montantReduit, Date dateTransaction, Date dateEnregistrement){
          
          UfTransaction trx = new UfTransaction();
          trx.setTransactionId(transactionId);
          trx.setDateTransaction(dateTransaction);
          trx.setMontantInitial(montantInitial);
          trx.setMontantReduit(montantReduit);
          trx.setDateEnregistrement(dateEnregistrement);
          trx.setCarte(clientService.searchCarte(carte));
          trx.setTerminal(commercantService.searchTerminal(terminal));
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
    @RequestMapping(value = "/infoTransactionAPI", method = RequestMethod.GET)
    Reponse infoTransaction(String transactionId, @RequestParam(name = "carte") String carte, @RequestParam(name = "terminal") String terminal, double montantInitial, double montantReduit, Date dateTransaction, Date dateEnregistrement, String hash, String login, String motDePasse) {
        UfTerminal term = commercantService.searchTerminal(terminal);
        UfCommercant comFromTerm = term.getPointDeVente().getCommercantCode();
        UfCommercant comFromUser = authentificationService.searchUserByLogin(login).getCommercant();
        String input = transactionId + carte + terminal + montantInitial + montantReduit + "UFI_FIDELITE";
        String hashRep = Utils.sha1(input);
        if (comFromTerm.equals(comFromUser)) {
            boolean existsAuth = authentificationService.searchExistsUser(login, motDePasse);
            if (!existsAuth) {
                return new Reponse(5, "erreur d'authentification", null);
            } else {
                boolean integrity = hash.equals(hashRep);
                if (!integrity) {
                    return new Reponse(4, "données reçues douteuses", null);
                } else {
                    UfTransaction trx = new UfTransaction();
                    trx.setTransactionId(transactionId);
                    trx.setDateTransaction(dateTransaction);
                    trx.setMontantInitial(montantInitial);
                    trx.setMontantReduit(montantReduit);
                    trx.setDateEnregistrement(dateEnregistrement);
                    trx.setCarte(clientService.searchCarte(carte));
                    trx.setTerminal(commercantService.searchTerminal(terminal));
                    trx.setCommentaire("transaction réussie à " + dateEnregistrement);
                    //System.out.println("......."+clientService.searchTransaction(transactionId));

                    boolean exists = clientService.searchExistTrx(transactionId);

                    if (exists) {
                        return new Reponse(2, "la transaction existe déjà", clientService.searchTransaction(transactionId));
                    } else {
                        trx = clientService.saveTransaction(trx);
                        if (trx != null) {
                            return new Reponse(1, "Enregistré avec succes", trx);
                        } else {
                            return new Reponse(0, "Une erreur s'est produite pendant l'enregistrement", null);
                        }
                    }
                }

            }
            //return new Reponse (3, "erreur correspondance terminal/commercant",null);
        } else {
            return new Reponse(3, "erreur correspondance terminal/commercant", null);
        }
    }

    @RequestMapping(value = "/infoAuthentificationAPI", method = RequestMethod.GET)
    Reponse infoAuthentification(String terminal, String login, String motDePasse) {
        UfTerminal term = commercantService.searchTerminal(terminal);
        UfCommercant comFromTerm = term.getPointDeVente().getCommercantCode();
        UfCommercant comFromUser = authentificationService.searchUserByLogin(login).getCommercant();
        if (comFromTerm.equals(comFromUser)) {
            boolean exists = authentificationService.searchExistsUser(login, motDePasse);
            if (exists) {
                return new Reponse(1, "auth réussie", terminal);
            } else {
                return new Reponse(0, "echec auth", null);
            }
        } else {
            return new Reponse(2, "erreur de correspondance terminal", null);
        }

    }

    public FidApiRestController() {
    }

}
