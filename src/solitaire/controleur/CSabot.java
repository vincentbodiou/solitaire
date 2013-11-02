package solitaire.controleur;

import javax.swing.JFrame;

import solitaire.application.Sabot;
import solitaire.application.Usine;
import solitaire.presentation.PSabot;
import solitaire.usine.CUsine;

public class CSabot extends Sabot {

	private CTasDeCarte tasVisible;
	private CTasDeCarte tasCache;
	private PSabot p;
	private static int XOffset=30;

	public CSabot(String nom, Usine usine) {
		super(nom, usine);
		this.tasCache =  (CTasDeCarte) cachees;
		this.tasVisible = (CTasDeCarte) visibles;
		
		p = new PSabot(this);
		tasVisible.getPresentation().setXoffset(XOffset);
	}

	public void retournerCarte() throws Exception
	{
	    System.out.println("retournerCarte de Csabot");
		if(!isRetournable())
			super.retournerCarte();
		else
			super.retourner();		
	}
	
	public void retourner() throws Exception
	{
		if(isRetournable())
			super.retourner();
	}
	
	public CTasDeCarte getTasVisible() {
		return tasVisible;
	}

	public void setTasVisible(CTasDeCarte tasVisible) {
		this.tasVisible = tasVisible;
	}

	public CTasDeCarte getTasCache() {
		return tasCache;
	}

	public void setTasCache(CTasDeCarte tasCache) {
		this.tasCache = tasCache;
	}

	public PSabot getP() {
		return p;
	}

	public void setP(PSabot p) {
		this.p = p;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Test CSabot");
		CUsine usine = new CUsine();
		CCarte c1 = new CCarte(2, 1);
		CCarte c2 = new CCarte(3, 2);
		CCarte c3 = new CCarte(4, 2);
		CCarte c4 = new CCarte(5, 1);
		
		
		CSabot sabot = new CSabot("sabot", usine);
		CTasDeCarte tas = new CTasDeCarte("tas", usine);
		tas.empiler(c1);
		tas.empiler(c2);
		tas.empiler(c3);
		tas.empiler(c4);
		
		sabot.setReserve(tas);
		try {
			sabot.retournerCarte();		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.getContentPane().add(sabot.getPresentation());

		frame.setVisible(true);
		frame.setSize(200, 400);
		frame.setLocationRelativeTo(frame.getParent());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	private PSabot getPresentation() {
		return p;
	}
}