package solitaire.controleur;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import solitaire.application.Carte;
import solitaire.presentation.PCarte;

public class CCarte extends Carte{

	private PCarte p;
	
	public CCarte(int v, int c) {
		super(Math.max(1, Math.min(v, NbCartesParCouleur)), Math.max(1,	Math.min(c, NbCouleurs)));
		p = new PCarte( valeurs[getValeur() - 1] + couleurs[getCouleur() - 1] , this);
        p.setFaceVisible( isFaceVisible() );		
	}
	
	public void setFaceVisible( boolean b )
    {
        super.setFaceVisible( b );
        p.setFaceVisible( isFaceVisible() );
    }

    public PCarte getPresentation()
    {
        return (PCarte) p;
    }
    
    /**
	 * Test d'affichage d'une carte
	 * @param args
	 */
	public static void main(String[] args) {

		CCarte carte = new CCarte(1, 2);
		CCarte carte2 = new CCarte(1, 3);

		JFrame frame = new JFrame("Test CCarte");
		frame.setLayout(new FlowLayout());
		frame.getContentPane().add(carte.getPresentation());
		frame.getContentPane().add(carte2.getPresentation());

		carte2.setFaceVisible(true);

		frame.setVisible(true);
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(frame.getParent());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
