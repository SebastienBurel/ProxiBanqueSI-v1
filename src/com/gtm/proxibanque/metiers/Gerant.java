package com.gtm.proxibanque.metiers;

import java.util.ArrayList;
import java.util.List;
/**
 * Classe de gerant
 * @author severinthibaut
 *
 */
public final class Gerant extends Conseiller {

	private List<Conseiller> listConseillers;

	public Gerant() {
		super();
		this.listConseillers = new ArrayList<>();
	}
	

	public Gerant(String nom, String prenom, String adresse, int codepostal, String ville, String numerotelephone, List<Conseiller> listConseillers) {
		super(nom, prenom, adresse, codepostal, ville, numerotelephone);
		this.listConseillers = listConseillers;
	}


	public List<Conseiller> getListConseillers() {
		return listConseillers;
	}


	public void setListConseillers(List<Conseiller> listConseillers) {
		this.listConseillers = listConseillers;
	}


	/**
	 * Methode permettant d ajouter des conseillers
	 * @param conseiller
	 */
	public void ajouterConseiller(Conseiller conseiller) {
		this.listConseillers.add(conseiller);
	}

	/**
	 * Methode permettant d afficher l'ensemble des conseillers clientele
	 */
	public void afficherPersonnel() {
		if (listConseillers.size() == 0) {
			System.out.println("L'agence ne possede aucun conseiller.");
		} else {
			for (int i = 0; i < listConseillers.size(); i++) {
				System.out.println("Conseiller " + (i + 1) + " : " + listConseillers.get(i));
			}
		}
	}

	@Override
	public String toString() {
		return "Gerant [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal=" + codepostal
				+ ", ville=" + ville + ", numeroTelephone=" + numerotelephone + "]";
	}

}
