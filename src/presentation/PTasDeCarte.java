package presentation;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

enum Decalage {
	HAUT,BAS,GAUCHE,DROITE
}

public class PTasDeCarte extends JPanel{

	private static int PAS=PCarte.largeur*30/100;

	private int dx = 0;
	private int dy = 0;
	
	public PTasDeCarte() {
		setLayout(null);		
		setSize(PCarte.largeur, PCarte.hauteur);
		setPreferredSize(getSize());
		setBackground(Color.blue);
		repaint();
	}

	public void empiler(PCarte carte) {
		this.setSize(carte.getWidth() + this.getComponentCount() * dx ,carte.getHeight() + this.getComponentCount() * dy);
		carte.setLocation(this.getComponentCount() * dx ,this.getComponentCount() * dy);
		setPreferredSize(getSize());
		add(carte,0);
		repaint();
	}

	public void depiler(PCarte carte) {
		this.setSize(this.getWidth() - dx, this.getHeight() - dy);
		remove(carte);
		repaint();
	}
	
	public void setDirectionDecalage(Decalage d){
		
		switch (d){
			case HAUT :
				dy = -(PTasDeCarte.PAS);
				break;
			case BAS :
				dy = (PTasDeCarte.PAS);
				break;
			case GAUCHE :
				dx = -(PTasDeCarte.PAS);
				break;
			case DROITE :
				dx = PTasDeCarte.PAS;
				break;
		
		}
		
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
	
		PTasDeCarte tasDeCarte = new PTasDeCarte();
		tasDeCarte.setVisible(true);
				
		// une carte visible
		PCarte pc = new PCarte ("1C");
		pc.setFaceVisible(true);
		tasDeCarte.empiler(pc);
			
		pc = new PCarte("1D");
		pc.setFaceVisible(true);
		tasDeCarte.empiler(pc);
		
		pc = new PCarte("1D");
		pc.setFaceVisible(true);
		tasDeCarte.empiler(pc);	
		
		f.getContentPane ().add(tasDeCarte) ;	
		
		f.pack () ;		// dimensionner le cadre
		f.setLocation(200,100);	// le positionner
		f.setVisible (true) ;	// et le rendre visible
    } // main

}
