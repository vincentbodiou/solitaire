package solitaire.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import listener.ClickListener;
import solitaire.controleur.CCarte;
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
		reserve.addMouseListener( new RetournerCarteSabot() );
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
	
	private class RetournerCarteSabot extends ClickListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            try
            {
                controleur.retournerCarte();
            }
            catch ( Exception e1 )
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }
}
