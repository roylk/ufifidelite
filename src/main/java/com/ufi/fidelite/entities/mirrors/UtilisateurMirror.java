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
public class UtilisateurMirror {
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String login;
    private String motDePasse;
    private String sexe;
    private short statut;
    private String commercant;
    private int role;

    public UtilisateurMirror() {
    }
    
    
    public UtilisateurMirror(String nom, String prenom, String telephone, String email, String login, String motDePasse, String sexe, short statut, String commercant, int role) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.login = login;
        this.motDePasse = motDePasse;
        this.sexe = sexe;
        this.statut = statut;
        this.commercant = commercant;
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getSexe() {
        return sexe;
    }

    public short getStatut() {
        return statut;
    }

    public String getCommercant() {
        return commercant;
    }

    public int getRole() {
        return role;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setStatut(short statut) {
        this.statut = statut;
    }

    public void setCommercant(String commercant) {
        this.commercant = commercant;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UtilisateurMirror{" + "nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", email=" + email + ", login=" + login + ", motDePasse=" + motDePasse + ", sexe=" + sexe + ", statut=" + statut + ", commercant=" + commercant + ", role=" + role + '}';
    }
    
    
    
    
    
    
}
