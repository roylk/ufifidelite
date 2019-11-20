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
@Table(name = "uf_politique_evaluation", catalog = "ufi_fidelite", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UfPolitiqueEvaluation.findAll", query = "SELECT u FROM UfPolitiqueEvaluation u")
    , @NamedQuery(name = "UfPolitiqueEvaluation.findByCode", query = "SELECT u FROM UfPolitiqueEvaluation u WHERE u.code = :code")
    , @NamedQuery(name = "UfPolitiqueEvaluation.findByLibele", query = "SELECT u FROM UfPolitiqueEvaluation u WHERE u.libele = :libele")})
public class UfPolitiqueEvaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String code;
    //@Size(max = 45)
    @Column(length = 45)
    private String libele;
     @Column()
    private String description;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "politiqueEvaluation", fetch = FetchType.LAZY)
//    private List<UfCategorieCarte> ufCategorieCarteList;

    public UfPolitiqueEvaluation() {
    }

    public UfPolitiqueEvaluation(String code) {
        this.code = code;
    }

    public UfPolitiqueEvaluation(String code, String libele, String description) {
        this.code = code;
        this.libele = libele;
        this.description=description;
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
    
    public String getDescription(){
        return description;
    }
    
    public void setDescription(String description){
        this.description=description;  
    }
    
    

//    @XmlTransient
//    public List<UfCategorieCarte> getUfCategorieCarteList() {
//        return ufCategorieCarteList;
//    }
//
//    public void setUfCategorieCarteList(List<UfCategorieCarte> ufCategorieCarteList) {
//        this.ufCategorieCarteList = ufCategorieCarteList;
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
        if (!(object instanceof UfPolitiqueEvaluation)) {
            return false;
        }
        UfPolitiqueEvaluation other = (UfPolitiqueEvaluation) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.ufi.fidelite.entities.UfPolitiqueEvaluation[ code=" + code + " ]";
//    }

    @Override
    public String toString() {
        return "UfPolitiqueEvaluation{" + "code=" + code + ", libele=" + libele + '}';
    }
    
    
}
