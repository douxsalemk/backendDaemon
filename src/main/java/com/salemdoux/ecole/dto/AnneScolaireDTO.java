package com.salemdoux.ecole.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.salemdoux.ecole.domain.AnneScolaire;

public class AnneScolaireDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotNull
	private String descricao;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dateInicial;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dateFinal;
	

	public AnneScolaireDTO() {

	}

	public AnneScolaireDTO(AnneScolaire obj) {
		id = obj.getId();
		dateInicial = obj.getDateInicial();
		dateFinal = obj.getDateFinal();
		descricao = obj.getDescricao();
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

	public Date getDateInicial() {
		return dateInicial;
	}

	public void setDateInicial(Date dateInicial) {
		this.dateInicial = dateInicial;
	}

	public Date getDateFinal() {
		return dateFinal;
	}

	public void setDateFinal(Date dateFinal) {
		this.dateFinal = dateFinal;
	}



}
