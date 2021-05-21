package com.salemdoux.ecole.dto;

import java.io.Serializable;

import com.salemdoux.ecole.domain.Fonction;

public class FonctionDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String  fonction;
	
	public FonctionDTO() {
		
	}

	public FonctionDTO(Fonction obj) {
		id = obj.getId();
		fonction = obj.getFonction();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	
}
