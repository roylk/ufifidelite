/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.entities.mirrors;


/**
 *
 * @author R. KOUANI
 */
public class CategorieCarteMirror {
    
    private String code;
    private String lebelle;
    private String periodicite;
    private short action;
    private short statut;
    private String commercant;
    private String politiqueEvaluation;

    public CategorieCarteMirror() {
    }

    public CategorieCarteMirror(String code, String lebelle, String periodicite, short action, short statut, String commercant, String politiqueEvaluation) {
        this.code = code;
        this.lebelle = lebelle;
        this.periodicite = periodicite;
        this.action = action;
        this.statut = statut;
        this.commercant = commercant;
        this.politiqueEvaluation = politiqueEvaluation;
   
    }

    public String getCode() {
        return code;
    }

    public String getLebelle() {
        return lebelle;
    }

    public String getPeriodicite() {
        return periodicite;
    }

    public short getAction() {
        return action;
    }

    public short getStatut() {
        return statut;
    }

    public String getCommercant() {
        return commercant;
    }

    public String getPolitiqueEvaluation() {
        return politiqueEvaluation;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLebelle(String lebelle) {
        this.lebelle = lebelle;
    }

    public void setPeriodicite(String periodicite) {
        this.periodicite = periodicite;
    }

    public void setAction(short action) {
        this.action = action;
    }

    public void setStatut(short statut) {
        this.statut = statut;
    }

    public void setCommercant(String commercant) {
        this.commercant = commercant;
    }

    public void setPolitiqueEvaluation(String politiqueEvaluation) {
        this.politiqueEvaluation = politiqueEvaluation;
    }

    @Override
    public String toString() {
        return "CategorieCarteMirror{" + "code=" + code + ", lebelle=" + lebelle + ", periodicite=" + periodicite + ", action=" + action + ", statut=" + statut + ", commercant=" + commercant + ", politiqueEvaluation=" + politiqueEvaluation + '}';
    }
    
    
    
    
            
    
    
    
    
     
    
}
