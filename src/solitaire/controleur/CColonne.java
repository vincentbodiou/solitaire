package solitaire.controleur;

import solitaire.application.Colonne;
import solitaire.application.Usine;

public class CColonne extends Colonne {

	private CTasDeCarte tasVisible;
	private CTasDeCarte tasCachee;
	
	public CColonne(String nom, Usine usine) {
		super(nom, usine);
		
	}

}
