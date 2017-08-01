package com.gtm.proxibanque.metiers;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import com.gtm.proxibanque.presentation.Constantes;

/**
 * Classe de Conseiller
 * 
 * @author Sebounet team
 *
 */
public class Conseiller extends Personne {
	
	private float soldeCompteCourantClient;
	private float soldeCompteEpargneClient;
	private Integer nbAction;
	private Collection<Client> clients;
	private HashSet<Action> actionsDisponibles;

	public Conseiller() {
		this.clients = new HashSet<>();
		this.actionsDisponibles = new HashSet<Action>();
	}

	public Collection<Client> getClients() {
		return clients;
	}

	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}

	public HashSet<Action> getActionsDisponibles() {
		return actionsDisponibles;
	}

	public void setActionsDisponibles(HashSet<Action> actionsDisponibles) {
		this.actionsDisponibles = actionsDisponibles;
	}

	/**
	 * Methode de creation d'un profil client
	 * 
	 * @param client
	 *            Client � ajouter
	 * 
	 * @param client
	 *            Client � ajouter
	 */
	public void creerClient(Client client) {

		if (clients.size() < Constantes.NOMBRE_MAX_CLIENTS_PAR_CONSEILLER) {
			boolean existant = false;
			for (Client client2 : this.clients) {
				if (client2.getNom() == client.getNom() && client2.getPrenom() == client.getPrenom()) {
					System.out.println("Impossible de cr�er ce client, il existe d�j�.");
					existant = true;
				}
			}
			if (existant == false) {
				this.clients.add(client);
				System.out.println("Le client " + client.getNom() + " " + client.getPrenom()
						+ " a bien �t� cr�� dans la base de donn�es");

			}
		}

		else {
			System.out.println("Impossible de cr�er un nouveau client : vous ne pouvez pas g�rer plus de 10 clients.");

		}

	}

	public void modifierClient() {

	}

	/**
	 * Methode de virements du Compte Epargne vers le Compte Courant
	 * 
	 * @param client
	 *            Proprietaire des comptes
	 * @param mt
	 *            Montant verse
	 */
	public void verserCompteEpargneVersCompteCourant(Client client, float mt) {
		if (client.getCompteCourant() == null) {
			System.out.println("Erreur : le client n a pas de compte courant !");
			System.out.println("Ouvrir d abord un compte courant au client !");
		} else {
			if (client.getCompteEpargne() == null) {
				System.out.println("Erreur : le client n a pas de compte epargne !");
				System.out.println("Ouvrir d abord un compte epargne au client !");
			} else {
				soldeCompteCourantClient = client.getCompteCourant().getSolde();
				soldeCompteEpargneClient = client.getCompteEpargne().getSolde();
				client.getCompteEpargne().retirer(mt);
				if (soldeCompteEpargneClient == client.getCompteEpargne().getSolde()) {
					System.out.println("Erreur de versement du compte epargne vers le compte courant !");
				} else {
					client.getCompteCourant().verser(mt);
				}
			}
		}
	}

	/**
	 * Methode de virements du Compte Courant vers le Compte Epargne
	 * 
	 * @param client
	 *            Proprietaire des comptes
	 * @param mt
	 *            Montant verse
	 */
	public void verserCompteCourantVersCompteEpargne(Client client, float mt) {
		if (client.getCompteCourant() == null) {
			System.out.println("Erreur : le client n a pas de compte courant !");
			System.out.println("Ouvrir d abord un compte courant au client !");
		} else {
			if (client.getCompteEpargne() == null) {
				System.out.println("Erreur : le client n a pas de compte epargne !");
				System.out.println("Ouvrir d abord un compte epargne au client !");
			} else {
				soldeCompteCourantClient = client.getCompteCourant().getSolde();
				soldeCompteEpargneClient = client.getCompteEpargne().getSolde();
				client.getCompteCourant().retirer(mt);
				if (soldeCompteCourantClient == client.getCompteCourant().getSolde()) {
					System.out.println("Erreur de versement du compte courant vers le compte epargne !");
				} else {
					client.getCompteEpargne().verser(mt);
				}
			}
		}
	}

	/**
	 * Methode de calcul du solde total du client
	 * 
	 * @param client
	 *            Proprietaire des comptes
	 * @return Solde total du client
	 */
	public float calculerSoldeTotal(Client client) {
		if (client.getCompteCourant() != null) {
			soldeCompteCourantClient = client.getCompteCourant().getSolde();
		} else {
			soldeCompteCourantClient = 0;
		}
		if (client.getCompteEpargne() != null) {
			soldeCompteEpargneClient = client.getCompteEpargne().getSolde();
		} else {
			soldeCompteEpargneClient = 0;
		}
		return soldeCompteCourantClient + soldeCompteEpargneClient;
	}

	/**
	 * Methode de simulation du credit consommation
	 * 
	 * @param client
	 *            Proprietaire du compte
	 */
	public void simulerCreditConso(Client client) {
		System.out.println("Proposition de credit consommation : ");
	}

	/**
	 * Methode de simulation de credit immobilier
	 * 
	 * @param client
	 *            Proprietaire du compte
	 */
	public void simulerCreditImmo(Client client) {
		System.out.println("Proposition de credit immobilier : ");
	}
	
	/**
	 * Méthode permettant d ajouter une action à une liste d actions disponibles pour achat
	 * dans le cadre de la gestion de patrimoine
	 * @param action action a rajouter dans la liste
	 */
	public void ajouterActionDisponible(Action action) {
		boolean flag = true;
		for (Action actionListe : this.actionsDisponibles) {
			if (actionListe.getNom() == action.getNom()) {
				flag = false;
			}
		}
		if (flag) {
			this.actionsDisponibles.add(action);
		}
	}
	
	
	public void afficherActionsDisponibles() {
		for (Action action: this.actionsDisponibles) {
			System.out.println("Disponibilite d achat de l action " + action.getNom() + 
					" sur la bourse de " + action.getBourse() + 
					" au prix de " + action.getCours() + " euros.");
		}
	}

	/**
	 * Methode de gestion du patrimoine si le client est suffisamment riche
	 * 
	 * @param client
	 *            Proprietaire du compte
	 */
	public void gererPatrimoine(Client client) {
		if (calculerSoldeTotal(client) > Constantes.SOLDE_MINIMUM_CLIENT_FORTUNE) {
			System.out.println("Le client " + client.getPrenom() + " " + client.getNom() + 
					" a un solde suffisant pour beneficier de la gestion de patrimoine");
			System.out.println("Gestion de Patrimoine :");
			Action actionAirbus = new Action("Airbus", 72, "Paris");
			ajouterActionDisponible(actionAirbus);
			Action actionFacebook = new Action("Facebook", 144, "New York");
			ajouterActionDisponible(actionFacebook);
			Action actionSony = new Action("Sony", 37, "Tokyo");
			ajouterActionDisponible(actionSony);
			afficherActionsDisponibles();
			acheterAction(client, actionFacebook, 10);
		} else {
			System.out.println("Le client " + client.getPrenom() + " " + client.getNom() +
					" n est pas assez riche pour beneficier de la gestion de patrimoine !");
		}
	}

	public void acheterAction(Client client, Action action, int quantite) {
		System.out.println("Achat de "+ quantite +" action(s) " + action.getNom() + " au prix de " + action.getCours() + " euros.");
		if (client.getPortefeuilleActions().containsKey(action)) {
			this.nbAction = client.getPortefeuilleActions().get(action);
			System.out.println(nbAction);
		} else {
			this.nbAction = 0;
			System.out.println(nbAction);
		}
		client.getPortefeuilleActions().put(action,nbAction + quantite);
		System.out.println("Le client " + client.getPrenom() + " " + client.getNom() + 
				" possede maintenant " + client.getPortefeuilleActions().get(action) + 
				" action(s) " + action.getNom() + ".");
	}

	/**
	 * Methode de lecture du profil client
	 * 
	 * @param nom
	 *            Nom du client
	 * @param prenom
	 *            Prenom du client
	 */
	public Client lireClient(String nom, String prenom) {
		boolean dejaaffiche = false;
		for (Client client : this.clients) {

			if (nom.equalsIgnoreCase(client.getNom()) && prenom.equalsIgnoreCase(client.getPrenom())) {
				System.out.println("Donn�es du client " + nom + " " + prenom + " :  Solde de Compte Courant = "
						+ client.getCompteCourant().getSolde() + ", solde de Compte Epargne = "
						+ client.getCompteEpargne().getSolde());
				return client;

			}

		}
		if (dejaaffiche == false) {
			System.out.println("Le client n'existe pas");

		}
		return null;
	}

	/**
	 * Methode de suppression d'un profil client
	 * 
	 * @param nom
	 *            Nom du client
	 * @param prenom
	 *            Prenom du client
	 */
	public void supprimerClient(String nom, String prenom) {
		Iterator<Client> it = clients.iterator();
		boolean existant = true;
		while (it.hasNext()) {
			Client client = it.next();
			if (nom == client.getNom() && prenom == client.getPrenom()) {
				it.remove();
				System.out.println("Le client " + client.getNom() + " " + client.getPrenom()
						+ " a bien �t� supprim� dans la base de donn�es");
				existant = false;
				System.out.println(clients.size());
			}
		}
		if (existant == true) {
			System.out.println("Action impossible, ce client n'existe pas");
		}
	}

	public Conseiller(String nom, String prenom, String adresse, int codepostal, String ville, String numerotelephone) {
		super(nom, prenom, adresse, codepostal, ville, numerotelephone);
	}

}
