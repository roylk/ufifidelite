/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "uf_pays", catalog = "ufi_fidelite", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UfPays.findAll", query = "SELECT u FROM UfPays u")
    , @NamedQuery(name = "UfPays.findByCode", query = "SELECT u FROM UfPays u WHERE u.code = :code")
    , @NamedQuery(name = "UfPays.findByNom", query = "SELECT u FROM UfPays u WHERE u.nom = :nom")
    , @NamedQuery(name = "UfPays.findByDateCreation", query = "SELECT u FROM UfPays u WHERE u.dateCreation = :dateCreation")})
public class UfPays implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
   // @NotNull
    //@Size(min = 1, max = 5)
    @Column(nullable = false, length = 5)
    private String code;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(nullable = false, length = 45) 
    private String nom;
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column()
    private String description;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pays", fetch = FetchType.LAZY)
//    private List<UfRegion> ufRegionList;

    public UfPays() {
    }

    public UfPays(String code) {
        this.code = code;
    }

    public UfPays(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public UfPays(String code, String nom, Date dateCreation, String description) {
        this.code = code;
        this.nom = nom;
        this.dateCreation = dateCreation;
        this.description=description;
    }
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

//    @XmlTransient
//    public List<UfRegion> getUfRegionList() {
//        return ufRegionList;
//    }
//
//    public void setUfRegionList(List<UfRegion> ufRegionList) {
//        this.ufRegionList = ufRegionList;
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
        if (!(object instanceof UfPays)) {
            return false;
        }
        UfPays other = (UfPays) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufi.fidelite.entities.UfPays[ code=" + code + " ]";
    }
    
}
