package com.gtm.proxibanque.metiers;

public class Auditeur extends Personne {
	private Agence agence;

	public Auditeur(String nom, String prenom, String adresse, int codepostal, String ville, String numerotelephone) {
		super(nom, prenom, adresse, codepostal, ville, numerotelephone);
	}

	public Auditeur() {
		super();
	}
	
	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public void Auditer(Agence agence) {
		for (Conseiller conseiller : agence.getGerant().getListConseillers()) {
			for (Client client : conseiller.getClients()) {
				if (conseiller.calculerSoldeTotal(client) < -5000) {
					System.out.println("Probleme avec ce client :");
					System.out.println(client);
					System.out.println("Il est au dela de la limite de debit !");
				}
			}
		}
	}

}
