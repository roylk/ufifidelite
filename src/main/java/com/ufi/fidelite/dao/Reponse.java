package com.ufi.fidelite.dao;

import java.io.Serializable;

public class Reponse implements Serializable{
	
	private int status;
	private String message;
        private Object data;
	
	public Reponse(int status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
                this.data=data;
	}
	public Reponse() {
		super();
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
        
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
        
        public Object getData(){
            return data;
        }
	
        public void setData(Object data) {
		this.data= data;
	}

}
