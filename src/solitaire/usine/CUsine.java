package solitaire.usine;

import solitaire.application.Carte;
import solitaire.application.Sabot;
import solitaire.application.TasDeCartes;
import solitaire.application.Usine;
import solitaire.controleur.CCarte;
import solitaire.controleur.CSabot;
import solitaire.controleur.CTasDeCarte;

public class CUsine extends Usine {
	public Carte newCarte(int v, int c) {
		return new CCarte(v, c);
	}

	public TasDeCartes newTasDeCartes(String name, Usine u) {
		return new CTasDeCarte(name, u);
	}
	
	public Sabot newSabot(String name, Usine u)
	{
		return new CSabot(name, u);
	}
}
