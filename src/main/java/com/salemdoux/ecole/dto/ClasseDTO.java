package com.salemdoux.ecole.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.salemdoux.ecole.domain.Classe;

public class ClasseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotNull
	private String descricao;
	
	@NotNull
	private Integer anneScolaire;
	
	@NotNull
	private Integer ecole;

	public ClasseDTO() {

	}

	public ClasseDTO(Classe obj) {
		id = obj.getId();
		descricao = obj.getDescricao();
		anneScolaire = obj.getAnneScolaire().getId();
		ecole = obj.getEcole().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getAnneScolaire() {
		return anneScolaire;
	}
	
	public void setAnneScolaire(Integer anneScolaire) {
		this.anneScolaire = anneScolaire;
	}

	public Integer getEcole() {
		return ecole;
	}

	public void setEcole(Integer ecole) {
		this.ecole = ecole;
	}


}
