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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "uf_ville", catalog = "ufi_fidelite", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UfVille.findAll", query = "SELECT u FROM UfVille u")
    , @NamedQuery(name = "UfVille.findById", query = "SELECT u FROM UfVille u WHERE u.id = :id")
    , @NamedQuery(name = "UfVille.findByCode", query = "SELECT u FROM UfVille u WHERE u.code = :code")
    , @NamedQuery(name = "UfVille.findByDateCreation", query = "SELECT u FROM UfVille u WHERE u.dateCreation = :dateCreation")})
public class UfVille implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 5)
    @Column(nullable = false, length = 5)
    private String code;
    @Column(nullable = false, length = 45)
    private String nom ;
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ville", fetch = FetchType.LAZY)
//    private List<UfPointDeVente> ufPointDeVenteList;
    @JoinColumn(name = "region", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UfRegion region;
    @Column()
    private String description;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ville", fetch = FetchType.LAZY)
//    private List<UfClient> ufClientList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ville", fetch = FetchType.LAZY)
//    private List<UfCommercant> ufCommercantList;

    public UfVille() {
    }

    public UfVille(Integer id) {
        this.id = id;
    }

    public UfVille(Integer id, String code) {
        this.id = id;
        this.code = code;
    }

    public UfVille(String code,String nom, Date dateCreation, UfRegion region, String description) {
        this.code = code;
        this.nom=nom;
        this.dateCreation = dateCreation;
        this.region = region;
        this.description=description;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }
    
    

    public void setCode(String code) {
        this.code = code;
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

//    @XmlTransient
//    public List<UfPointDeVente> getUfPointDeVenteList() {
//        return ufPointDeVenteList;
//    }
//
//    public void setUfPointDeVenteList(List<UfPointDeVente> ufPointDeVenteList) {
//        this.ufPointDeVenteList = ufPointDeVenteList;
//    }

    public UfRegion getRegion() {
        return region;
    }

    public void setRegion(UfRegion region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

//    @XmlTransient
//    public List<UfClient> getUfClientList() {
//        return ufClientList;
//    }
//
//    public void setUfClientList(List<UfClient> ufClientList) {
//        this.ufClientList = ufClientList;
//    }
//
//    @XmlTransient
//    public List<UfCommercant> getUfCommercantList() {
//        return ufCommercantList;
//    }
//
//    public void setUfCommercantList(List<UfCommercant> ufCommercantList) {
//        this.ufCommercantList = ufCommercantList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UfVille)) {
            return false;
        }
        UfVille other = (UfVille) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufi.fidelite.entities.UfVille[ id=" + id + " ]";
    }
    
}
