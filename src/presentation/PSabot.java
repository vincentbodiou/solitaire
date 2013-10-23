package presentation;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class PSabot extends JPanel
{

	private PTasDeCarte reserve;
	private PTasDeCarte tasVisible;
	private static final int MARGE = 10;

	public PSabot(PTasDeCarte reserve, PTasDeCarte tasVisible)
	{
		this.reserve = reserve;
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
		repaint();
	}

	public void depilerReserve(PCarte carte)
	{
		reserve.depiler(carte);
		setSize(MARGE * 3 + tasVisible.getWidth() + reserve.getWidth(), getHeight());
		setPreferredSize(getSize());
		repaint();
	}

	public void empilerTasVisible(PCarte carte)
	{
		tasVisible.empiler(carte);
		setSize(MARGE * 3 + tasVisible.getWidth() + reserve.getWidth(), getHeight());
		setPreferredSize(getSize());
		repaint();
	}

	public void empilerReserve(PCarte carte)
	{
		reserve.empiler(carte);
		repaint();
	}

	public PTasDeCarte getReserve()
	{
		return reserve;
	}

	public void setReserve(PTasDeCarte reserve)
	{
		this.reserve = reserve;
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
		f.getContentPane().setBackground(new Color(143, 143, 195)); // violet
																	// pâle

		PTasDeCarte tasDeCarte = new PTasDeCarte(Decalage.DROITE);
		tasDeCarte.setVisible(true);

		// une carte visible
		PCarte pc = new PCarte("1C");
		pc.setFaceVisible(true);
		tasDeCarte.empiler(pc);

		pc = new PCarte("1C");
		pc.setFaceVisible(true);
		tasDeCarte.empiler(pc);

		pc = new PCarte("1D");
		pc.setFaceVisible(true);
		tasDeCarte.empiler(pc);

		pc = new PCarte("1D");
		pc.setFaceVisible(true);
		tasDeCarte.empiler(pc);

		PTasDeCarte tasDeCarte2 = new PTasDeCarte(Decalage.SANS_DECALAGE);
		tasDeCarte2.setVisible(true);

		// une carte visible
		PCarte pc2 = new PCarte("1C");
		pc2.setFaceVisible(true);
		tasDeCarte2.empiler(pc2);

		pc2 = new PCarte("1C");
		pc2.setFaceVisible(true);
		tasDeCarte2.empiler(pc2);

		pc2 = new PCarte("1D");
		pc2.setFaceVisible(true);
		tasDeCarte2.empiler(pc2);

		pc2 = new PCarte("1D");
		pc.setFaceVisible(true);
		tasDeCarte2.empiler(pc2);

		PSabot sabot = new PSabot(tasDeCarte2, tasDeCarte);

		sabot.depilerTasVisible(pc);

		f.getContentPane().add(sabot);
		f.pack(); // dimensionner le cadre
		f.setLocation(200, 100); // le positionner
		f.setVisible(true); // et le rendre visible
	} // main

}
