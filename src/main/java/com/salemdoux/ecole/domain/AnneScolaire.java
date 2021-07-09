package com.salemdoux.ecole.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AnneScolaire implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	private Date dateInicial;
	
	@Temporal(TemporalType.DATE)
	private Date dateFinal;
	
	@JsonIgnore
	@OneToMany(mappedBy = "anneScolaire")
	private List<Classe> classes = new ArrayList<>();

	
	public Integer getId() {
		return id;
	}
	
	
	public AnneScolaire() {
		
	}
	
	public AnneScolaire(Integer id, String descricao, Date dateInicial, Date dateFinal) {
		super();
		this.id = id;
		this.dateInicial = dateInicial;
		this.dateFinal = dateFinal;
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public void setId(Integer id) {
		this.id = id;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnneScolaire other = (AnneScolaire) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
