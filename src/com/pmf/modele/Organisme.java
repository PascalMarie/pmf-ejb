package com.pmf.modele;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the organisme database table.
 * 
 */
@Entity
@NamedQuery(name="Organisme.findAll", query="SELECT o FROM Organisme o")
public class Organisme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int identifiant;

	private String adresseEMail;

	private String login;

	private String motDePasse;

	private String raisonSocial;

	private String siret;

	private String telephone;

	//bi-directional many-to-one association to Formation
	@OneToMany(mappedBy="organisme")
	private List<Formation> formations;

	public Organisme() {
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

	public String getRaisonSocial() {
		return this.raisonSocial;
	}

	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}

	public String getSiret() {
		return this.siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Formation> getFormations() {
		return this.formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public Formation addFormation(Formation formation) {
		getFormations().add(formation);
		formation.setOrganisme(this);

		return formation;
	}

	public Formation removeFormation(Formation formation) {
		getFormations().remove(formation);
		formation.setOrganisme(null);

		return formation;
	}

}