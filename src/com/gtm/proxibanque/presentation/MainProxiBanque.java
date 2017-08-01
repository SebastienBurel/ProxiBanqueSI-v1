package com.gtm.proxibanque.presentation;

import java.util.Scanner;

import com.gtm.proxibanque.metiers.Client;
import com.gtm.proxibanque.metiers.CompteCourant;
import com.gtm.proxibanque.metiers.CompteEpargne;
import com.gtm.proxibanque.metiers.Conseiller;

public class MainProxiBanque {

	public static void main(String[] args) {

		Conseiller conseiller = new Conseiller();
		// conseiller.creerClient(new Client("Altier", "Jules", "700 route du paradis",
		// 80000, "Nice", "568888"));
		// conseiller.creerClient(new Client("Burel", "Sebastien", "643 route de
		// Layrac", 31340, "Toulouse", "0611167004"));
		// conseiller.creerClient(new Client("Burel", "Jonathan", "700 route de Layrac",
		// 78555, "Bordeaux", "65"));
		// conseiller.creerClient(new Client("XYZ", "Patrick", "rue des pilotis", 50000,
		// "Paris", "5687"));
		// conseiller.creerClient(new Client("Altier", "Jules", "700 route du paradis",
		// 80000, "Nice", "568888"));

		// conseiller.supprimerClient("Burel", "kk");

		// conseiller.lireClient("Burel", "kk");

		System.out.println("Que voulez vous faire ?");
		System.out.println("Creer un client : tapez 1");
		System.out.println("Modifier un client : tapez 2");
		System.out.println("Lire un client : tapez 3");
		System.out.println("Supprimer un client : tapez 4");
		System.out.println("Effectuer un virement : tapez 5");
		Scanner clavier = new Scanner(System.in);
		short choix = clavier.nextShort();
		switch (choix) {
		case 1:
			System.out.println("Nom de la personne à ajouter :");
			String nom = clavier.next();
			System.out.println("Prenom de la personne à ajouter :");
			String prenom = clavier.next();
			System.out.println("Adresse de la personne à ajouter :");
			String adresse = clavier.nextLine();
			clavier.nextLine();
			System.out.println("Code postal de la personne à ajouter :");
			int codepostal = clavier.nextInt();
			System.out.println("Ville de la personne à ajouter :");
			String ville = clavier.next();
			System.out.println("Numero de telephone de la personne à ajouter :");
			String numerotelephone = clavier.next();

			System.out.println("Numero du nouveau compte courant de la personne à ajouter :");
			String numeroCC = clavier.next();
			System.out.println("Solde de compte courant de la personne à ajouter :");
			float soldeCC = clavier.nextFloat();
			System.out.println("Annee de creation du nouveau compte courant de la personne à ajouter :");
			short anneeCC = clavier.nextShort();

			System.out.println("Numero du nouveau compte epargne de la personne à ajouter :");
			String numeroCE = clavier.next();
			System.out.println("Solde de compte epargne de la personne à ajouter :");
			float soldeCE = clavier.nextFloat();
			System.out.println("Annee de creation du nouveau compte epargne de la personne à ajouter :");
			short anneeCE = clavier.nextShort();
			System.out.println("Choix de la carte bancaire de la personne à ajouter : tapez 1 pour Visa Electron ou tapez 2 pour Visa Premier");
			boolean x = true;
			while (x) {
				int choix2 = clavier.nextInt();
				switch (choix2) {
				case 1:
					System.out.println("Carte Visa Electron choisie");
					String cb="Visa Electron";
					CompteCourant cc1 = new CompteCourant(numeroCC, soldeCC, anneeCC, cb);
					CompteEpargne ce1 = new CompteEpargne(numeroCE, soldeCE, anneeCE, cb);
					System.out.println("Le compte courant a bien ete cree : Numero = "+numeroCC+", solde = "+soldeCC+", annee de creation = "+anneeCC+", carte bancaire choisie = "+cb);
					System.out.println("Le compte epargne a bien ete cree : Numero = "+numeroCE+", solde = "+soldeCE+", annee de creation = "+anneeCE);
					Client cl1 = new Client(nom, prenom, adresse, codepostal, ville, numerotelephone, cc1, ce1);
					x = false;
					break;
				case 2:
					System.out.println("Carte Visa Premier choisie");
					cb="Visa Premier";
					CompteCourant cc2 = new CompteCourant(numeroCC, soldeCC, anneeCC, cb);
					CompteEpargne ce2 = new CompteEpargne(numeroCE, soldeCE, anneeCE, cb);
					System.out.println("Le compte courant a bien ete cree : Numero = "+numeroCC+", solde = "+soldeCC+", annee de creation = "+anneeCC+", carte bancaire choisie = "+cb);
					System.out.println("Le compte epargne a bien ete cree : Numero = "+numeroCE+", solde = "+soldeCE+", annee de creation = "+anneeCE);
					Client cl2 = new Client(nom, prenom, adresse, codepostal, ville, numerotelephone, cc2, ce2);
					x = false;
					break;
				default:
					System.out.println("Choix impossible, tapez 1 ou 2");
					break;
				}
			}
			

			

		}

	}

}
