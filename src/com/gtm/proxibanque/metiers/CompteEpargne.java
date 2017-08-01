package com.gtm.proxibanque.metiers;

import com.gtm.proxibanque.presentation.Constantes;
/**
 * Classe Compte Epargne
 * @author Sebounet team
 *
 */
public class CompteEpargne extends Compte {
	
	/**
	 * taux d'interets en pourcentage du compte Ãeepargne
	 */
	private float taux;
	
	/**
	 * Interets annuels du compte epargne
	 */
	private float interets;

	public CompteEpargne(String numero, float solde, int annee, String cb) {
		super(numero, solde, annee, cb);
	
		this.taux = Constantes.TAUX_REMUNERATION;
	}

	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}
	
	/**
	 * Methode permettant d'afficher le taux de remuneration
	 */
	public void afficherTaux()
	{
		System.out.println("le taux du compte epargne s'eleve à "+ taux);
	}
	
	/**
	 * Methode permettant de calculer les interets et d'afficher le nouveau solde
	 */
	public void calculInterets() {
		if (taux >= 0.) {
			interets = solde * taux / 100;
			solde += interets;
			System.out.println("Interets verses (" + interets + ")! Le compte epargne a maintenant un solde de " + solde);
		} else {
			System.out.println("Erreur : le taux est negatif !");
		}
	}

	@Override
	public String toString() {
		return "CompteEpargne [taux=" + taux + ", numero=" + numero + ", solde=" + solde + ", annee=" + annee + ", cb="
				+ cb + "]";
	}

	
	

}
