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
public class ClientMirror {
    
    private String code;
    private String titre;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String telephone1;
    private String telephone2;
    private String adresse;
    private String email;
    private short statut;
    //private Integer ville;
    private String ville;

    public ClientMirror() {
    }

    public ClientMirror(String code, String titre, String nom, String prenom, Date dateNaissance, String telephone1, String telephone2, String adresse, String email, Short statut, String ville) {
        this.code = code;
        this.titre = titre;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.telephone1 = telephone1;
        this.telephone2 = telephone2;
        this.adresse = adresse;
        this.email = email;
        this.statut = statut;
        this.ville = ville;
    }

    public String getCode() {
        return code;
    }

    public String getTitre() {
        return titre;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
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

    public Short getStatut() {
        return statut;
    }

    public String getVille() {
        return ville;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
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

    public void setStatut(Short statut) {
        this.statut = statut;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "ClientMirror{" + "code=" + code + ", titre=" + titre + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", telephone1=" + telephone1 + ", telephone2=" + telephone2 + ", adresse=" + adresse + ", email=" + email + ", statut=" + statut + ", ville=" + ville + '}';
    }
    
    
    
    
    
    
    
    
    
}
