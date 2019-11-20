/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author R. KOUANI
 */
@Entity
@Table(name = "uf_rapport", catalog = "ufi_fidelite", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UfRapport.findAll", query = "SELECT u FROM UfRapport u")
    , @NamedQuery(name = "UfRapport.findById", query = "SELECT u FROM UfRapport u WHERE u.id = :id")
    , @NamedQuery(name = "UfRapport.findByLibele", query = "SELECT u FROM UfRapport u WHERE u.libele = :libele")
    , @NamedQuery(name = "UfRapport.findByDateDebut", query = "SELECT u FROM UfRapport u WHERE u.dateDebut = :dateDebut")
    , @NamedQuery(name = "UfRapport.findByDateFin", query = "SELECT u FROM UfRapport u WHERE u.dateFin = :dateFin")
    , @NamedQuery(name = "UfRapport.findByNombreTraitement", query = "SELECT u FROM UfRapport u WHERE u.nombreTraitement = :nombreTraitement")})
public class UfRapport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String libele;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "date_debut", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "date_fin", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @Column(name = "nombre_traitement")
    private Integer nombreTraitement;
    @Lob
    //@Size(max = 16777215)
    @Column(length = 16777215)
    private String description;

    public UfRapport() {
    }

    public UfRapport(Integer id) {
        this.id = id;
    }

    public UfRapport(Integer id, String libele, Date dateDebut, Date dateFin) {
        this.id = id;
        this.libele = libele;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Integer getNombreTraitement() {
        return nombreTraitement;
    }

    public void setNombreTraitement(Integer nombreTraitement) {
        this.nombreTraitement = nombreTraitement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof UfRapport)) {
            return false;
        }
        UfRapport other = (UfRapport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufi.fidelite.entities.UfRapport[ id=" + id + " ]";
    }
    
}
