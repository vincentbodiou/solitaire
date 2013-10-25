package presentation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

@SuppressWarnings( "serial" )
public class P4CarteColoree extends JPanel
{
    private static int NB_TASDECARTES = 4;

    private int HAUTEUR = 100;

    private final static int LARGEUR = 800;

    private List<PTasDeCarte> lTasDeCartes;

    public P4CarteColoree( List<PTasDeCarte> lTasDeCartes )
    {
        this.lTasDeCartes = lTasDeCartes;
        int i = 0;
        setLayout( null );
        GridLayout GridColonnes = new GridLayout( 0, NB_TASDECARTES );
        setLayout( GridColonnes );

        Iterator<PTasDeCarte> it = lTasDeCartes.iterator();

        while ( it.hasNext() && i < NB_TASDECARTES )
        {
            PTasDeCarte tasDeCarte = it.next();
            add( tasDeCarte );
            i++;
        }

        setSize( LARGEUR, HAUTEUR );
        setPreferredSize( getSize() );
        setVisible( true );
        setBackground( Color.white );

    }

    /**
     * programme de test : à déplacer dans une classe dédiée aux tests
     * 
     * @param args
     */
    public static void main( String args[] )
    {
        int nb_tas = 4;

        JFrame f = new JFrame( "Test P4TasColoree" );
        f.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        f.setLayout( new FlowLayout() ); // au lieu de BorderLayout par défaut
        f.getContentPane().setBackground( new Color( 143, 143, 195 ) ); // violet
                                                                        // //
                                                                        // pâle

        List<PTasDeCarte> lTas = new ArrayList<>( nb_tas );

        PTasDeCarte tasPique;
        PTasDeCarte tasCoeur;
        PTasDeCarte tasCarreau;
        PTasDeCarte tasTrefle;

        // PIQUE
        tasPique = new PTasDeCarte( Decalage.SANS_DECALAGE );
        tasPique.setVisible( true );

        PCarte cartePique1 = new PCarte( "2S" );
        cartePique1.setFaceVisible( true );
        tasPique.empiler( cartePique1 );

        PCarte cartePique2 = new PCarte( "3S" );
        cartePique2.setFaceVisible( true );
        tasPique.empiler( cartePique2 );

        // Coeur
        tasCoeur = new PTasDeCarte( Decalage.SANS_DECALAGE );
        tasCoeur.setVisible( true );

        PCarte carteCoeur1 = new PCarte( "2H" );
        carteCoeur1.setFaceVisible( true );
        tasCoeur.empiler( carteCoeur1 );

        PCarte carteCoeur2 = new PCarte( "3H" );
        carteCoeur2.setFaceVisible( true );
        tasCoeur.empiler( carteCoeur2 );

        // Carreau
        tasCarreau = new PTasDeCarte( Decalage.SANS_DECALAGE );
        tasCarreau.setVisible( true );

        PCarte carteCarreau1 = new PCarte( "2D" );
        carteCarreau1.setFaceVisible( true );
        tasCarreau.empiler( carteCarreau1 );

        PCarte carteCarreau2 = new PCarte( "3D" );
        carteCarreau2.setFaceVisible( true );
        tasCarreau.empiler( carteCarreau2 );

        // Trefle
        tasTrefle = new PTasDeCarte( Decalage.SANS_DECALAGE );
        tasTrefle.setVisible( true );

        PCarte carteTrefle1 = new PCarte( "2C" );
        carteTrefle1.setFaceVisible( true );
        tasTrefle.empiler( carteTrefle1 );

        PCarte carteTrefle2 = new PCarte( "3C" );
        carteTrefle2.setFaceVisible( true );
        tasTrefle.empiler( carteTrefle2 );

        lTas.add( tasCarreau );
        lTas.add( tasCoeur );
        lTas.add( tasPique );
        lTas.add( tasTrefle );

        P4CarteColoree p4t = new P4CarteColoree( lTas );
        p4t.setVisible( true );
        f.getContentPane().add( p4t );
        f.pack(); // dimensionner le cadre
        f.setLocation( 200, 100 ); // le positionner
        f.setVisible( true ); // et le rendre visible
    } // main
}
