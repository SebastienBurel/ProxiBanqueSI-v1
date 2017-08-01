package com.gtm.proxibanque.presentation;

import java.util.Scanner;

import com.gtm.proxibanque.metiers.Client;
import com.gtm.proxibanque.metiers.CompteCourant;
import com.gtm.proxibanque.metiers.CompteEpargne;
import com.gtm.proxibanque.metiers.Conseiller;

public class MainProxiBanque {

	public static void main(String[] args) {

		Conseiller conseiller = new Conseiller();

		// tests
		CompteCourant cc = new CompteCourant("546", 100, 2000, "Visa Electron");
		CompteEpargne ce = new CompteEpargne("987", 200, 2000, "Visa Electron");
		conseiller.creerClient(new Client("Burel", "Seb", "643 route de Layrac", 31200, "Toulouse", "0611167004", cc, ce));
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
			System.out.println("Gestion de patrimoine : tapez 9");

	
			short choix = clavier.nextShort();

			// Choix 1
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
							String cb = "Visa Electron";
							CompteCourant cc1 = new CompteCourant(numeroCC, soldeCC, anneeCC, cb);
							CompteEpargne ce1 = new CompteEpargne(numeroCE, soldeCE, anneeCE, cb);
							System.out
									.println("Le compte courant a bien ete cree : Numero = " + numeroCC + ", solde = " + soldeCC + ", annee de creation = " + anneeCC + ", carte bancaire choisie = " + cb);
							System.out.println("Le compte epargne a bien ete cree : Numero = " + numeroCE + ", solde = " + soldeCE + ", annee de creation = " + anneeCE);
							Client cl1 = new Client(nom, prenom, adresse, codepostal, ville, numerotelephone, cc1, ce1);
							x = false;
							break;
						case 2:
							System.out.println("Carte Visa Premier choisie");
							cb = "Visa Premier";
							CompteCourant cc2 = new CompteCourant(numeroCC, soldeCC, anneeCC, cb);
							CompteEpargne ce2 = new CompteEpargne(numeroCE, soldeCE, anneeCE, cb);
							System.out
									.println("Le compte courant a bien ete cree : Numero = " + numeroCC + ", solde = " + soldeCC + ", annee de creation = " + anneeCC + ", carte bancaire choisie = " + cb);
							System.out.println("Le compte epargne a bien ete cree : Numero = " + numeroCE + ", solde = " + soldeCE + ", annee de creation = " + anneeCE);
							Client cl2 = new Client(nom, prenom, adresse, codepostal, ville, numerotelephone, cc2, ce2);
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
				System.out.println("Nom de la personne détentrice des comptes : ");
				String nom5 = clavier.next();
				System.out.println("Prenom de la personne détentrice des comptes : ");
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
							System.out.println("Nom de la personne détentrice des comptes : ");
							String nom2 = clavier.next();
							System.out.println("Prenom de la personne détentrice des comptes : ");
							String prenom2 = clavier.next();
							Client client4 = conseiller.lireClient(nom2, prenom2);
	
							System.out.println("Selectionnez un montant à verser : ");
							float mt = clavier.nextFloat();
							conseiller.verserCompteCourantVersCompteEpargne(client4, mt);
							x2 = false;
							
							break;
	
						case 2:
							System.out.println("Virement depuis Compte Epargne vers Compte Courant choisi");
							System.out.println("Nom de la personne détentrice des comptes : ");
							String nom3 = clavier.next();
							System.out.println("Prenom de la personne détentrice des comptes : ");
							String prenom3 = clavier.next();
							Client client5 = conseiller.lireClient(nom3, prenom3);
	
							System.out.println("Selectionnez un montant à verser : ");
							float mt2 = clavier.nextFloat();
							conseiller.verserCompteEpargneVersCompteCourant(client5, mt2);
							x2 = false;
							break;
						default:
							System.out.println("Choix invalide, tapez 1 ou 2");							
	
						}					
				}
				break;
				
			case 9 :				
				y = false;
	
				
			}
			
			
		}
		
		clavier.close();
	}
}
