package solitaire.presentation;

import java.awt.Color;

import javax.swing.JPanel;

import solitaire.application.TasDeCartes;
import solitaire.application.Usine;
import solitaire.controleur.CTasDeCarte;

public class PTasDeCarte extends JPanel {

	private static final long serialVersionUID = 1L;
	private CTasDeCarte controleur;
	private int Xoffset;
	private int Yoffset;
	
	public PTasDeCarte(String nom, Usine usine, CTasDeCarte cTasDeCarte) {
		super();
		this.controleur = cTasDeCarte;
		setLayout( null );
        setSize( PCarte.largeur, PCarte.hauteur );
        setPreferredSize( getSize() );
        setBackground( Color.blue );
	}

	public void empiler(PCarte pCard) {
	    System.out.println("empiler de PTasDeCarte");
		int nbCard = getNbCard();
		
		int xOffset = getXoffset();
		int yOffset = getYoffset();

		add(pCard, 0);
		pCard.setLocation((nbCard - 1) * xOffset, 	((nbCard - 1) * yOffset));

		rafraichir();
	}

	private void rafraichir() {		
		repaint();
	}
	
	public void depiler(PCarte c) {
	    System.out.println("depiler de PTasDeCarte");
		remove(c);
		rafraichir();
	}


	private int getNbCard() {
		return controleur.getNombre();
	}
	
	public CTasDeCarte getControleur() {
		return controleur;
	}

	public void setControleur(CTasDeCarte controleur) {
		this.controleur = controleur;
	}

	public int getXoffset() {
		return Xoffset;
	}

	public void setXoffset(int xoffset) {
		Xoffset = xoffset;
	}

	public int getYoffset() {
		return Yoffset;
	}

	public void setYoffset(int yoffset) {
		Yoffset = yoffset;
	}

	
}
