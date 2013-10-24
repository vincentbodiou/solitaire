package main;

import solitaire.application.Solitaire;
import solitaire.application.Usine;

public class Lanceur {

	public static void main(String[] args) {
				
		Usine usine = new Usine();
		Solitaire solitaire = new Solitaire("", usine);
		solitaire.initialiser();
		solitaire.run();	
		
	}

}
