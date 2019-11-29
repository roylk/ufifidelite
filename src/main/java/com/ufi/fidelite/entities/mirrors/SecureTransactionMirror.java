/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.entities.mirrors;

import java.util.Date;

/**
 *
 * @author R. KOUANI
 */
public class SecureTransactionMirror {
    private String transactionId;
    private Date dateTransaction;
    private Double montantInitial;
    private Double montantReduit;
    private Date dateEnregistrement;
    private String carte;
    private String terminal;
    private String hash;
    private String login;
    private String motDePasse;
    
    public SecureTransactionMirror(){
        super();
    }

    public SecureTransactionMirror(String transactionId, Date dateTransaction, Double montantInitial, Double montantReduit, Date dateEnregistrement, String carte, String terminal, String hash, String login, String motDePasse) {
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

    public Double getMontantInitial() {
        return montantInitial;
    }

    public Double getMontantReduit() {
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

    public void setMontantInitial(Double montantInitial) {
        this.montantInitial = montantInitial;
    }

    public void setMontantReduit(Double montantReduit) {
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
    
    
    
    
    
    
}
