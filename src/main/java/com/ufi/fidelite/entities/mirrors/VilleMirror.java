/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.entities.mirrors;

import com.ufi.fidelite.entities.UfRegion;
import java.util.Date;

/**
 *
 * @author R. KOUANI
 */
public class VilleMirror {
    private String code;
    private String nom;
    private Date dateCreation;
    private Integer Region;
    private String description;

    public VilleMirror() {
    }

    public VilleMirror(String code, String nom, Date dateCreation, Integer Region, String description) {
        this.code = code;
        this.nom = nom;
        this.dateCreation = dateCreation;
        this.Region = Region;
        this.description=description;
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

    public Integer getRegion() {
        return Region;
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

    public void setRegion(Integer Region) {
        this.Region = Region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    @Override
    public String toString() {
        return "VilleMirror{" + "code=" + code + ", nom=" + nom + ", dateCreation=" + dateCreation + ", Region=" + Region + '}';
    }
    
    
    
    
    
    
    
    
    
}
