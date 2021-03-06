package com.gtm.proxibanque.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import com.gtm.proxibanque.metiers.Action;
import com.gtm.proxibanque.metiers.Agence;
import com.gtm.proxibanque.metiers.Auditeur;
import com.gtm.proxibanque.metiers.Client;
import com.gtm.proxibanque.metiers.CompteCourant;
import com.gtm.proxibanque.metiers.CompteEpargne;
import com.gtm.proxibanque.metiers.Conseiller;
import com.gtm.proxibanque.metiers.Gerant;

public class MainProxiBanque {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List conseillers = new ArrayList<>();
		Conseiller conseiller = new Conseiller();

		// tests
		CompteCourant cc = new CompteCourant("546", 100, 2000, "Visa Electron");
		CompteEpargne ce = new CompteEpargne("987", 2000000, 2000, "Visa Electron");
		Client seb = new Client("Burel", "Seb", "643 route de Layrac", 31200, "Toulouse", "0611167004", cc, ce);
		conseiller.creerClient(seb);
		Gerant gerant1 = new Gerant("Dupond", "Michel", "33 rue des lamas", 32000, "Toulouse", "0785961232", conseillers);
		Agence agence = new Agence("56897D", "2000", gerant1);
		Auditeur auditeur = new Auditeur("Dupont", "Bertrand", "589 impasse des mulots", 31300, "Toulouse", "0223125689");
		auditeur.Auditer(agence);
		Action actionAirbus = new Action("Airbus", 72, "Paris");
		conseiller.ajouterActionDisponible(actionAirbus);
		Action actionFacebook = new Action("Facebook", 144, "New York");
		conseiller.ajouterActionDisponible(actionFacebook);
		Action actionSony = new Action("Sony", 37, "Tokyo");
		conseiller.ajouterActionDisponible(actionSony);
		// conseiller.lireClient("Burel", "Seb");

		boolean y = true;

		Scanner clavier = new Scanner(System.in);

		while (y) {

			System.out.println("Que voulez vous faire ?");
			System.out.println("Creer un client : tapez 1");
			System.out.println("Modifier un client : tapez 2");
			System.out.println("Lire un client : tapez 3");
			System.out.println("Supprimer un client : tapez 4");
			System.out.println("Effectuer un virement : tapez 5");
			System.out.println("Simuler un credit : tapez 6");
			System.out.println("Realiser un audit d'agence : tapez 7");
			System.out.println("Gestion de patrimoine : tapez 8");
			System.out.println("Quitter le programme : tapez 9");

			short choix = clavier.nextShort();

			// Choix 1
			switch (choix) {
			case 1:
				System.out.println("Nom de la personne � ajouter :");
				String nom = clavier.next();
				System.out.println("Prenom de la personne � ajouter :");
				String prenom = clavier.next();
				System.out.println("Adresse de la personne � ajouter :");
				String adresse = clavier.nextLine();
				clavier.nextLine();
				System.out.println("Code postal de la personne � ajouter :");
				int codepostal = clavier.nextInt();
				System.out.println("Ville de la personne � ajouter :");
				String ville = clavier.next();
				System.out.println("Numero de telephone de la personne � ajouter :");
				String numerotelephone = clavier.next();

				System.out.println("Numero du nouveau compte courant de la personne � ajouter :");
				String numeroCC = clavier.next();
				System.out.println("Solde de compte courant de la personne � ajouter :");
				float soldeCC = clavier.nextFloat();
				System.out.println("Annee de creation du nouveau compte courant de la personne � ajouter :");
				short anneeCC = clavier.nextShort();

				System.out.println("Numero du nouveau compte epargne de la personne � ajouter :");
				String numeroCE = clavier.next();
				System.out.println("Solde de compte epargne de la personne � ajouter :");
				float soldeCE = clavier.nextFloat();
				System.out.println("Annee de creation du nouveau compte epargne de la personne � ajouter :");
				short anneeCE = clavier.nextShort();
				System.out.println("Choix de la carte bancaire de la personne � ajouter : tapez 1 pour Visa Electron ou tapez 2 pour Visa Premier");
				boolean x = true;
				while (x) {
					int choix2 = clavier.nextInt();
					switch (choix2) {
					case 1:
						System.out.println("Carte Visa Electron choisie");
						String cb = "Visa Electron";
						CompteCourant cc1 = new CompteCourant(numeroCC, soldeCC, anneeCC, cb);
						CompteEpargne ce1 = new CompteEpargne(numeroCE, soldeCE, anneeCE, cb);
						System.out.println("Le compte courant a bien ete cree : Numero = " + numeroCC + ", solde = " + soldeCC + ", annee de creation = " + anneeCC + ", carte bancaire choisie = " + cb);
						System.out.println("Le compte epargne a bien ete cree : Numero = " + numeroCE + ", solde = " + soldeCE + ", annee de creation = " + anneeCE);
						Client cl1 = new Client(nom, prenom, adresse, codepostal, ville, numerotelephone, cc1, ce1);
						conseiller.creerClient(cl1);
						x = false;
						break;
					case 2:
						System.out.println("Carte Visa Premier choisie");
						cb = "Visa Premier";
						CompteCourant cc2 = new CompteCourant(numeroCC, soldeCC, anneeCC, cb);
						CompteEpargne ce2 = new CompteEpargne(numeroCE, soldeCE, anneeCE, cb);
						System.out.println("Le compte courant a bien ete cree : Numero = " + numeroCC + ", solde = " + soldeCC + ", annee de creation = " + anneeCC + ", carte bancaire choisie = " + cb);
						System.out.println("Le compte epargne a bien ete cree : Numero = " + numeroCE + ", solde = " + soldeCE + ", annee de creation = " + anneeCE);
						Client cl2 = new Client(nom, prenom, adresse, codepostal, ville, numerotelephone, cc2, ce2);
						conseiller.creerClient(cl2);
						x = false;
						break;
					default:
						System.out.println("Choix impossible, tapez 1 ou 2");
						break;
					}
				}
				y = true;
				break;

			// Choix 3
			case 3:
				System.out.println("Lecture des comptes d'un client");
				System.out.println("Nom de la personne d�tentrice des comptes : ");
				String nom5 = clavier.next();
				System.out.println("Prenom de la personne d�tentrice des comptes : ");
				String prenom5 = clavier.next();
				conseiller.lireClient(nom5, prenom5);
				y = true;
				break;

			// Choix 5
			case 5:
				System.out.println("Voulez vous effectuer un virement depuis le Compte Courant vers le Compte Epargne (tapez 1) ou depuis le Compte Epargne vers le compte Courant (tapez 2) ?");
				boolean x2 = true;
				while (x2) {
					int choix3 = clavier.nextInt();
					switch (choix3) {
					case 1:
						System.out.println("Virement depuis Compte Courant vers Compte Epargne choisi");
						System.out.println("Nom de la personne d�tentrice des comptes : ");
						String nom2 = clavier.next();
						System.out.println("Prenom de la personne d�tentrice des comptes : ");
						String prenom2 = clavier.next();
						Client client4 = conseiller.lireClient(nom2, prenom2);
						
						System.out.println("Selectionnez un montant � verser : ");
						float mt = clavier.nextFloat();
						conseiller.verserCompteCourantVersCompteEpargne(client4, mt);
						x2 = false;

						break;

					case 2:
							System.out.println("Virement depuis Compte Epargne vers Compte Courant choisi");
							System.out.println("Nom de la personne d�tentrice des comptes : ");
							String nom3 = clavier.next();
							System.out.println("Prenom de la personne d�tentrice des comptes : ");
							String prenom3 = clavier.next();
							Client client5 = conseiller.lireClient(nom3, prenom3);
							
							System.out.println("Selectionnez un montant � verser : ");
							float mt2 = clavier.nextFloat();
							conseiller.verserCompteEpargneVersCompteCourant(client5, mt2);
							x2 = false;
							break;						
					default:
						System.out.println("Choix invalide, tapez 1 ou 2");

					}
				}
				break;
				
			case 8:
				System.out.println("Nom de la personne detentrice des comptes : ");
				String nom8 = clavier.next();
				System.out.println("Prenom de la personne detentrice des comptes : ");
				String prenom8 = clavier.next();
				Client client8 = conseiller.lireClient(nom8, prenom8);
				if (conseiller.gererPatrimoine(client8)) {
					conseiller.afficherActionsDisponibles();
					conseiller.afficherActionsClient(client8);
					System.out.println("Acheter action Airbus : tapez 1");
					System.out.println("Acheter action Facebook : tapez 2");
					System.out.println("Acheter action Sony : tapez 3");
					boolean x8 = true;
					while (x8) {
						int choix8 = clavier.nextInt();
						switch (choix8) {
						case 1:
							System.out.println("Entrer quantite :");
							int quantite1 = clavier.nextInt();
							conseiller.acheterAction(client8, actionAirbus, quantite1);
							x8 = false;
							break;
						case 2:
							System.out.println("Entrer quantite :");
							int quantite2 = clavier.nextInt();
							conseiller.acheterAction(client8, actionFacebook, quantite2);
							x8 = false;
							break;
						case 3:
							System.out.println("Entrer quantite :");
							int quantite3 = clavier.nextInt();
							conseiller.acheterAction(client8, actionSony, quantite3);
							x8 = false;
							break;
						default:
							System.out.println("Choix invalide, tapez 1, 2 ou 3");
						}
					}

				} else {
					break;
				}
				break;

			case 9:
				y = false;

			}

		}

		clavier.close();
	}
}
