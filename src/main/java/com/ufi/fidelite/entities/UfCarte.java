/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.entities;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "uf_carte", catalog = "ufi_fidelite", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"numero"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UfCarte.findAll", query = "SELECT u FROM UfCarte u")
    , @NamedQuery(name = "UfCarte.findByNumero", query = "SELECT u FROM UfCarte u WHERE u.numero = :numero")
    , @NamedQuery(name = "UfCarte.findByCompteurPoint", query = "SELECT u FROM UfCarte u WHERE u.compteurPoint = :compteurPoint")
    , @NamedQuery(name = "UfCarte.findByMontantAcumule", query = "SELECT u FROM UfCarte u WHERE u.montantAcumule = :montantAcumule")
    , @NamedQuery(name = "UfCarte.findByNombreTransaction", query = "SELECT u FROM UfCarte u WHERE u.nombreTransaction = :nombreTransaction")
    , @NamedQuery(name = "UfCarte.findByStatut", query = "SELECT u FROM UfCarte u WHERE u.statut = :statut")})
public class UfCarte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String numero;
    @Column(name = "compteur_point")
    private BigInteger compteurPoint;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant_acumule", precision = 22)
    private Double montantAcumule;
    @Column(name = "nombre_transaction")
    private Integer nombreTransaction;
    @Basic(optional = false)
    //@NotNull
    @Column(nullable = false)
    private short statut;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carte", fetch = FetchType.LAZY)
//    private List<UfTransaction> ufTransactionList;
    @JoinColumn(name = "categorie_carte", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UfCategorieCarte categorieCarte;
    @JoinColumn(name = "client", referencedColumnName = "code")
    @ManyToOne(fetch = FetchType.LAZY)
    private UfClient client;

    public UfCarte() {
    }

    public UfCarte(String numero, BigInteger compteurPoint, Double montantAcumule, Integer nombreTransaction, short statut, UfCategorieCarte categorieCarte, UfClient client) {
        this.numero = numero;
        this.compteurPoint = compteurPoint;
        this.montantAcumule = montantAcumule;
        this.nombreTransaction = nombreTransaction;
        this.statut = statut;
        this.categorieCarte = categorieCarte;
        this.client = client;
    }
    
    

    public UfCarte(String numero) {
        this.numero = numero;
    }

    public UfCarte(String numero, short statut) {
        this.numero = numero;
        this.statut = statut;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigInteger getCompteurPoint() {
        return compteurPoint;
    }

    public void setCompteurPoint(BigInteger compteurPoint) {
        this.compteurPoint = compteurPoint;
    }

    public Double getMontantAcumule() {
        return montantAcumule;
    }

    public void setMontantAcumule(Double montantAcumule) {
        this.montantAcumule = montantAcumule;
    }

    public Integer getNombreTransaction() {
        return nombreTransaction;
    }

    public void setNombreTransaction(Integer nombreTransaction) {
        this.nombreTransaction = nombreTransaction;
    }

    public short getStatut() {
        return statut;
    }

    public void setStatut(short statut) {
        this.statut = statut;
    }

    //@XmlTransient
//    public List<UfTransaction> getUfTransactionList() {
//        return ufTransactionList;
//    }
//
//    public void setUfTransactionList(List<UfTransaction> ufTransactionList) {
//        this.ufTransactionList = ufTransactionList;
//    }

    public UfCategorieCarte getCategorieCarte() {
        return categorieCarte;
    }

    public void setCategorieCarte(UfCategorieCarte categorieCarte) {
        this.categorieCarte = categorieCarte;
    }

    public UfClient getClient() {
        return client;
    }

    public void setClient(UfClient client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UfCarte)) {
            return false;
        }
        UfCarte other = (UfCarte) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufi.fidelite.entities.UfCarte[ numero=" + numero + " ]";
    }
    
}
