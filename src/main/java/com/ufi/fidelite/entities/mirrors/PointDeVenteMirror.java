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
public class PointDeVenteMirror {
    private String code;
    private String acronyme;
    private String nom;
    private String adresse;
    private String email;
    private String telephone1;
    private String telephone2;
    private short statut;
    private String commercantCode;
    //private Integer ville;
    private String ville;
    
    

    public PointDeVenteMirror() {
    }

    public PointDeVenteMirror(String code, String acronyme,String nom, String adresse, String email, String telephone1, String telephone2, short statut, String commercantCode, String ville) {
        this.code = code;
        this.acronyme = acronyme;
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.telephone1 = telephone1;
        this.telephone2 = telephone2;
        this.statut = statut;
        this.commercantCode = commercantCode;
        this.ville = ville;
    }

    public String getCode() {
        return code;
    }

    public String getAcronyme() {
        return acronyme;
    }

    public String getNom() {
        return nom;
    }
    
    

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public short getStatut() {
        return statut;
    }

    public String getCommercantCode() {
        return commercantCode;
    }

    public String getVille() {
        return ville;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setAcronyme(String acronyme) {
        this.acronyme = acronyme;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public void setStatut(short statut) {
        this.statut = statut;
    }

    public void setCommercant(String commercantCode) {
        this.commercantCode = commercantCode;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "PointDeVenteMirror{" + "code=" + code + ", acronyme=" + acronyme + ", adresse=" + adresse + ", email=" + email + ", telephone1=" + telephone1 + ", telephone2=" + telephone2 + ", statut=" + statut + ", commercant=" + commercantCode + ", ville=" + ville + '}';
    }
    
    
    
    
}


