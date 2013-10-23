package controleur;

import presentation.PTasDeCarte;
import solitaire.application.Carte;
import solitaire.application.TasDeCartes;
import solitaire.application.Usine;

public class CTasDeCarte extends TasDeCartes {

	private PTasDeCarte p;
	
	public CTasDeCarte(String nom, Usine usine) {
		super(nom, usine);
		p = new PTasDeCarte(this);
	}

	// Tas de carte 

	// 3 methode a redefinir :
	// Constructeur
	// empiler
	// dépiler

	// 1 methode a faire :
	// getPresentation

	PTasDeCarte getPresentation() {
		return p;
	}

	public void empiler(Carte carte) {
		if(isEmpilable(carte)) {
			super.empiler(carte);
			try {
				if(carte==getSommet()) { 
					p.empiler((CCarte)carte).getPresentation();
				}
			} catch (Exception e) {
				e.printStackTrace(); //tas de carte vide
			}
		}
	}

	public void depiler() throws Exception {
		Carte carte = getSommet();
		super.depiler();
		p.depiler((CCarte)carte).getPresentation();
	}
}
