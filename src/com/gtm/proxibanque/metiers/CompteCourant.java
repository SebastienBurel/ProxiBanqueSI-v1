package com.gtm.proxibanque.metiers;

import com.gtm.proxibanque.presentation.Constantes;

/**
 * Classe de Compte Courant
 * @author Sebounet team
 *
 */
public class CompteCourant extends Compte {
	/**
	 * montant du decouvert autorise du compte courant
	 */
	private float decouvert;

	public CompteCourant(String numero, float solde, int annee,String cb) {
		super(numero, solde, annee, cb);
		
		this.decouvert = Constantes.DECOUVERT_AUTORISE;
	}

	public float getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(float decouvert) {
		this.decouvert = decouvert;
	}
	
	/**
	 * Methode permettant de retirer de l'argent sur le compte si le solde et le decouvert l'autorise
	 * @param mt montant ра retirer du compte
	 */
	@Override
	public void retirer(float mt) {
		if (mt < 0) {
			System.out.println("Erreur : le montant ра retirer est negatif !");
		} else {
			if (solde + decouvert >= mt) {
				solde -= mt;
				System.out.println("Retrait effectue de " + mt + "! Le compte courant a maintenant un solde de " + solde);
			} else {
				System.out.println("Erreur : Le decouvert du compte depasse le decouvert autorise !");
			}
		}
		
	}

	@Override
	public String toString() {
		return "CompteCourant [decouvert=" + decouvert + ", numero=" + numero + ", solde=" + solde + ", annee=" + annee
				+ ", cb=" + cb + "]";
	}

	
	}



