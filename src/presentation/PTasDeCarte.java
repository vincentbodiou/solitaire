package presentation;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class PTasDeCarte extends JPanel
{
	private Decalage decalage;

	public PTasDeCarte(Decalage decalage)
	{
		this.decalage = decalage;

		setLayout(null);
		setSize(PCarte.largeur, PCarte.hauteur);
		setPreferredSize(getSize());
		setBackground(Color.blue);
		repaint();
	}

	public void empiler(PCarte carte)
	{
		this.setSize(carte.getWidth() + this.getComponentCount() * decalage.getDx(),
				carte.getHeight() + this.getComponentCount() * decalage.getDy());
		carte.setLocation(this.getComponentCount() * decalage.getDx(), this.getComponentCount() * decalage.getDy());
		setPreferredSize(getSize());
		add(carte, 0);
		repaint();
	}

	public void depiler(PCarte carte)
	{
		remove(carte);
		this.setSize(this.getWidth() - decalage.getDx(), this.getHeight() - decalage.getDy());
		setPreferredSize(getSize());
		repaint();
	}

	/**
	 * programme de test : à déplacer dans une classe dédiée aux tests
	 * 
	 * @param args
	 */
	public static void main (String args []) {
		JFrame f = new JFrame ("Test PCarte") ;
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
		f.getContentPane ().setBackground(Color.gray); // violet pâle
	
		PTasDeCarte tasDeCarte = new PTasDeCarte(Decalage.DROITE);
		tasDeCarte.setVisible(true);
				
		// empile une carte
		PCarte pc1 = new PCarte ("1C");
		pc1.setFaceVisible(true);
		tasDeCarte.empiler(pc1);
		
		//puis une autre...
		PCarte pc2 = new PCarte("1D");
		pc2.setFaceVisible(true);
		tasDeCarte.empiler(pc2);
		
		//puis une autre...
		PCarte pc3 = new PCarte("10H");
		pc3.setFaceVisible(true);
		tasDeCarte.empiler(pc3);
		
		PCarte pc4 = new PCarte("4S");
		pc4.setFaceVisible(true);
		tasDeCarte.empiler(pc4);
		
		tasDeCarte.depiler(pc4);
		
		f.getContentPane ().add(tasDeCarte) ;	
		
		
		f.pack () ;		// dimensionner le cadre
		f.setLocation(200,100);	// le positionner
		f.setVisible (true) ;	// et le rendre visible
    } // main
}
