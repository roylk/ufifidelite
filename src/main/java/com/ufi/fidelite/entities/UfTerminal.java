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
@Table(name = "uf_terminal", catalog = "ufi_fidelite", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UfTerminal.findAll", query = "SELECT u FROM UfTerminal u")
    , @NamedQuery(name = "UfTerminal.findByCode", query = "SELECT u FROM UfTerminal u WHERE u.code = :code")
    , @NamedQuery(name = "UfTerminal.findByDesignation", query = "SELECT u FROM UfTerminal u WHERE u.designation = :designation")
    , @NamedQuery(name = "UfTerminal.findByNumeroSerie", query = "SELECT u FROM UfTerminal u WHERE u.numeroSerie = :numeroSerie")
    , @NamedQuery(name = "UfTerminal.findByStatut", query = "SELECT u FROM UfTerminal u WHERE u.statut = :statut")})
public class UfTerminal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
   // @NotNull
    //@Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String code;
    //@Size(max = 45)
    @Column(length = 45)
    private String designation;
    @Basic(optional = false)
   // @NotNull
    //@Size(min = 1, max = 45)
    @Column(name = "numero_serie", nullable = false, length = 45)
    private String numeroSerie;
    @Basic(optional = false)
   // @NotNull
    @Column(nullable = false)
    private short statut;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "terminal", fetch = FetchType.LAZY)
//    private List<UfTransaction> ufTransactionList;
    @JoinColumn(name = "point_de_vente", referencedColumnName = "code")
    @ManyToOne(fetch = FetchType.LAZY)
    private UfPointDeVente pointDeVente;

    public UfTerminal() {
    }

    public UfTerminal(String code) {
        this.code = code;
    }

    public UfTerminal(String code, String designation, String numeroSerie, short statut, UfPointDeVente pointDeVente) {
        this.code = code;
        this.designation = designation;
        this.numeroSerie = numeroSerie;
        this.statut = statut;
        this.pointDeVente = pointDeVente;
    }
    

    public UfTerminal(String code, String numeroSerie, short statut) {
        this.code = code;
        this.numeroSerie = numeroSerie;
        this.statut = statut;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public short getStatut() {
        return statut;
    }

    public void setStatut(short statut) {
        this.statut = statut;
    }

//    @XmlTransient
//    public List<UfTransaction> getUfTransactionList() {
//        return ufTransactionList;
//    }
//
//    public void setUfTransactionList(List<UfTransaction> ufTransactionList) {
//        this.ufTransactionList = ufTransactionList;
//    }

    public UfPointDeVente getPointDeVente() {
        return pointDeVente;
    }

    public void setPointDeVente(UfPointDeVente pointDeVente) {
        this.pointDeVente = pointDeVente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UfTerminal)) {
            return false;
        }
        UfTerminal other = (UfTerminal) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufi.fidelite.entities.UfTerminal[ code=" + code + " ]";
    }
    
}
