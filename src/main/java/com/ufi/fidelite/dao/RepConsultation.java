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
   
    private Object securite;
    private double montantInitial;
    private double montantReduit;

    public RepConsultation( Object securite, double montantInitial, double montantReduit) {
        
        this.securite = securite;
        this.montantInitial = montantInitial;
        this.montantReduit = montantReduit;
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
