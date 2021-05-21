package com.salemdoux.ecole.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.salemdoux.ecole.domain.Adresse;

public class AdresseDTO implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "a cidade não pode ser vazia")@NotEmpty(message = "a cidade não pode ser vazia")
	@Length(min=5, max=80, message= "O tamanho deve ser entr 5 e 80 caracteres")
	private String ville;
	
	@NotEmpty(message = "o bairro não pode ser vazio")
	private String quartier;
	
	@NotEmpty(message = "a rua não pode ser vazia")
	private String avenue;
	
	public AdresseDTO() {
		
	}

	public AdresseDTO(Adresse obj) {
		id = obj.getId();
		ville = obj.getVille();
		quartier = obj.getQuartier();
		avenue = obj.getAvenue();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getQuartier() {
		return quartier;
	}

	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}

	public String getAvenue() {
		return avenue;
	}

	public void setAvenue(String avenue) {
		this.avenue = avenue;
	}
	
}
