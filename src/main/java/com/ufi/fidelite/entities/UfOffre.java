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
@Table(name = "uf_offre", catalog = "ufi_fidelite", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UfOffre.findAll", query = "SELECT u FROM UfOffre u")
    , @NamedQuery(name = "UfOffre.findById", query = "SELECT u FROM UfOffre u WHERE u.id = :id")
    , @NamedQuery(name = "UfOffre.findByCode", query = "SELECT u FROM UfOffre u WHERE u.code = :code")
    , @NamedQuery(name = "UfOffre.findByLibele", query = "SELECT u FROM UfOffre u WHERE u.libele = :libele")
    , @NamedQuery(name = "UfOffre.findByOrientation", query = "SELECT u FROM UfOffre u WHERE u.orientation = :orientation")
    , @NamedQuery(name = "UfOffre.findByDateDebut", query = "SELECT u FROM UfOffre u WHERE u.dateDebut = :dateDebut")
    , @NamedQuery(name = "UfOffre.findByDateFin", query = "SELECT u FROM UfOffre u WHERE u.dateFin = :dateFin")
    , @NamedQuery(name = "UfOffre.findByStatut", query = "SELECT u FROM UfOffre u WHERE u.statut = :statut")})
public class UfOffre implements Serializable {

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
    private String code;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String libele;
    @Basic(optional = false)
    //@NotNull
    @Column(nullable = false)
    private short orientation;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "date_debut", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "date_fin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Basic(optional = false)
    //@NotNull
    @Column(nullable = false)
    private short statut;
    @JoinColumn(name = "categorie_carte", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UfCategorieCarte categorieCarte;
    @JoinColumn(name = "type_offre", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UfTypeOffre typeOffre;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "offre", fetch = FetchType.LAZY)
//    private List<UfPalier> ufPalierList;

    public UfOffre() {
    }

    public UfOffre(Integer id) {
        this.id = id;
    }

    public UfOffre(Integer id, String code, String libele, short orientation, Date dateDebut, Date dateFin, short statut) {
        this.id = id;
        this.code = code;
        this.libele = libele;
        this.orientation = orientation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
    }

    public UfOffre(String code, String libele, short orientation, Date dateDebut, Date dateFin, short statut, UfCategorieCarte categorieCarte, UfTypeOffre typeOffre) {
        this.code = code;
        this.libele = libele;
        this.orientation = orientation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = statut;
        this.categorieCarte = categorieCarte;
        this.typeOffre = typeOffre;
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

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibele() {
        return libele; 
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public short getOrientation() {
        return orientation;
    }

    public void setOrientation(short orientation) {
        this.orientation = orientation;
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

    public short getStatut() {
        return statut;
    }

    public void setStatut(short statut) {
        this.statut = statut;
    }

    public UfCategorieCarte getCategorieCarte() {
        return categorieCarte;
    }

    public void setCategorieCarte(UfCategorieCarte categorieCarte) {
        this.categorieCarte = categorieCarte;
    }

    public UfTypeOffre getTypeOffre() {
        return typeOffre;
    }

    public void setTypeOffre(UfTypeOffre typeOffre) {
        this.typeOffre = typeOffre;
    }

//    @XmlTransient
//    public List<UfPalier> getUfPalierList() {
//        return ufPalierList;
//    }
//
//    public void setUfPalierList(List<UfPalier> ufPalierList) {
//        this.ufPalierList = ufPalierList;
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
        if (!(object instanceof UfOffre)) {
            return false;
        }
        
        UfOffre other = (UfOffre) object;
         if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufi.fidelite.entities.UfOffre[ id=" + id + " ]";
    }
    
}
