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
public class TerminalMirror {
    private String code; 
    private String designation;
    private String numeroSerie;
    private short statut;
    private String pointDeVente;
    
    

    public TerminalMirror() {
        
    }

    public TerminalMirror(String code, String designation, String numeroSerie, short statut, String pointDeVente) {
        this.code = code;
        this.designation = designation;
        this.numeroSerie = numeroSerie;
        this.statut = statut;
        this.pointDeVente = pointDeVente;
    }

    public String getCode() {
        return code;
    }

    public String getDesignation() {
        return designation;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public short getStatut() {
        return statut;
    }

    public String getPointDeVente() {
        return pointDeVente;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public void setStatut(short statut) {
        this.statut = statut;
    }

    public void setPointDeVente(String pointDeVente) {
        this.pointDeVente = pointDeVente;
    }

    @Override
    public String toString() {
        return "TerminalMirror{" + "code=" + code + ", designation=" + designation + ", numeroSerie=" + numeroSerie + ", statut=" + statut + ", pointDeVente=" + pointDeVente + '}';
    }
    
    
    
}
