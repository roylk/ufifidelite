/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author R. KOUANI
 */
@Entity
@Table(catalog = "ufi_fidelite", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conversion.findAll", query = "SELECT c FROM Conversion c")
    , @NamedQuery(name = "Conversion.findById", query = "SELECT c FROM Conversion c WHERE c.id = :id")
    , @NamedQuery(name = "Conversion.findByNbpointInf", query = "SELECT c FROM Conversion c WHERE c.nbpointInf = :nbpointInf")
    , @NamedQuery(name = "Conversion.findByNbpointSup", query = "SELECT c FROM Conversion c WHERE c.nbpointSup = :nbpointSup")
    , @NamedQuery(name = "Conversion.findByReduction", query = "SELECT c FROM Conversion c WHERE c.reduction = :reduction")
    , @NamedQuery(name = "Conversion.findByType", query = "SELECT c FROM Conversion c WHERE c.type = :type")})
public class Conversion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "nbpoint_inf", nullable = false)
    private int nbpointInf;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "nbpoint_sup", nullable = false)
    private int nbpointSup;
    @Basic(optional = false)
    //@NotNull
    @Column(nullable = false)
    private double reduction;
    @Basic(optional = false)
    //@NotNull
    @Column(nullable = false)
    private short type;
    @JoinColumn(name = "commercant", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UfCommercant commercant;

    public Conversion() {
    }

    public Conversion(int nbpointInf, int nbpointSup, double reduction, short type, UfCommercant commercant) {
        this.nbpointInf = nbpointInf;
        this.nbpointSup = nbpointSup;
        this.reduction = reduction;
        this.type = type;
        this.commercant = commercant;
    }
    
    

    public Conversion(Integer id) {
        this.id = id;
    }

    public Conversion(Integer id, int nbpointInf, int nbpointSup, double reduction, short type) {
        this.id = id;
        this.nbpointInf = nbpointInf;
        this.nbpointSup = nbpointSup;
        this.reduction = reduction;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNbpointInf() {
        return nbpointInf;
    }

    public void setNbpointInf(int nbpointInf) {
        this.nbpointInf = nbpointInf;
    }

    public int getNbpointSup() {
        return nbpointSup;
    }

    public void setNbpointSup(int nbpointSup) {
        this.nbpointSup = nbpointSup;
    }

    public double getReduction() {
        return reduction;
    }

    public void setReduction(double reduction) {
        this.reduction = reduction;
    }

    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }

    public UfCommercant getCommercant() {
        return commercant;
    }

    public void setCommercant(UfCommercant commercant) {
        this.commercant = commercant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conversion)) {
            return false;
        }
        Conversion other = (Conversion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufi.fidelite.entities.Conversion[ id=" + id + " ]";
    }
    
}
