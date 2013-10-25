package presentation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

@SuppressWarnings( "serial" )
public class P7Colonne extends JPanel
{
    private List<PColonne> colonnes;

    private final static int MARGE = 10;

    public P7Colonne( List<PColonne> colonnes )
    {
        int i = 0;
        setLayout( null );
        GridLayout GridColonnes = new GridLayout(0,7);
        setLayout( GridColonnes );
        this.colonnes = colonnes;
        Iterator<PColonne> it = colonnes.iterator();

        while ( it.hasNext() && i < 7 )
        {
            PColonne colonne = it.next();
            add( colonne );
            i++;
        }
        
        setSize(800,200);
        setPreferredSize(getSize());
        setVisible(true);
        setBackground(Color.white);       
    }
    
    /**
     * programme de test : � d�placer dans une classe d�di�e aux tests
     * 
     * @param args
     */
    public static void main(String args[])
    {
        JFrame f = new JFrame("Test P7Colonne");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout()); // au lieu de BorderLayout par d�faut
        f.getContentPane().setBackground(new Color(143, 143, 195)); // violet                                                                   // p�le

        List<PColonne> colonnes = new ArrayList<>( 7 );
        
        PTasDeCarte tasVisible;
        PTasDeCarte tasCache;
        
        for(int i =0; i<7 ;i++ )
        {
            tasVisible = new PTasDeCarte(Decalage.BAS);
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
            tasCache = new PTasDeCarte(Decalage.BAS);
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
            
            colonnes.add(new PColonne( tasVisible, tasCache ));
        }
        
        P7Colonne p7c = new P7Colonne( colonnes );
        p7c.setVisible( true );
        f.getContentPane().add(p7c);
        f.pack(); // dimensionner le cadre
        f.setLocation(200, 100); // le positionner
        f.setVisible(true); // et le rendre visible
    } // main
}
