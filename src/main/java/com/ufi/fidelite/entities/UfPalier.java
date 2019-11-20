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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author R. KOUANI
 */
@Entity
@Table(name = "uf_palier", catalog = "ufi_fidelite", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UfPalier.findAll", query = "SELECT u FROM UfPalier u")
    , @NamedQuery(name = "UfPalier.findById", query = "SELECT u FROM UfPalier u WHERE u.id = :id")
    , @NamedQuery(name = "UfPalier.findByMontantInf", query = "SELECT u FROM UfPalier u WHERE u.montantInf = :montantInf")
    , @NamedQuery(name = "UfPalier.findByMontantSup", query = "SELECT u FROM UfPalier u WHERE u.montantSup = :montantSup")
    , @NamedQuery(name = "UfPalier.findByUniteDevise", query = "SELECT u FROM UfPalier u WHERE u.uniteDevise = :uniteDevise")
    , @NamedQuery(name = "UfPalier.findByUnitePoint", query = "SELECT u FROM UfPalier u WHERE u.unitePoint = :unitePoint")})
public class UfPalier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant_inf", precision = 22)
    private Double montantInf;
    @Column(name = "montant_sup", precision = 22)
    private Double montantSup;
    @Column(name = "unite_devise")
    private Integer uniteDevise;
    @Column(name = "unite_point")
    private Integer unitePoint;
    @JoinColumn(name = "offre", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UfOffre offre;

    public UfPalier() {
    }

    public UfPalier(Integer id) {
        this.id = id;
    }

    public UfPalier(Double montantInf, Double montantSup, Integer uniteDevise, Integer unitePoint, UfOffre offre) {
        this.montantInf = montantInf;
        this.montantSup = montantSup;
        this.uniteDevise = uniteDevise;
        this.unitePoint = unitePoint;
        this.offre = offre;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMontantInf() {
        return montantInf;
    }

    public void setMontantInf(Double montantInf) {
        this.montantInf = montantInf;
    }

    public Double getMontantSup() {
        return montantSup;
    }

    public void setMontantSup(Double montantSup) {
        this.montantSup = montantSup;
    }

    public Integer getUniteDevise() {
        return uniteDevise;
    }

    public void setUniteDevise(Integer uniteDevise) {
        this.uniteDevise = uniteDevise;
    }

    public Integer getUnitePoint() {
        return unitePoint;
    }

    public void setUnitePoint(Integer unitePoint) {
        this.unitePoint = unitePoint;
    }

    public UfOffre getOffre() {
        return offre;
    }

    public void setOffre(UfOffre offre) {
        this.offre = offre;
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
        if (!(object instanceof UfPalier)) {
            return false;
        }
        UfPalier other = (UfPalier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufi.fidelite.entities.UfPalier[ id=" + id + " ]";
    }
    
}
