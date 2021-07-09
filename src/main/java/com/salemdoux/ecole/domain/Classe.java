package com.salemdoux.ecole.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Classe implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String descricao;


	// @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "anne_scolaire_id")
	private AnneScolaire anneScolaire;
	
	//@JsonIgnore
    @ManyToOne
	@JoinColumn(name = "ecole_id")
	private Ecole ecole;
		
		
	
	public Classe() {
		
	}
	
	public Classe(Integer id, String descricao, AnneScolaire anneScolaire, Ecole ecole) {
		super();
		this.id = id;
		this.anneScolaire = anneScolaire;
		this.descricao = descricao;
		this.ecole = ecole;
	}
//	@ManyToOne
//	@JoinColumn(name="niveau_id")
//	private Niveau niveau;
//	
//	@ManyToMany
//	@JoinTable(name = "classe_discipline",
//	joinColumns = @JoinColumn(name = "classe_id"),
//	inverseJoinColumns = @JoinColumn(name = "discipline_id")
//	)
//	private List<Discipline> disciplines = new ArrayList<>();
//	
//	
//    public List<Discipline> getDisciplines() {
//		return disciplines;
//	}
//
//	public void setDisciplines(List<Discipline> disciplines) {
//		this.disciplines = disciplines;
//	}
//
//	public Niveau getNiveau() {
//		return niveau;
//	}
//
//	public void setNiveau(Niveau niveau) {
//		this.niveau = niveau;
//	}


	public AnneScolaire getAnneScolaire() {
		return anneScolaire;
	}

	public void setAnnescolaire(AnneScolaire anneScolaire) {
		this.anneScolaire = anneScolaire;
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

	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
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
		Classe other = (Classe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
