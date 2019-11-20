/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.entities.mirrors;

import java.io.Serializable;

/**
 *
 * @author R. KOUANI
 */
public class CommercantMirror  {
    
    private String code;
    private String Acronyme;
    private String nom;
    private String telephone1;
    private String telephone2;
    private String adresse;
    private String email;
    //private Integer ville; 
    private String ville;
    private short statut;

    public CommercantMirror() {
    }
    
    
    
    

    public CommercantMirror(String code, String Acronyme, String nom, String telephone1, String telephone2, String adresse, String email, String ville, short statut) {
        this.code = code;
        this.Acronyme = Acronyme;
        this.nom = nom;
        this.telephone1 = telephone1;
        this.telephone2 = telephone2;
        this.adresse = adresse;
        this.email = email;
        this.ville = ville;
        this.statut=statut;
    }

    public String getCode() {
        return code;
    }

    public String getAcronyme() {
        return Acronyme;
    }

    public String getNom() {
        return nom;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getVille() {
        return ville;
    }

    public short getStatut() {
        return statut;
    }
    
    

    public void setCode(String code) {
        this.code = code;
    }

    public void setAcronyme(String Acronyme) {
        this.Acronyme = Acronyme;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setStatut(short statut) {
        this.statut = statut;
    }
    

    @Override
    public String toString() {
        return "CommercantMirror{" + "code=" + code + ", Acronyme=" + Acronyme + ", nom=" + nom + ", telephone1=" + telephone1 + ", telephone2=" + telephone2 + ", adresse=" + adresse + ", email=" + email + ", ville=" + ville + '}';
    }
    
    
            
    
}
