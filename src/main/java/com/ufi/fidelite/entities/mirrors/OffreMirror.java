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
public class OffreMirror {
    private String code;
    private String libele;
    private short orientation;
    private Date dateDebut;
    private Date dateFin;
    private short statut;
    private String categorieCarte;
    private String typeOffre;

    public OffreMirror() {
    }

    public OffreMirror(String code, String libele, short orientation, Date dateDebut, Date dateFin, short statut, String categorieCarte, String typeOffre) {
        this.code = code;
        this.libele = libele;
        this.orientation = orientation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
        this.categorieCarte = categorieCarte;
        this.typeOffre = typeOffre;
    }

    public String getCode() {
        return code;
    }

    public String getLibele() {
        return libele;
    }

    public short getOrientation() {
        return orientation;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public short getStatut() {
        return statut;
    }

    public String getCategorieCarte() {
        return categorieCarte;
    }

    public String getTypeOffre() {
        return typeOffre;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public void setOrientation(short orientation) {
        this.orientation = orientation;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setStatut(short statut) {
        this.statut = statut;
    }

    public void setCategorieCarte(String categorieCarte) {
        this.categorieCarte = categorieCarte;
    }

    public void setTypeOffre(String typeOffre) {
        this.typeOffre = typeOffre;
    }

    @Override
    public String toString() {
        return "OffreMirror{" + "code=" + code + ", libele=" + libele + ", orientation=" + orientation + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", statut=" + statut + ", categorieCarte=" + categorieCarte + ", typeOffre=" + typeOffre + '}';
    }
    
 
    
    
    
    
    
}
