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
import javax.persistence.Lob;
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
@Table(name = "uf_type_offre", catalog = "ufi_fidelite", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UfTypeOffre.findAll", query = "SELECT u FROM UfTypeOffre u")
    , @NamedQuery(name = "UfTypeOffre.findByCode", query = "SELECT u FROM UfTypeOffre u WHERE u.code = :code")
    , @NamedQuery(name = "UfTypeOffre.findByLibelle", query = "SELECT u FROM UfTypeOffre u WHERE u.libelle = :libelle")})
public class UfTypeOffre implements Serializable {

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
    private String libelle;
    @Lob
    //@Size(max = 16777215)
    @Column(length = 16777215)
    private String description;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeOffre", fetch = FetchType.LAZY)
//    private List<UfOffre> ufOffreList;

    public UfTypeOffre() {
    }

    public UfTypeOffre(String code) {
        this.code = code;
    }

    public UfTypeOffre(String code, String libelle, String description) {
        this.code = code;
        this.libelle = libelle;
        this.description = description;
    }
    
    

    public UfTypeOffre(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof UfTypeOffre)) {
            return false;
        }
        UfTypeOffre other = (UfTypeOffre) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufi.fidelite.entities.UfTypeOffre[ code=" + code + " ]";
    }
    
}
