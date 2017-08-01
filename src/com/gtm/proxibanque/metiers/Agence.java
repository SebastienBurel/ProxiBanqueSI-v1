package com.gtm.proxibanque.metiers;
/**
 * Classe Agence
 * @author severinthibaut
 *
 */
public class Agence {

	private String numID;
	private String dateCreation;
	private Gerant gerant;
	
	
	public Agence(String numID, String dateCreation, Gerant gerant) {
		super();
		this.numID = numID;
		this.dateCreation = dateCreation;
		this.gerant = gerant;
	}
	
	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getNumID() {
		return numID;
	}
	public void setNumID(String numID) {
		this.numID = numID;
	}
	public String getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Gerant getGerant() {
		return gerant;
	}
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	@Override
	public String toString() {
		return "Agence [numID=" + numID + ", dateCreation=" + dateCreation + ", gerant=" + gerant + "]";
	}

}
