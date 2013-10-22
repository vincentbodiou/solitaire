package solitaire.main;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import solitaire.application.Carte;
import solitaire.controleur.CCarte;
import solitaire.presentation.PCarte;

public class Solitaire {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
		
		CCarte c=new CCarte(1,1);
		frame.getContentPane().add(c.getPresentation());
		frame.setVisible(true);
	}

}
