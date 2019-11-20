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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "uf_utilisateur", catalog = "ufi_fidelite", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"email","login"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UfUtilisateur.findAll", query = "SELECT u FROM UfUtilisateur u")
    , @NamedQuery(name = "UfUtilisateur.findById", query = "SELECT u FROM UfUtilisateur u WHERE u.id = :id")
    , @NamedQuery(name = "UfUtilisateur.findByNom", query = "SELECT u FROM UfUtilisateur u WHERE u.nom = :nom")
    , @NamedQuery(name = "UfUtilisateur.findByPrenom", query = "SELECT u FROM UfUtilisateur u WHERE u.prenom = :prenom")
    , @NamedQuery(name = "UfUtilisateur.findByTelephone", query = "SELECT u FROM UfUtilisateur u WHERE u.telephone = :telephone")
    , @NamedQuery(name = "UfUtilisateur.findByEmail", query = "SELECT u FROM UfUtilisateur u WHERE u.email = :email")
    , @NamedQuery(name = "UfUtilisateur.findByLogin", query = "SELECT u FROM UfUtilisateur u WHERE u.login = :login")
    , @NamedQuery(name = "UfUtilisateur.findByMotDePasse", query = "SELECT u FROM UfUtilisateur u WHERE u.motDePasse = :motDePasse")
    , @NamedQuery(name = "UfUtilisateur.findBySexe", query = "SELECT u FROM UfUtilisateur u WHERE u.sexe = :sexe")
    , @NamedQuery(name = "UfUtilisateur.findByStatut", query = "SELECT u FROM UfUtilisateur u WHERE u.statut = :statut")})
public class UfUtilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    //@Size(max = 45)
    @Column(length = 45)
    private String nom;
    //@Size(max = 45)
    @Column(length = 45)
    private String prenom;
    //@Size(max = 45)
    @Column(length = 45)
    private String telephone;
    //@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    //@Size(max = 45)
    @Column(length = 45)
    private String email;
    //@Size(max = 20)
    @Column(length = 20)
    private String login;
    //@Size(max = 300)
    @Column(name = "mot_de_passe", length = 300)
    private String motDePasse;
    //@Size(max = 10)
    @Column(length = 10)
    private String sexe;
    @Basic(optional = false)
    //@NotNull
    @Column(nullable = false)
    private short statut;
    @JoinColumn(name = "commercant", referencedColumnName = "code")
    @ManyToOne(fetch = FetchType.LAZY)
    private UfCommercant commercant;
    @JoinColumn(name = "role", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UfRole role;

    public UfUtilisateur() {
    }

    public UfUtilisateur(Integer id) {
        this.id = id;
    }

    public UfUtilisateur(Integer id, short statut) {
        this.id = id;
        this.statut = statut;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public short getStatut() {
        return statut;
    }

    public void setStatut(short statut) {
        this.statut = statut;
    }

    public UfCommercant getCommercant() {
        return commercant;
    }

    public void setCommercant(UfCommercant commercant) {
        this.commercant = commercant;
    }

    public UfRole getRole() {
        return role;
    }

    public void setRole(UfRole role) {
        this.role = role;
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
        if (!(object instanceof UfUtilisateur)) {
            return false;
        }
        UfUtilisateur other = (UfUtilisateur) object;
        
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufi.fidelite.entities.UfUtilisateur[ id=" + id + " ]";
    }
    
}
