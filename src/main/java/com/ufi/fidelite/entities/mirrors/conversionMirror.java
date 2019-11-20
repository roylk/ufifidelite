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
public class conversionMirror {
      
    private int nbpointInf;
    private int nbpointSup;
    private double reduction;
    private short type;
    private String commercant;

    public conversionMirror() {
    }

    public conversionMirror(int nbpointInf, int nbpointSup, double reduction, short type, String commercant) {
        this.nbpointInf = nbpointInf;
        this.nbpointSup = nbpointSup;
        this.reduction = reduction;
        this.type = type;
        this.commercant = commercant;
    }

    public int getNbpointInf() {
        return nbpointInf;
    }

    public int getNbpointSup() {
        return nbpointSup;
    }

    public double getReduction() {
        return reduction;
    }

    public short getType() {
        return type;
    }

    public String getCommercant() {
        return commercant;
    }

    public void setNbpointInf(int nbpointInf) {
        this.nbpointInf = nbpointInf;
    }

    public void setNbpointSup(int nbpointSup) {
        this.nbpointSup = nbpointSup;
    }

    public void setReduction(double reduction) {
        this.reduction = reduction;
    }

    public void setType(short type) {
        this.type = type;
    }

    public void setCommercant(String commercant) {
        this.commercant = commercant;
    }

    @Override
    public String toString() {
        return "conversionMirror{" + "nbpointInf=" + nbpointInf + ", nbpointSup=" + nbpointSup + ", reduction=" + reduction + ", type=" + type + ", commercant=" + commercant + '}';
    }
    
    
    
    
   
    
}
