/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.entities;

import java.io.Serializable;
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
@Table(name = "uf_point_de_vente", catalog = "ufi_fidelite", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UfPointDeVente.findAll", query = "SELECT u FROM UfPointDeVente u")
    , @NamedQuery(name = "UfPointDeVente.findByCode", query = "SELECT u FROM UfPointDeVente u WHERE u.code = :code")
    , @NamedQuery(name = "UfPointDeVente.findByNom", query = "SELECT u FROM UfPointDeVente u WHERE u.nom = :nom")
    , @NamedQuery(name = "UfPointDeVente.findByAcronyme", query = "SELECT u FROM UfPointDeVente u WHERE u.acronyme = :acronyme")
    , @NamedQuery(name = "UfPointDeVente.findByAdresse", query = "SELECT u FROM UfPointDeVente u WHERE u.adresse = :adresse")
    , @NamedQuery(name = "UfPointDeVente.findByEmail", query = "SELECT u FROM UfPointDeVente u WHERE u.email = :email")
    , @NamedQuery(name = "UfPointDeVente.findByTelephone1", query = "SELECT u FROM UfPointDeVente u WHERE u.telephone1 = :telephone1")
    , @NamedQuery(name = "UfPointDeVente.findByTelephone2", query = "SELECT u FROM UfPointDeVente u WHERE u.telephone2 = :telephone2")
    , @NamedQuery(name = "UfPointDeVente.findByStatut", query = "SELECT u FROM UfPointDeVente u WHERE u.statut = :statut")})
public class UfPointDeVente implements Serializable {

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
    private String nom;
    //@Size(max = 45)
    @Column(length = 45)
    private String acronyme;
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
    //@Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String telephone1;
    //@Size(max = 45)
    @Column(length = 45)
    private String telephone2;
    @Basic(optional = false)
    //@NotNull
    @Column(nullable = false)
    private short statut;
    @JoinColumn(name = "commercant_code", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UfCommercant commercantCode;
    @JoinColumn(name = "ville", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UfVille ville;
//    @OneToMany(mappedBy = "pointDeVente", fetch = FetchType.LAZY)
//    private List<UfTerminal> ufTerminalList;

    public UfPointDeVente() {
    }

    public UfPointDeVente(String code, String nom, String acronyme, String adresse, String email, String telephone1, String telephone2, short statut, UfCommercant commercantCode, UfVille ville) {
        this.code = code;
        this.nom = nom;
        this.acronyme = acronyme;
        this.adresse = adresse;
        this.email = email;
        this.telephone1 = telephone1;
        this.telephone2 = telephone2;
        this.statut = statut;
        this.commercantCode = commercantCode;
        this.ville = ville;
    }
    
    
    

    public UfPointDeVente(String code) {
        this.code = code;
    }

    public UfPointDeVente(String code, String nom, String adresse, String email, String telephone1, short statut) {
        this.code = code;
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.telephone1 = telephone1;
        this.statut = statut;
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

    public String getAcronyme() {
        return acronyme;
    }

    public void setAcronyme(String acronyme) {
        this.acronyme = acronyme;
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

    public short getStatut() {
        return statut;
    }

    public void setStatut(short statut) {
        this.statut = statut;
    }

    public UfCommercant getCommercantCode() {
        return commercantCode;
    }

    public void setCommercantCode(UfCommercant commercantCode) {
        this.commercantCode = commercantCode;
    }

    public UfVille getVille() {
        return ville;
    }

    public void setVille(UfVille ville) {
        this.ville = ville;
    }

    @XmlTransient
//    public List<UfTerminal> getUfTerminalList() {
//        return ufTerminalList;
//    }
//
//    public void setUfTerminalList(List<UfTerminal> ufTerminalList) {
//        this.ufTerminalList = ufTerminalList;
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
        if (!(object instanceof UfPointDeVente)) {
            return false;
        }
        UfPointDeVente other = (UfPointDeVente) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufi.fidelite.entities.UfPointDeVente[ code=" + code + " ]";
    }
    
}
