/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufi.fidelite.config;

/**
 *
 * @author R. KOUANI
 */
public class ReponseRest {
    private int code = Constantes.CODE_ERREUR_INITIALISATION;
    private boolean statut = false;
    private String message = "";
    private Object data = null;

    public ReponseRest() {
    }

    public ReponseRest(int code, boolean statut , String message, Object data) {
        this.code=code;
        this.statut=statut;
        this.message=message;
        this.data=data;
    }
    
    
    
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    
}
