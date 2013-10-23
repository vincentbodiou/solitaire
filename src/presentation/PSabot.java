package presentation;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class PSabot extends JPanel
{
	private PTasDeCarte tasReserve;
	private PTasDeCarte tasVisible;
	private static final int MARGE = 10;

	public PSabot(PTasDeCarte reserve, PTasDeCarte tasVisible)
	{
		this.tasReserve = reserve;
		this.tasVisible = tasVisible;
		setLayout(null);

		reserve.setLocation(MARGE, MARGE);
		tasVisible.setLocation(MARGE * 2 + reserve.getWidth(), MARGE);
		add(reserve);
		add(tasVisible);

		// tasVisible.setLocation(MARGE*2 + reserve.getWidth(), MARGE);
		// add(tasVisible);

		setSize(reserve.getWidth() + tasVisible.getWidth() + MARGE * 3, reserve.getHeight() + MARGE * 2);
		setPreferredSize(getSize());
		setVisible(true);
		setBackground(Color.cyan);

		repaint();
	}

	/*
	 * RetournerCarteListener rcl; RetournerSabotListener rsl;
	 * 
	 * 
	 * PSabot( Csabot c, PTasDecarte caché, PTasDeCarte visible) { //add ...
	 * add(visible); visible.setDxDy(20,0); add(cachees); cachees.setDxDy(0,0);
	 * }
	 * 
	 * 
	 * class RetournerSabotListener implements MouseListener { public void
	 * mouseClicked(ME e) { control.retourner(); } }
	 * 
	 * class RetournerCarteListener implements MouseListener { public void
	 * mouseClicked(ME e) { control.retournerCarte(); } }
	 * 
	 * void activerRetournerSabot() { cache.setMouseListener(rsl); }
	 */

	public void depilerTasVisible(PCarte carte)
	{
		tasVisible.depiler(carte);
		setSize(MARGE * 3 + tasVisible.getWidth() + tasReserve.getWidth(), getHeight());
		setPreferredSize(getSize());
		repaint();
	}

	public void depilerReserve(PCarte carte)
	{
		tasReserve.depiler(carte);
		repaint();
	}

	public void empilerTasVisible(PCarte carte)
	{
		tasVisible.empiler(carte);
		setSize(MARGE * 3 + tasVisible.getWidth() + tasReserve.getWidth(), getHeight());
		setPreferredSize(getSize());
		repaint();
	}

	public void empilerReserve(PCarte carte)
	{
		tasReserve.empiler(carte);
		repaint();
	}

	public PTasDeCarte getReserve()
	{
		return tasReserve;
	}

	public void setReserve(PTasDeCarte reserve)
	{
		this.tasReserve = reserve;
	}

	public PTasDeCarte getTasVisible()
	{
		return tasVisible;
	}

	public void setTasVisible(PTasDeCarte tasVisible)
	{
		this.tasVisible = tasVisible;
	}

	public static int getMarge()
	{
		return MARGE;
	}

	/**
	 * programme de test : à déplacer dans une classe dédiée aux tests
	 * 
	 * @param args
	 */
	public static void main(String args[])
	{
		JFrame f = new JFrame("Test PCarte");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
		f.getContentPane().setBackground(new Color(143, 143, 195)); // violet																	// pâle

		PTasDeCarte tasVisible = new PTasDeCarte(Decalage.DROITE);
		tasVisible.setVisible(true);

		// init du tas de carte visible 
		PCarte carteVisible1 = new PCarte("1C");
		carteVisible1.setFaceVisible(true);
		tasVisible.empiler(carteVisible1);

		PCarte carteVisible2 = new PCarte("1C");
		carteVisible2.setFaceVisible(true);
		tasVisible.empiler(carteVisible2);

		PCarte carteVisible3 = new PCarte("1D");
		carteVisible3.setFaceVisible(true);
		tasVisible.empiler(carteVisible3);

		PCarte carteVisible4 = new PCarte("1D");
		carteVisible4.setFaceVisible(true);
		tasVisible.empiler(carteVisible4);

		// init du tas de carte de la reserve 
		PTasDeCarte reserve = new PTasDeCarte(Decalage.SANS_DECALAGE);
		reserve.setVisible(true);

		PCarte carteReserve1 = new PCarte("1C");
		carteReserve1.setFaceVisible(true);
		reserve.empiler(carteReserve1);

		PCarte carteReserve2 = new PCarte("1C");
		carteReserve2.setFaceVisible(true);
		reserve.empiler(carteReserve2);

		PCarte carteReserve3 = new PCarte("1D");
		carteReserve3.setFaceVisible(true);
		reserve.empiler(carteReserve3);
		
		//ajout dans le sabot
		PSabot sabot = new PSabot(reserve, tasVisible);

		//sabot.empilerTasVisible(new PCarte("10C"));
		sabot.depilerTasVisible(carteVisible4);
		
		//sabot.depilerReserve(carteReserve3);
		//sabot.empilerReserve(new PCarte("2H"));

		f.getContentPane().add(sabot);
		f.pack(); // dimensionner le cadre
		f.setLocation(200, 100); // le positionner
		f.setVisible(true); // et le rendre visible
	} // main

}
