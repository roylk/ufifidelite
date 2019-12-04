/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.dao;

import java.io.Serializable;

/**
 *
 * @author R. KOUANI
 */
public class RepConsultation  implements Serializable{
    
    private int code;
    private boolean statut;
    private String message;
    private Object securite;
    private double montantInitial;
    private double montantReduit;

    public RepConsultation( int code, boolean statut, String message, Object securite, double montantInitial, double montantReduit) {
        this.code=code;
        this.statut=statut;
        this.message=message;
        this.securite = securite;
        this.montantInitial = montantInitial;
        this.montantReduit = montantReduit;
    }
    
   

    public int codeStatut() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }
    
    

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    public Object getSecurite() {
        return securite;
    }

    public double getMontantInitial() {
        return montantInitial;
    }

    public double getMontantReduit() {
        return montantReduit;
    }

   

    public void setSecurite(Object securite) {
        this.securite = securite;
    }

    public void setMontantInitial(double montantInitial) {
        this.montantInitial = montantInitial;
    }

    public void setMontantReduit(double montantReduit) {
        this.montantReduit = montantReduit;
    }
    
    
        
    }
    
    
    
    
    
    
    

