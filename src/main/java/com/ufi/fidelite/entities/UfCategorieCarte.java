/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author R. KOUANI
 */
@Entity
@Table(name = "uf_categorie_carte", catalog = "ufi_fidelite", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UfCategorieCarte.findAll", query = "SELECT u FROM UfCategorieCarte u")
    , @NamedQuery(name = "UfCategorieCarte.findByCode", query = "SELECT u FROM UfCategorieCarte u WHERE u.code = :code")
    , @NamedQuery(name = "UfCategorieCarte.findByLebelle", query = "SELECT u FROM UfCategorieCarte u WHERE u.lebelle = :lebelle")
    , @NamedQuery(name = "UfCategorieCarte.findByPeriodicite", query = "SELECT u FROM UfCategorieCarte u WHERE u.periodicite = :periodicite")
    , @NamedQuery(name = "UfCategorieCarte.findByAction", query = "SELECT u FROM UfCategorieCarte u WHERE u.action = :action")
    , @NamedQuery(name = "UfCategorieCarte.findByStatut", query = "SELECT u FROM UfCategorieCarte u WHERE u.statut = :statut")})
@SuppressWarnings("ValidAttributes")
public class UfCategorieCarte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String code;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String lebelle;
    //@Size(max = 20)
    @Column(length = 20)
    private String periodicite;
    @Basic(optional = false)
    //@NotNull
    @Column(nullable = false)
    private short action;
    @Basic(optional = false)
    //@NotNull
    @Column(nullable = false)
    private short statut;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorieCarte", fetch = FetchType.LAZY)
//    private List<UfCarte> ufCarteList;
    @JoinColumn(name = "commercant", referencedColumnName = "code")
    @ManyToOne(fetch = FetchType.LAZY)
    private UfCommercant commercant;
    @JoinColumn(name = "politique_evaluation", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UfPolitiqueEvaluation politiqueEvaluation;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorieCarte", fetch = FetchType.LAZY)
//    private List<UfOffre> ufOffreList;

    public UfCategorieCarte() {
    }

    public UfCategorieCarte(String code, String lebelle, String periodicite, short action, short statut, UfCommercant commercant, UfPolitiqueEvaluation politiqueEvaluation) {
        this.code = code;
        this.lebelle = lebelle;
        this.periodicite = periodicite;
        this.action = action;
        this.statut = statut;
        this.commercant = commercant;
        this.politiqueEvaluation = politiqueEvaluation;
    }
    
    

    public UfCategorieCarte(String code) {
        this.code = code;
    }

    public UfCategorieCarte(String code, String lebelle, short action, short statut) {
        this.code = code;
        this.lebelle = lebelle;
        this.action = action;
        this.statut = statut;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLebelle() {
        return lebelle;
    }

    public void setLebelle(String lebelle) {
        this.lebelle = lebelle;
    }

    public String getPeriodicite() {
        return periodicite;
    }

    public void setPeriodicite(String periodicite) {
        this.periodicite = periodicite;
    }

    public short getAction() {
        return action;
    }

    public void setAction(short action) {
        this.action = action;
    }

    public short getStatut() {
        return statut;
    }

    public void setStatut(short statut) {
        this.statut = statut;
    }

//    @XmlTransient
//    public List<UfCarte> getUfCarteList() {
//        return ufCarteList;
//    }
//
//    public void setUfCarteList(List<UfCarte> ufCarteList) {
//        this.ufCarteList = ufCarteList;
//    }

    public UfCommercant getCommercant() {
        return commercant;
    }

    public void setCommercant(UfCommercant commercant) {
        this.commercant = commercant;
    }

    public UfPolitiqueEvaluation getPolitiqueEvaluation() {
        return politiqueEvaluation;
    }

    public void setPolitiqueEvaluation(UfPolitiqueEvaluation politiqueEvaluation) {
        this.politiqueEvaluation = politiqueEvaluation;
    }

//    @XmlTransient
//    public List<UfOffre> getUfOffreList() {
//        return ufOffreList;
//    }
//
//    public void setUfOffreList(List<UfOffre> ufOffreList) {
//        this.ufOffreList = ufOffreList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UfCategorieCarte)) {
            return false;
        }
        UfCategorieCarte other = (UfCategorieCarte) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

//   

    @Override
    public String toString() {
        return "UfCategorieCarte{" + "code=" + code + ", lebelle=" + lebelle + ", periodicite=" + periodicite + ", action=" + action + ", statut=" + statut + ", commercant=" + commercant + ", politiqueEvaluation=" + politiqueEvaluation + '}';
    }

    
}
