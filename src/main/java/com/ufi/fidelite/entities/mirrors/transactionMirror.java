/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.entities.mirrors;

import com.ufi.fidelite.entities.UfCarte;
import com.ufi.fidelite.entities.UfTerminal;
import java.util.Date;

/**
 *
 * @author R. KOUANI
 */
public class transactionMirror {
    
    private String transactionId;
    private Date dateTransaction;
    private Double montantInitial;
    private Double montantReduit;
    private Date dateEnregistrement;
    private String commentaire;
    private String carte;
    private String terminal;
    private boolean statut;

    public transactionMirror() {
    }

    public transactionMirror(String transactionId, Date dateTransaction, Double montantInitial, Double montantReduit, Date dateEnregistrement, String commentaire, String carte, String terminal, boolean statut) {
        this.transactionId = transactionId;
        this.dateTransaction = dateTransaction;
        this.montantInitial = montantInitial;
        this.montantReduit = montantReduit;
        this.dateEnregistrement = dateEnregistrement;
        this.commentaire = commentaire;
        this.carte = carte;
        this.terminal = terminal;
        this.statut= statut;
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

    public String getCommentaire() {
        return commentaire;
    }

    public String getCarte() {
        return carte;
    }

    public String getTerminal() {
        return terminal;
    }

    public boolean isStatut() {
        return statut;
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

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setCarte(String carte) {
        this.carte = carte;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }
    
    

    @Override
    public String toString() {
        return "transactionMirror{" + "transactionId=" + transactionId + ", dateTransaction=" + dateTransaction + ", montantInitial=" + montantInitial + ", montantReduit=" + montantReduit + ", dateEnregistrement=" + dateEnregistrement + ", commentaire=" + commentaire + ", carte=" + carte + ", terminal=" + terminal + '}';
    }
    
    
    
    
    
    

    
}
