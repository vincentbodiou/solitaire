package presentation;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

@SuppressWarnings( "serial" )
public class PColonne extends JPanel
{
    private PTasDeCarte tasVisible;
    private PTasDeCarte tasCache;
    private static final int MARGE = 10;
    private static final int HAUTEUR = 400;
    private static int LARGEUR=PCarte.largeur+2*MARGE;
    
    public PColonne( PTasDeCarte tasVisible, PTasDeCarte tasCache  )
    {
        this.setTasVisible( tasVisible );
        this.setTasCache( tasCache );
        setLayout( null );
        
        tasCache.setLocation( MARGE, MARGE );
        tasVisible.setLocation( MARGE , tasCache.getSize().height-(PCarte.hauteur-Decalage.BAS.getDy()));
        
        add(tasCache);
        add(tasVisible,0);
        
        setSize(LARGEUR , HAUTEUR);
        setPreferredSize(getSize());
        
        setBackground(Color.red);
        setVisible(true);
        repaint();
        
    }


    public PTasDeCarte getTasCache()
    {
        return tasCache;
    }


    public void setTasCache( PTasDeCarte tasCache )
    {
        this.tasCache = tasCache;
    }


    public PTasDeCarte getTasVisible()
    {
        return tasVisible;
    }


    public void setTasVisible( PTasDeCarte tasVisible )
    {
        this.tasVisible = tasVisible;
    }

    /**
     * programme de test : à déplacer dans une classe dédiée aux tests
     * 
     * @param args
     */
    public static void main(String args[])
    {
        JFrame f = new JFrame("Test PColonne");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
        f.getContentPane().setBackground(new Color(143, 143, 195)); // violet                                                                   // pâle

        PTasDeCarte tasVisible = new PTasDeCarte(Decalage.BAS);
        tasVisible.setVisible(true);

        // init du tas de carte visible 
        PCarte carteVisible1 = new PCarte("5C");
        carteVisible1.setFaceVisible(true);
        tasVisible.empiler(carteVisible1);

        PCarte carteVisible2 = new PCarte("4D");
        carteVisible2.setFaceVisible(true);
        tasVisible.empiler(carteVisible2);

        PCarte carteVisible3 = new PCarte("3C");
        carteVisible3.setFaceVisible(true);
        tasVisible.empiler(carteVisible3);

        PCarte carteVisible4 = new PCarte("2D");
        carteVisible4.setFaceVisible(true);
        tasVisible.empiler(carteVisible4);

        
        // init du tas de carte de la reserve 
        PTasDeCarte tasCache = new PTasDeCarte(Decalage.BAS);
        tasCache.setVisible(true);

        PCarte carteReserve1 = new PCarte("1C");
        carteReserve1.setFaceVisible(false);
        tasCache.empiler(carteReserve1);

        PCarte carteReserve2 = new PCarte("1C");
        carteReserve2.setFaceVisible(false);
        tasCache.empiler(carteReserve2);

        PCarte carteReserve3 = new PCarte("1D");
        carteReserve3.setFaceVisible(false);
        tasCache.empiler(carteReserve3);
        
        PColonne colonne = new PColonne( tasVisible, tasCache );

        f.getContentPane().add(colonne);
        f.pack(); // dimensionner le cadre
        f.setLocation(200, 100); // le positionner
        f.setVisible(true); // et le rendre visible
    } // main


    public static int getLARGEUR()
    {
        return LARGEUR;
    }

}
