/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.entities.mirrors;

import com.ufi.fidelite.entities.UfPays;
import java.util.Date;

/**
 *
 * @author R. KOUANI
 */
public class RegionMirror {
    private String code;
    private String nom;
    private Date dateCreation;
    private String pays;
    private String description;

    public RegionMirror() {
    }

    public RegionMirror(String code, String nom, Date dateCreation, String pays, String description) {
        this.code = code;
        this.nom = nom;
        this.dateCreation = dateCreation;
        this.pays = pays;
        this.description = description;
        
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public String getPays() {
        return pays;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    @Override
    public String toString() {
        return "RegionMirror{" + "code=" + code + ", nom=" + nom + ", dateCreation=" + dateCreation + ", pays=" + pays + '}';
    }
    
    
    
    
     
    
}
