package controleur;

import solitaire.application.Usine;

public class CUsine extends Usine{

	public CUsine()
	{
		super();
	}
	
	public CCarte newCarte(int valeur, int couleur){
		return new CCarte(valeur,couleur);
	}
	
}
