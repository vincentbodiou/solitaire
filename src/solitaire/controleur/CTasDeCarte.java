package solitaire.controleur;

import solitaire.application.TasDeCartes;
import solitaire.presentation.PTasDeCarte;

public class CTasDeCarte extends TasDeCartes {

	// Tas de carte 

	// 3 methode a redefinir :
	// Constructeur
	// empiler
	// dépiler

	// 1 methode a faire :
	// getPresentation
	PTasDeCarte p;
	
	CTasDeCartes(String nom, CUsine u ) {
		super(nom, u);
		p = new PTasDeCarte(this);
	}

	PTasDeCarte getPresentation() {
		return p;
	}

	public void empiler( Carte carte) {
		if(isEmpilable(carte)) {
			super.empiler(carte);
			if(carte==getSommet()) { //pensez au try catch
				p.empiler((CCarte)carte).getPresentation();
			}
		}
	}

	public void depiler() throws Exception {
		Carte carte = getSommet();
		super.depiler();
		presentation.depiler((CCarte)carte).getPresentation());
	}
}
