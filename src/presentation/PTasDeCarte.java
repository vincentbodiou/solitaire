package presentation;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class PTasDeCarte extends JPanel
{

	private static int PAS = PCarte.largeur * 30 / 100;

	private int dx = 0;
	private int dy = 0;

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
		this.setSize(this.getWidth() - decalage.getDx(), this.getHeight() - decalage.getDy());
		remove(carte);
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
		f.getContentPane ().setBackground(new Color(143, 143, 195)); // violet pâle
	
		PTasDeCarte tasDeCarte = new PTasDeCarte(Decalage.DROITE);
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
		tasDeCarte.empiler(new PCarte("1C"));
		tasDeCarte.empiler(new PCarte("1D"));
		
		f.pack () ;		// dimensionner le cadre
		f.setLocation(200,100);	// le positionner
		f.setVisible (true) ;	// et le rendre visible
    } // main
}
