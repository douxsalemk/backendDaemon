package com.salemdoux.ecole.dto;

import java.io.Serializable;

import com.salemdoux.ecole.domain.Ecole;

public class EcoleDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Integer id;	

	private String ecole;

	
	public EcoleDTO() {
		
	}

	public EcoleDTO(Ecole obj) {
		id = obj.getId();
		ecole = obj.getEcole();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEcole() {
		return ecole;
	}

	public void setEcole(String ecole) {
		this.ecole = ecole;
	}
}
