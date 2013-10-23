package controleur;

import controleur.Interface.ICSolitaire;
import solitaire.application.Solitaire;
import solitaire.application.Usine;

public class CSolitaire extends Solitaire implements ICSolitaire{

	public CSolitaire(String nom, Usine usine) {
		super(nom, usine);		
	}
	
}
