/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.entities.mirrors;

import java.math.BigInteger;
import javax.validation.constraints.Size;

/**
 *
 * @author R. KOUANI
 */
public class CarteMirror {
    private String numero;
    private BigInteger compteurPoint;
    private Double montantAcumule;
    private Integer nombreTransaction;
    private short statut;
    private String categorieCarte;
    @Size(min = 1, max = 45)
    private String client;

    public CarteMirror() {
    }

    public CarteMirror(String numero, BigInteger compteurPoint, Double montantAcumule, Integer nombreTransaction, short statut, String categorieCarte, String client) {
        this.numero = numero;
        this.compteurPoint = compteurPoint;
        this.montantAcumule = montantAcumule;
        this.nombreTransaction = nombreTransaction;
        this.statut = statut;
        this.categorieCarte = categorieCarte;
        this.client = client;
    }

    public String getNumero() {
        return numero;
    }

    public BigInteger getCompteurPoint() {
        return compteurPoint;
    }

    public Double getMontantAcumule() {
        return montantAcumule;
    }

    public Integer getNombreTransaction() {
        return nombreTransaction;
    }

    public short getStatut() {
        return statut;
    }

    public String getCategorieCarte() {
        return categorieCarte;
    }

    public String getClient() {
        return client;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCompteurPoint(BigInteger compteurPoint) {
        this.compteurPoint = compteurPoint;
    }

    public void setMontantAcumule(Double montantAcumule) {
        this.montantAcumule = montantAcumule;
    }

    public void setNombreTransaction(Integer nombreTransaction) {
        this.nombreTransaction = nombreTransaction;
    }

    public void setStatut(short statut) {
        this.statut = statut;
    }

    public void setCategorieCarte(String categorieCarte) {
        this.categorieCarte = categorieCarte;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "CarteMirror{" + "numero=" + numero + ", compteurPoint=" + compteurPoint + ", montantAcumule=" + montantAcumule + ", nombreTransaction=" + nombreTransaction + ", statut=" + statut + ", categorieCarte=" + categorieCarte + ", client=" + client + '}';
    }
    
    
    
    
     
    
}
