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
@Table(name = "uf_commercant", catalog = "ufi_fidelite", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UfCommercant.findAll", query = "SELECT u FROM UfCommercant u")
    , @NamedQuery(name = "UfCommercant.findByCode", query = "SELECT u FROM UfCommercant u WHERE u.code = :code")
    , @NamedQuery(name = "UfCommercant.findByNom", query = "SELECT u FROM UfCommercant u WHERE u.nom = :nom")
    , @NamedQuery(name = "UfCommercant.findByAcronyme", query = "SELECT u FROM UfCommercant u WHERE u.acronyme = :acronyme")
    , @NamedQuery(name = "UfCommercant.findByTelephone1", query = "SELECT u FROM UfCommercant u WHERE u.telephone1 = :telephone1")
    , @NamedQuery(name = "UfCommercant.findByTelephone2", query = "SELECT u FROM UfCommercant u WHERE u.telephone2 = :telephone2")
    , @NamedQuery(name = "UfCommercant.findByAdresse", query = "SELECT u FROM UfCommercant u WHERE u.adresse = :adresse")
    , @NamedQuery(name = "UfCommercant.findByEmail", query = "SELECT u FROM UfCommercant u WHERE u.email = :email")})
public class UfCommercant implements Serializable {

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
    //@Size(min = 1, max = 20)
    @Column(nullable = false, length = 20)
    private String telephone1;
    //@Size(max = 20)
    @Column(length = 20)
    private String telephone2;
    //@Size(max = 45)
    @Column(length = 45)
    private String adresse;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String email;
   
//    @OneToMany(mappedBy = "commercant", fetch = FetchType.LAZY)
//    private List<UfUtilisateur> ufUtilisateurList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commercantCode", fetch = FetchType.LAZY)
//    private List<UfPointDeVente> ufPointDeVenteList;
//    @OneToMany(mappedBy = "commercant", fetch = FetchType.LAZY)
//    private List<UfCategorieCarte> ufCategorieCarteList;
    @JoinColumn(name = "ville", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UfVille ville;
     @Column(nullable = false)
    private short statut;
      @Column()
    private String config;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commercant", fetch = FetchType.LAZY)
//    private List<Conversion> conversionList;

    public UfCommercant() {
    }

    public UfCommercant(String code) {
        this.code = code;
    }

    public UfCommercant(String code, String nom, String telephone1, String email) {
        this.code = code;
        this.nom = nom;
        this.telephone1 = telephone1;
        this.email = email;
    }

    public UfCommercant(String code, String nom, String telephone1, String telephone2,String adresse,  String email, UfVille ville, short statut) {
        this.code = code;
        this.nom = nom;
        this.telephone1 = telephone1;
        this.telephone2 = telephone2;
        this.adresse =adresse;
        this.email = email;
        this.ville = ville;
        this.statut=statut;
    }
    
    public UfCommercant(String code, String nom, String telephone1, String telephone2,String adresse,  String email, UfVille ville, short statut, String config) {
        this.code = code;
        this.nom = nom;
        this.telephone1 = telephone1;
        this.telephone2 = telephone2;
        this.adresse =adresse;
        this.email = email;
        this.ville = ville;
        this.statut=statut;
        this.config=config;
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
    

    @XmlTransient
//    public List<UfUtilisateur> getUfUtilisateurList() {
//        return ufUtilisateurList;
//    }
//
//    public void setUfUtilisateurList(List<UfUtilisateur> ufUtilisateurList) {
//        this.ufUtilisateurList = ufUtilisateurList;
//    }
//
//    @XmlTransient
//    public List<UfPointDeVente> getUfPointDeVenteList() {
//        return ufPointDeVenteList;
//    }
//
//    public void setUfPointDeVenteList(List<UfPointDeVente> ufPointDeVenteList) {
//        this.ufPointDeVenteList = ufPointDeVenteList;
//    }

//    @XmlTransient
//    public List<UfCategorieCarte> getUfCategorieCarteList() {
//        return ufCategorieCarteList;
//    }
//
//    public void setUfCategorieCarteList(List<UfCategorieCarte> ufCategorieCarteList) {
//        this.ufCategorieCarteList = ufCategorieCarteList;
//    }

    public UfVille getVille() {
        return ville;
    }

    public void setVille(UfVille ville) {
        this.ville = ville;
    }
    
    public int getStatut(){
        return statut;
    }
    
    public void setStatut(short statut){
        this.statut=statut;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
    
    

    @XmlTransient
//    public List<Conversion> getConversionList() {
//        return conversionList;
//    }
//
//    public void setConversionList(List<Conversion> conversionList) {
//        this.conversionList = conversionList;
   // }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UfCommercant)) {
            return false;
        }
        UfCommercant other = (UfCommercant) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufi.fidelite.entities.UfCommercant[ code=" + code + " ]";
    }
    
}
