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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "uf_role", catalog = "ufi_fidelite", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"libele"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UfRole.findAll", query = "SELECT u FROM UfRole u")
    , @NamedQuery(name = "UfRole.findById", query = "SELECT u FROM UfRole u WHERE u.id = :id")
    , @NamedQuery(name = "UfRole.findByLibele", query = "SELECT u FROM UfRole u WHERE u.libele = :libele")})
public class UfRole implements Serializable {

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
    @Lob
    //@Size(max = 16777215)
    @Column(length = 16777215)
    private String description;
    @ManyToMany(mappedBy = "ufRoleList", fetch = FetchType.LAZY)
    private List<UfPrivilege> ufPrivilegeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role", fetch = FetchType.LAZY)
    private List<UfUtilisateur> ufUtilisateurList;

    public UfRole() {
    }

    public UfRole(Integer id) {
        this.id = id;
    }

    public UfRole(Integer id, String libele) {
        this.id = id;
        this.libele = libele;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<UfPrivilege> getUfPrivilegeList() {
        return ufPrivilegeList;
    }

    public void setUfPrivilegeList(List<UfPrivilege> ufPrivilegeList) {
        this.ufPrivilegeList = ufPrivilegeList;
    }

    @XmlTransient
    public List<UfUtilisateur> getUfUtilisateurList() {
        return ufUtilisateurList;
    }

    public void setUfUtilisateurList(List<UfUtilisateur> ufUtilisateurList) {
        this.ufUtilisateurList = ufUtilisateurList;
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
        if (!(object instanceof UfRole)) {
            return false;
        }
        UfRole other = (UfRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufi.fidelite.entities.UfRole[ id=" + id + " ]";
    }
    
}
