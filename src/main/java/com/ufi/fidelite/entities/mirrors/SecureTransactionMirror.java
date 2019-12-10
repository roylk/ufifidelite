/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.entities.mirrors;

import com.ufi.fidelite.config.Constantes;
import com.ufi.fidelite.config.ReponseRest;
import java.util.Date;

/**
 *
 * @author R. KOUANI
 */
public class SecureTransactionMirror {
    private String transactionId;
    private Date dateTransaction;
    //private Double montantInitial;
    private String montantInitial;
    //private Double montantReduit;
    private String montantReduit;
    private Date dateEnregistrement;
    private String carte;
    private String terminal;
    private String hash;
    private String login;
    private String motDePasse;
    
    public SecureTransactionMirror(){
        super();
    }

    public SecureTransactionMirror(String transactionId, Date dateTransaction, String montantInitial, String montantReduit, Date dateEnregistrement, String carte, String terminal, String hash, String login, String motDePasse) {
        this.transactionId = transactionId;
        this.dateTransaction = dateTransaction;
        this.montantInitial = montantInitial;
        this.montantReduit = montantReduit;
        this.dateEnregistrement = dateEnregistrement;
        this.carte = carte;
        this.terminal = terminal;
        this.hash = hash;
        this.login = login;
        this.motDePasse = motDePasse;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public String getMontantInitial() {
        return montantInitial;
    }

    public String getMontantReduit() {
        return montantReduit;
    }

    public Date getDateEnregistrement() {
        return dateEnregistrement;
    }

    public String getCarte() {
        return carte;
    }

    public String getTerminal() {
        return terminal;
    }

    public String getHash() {
        return hash;
    }

    public String getLogin() {
        return login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public void setMontantInitial(String montantInitial) {
        this.montantInitial = montantInitial;
    }

    public void setMontantReduit(String montantReduit) {
        this.montantReduit = montantReduit;
    }

    public void setDateEnregistrement(Date dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public void setCarte(String carte) {
        this.carte = carte;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "SecureTransactionMirror{" + "transactionId=" + transactionId + ", dateTransaction=" + dateTransaction + ", montantInitial=" + montantInitial + ", montantReduit=" + montantReduit + ", dateEnregistrement=" + dateEnregistrement + ", carte=" + carte + ", terminal=" + terminal + ", hash=" + hash + ", login=" + login + ", motDePasse=" + motDePasse + '}';
    }
    
    
   public ReponseRest checkInput(){
        ReponseRest repRest = new ReponseRest();
        if(this.getTransactionId().isEmpty() || this.getTransactionId() == null){
            repRest.setCode(Constantes.CODE_TRANSACTION_ID_NOT_SET);
            repRest.setMessage("Transaction ID not set or is empty");
            repRest.setStatut(false);
            repRest.setData(null);
            return repRest;
        }else if (this.getDateTransaction()==null||this.getDateEnregistrement()==null){
            repRest.setCode(Constantes.CODE_TRANSACTION_DATE_ERROR);
            repRest.setMessage("Transaction Dates  not set or is empty");
            repRest.setStatut(false);
            repRest.setData(null);
            return repRest;
        }else if(this.getCarte().isEmpty()||this.getCarte()==null){
            repRest.setCode(Constantes.CODE_CARTE_NOT_SET);
            repRest.setMessage("Carte not set or is empty");
            repRest.setStatut(false);
            repRest.setData(null);
            return repRest;
            
        }else if(this.getTerminal().isEmpty()||this.getTerminal()==null){
            repRest.setCode(Constantes.CODE_TERMINAL_NOT_SET);
            repRest.setMessage(" Terminal not set or is empty");
            repRest.setStatut(false);
            repRest.setData(null);
            return repRest;
            
        }/*else if (this.getMontantInitial().isEmpty()||this.getMontantInitial()==null){
            /*boolean numeric=true;
            
            try {
                Double num1= Double.parseDouble(this.getMontantInitial());
                //Double num2= Double.parseDouble(this.getMontantReduit().toString());
                
                
            } catch (NumberFormatException e) {
                numeric=false;
                
            }
            if(!numeric){*/
           /* repRest.setCode(Constantes.CODE_MONTANT_ERROR);
            repRest.setMessage(" Montant not set, is empty ");
            repRest.setStatut(false);
            repRest.setData(null);
            return repRest;
            }/*else if(!(this.getMontantInitial().isEmpty()||this.getMontantInitial()==null)) {
                boolean numeric=true;
                int controle=1;
            while(controle==1){
            try {
                Double num1= Double.parseDouble(this.getMontantInitial());
                //Double num2= Double.parseDouble(this.getMontantReduit().toString());
                
                
            } catch (NumberFormatException e) {
                numeric=false;
                   
            }
            if(!numeric){
                repRest.setCode(Constantes.CODE_MONTANT_ERROR);
                repRest.setMessage(" Montant is not a number ");
                repRest.setStatut(false);
                repRest.setData(null);
                return repRest; 
            }else{
                controle=0;
                break;
            }
            }*/
            //return repRest;
        else if(this.getLogin().isEmpty()||this.getLogin()==null ||this.getMotDePasse().isEmpty()||this.getMotDePasse()==null){
            repRest.setCode(Constantes.CODE_LOGIN_OR_PASSWORD_NOT_SET);
            repRest.setMessage("login or password  not set or is empty");
            repRest.setStatut(false);
            repRest.setData(null);
            return repRest; 
            
        }else if(this.getHash().isEmpty()||this.getHash()==null){
          repRest.setCode(Constantes.CODE_HASH_NOT_SET);
            repRest.setMessage("login or password  not set or is empty");
            repRest.setStatut(false);
            repRest.setData(null);
            return repRest;   
        }else if (this.getMontantInitial().isEmpty()||this.getMontantInitial()==null||this.getMontantReduit().isEmpty()||this.getMontantReduit()==null){
            /*boolean numeric=true;
            
            try {
                Double num1= Double.parseDouble(this.getMontantInitial());
                //Double num2= Double.parseDouble(this.getMontantReduit().toString());
                
                
            } catch (NumberFormatException e) {
                numeric=false;
                
            }
            if(!numeric){*/
            repRest.setCode(Constantes.CODE_MONTANT_ERROR);
            repRest.setMessage(" MontantInitial or MontantReduit not set or empty ");
            repRest.setStatut(false);
            repRest.setData(null);
            return repRest;
            }
        
        
        else if(!((this.getMontantInitial().isEmpty()||this.getMontantInitial()==null)&&(this.getMontantReduit().isEmpty()||this.getMontantReduit()==null))) {
                boolean numeric=true;
                int controle=1;
            while(controle==1){
            try {
                Double num1= Double.parseDouble(this.getMontantInitial());
                Double num2= Double.parseDouble(this.getMontantReduit());
                
                
            } catch (NumberFormatException e) {
                numeric=false;
                   
            }
            if(!numeric){
                repRest.setCode(Constantes.CODE_MONTANT_ERROR);
                repRest.setMessage(" MontantInitial or MontantReduit is not a number ");
                repRest.setStatut(false);
                repRest.setData(null);
                return repRest; 
            }else{
                controle=0;
                repRest.setCode(Constantes.CODE_SUCCES);
            repRest.setMessage("success");
            repRest.setStatut(true);
            repRest.setData(null);
            return repRest;
               
            }
            }
        }
       
        else{
           /* repRest.setCode(Constantes.CODE_SUCCES);
            repRest.setMessage("success");
            repRest.setStatut(true);
            repRest.setData(null);*/
            return repRest;
        }  
            
        return repRest;
        
        
        
    }
      
    
    
    
}
