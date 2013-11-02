package solitaire.usine;

import solitaire.application.Carte;
import solitaire.application.Colonne;
import solitaire.application.Sabot;
import solitaire.application.TasDeCartes;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.Usine;
import solitaire.controleur.CCarte;
import solitaire.controleur.CColonne;
import solitaire.controleur.CSabot;
import solitaire.controleur.CTasDeCarte;
import solitaire.controleur.CTasDeCarteAlterne;

public class CUsine extends Usine {
    
    public CUsine() 
    {
        super();
    }
    
	public Carte newCarte(int v, int c) {
		return new CCarte(v, c);
	}

	public TasDeCartes newTasDeCartes(String name, Usine u) {
		return new CTasDeCarte(name, u);
	}
	
	public TasDeCartesAlternees newTasDeCartesAlternees(String name, Usine u) {
        return new CTasDeCarteAlterne(name, u);
    }
	
	public Sabot newSabot(String name, Usine u)
	{
		return new CSabot(name, u);
	}
	
	public Colonne newColonne(String name, Usine u)
	{
	    return new CColonne( name, u );
	}
}
