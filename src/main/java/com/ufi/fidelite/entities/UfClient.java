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
@Table(name = "uf_client", catalog = "ufi_fidelite", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})
    , @UniqueConstraint(columnNames = {"email"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UfClient.findAll", query = "SELECT u FROM UfClient u")
    , @NamedQuery(name = "UfClient.findByCode", query = "SELECT u FROM UfClient u WHERE u.code = :code")
    , @NamedQuery(name = "UfClient.findByTitre", query = "SELECT u FROM UfClient u WHERE u.titre = :titre")
    , @NamedQuery(name = "UfClient.findByNom", query = "SELECT u FROM UfClient u WHERE u.nom = :nom")
    , @NamedQuery(name = "UfClient.findByPrenom", query = "SELECT u FROM UfClient u WHERE u.prenom = :prenom")
    , @NamedQuery(name = "UfClient.findByDateNaissance", query = "SELECT u FROM UfClient u WHERE u.dateNaissance = :dateNaissance")
    , @NamedQuery(name = "UfClient.findByTelephone1", query = "SELECT u FROM UfClient u WHERE u.telephone1 = :telephone1")
    , @NamedQuery(name = "UfClient.findByTelephone2", query = "SELECT u FROM UfClient u WHERE u.telephone2 = :telephone2")
    , @NamedQuery(name = "UfClient.findByAdresse", query = "SELECT u FROM UfClient u WHERE u.adresse = :adresse")
    , @NamedQuery(name = "UfClient.findByEmail", query = "SELECT u FROM UfClient u WHERE u.email = :email")
    , @NamedQuery(name = "UfClient.findByStatut", query = "SELECT u FROM UfClient u WHERE u.statut = :statut")})
public class UfClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String code;
   // @Size(max = 15)
    @Column(length = 15)
    private String titre;
    //@Size(max = 45)
    @Column(length = 45)
    private String nom;
    //@Size(max = 45)
    @Column(length = 45)
    private String prenom;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "date_naissance", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String telephone1;
   // @Size(max = 45)
    @Column(length = 45)
    private String telephone2;
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String adresse;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String email;
    @Basic(optional = false)
    //@NotNull
    @Column(nullable = false)
    private short statut;
//    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
//    private List<UfCarte> ufCarteList;
    @JoinColumn(name = "ville", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UfVille ville;

    public UfClient() {
    }

    public UfClient(String code) {
        this.code = code;
    }

    public UfClient(String code, String titre, String nom, String prenom, Date dateNaissance, String telephone1, String telephone2, String adresse, String email, short statut, UfVille ville) {
        this.code = code;
        this.titre = titre;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.telephone1 = telephone1;
        this.telephone2 = telephone2;
        this.adresse = adresse;
        this.email = email;
        this.statut = statut;
        this.ville = ville;
    }
    
    

    public UfClient(String code, Date dateNaissance, String telephone1, String adresse, String email, short statut) {
        this.code = code;
        this.dateNaissance = dateNaissance;
        this.telephone1 = telephone1;
        this.adresse = adresse;
        this.email = email;
        this.statut = statut;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public short getStatut() {
        return statut;
    }

    public void setStatut(short statut) {
        this.statut = statut;
    }

    @XmlTransient
//    public List<UfCarte> getUfCarteList() {
//        return ufCarteList;
//    }
//
//    public void setUfCarteList(List<UfCarte> ufCarteList) {
//        this.ufCarteList = ufCarteList;
//    }

    public UfVille getVille() {
        return ville;
    }

    public void setVille(UfVille ville) {
        this.ville = ville;
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
        if (!(object instanceof UfClient)) {
            return false;
        }
        UfClient other = (UfClient) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufi.fidelite.entities.UfClient[ code=" + code + " ]";
    }
    
}
