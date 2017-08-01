package com.gtm.proxibanque.metiers;

import java.util.Hashtable;

/**
 * Methode des clients
 * 
 * @author Sebounet team
 *
 */
public class Client extends Personne {

	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;
	private Hashtable<Action,Integer> portefeuilleActions;

	public Client(String nom, String prenom, String adresse, int codepostal, String ville, String numerotelephone,
			CompteCourant compteCourant, CompteEpargne compteEpargne) {
		super(nom, prenom, adresse, codepostal, ville, numerotelephone);
		this.compteCourant = compteCourant;
		this.compteEpargne = compteEpargne;
		this.portefeuilleActions = new Hashtable<Action,Integer>();
	}

	public Hashtable<Action,Integer> getPortefeuilleActions() {
		return portefeuilleActions;
	}

	public void setPortefeuilleActions(Hashtable<Action,Integer> portefeuilleActions) {
		this.portefeuilleActions = portefeuilleActions;
	}

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	@Override
	public String toString() {
		return "Client [ nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal=" + codepostal
				+ ", ville=" + ville + ", numeroTelephone=" + numerotelephone + "]";
	}

}
