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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author R. KOUANI
 */
@Entity
@Table(name = "uf_region", catalog = "ufi_fidelite", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UfRegion.findAll", query = "SELECT u FROM UfRegion u")
    , @NamedQuery(name = "UfRegion.findById", query = "SELECT u FROM UfRegion u WHERE u.id = :id")
    , @NamedQuery(name = "UfRegion.findByNom", query = "SELECT u FROM UfRegion u WHERE u.nom = :nom")
    , @NamedQuery(name = "UfRegion.findByDateCreation", query = "SELECT u FROM UfRegion u WHERE u.dateCreation = :dateCreation")})
public class UfRegion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    
    @Column(nullable = false, length = 5)
    private String code; 
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String nom;
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @JoinColumn(name = "pays", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UfPays pays;
    @Column()
    private String description;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "region", fetch = FetchType.LAZY)
//    private List<UfVille> ufVilleList;

    public UfRegion() {
    }

    public UfRegion(String nom,String code,Date dateCreation, UfPays pays,String description) {
        this.nom = nom;
        this.code= code;
        this.dateCreation = dateCreation;
        this.pays = pays;
        this.description = description;    }
    

    public UfRegion(Integer id) {
        this.id = id;
    }

    public UfRegion(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    public UfRegion( String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }
    

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public UfPays getPays() {
        return pays;
    }

    public void setPays(UfPays pays) {
        this.pays = pays;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
    

//    @XmlTransient
//    public List<UfVille> getUfVilleList() {
//        return ufVilleList;
//    }
//
//    public void setUfVilleList(List<UfVille> ufVilleList) {
//        this.ufVilleList = ufVilleList;
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
        if (!(object instanceof UfRegion)) {
            return false;
        }
        UfRegion other = (UfRegion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufi.fidelite.entities.UfRegion[ id=" + id + " ]";
    }
    
}
