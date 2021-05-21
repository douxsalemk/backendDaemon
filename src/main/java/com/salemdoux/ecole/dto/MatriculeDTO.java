package com.salemdoux.ecole.dto;

import java.io.Serializable;

import com.salemdoux.ecole.domain.Matricule;

public class MatriculeDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Number numero;
	
	public MatriculeDTO() {
		
	}

	public MatriculeDTO(Matricule obj) {
		id = obj.getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Number getNumero() {
		return numero;
	}

	public void setNumero(Number numero) {
		this.numero = numero;
	}
	
}
