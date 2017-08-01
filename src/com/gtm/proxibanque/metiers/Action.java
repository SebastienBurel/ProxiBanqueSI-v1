package com.gtm.proxibanque.metiers;
/**
 * Classe d'actions
 * @author severinthibaut
 *
 */
public class Action {

	private String nom;
	private float cours;
	private String bourse;

	
	public Action(String nom, float cours, String bourse) {
		super();
		this.nom = nom;
		this.cours = cours;
		this.bourse = bourse;
	}

	public Action() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getCours() {
		return cours;
	}

	public void setCours(float cours) {
		this.cours = cours;
	}

	public String getBourse() {
		return bourse;
	}

	public void setBourse(String bourse) {
		this.bourse = bourse;
	}
	
	
}
