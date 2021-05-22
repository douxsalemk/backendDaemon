package com.salemdoux.ecole.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.salemdoux.ecole.domain.Pessoa;
import com.salemdoux.ecole.domain.enums.Sexe;

public class PessoaDTO implements Serializable{


	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "prenchimento obrigatório")
	@Length(min=3, max=120, message= "O tamanho deve ser entre 3 e 120 caracteres")
	private String nom;
	
	@NotEmpty(message = "prenchimento obrigatório")
	@Length(min=3, max=120, message= "O tamanho deve ser entre 3 e 120 caracteres")
	private String postNom;

	@NotEmpty(message = "prenchimento obrigatório")
	@Length(min=3, max=120, message= "O tamanho deve ser entre 3 e 120 caracteres")
	private String preNom;
	
	private Integer sexe;
	
	public PessoaDTO() {
		
	}

	public PessoaDTO(Pessoa obj) {
		id = obj.getId();
		nom = obj.getNom();
		preNom = obj.getPreNom();
		postNom = obj.getPostNom();
		sexe = obj.getSexe().getCod();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPostNom() {
		return postNom;
	}

	public void setPostNom(String postNom) {
		this.postNom = postNom;
	}

	public String getPreNom() {
		return preNom;
	}

	public void setPreNom(String preNom) {
		this.preNom = preNom;
	}

	public Sexe getSexe() {
		return Sexe.toEnum(sexe);
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe.getCod();
	}
	
}
