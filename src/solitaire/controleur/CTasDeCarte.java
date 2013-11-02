package solitaire.controleur;

import javax.swing.JFrame;

import solitaire.application.Carte;
import solitaire.application.TasDeCartes;
import solitaire.application.Usine;
import solitaire.presentation.PTasDeCarte;
import solitaire.usine.CUsine;

public class CTasDeCarte extends TasDeCartes {

	private PTasDeCarte p;

	public CTasDeCarte(String nom, Usine usine) {
		super(nom, usine);
		p = new PTasDeCarte(nom, usine, this);
	}

	public void empiler(Carte c) {
		if (isEmpilable(c)) {
			super.empiler(c);
			try {
				if (c == getSommet()) {
					p.empiler(((CCarte) c).getPresentation());
				}
			} catch (Exception e) {
				System.out.println("impossible d'empiler");
			}

		}
	}

	public void depiler() throws Exception {
		if(!isVide()){
			CCarte c = (CCarte)getSommet();
			super.depiler();
			p.depiler(c.getPresentation());
		}
	}

	public PTasDeCarte getPresentation() {
		return p;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Test CTasDeCarte");

		CCarte c1 = new CCarte(1, 1);
		CCarte c2 = new CCarte(2, 2);
		CCarte c3 = new CCarte(13, 3);
		CCarte c4 = new CCarte(12, 2);
		c1.setFaceVisible(true);
		c2.setFaceVisible(true);
		c3.setFaceVisible(true);
		c4.setFaceVisible(true);

		CUsine factory = new CUsine();

		CTasDeCarte tasDeCarte = (CTasDeCarte) factory.newTasDeCartes("tas",
				factory);
		tasDeCarte.getPresentation().setXoffset(0);
		tasDeCarte.getPresentation().setYoffset(30);
		tasDeCarte.empiler(c1);
		tasDeCarte.empiler(c2);
		tasDeCarte.empiler(c3);
		tasDeCarte.empiler(c4);
		try {
			tasDeCarte.depiler();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.getContentPane().add(tasDeCarte.getPresentation());

		frame.setVisible(true);
		frame.setSize(200, 400);
		frame.setLocationRelativeTo(frame.getParent());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
