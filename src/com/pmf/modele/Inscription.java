package com.pmf.modele;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the inscription database table.
 * 
 */
@Entity
@NamedQuery(name="Inscription.findAll", query="SELECT i FROM Inscription i")
public class Inscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idInscription;

	private String dateInscription;

	//bi-directional many-to-one association to Formation
	@ManyToOne
	private Formation formation;

	//bi-directional many-to-one association to Stagiaire
	@ManyToOne
	private Stagiaire stagiaire;

	public Inscription() {
	}

	public int getIdInscription() {
		return this.idInscription;
	}

	public void setIdInscription(int idInscription) {
		this.idInscription = idInscription;
	}

	public String getDateInscription() {
		return this.dateInscription;
	}

	public void setDateInscription(String dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Formation getFormation() {
		return this.formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Stagiaire getStagiaire() {
		return this.stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

}