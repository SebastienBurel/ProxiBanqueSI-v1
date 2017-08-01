package com.gtm.proxibanque.metiers;

public class Personne {

	protected String nom;
	protected String prenom;
	protected String adresse;
	protected int codepostal;
	protected String ville;
	protected String numerotelephone;

	public Personne(String nom, String prenom, String adresse, int codepostal, String ville, String numerotelephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codepostal = codepostal;
		this.ville = ville;
		this.numerotelephone = numerotelephone;
	}

	public Personne() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(int codepostal) {
		this.codepostal = codepostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getNumerotelephone() {
		return numerotelephone;
	}

	public void setNumerotelephone(String numerotelephone) {
		this.numerotelephone = numerotelephone;
	}

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codepostal=" + codepostal
				+ ", ville=" + ville + ", numerotelephone=" + numerotelephone + "]";
	}

}