package solitaire.presentation;

import javax.swing.JPanel;

import solitaire.controleur.CSabot;

public class PSabot extends JPanel {

	private static final long serialVersionUID = 1L;
	private CSabot controleur;
	private PTasDeCarte reserve;
	private PTasDeCarte visible;

	public PSabot(CSabot s) {
		setControleur(s);
		this.reserve = s.getTasCache().getPresentation();
		this.visible = s.getTasVisible().getPresentation();
		add(reserve);
		add(visible);
		setVisible(true);
	}
	
	

	public CSabot getControleur() {
		return controleur;
	}

	public void setControleur(CSabot controleur) {
		this.controleur = controleur;
	}

	public PTasDeCarte getReserve() {
		return reserve;
	}

	public void setReserve(PTasDeCarte reserve) {
		this.reserve = reserve;
	}

	public PTasDeCarte getVisible() {
		return visible;
	}

	public void setVisible(PTasDeCarte visible) {
		this.visible = visible;
	}

}
