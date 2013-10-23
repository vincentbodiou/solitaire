package presentation;

import java.awt.Color;

import javax.swing.JPanel;

public class PTasDeCarte extends JPanel{

	private static int dx=10,dy=10;
	
	public PTasDeCarte() {
		setLayout(null);
		setSize(72, 96);
		setBackground(Color.blue);
		repaint();
	}

	public void empiler(PCarte carte) {
		this.setSize(carte.getWidth() + this.getComponentCount() * dx ,carte.getHeight() + this.getComponentCount() * dy);
		carte.setLocation(this.getComponentCount() * dx ,this.getComponentCount() * dy);
		add(carte);		
		repaint();
	}

	public void depiler(PCarte carte) {
		this.setSize(this.getWidth() - dx, this.getHeight() - dy);
		remove(carte);
		repaint();
	}

}
