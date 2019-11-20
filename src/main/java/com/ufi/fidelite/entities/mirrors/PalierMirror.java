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
public class PalierMirror {
    private Double montantInf ;
    private Double montantSup ;
    private Integer uniteDevise ;
    private Integer unitePoint ;
    private String offre ;

    public PalierMirror() {
    }

    public PalierMirror(Double montantInf, Double montantSup, Integer uniteDevise, Integer unitePoint, String offre) {
        this.montantInf = montantInf;
        this.montantSup = montantSup;
        this.uniteDevise = uniteDevise;
        this.unitePoint = unitePoint;
        this.offre = offre;
    }

    public Double getMontantInf() {
        return montantInf;
    }

    public Double getMontantSup() {
        return montantSup;
    }

    public Integer getUniteDevise() {
        return uniteDevise;
    }

    public Integer getUnitePoint() {
        return unitePoint;
    }

    public String getOffre() {
        return offre;
    }

    public void setMontantInf(Double montantInf) {
        this.montantInf = montantInf;
    }

    public void setMontantSup(Double montantSup) {
        this.montantSup = montantSup;
    }

    public void setUniteDevise(Integer uniteDevise) {
        this.uniteDevise = uniteDevise;
    }

    public void setUnitePoint(Integer unitePoint) {
        this.unitePoint = unitePoint;
    }

    public void setOffre(String offre) {
        this.offre = offre;
    }

    @Override
    public String toString() {
        return "PalierMirror{" + "montantInf=" + montantInf + ", montantSup=" + montantSup + ", uniteDevise=" + uniteDevise + ", unitePoint=" + unitePoint + ", offre=" + offre + '}';
    }
    
    
    
    
    
    
     
}
