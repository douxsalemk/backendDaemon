package com.salemdoux.ecole.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.salemdoux.ecole.domain.Fonction;

public class FonctionDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "prenchimento obrigatório")
	@Length(min=3, max=120, message= "O tamanho deve ser entre 3 e 120 caracteres")
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
