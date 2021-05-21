package com.salemdoux.ecole.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.salemdoux.ecole.domain.Actif;
import com.salemdoux.ecole.domain.Adresse;

public class ActifDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotNull
	private Boolean actif;

	public ActifDTO() {

	}


	public ActifDTO(Actif obj) {
		id = obj.getId();
		actif = obj.getActif();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActif() {
		return actif;
	}
	
	public void setActif(Boolean actif) {
		this.actif = actif;
	}
}
