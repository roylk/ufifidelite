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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author R. KOUANI
 */
@Entity
@Table(name = "uf_transaction", catalog = "ufi_fidelite", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"transaction_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UfTransaction.findAll", query = "SELECT u FROM UfTransaction u")
    , @NamedQuery(name = "UfTransaction.findByTransactionId", query = "SELECT u FROM UfTransaction u WHERE u.transactionId = :transactionId")
    , @NamedQuery(name = "UfTransaction.findByDateTransaction", query = "SELECT u FROM UfTransaction u WHERE u.dateTransaction = :dateTransaction")
    , @NamedQuery(name = "UfTransaction.findByMontantInitial", query = "SELECT u FROM UfTransaction u WHERE u.montantInitial = :montantInitial")
    , @NamedQuery(name = "UfTransaction.findByMontantReduit", query = "SELECT u FROM UfTransaction u WHERE u.montantReduit = :montantReduit")
    , @NamedQuery(name = "UfTransaction.findByDateEnregistrement", query = "SELECT u FROM UfTransaction u WHERE u.dateEnregistrement = :dateEnregistrement")})
public class UfTransaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    //@Size(min = 1, max = 45)
    @Column(name = "transaction_id", nullable = false, length = 45)
    private String transactionId;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "date_transaction", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTransaction;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant_initial", precision = 22)
    private Double montantInitial;
    @Column(name = "montant_reduit", precision = 22)
    private Double montantReduit;
    @Column(name = "date_enregistrement")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnregistrement;
    @Lob
    //@Size(max = 16777215)
    @Column(length = 16777215)
    private String commentaire;
    @JoinColumn(name = "carte", referencedColumnName = "numero", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UfCarte carte;
    @JoinColumn(name = "terminal", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UfTerminal terminal;

    public UfTransaction() {
    }

    public UfTransaction(String transactionId, Date dateTransaction, Double montantInitial, Double montantReduit, Date dateEnregistrement, String commentaire, UfCarte carte, UfTerminal terminal) {
        this.transactionId = transactionId;
        this.dateTransaction = dateTransaction;
        this.montantInitial = montantInitial;
        this.montantReduit = montantReduit;
        this.dateEnregistrement = dateEnregistrement;
        this.commentaire = commentaire;
        this.carte = carte;
        this.terminal = terminal;
    }
    
    

    public UfTransaction(String transactionId) {
        this.transactionId = transactionId;
    }

    public UfTransaction(String transactionId, Date dateTransaction) {
        this.transactionId = transactionId;
        this.dateTransaction = dateTransaction;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public Double getMontantInitial() {
        return montantInitial;
    }

    public void setMontantInitial(Double montantInitial) {
        this.montantInitial = montantInitial;
    }

    public Double getMontantReduit() {
        return montantReduit;
    }

    public void setMontantReduit(Double montantReduit) {
        this.montantReduit = montantReduit;
    }

    public Date getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(Date dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public UfCarte getCarte() {
        return carte;
    }

    public void setCarte(UfCarte carte) {
        this.carte = carte;
    }

    public UfTerminal getTerminal() {
        return terminal;
    }

    public void setTerminal(UfTerminal terminal) {
        this.terminal = terminal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UfTransaction)) {
            return false;
        }
        UfTransaction other = (UfTransaction) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ufi.fidelite.entities.UfTransaction[ transactionId=" + transactionId + " ]";
    }
    
}
