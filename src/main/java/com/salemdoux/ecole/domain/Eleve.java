package com.salemdoux.ecole.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salemdoux.ecole.domain.enums.Sexe;

@Entity
public class Eleve extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ecole_id")
	private Ecole ecole;

	@OneToOne
	private Matricule matricule;

	public Eleve() {

	}

	
	public Eleve(Integer id, String nom, String postNom, String preNom, Date dateDeNaissance, Adresse adresse,
			Contact contact, Sexe sexe, Ecole ecole, Matricule matricule) {
		super(id, nom, postNom, preNom, dateDeNaissance, adresse, contact, sexe);
		this.id = id;
		this.ecole = ecole;
		this.matricule = matricule;
	}


	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}

	public Matricule getMatricule() {
		return matricule;
	}

	public void setMatricule(Matricule matricule) {
		this.matricule = matricule;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		StringBuilder builder = new StringBuilder();
		builder.append("\nBIENVENU A L'ECOLE: ");
		builder.append(ecole.getEcole());
		builder.append("\n ELEVE [");
		builder.append("\n    Nom : ");
		builder.append(getPreNom());
		builder.append("\n    PostNom : ");
		builder.append(getPostNom());
		builder.append("\n    PreNom :  ");
		builder.append(getPreNom());
		builder.append("\n    Sexe : ");
		builder.append(getSexe().getDescricao());
		builder.append("\n    Date de Naisance : ");
		builder.append(sdf.format(getDateDeNaissance()));
		builder.append("    \n]");
		builder.append("\n\nADRESSE [ ");
		builder.append("\n    Province :");
		builder.append(getAdresse().getProvince());
		builder.append("\n    Ville :");
		builder.append(getAdresse().getVille());
		builder.append("\n    Comune :");
		builder.append(getAdresse().getComune());
		builder.append("\n    Quartier :");
		builder.append(getAdresse().getQuartier());
		builder.append("\n    Avenue :");
		builder.append(getAdresse().getAvenue());
		builder.append("\n    Numero :");
		builder.append(getAdresse().getReference());
		builder.append("    \n]");
		builder.append("\n\nCONTACT [");
		builder.append("\n    Email : ");
		builder.append(getContact().getEmail());
		builder.append("\n    Telefone :");
		builder.append(getContact().getTelefone());
		builder.append("    \n]");
		builder.append("\n\nMATRICULE [");
		builder.append("\n    Numero : ");
		builder.append(getMatricule().getNumero());
		builder.append("    \n]");
		builder.append("\n]");
		
		return builder.toString();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eleve other = (Eleve) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
