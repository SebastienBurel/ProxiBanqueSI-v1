package com.gtm.proxibanque.metiers;

/**
 * Classe Compte
 * @author Sebounet team
 *
 */
public class Compte {
	protected String numero;
	protected float solde;
	protected int annee;
	protected String cb;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getCb() {
		return cb;
	}

	public void setCb(String cb) {
		this.cb = cb;
	}

//	/**
//	 * Methode permettant de verser de l'argent sur le compte
//	 * @param mt montant ра verser sur le compte
//	 */
//	public void verser(float mt) {
//		if (mt >= 0.) {
//			solde += mt;
//			System.out.println("Versement effectue de " + mt + "! Le compte a maintenant un solde de " + solde);
//		} else {
//			System.out.println("Erreur : vous ne pouvez pas verser un montant negatif !");
//		}
//	}
//	
//	/**
//	 * Methode permettant de retirer de l'argent sur le compte si le solde le permet
//	 * @param mt montant ра retirer du compte
//	 */
//	public void retirer(float mt) {
//		if (mt < 0) {
//			System.out.println("Erreur : le montant ра retirer est negatif !");
//		} else {
//			if (solde >= mt) {
//				solde -= mt;
//				System.out.println("Retrait effectue de " + mt + "! Le compte a maintenant un solde de " + solde);
//			} else {
//				System.out.println("Erreur : Le solde est insuffisant !");
//			}
//		}
//		
//	}

	public Compte(String numero, float solde, int annee, String cb) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.annee = annee;
		this.cb = cb;
	}

	
	}


