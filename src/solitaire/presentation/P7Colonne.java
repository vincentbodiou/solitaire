package solitaire.presentation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import solitaire.usine.*;
import solitaire.controleur.*;

public class P7Colonne extends JPanel
{
    private static final long serialVersionUID = 1L;
    private static int MARGE = 10;

    private static int NB_COLONNE = 7;

    private CColonne[] tab;

    public P7Colonne( CColonne[] tab )
    {
        this.tab = tab;
        setLayout( null );
        GridLayout GridColonnes = new GridLayout( 0, NB_COLONNE );
        setLayout( GridColonnes );

        for ( int i = 0; i < NB_COLONNE; i++ )
        {
            add( tab[i].getPresentation() );
        }
        
        setSize((PCarte.largeur+2*MARGE)*NB_COLONNE, 500);
        setPreferredSize( getSize() );
        setVisible( true );
        setBackground( Color.white );
    }

    public static void main( String args[] )
    {
        JFrame f = new JFrame( "Test P7Colonne" );
        f.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        f.setLayout( new FlowLayout() );
        f.getContentPane().setBackground( new Color( 143, 143, 195 ) );

        CColonne[] colonnes = new CColonne[NB_COLONNE];

        for ( int i = 0; i < NB_COLONNE; i++ )
        {
            CUsine usine = new CUsine();
            CCarte c1 = new CCarte( 13, 2 );
            CCarte c2 = new CCarte( 12, 1 );
            CCarte c3 = new CCarte( 11, 2 );
            CCarte c4 = new CCarte( 10, 1 );

            colonnes[i] = new CColonne( "colonnes", usine );
            CTasDeCarte tas = new CTasDeCarte( "tas", usine );
            tas.empiler( c1 );
            tas.empiler( c2 );
            tas.empiler( c3 );
            tas.empiler( c4 );
            colonnes[i].setReserve( tas );
        }

        f.getContentPane().add( new P7Colonne( colonnes ) );
        try
        {
            colonnes[2].retournerCarte();
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        f.pack(); // dimensionner le cadre
        f.setLocation( 200, 100 ); // le positionner
        f.setVisible( true ); // et le rendre visible
    } // main

}
