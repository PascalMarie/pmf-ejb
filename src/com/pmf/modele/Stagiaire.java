package com.pmf.modele;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the stagiaire database table.
 * 
 */
@Entity
@NamedQuery(name="Stagiaire.findAll", query="SELECT s FROM Stagiaire s")
public class Stagiaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identifiant;

	private String adresseEMail;

	private String login;

	private String motDePasse;

	private String telephone;

	//bi-directional many-to-one association to Evaluation
	@OneToMany(mappedBy="stagiaire")
	private List<Evaluation> evaluations;

	//bi-directional many-to-one association to Inscription
	@OneToMany(mappedBy="stagiaire")
	private List<Inscription> inscriptions;

	public Stagiaire() {
	}

	public int getIdentifiant() {
		return this.identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getAdresseEMail() {
		return this.adresseEMail;
	}

	public void setAdresseEMail(String adresseEMail) {
		this.adresseEMail = adresseEMail;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Evaluation> getEvaluations() {
		return this.evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public Evaluation addEvaluation(Evaluation evaluation) {
		getEvaluations().add(evaluation);
		evaluation.setStagiaire(this);

		return evaluation;
	}

	public Evaluation removeEvaluation(Evaluation evaluation) {
		getEvaluations().remove(evaluation);
		evaluation.setStagiaire(null);

		return evaluation;
	}

	public List<Inscription> getInscriptions() {
		return this.inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public Inscription addInscription(Inscription inscription) {
		getInscriptions().add(inscription);
		inscription.setStagiaire(this);

		return inscription;
	}

	public Inscription removeInscription(Inscription inscription) {
		getInscriptions().remove(inscription);
		inscription.setStagiaire(null);

		return inscription;
	}

}