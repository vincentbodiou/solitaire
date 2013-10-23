package main;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import presentation.PCarte;
import controleur.CCarte;
import controleur.CSolitaire;
import controleur.CUsine;
import controleur.Interface.ICSolitaire;
import solitaire.application.Carte;
import solitaire.application.DoubleTas;
import solitaire.application.Sabot;
import solitaire.application.Solitaire;
import solitaire.application.Tas;
import solitaire.application.Usine;

public class ASolitaire {

	public static void main(String[] args) {
		
		/*JFrame frame = new JFrame();
		
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
		
		CCarte c=new CCarte(1,1);
		frame.getContentPane().add(c.getPresentation());
		frame.setVisible(true);*/
		
		Usine usine = new Usine();
		Solitaire solitaire = new Solitaire("", usine);
		solitaire.initialiser();
		solitaire.run();
		Sabot s = new Sabot("", usine);		
		
	}

}
