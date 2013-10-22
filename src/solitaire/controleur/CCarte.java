package solitaire.controleur;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import solitaire.application.Carte;
import solitaire.application.Solitaire;
import solitaire.presentation.PCarte;

public class CCarte extends Carte{

	private PCarte p;
	
	public CCarte(int valeur, int couleur) {
		super(Math.min(Math.max(1, valeur),NbCartesParCouleur), Math.min(Math.max(1,couleur),NbCouleurs));
		p = new PCarte(valeurs[getValeur()-1] + couleurs[getCouleur()-1]);
		p.setFaceVisible(isFaceVisible());
	}

	public void setFaceVisible(boolean b) {
	 super.setFaceVisible(b);
	 p.setFaceVisible(isFaceVisible());
	}

	public PCarte getPresentation() {
		return p;
	}
	
	 /**
     * programme de test : à déplacer dans une classe dédiée aux tests
     * @param args
     */
    public static void main (String args []) {
	JFrame f = new JFrame ("Test PCarte") ;
	f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
	f.getContentPane ().setBackground(new Color(143, 143, 195)); // violet pâle

	// une carte visible
	CCarte pc = new CCarte (1,1);
	pc.setFaceVisible(true);
	f.getContentPane ().add(pc.getPresentation()) ;

	f.pack () ;		// dimensionner le cadre
	f.setLocation(200,100);	// le positionner
	f.setVisible (true) ;	// et le rendre visible
    } // main
	
}
