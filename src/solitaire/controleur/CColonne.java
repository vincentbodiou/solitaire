package solitaire.controleur;

import javax.swing.JFrame;

import solitaire.application.Colonne;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.Usine;
import solitaire.presentation.PColonne;
import solitaire.usine.CUsine;

public class CColonne extends Colonne {

	private CTasDeCarteAlterne tasVisible;
	private CTasDeCarte tasCachee;
	private PColonne p;
	
	public CColonne(String nom, Usine usine) {
		super(nom, usine);
		this.tasCachee =  (CTasDeCarte) cachees;
        
		this.tasVisible = (CTasDeCarteAlterne) visibles;
		//p = new PColonne( this );		
	}

    public CTasDeCarteAlterne getTasVisible()
    {
        return tasVisible;
    }

    public void setTasVisible( CTasDeCarteAlterne tasVisible )
    {
        this.tasVisible = tasVisible;
    }

    public CTasDeCarte getTasCachee()
    {
        return tasCachee;
    }

    public void setTasCachee( CTasDeCarte tasCachee )
    {
        this.tasCachee = tasCachee;
    }
    
    private PColonne getPresentation()
    {
        return p;
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test CColonne");
        CUsine usine = new CUsine();
        CCarte c1 = new CCarte(2, 1);
        CCarte c2 = new CCarte(3, 2);
        CCarte c3 = new CCarte(4, 2);
        CCarte c4 = new CCarte(5, 1);
        
        
       CColonne c = new CColonne("colonne", usine);
        /*CTasDeCarte tas = new CTasDeCarte("tas", usine);
        tas.empiler(c1);
        tas.empiler(c2);
        tas.empiler(c3);
        tas.empiler(c4);
        c.setReserve(tas);*/
        
        try {
            //c.retournerCarte();     
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        frame.getContentPane().add(c.getPresentation());

        frame.setVisible(true);
        frame.setSize(200, 400);
        frame.setLocationRelativeTo(frame.getParent());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }   

}
