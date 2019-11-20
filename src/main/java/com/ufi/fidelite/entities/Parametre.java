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
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author R. KOUANI
 */
@Entity
@Table(catalog = "ufi_fidelite", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametre.findAll", query = "SELECT p FROM Parametre p")
    , @NamedQuery(name = "Parametre.findByCode", query = "SELECT p FROM Parametre p WHERE p.code = :code")})
public class Parametre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 100)
    @Column(nullable = false, length = 100)
    private String code;
    @Basic(optional = false)
    //@NotNull
    @Lob
    //@Size(min = 1, max = 16777215)
    @Column(nullable = false, length = 16777215)
    private String valeur;

    public Parametre() {
    }

    public Parametre(String code) {
        this.code = code;
    }

    public Parametre(String code, String valeur) {
        this.code = code;
        this.valeur = valeur;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
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
        if (!(object instanceof Parametre)) {
            return false;
        }
        Parametre other = (Parametre) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufi.fidelite.entities.Parametre[ code=" + code + " ]";
    }
    
}
