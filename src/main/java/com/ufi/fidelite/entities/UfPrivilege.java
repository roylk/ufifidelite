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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "uf_privilege", catalog = "ufi_fidelite", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"code"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UfPrivilege.findAll", query = "SELECT u FROM UfPrivilege u")
    , @NamedQuery(name = "UfPrivilege.findByCode", query = "SELECT u FROM UfPrivilege u WHERE u.code = :code")})
public class UfPrivilege implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 15)
    @Column(nullable = false, length = 15)
    private String code;
    @Lob
    //@Size(max = 16777215)
    @Column(length = 16777215)
    private String description;
    @JoinTable(name = "uf_role_privilege", joinColumns = {
        @JoinColumn(name = "privilege", referencedColumnName = "code", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "role", referencedColumnName = "id", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<UfRole> ufRoleList;

    public UfPrivilege() {
    }

    public UfPrivilege(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
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

    @XmlTransient
    public List<UfRole> getUfRoleList() {
        return ufRoleList;
    }

    public void setUfRoleList(List<UfRole> ufRoleList) {
        this.ufRoleList = ufRoleList;
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
        if (!(object instanceof UfPrivilege)) {
            return false;
        }
        UfPrivilege other = (UfPrivilege) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufi.fidelite.entities.UfPrivilege[ code=" + code + " ]";
    }
    
}
