package solitaire.controleur;

import javax.swing.JFrame;

import solitaire.application.Carte;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.Usine;
import solitaire.presentation.PTasDeCarte;
import solitaire.presentation.PTasDeCarteAlterne;
import solitaire.usine.CUsine;

public class CTasDeCarteAlterne extends TasDeCartesAlternees
{

    private PTasDeCarteAlterne p;

    public CTasDeCarteAlterne( String nom, Usine usine )
    {
        super( nom, usine );
        p = new PTasDeCarteAlterne( this );
    }

    
    public void empiler( Carte c )
    {        
        super.empiler( c );
        try
        {
            if ( c == getSommet() )
            {
                p.empiler( ( (CCarte) c ).getPresentation() );
            }
        }
        catch ( Exception e )
        {
            System.out.println( "impossible d'empiler" );
        }
    }

    public void depiler() throws Exception
    {
        if ( !isVide() )
        {
            CCarte c = (CCarte) getSommet();
            super.depiler();
            p.depiler( c.getPresentation() );
        }
    }

    public PTasDeCarteAlterne getPresentation()
    {
        return p;
    }

    public static void main( String[] args )
    {
        JFrame frame = new JFrame( "Test CTasDeCarteAlternee" );

        CCarte c1 = new CCarte( 11, 3 );
        CCarte c2 = new CCarte( 10, 2 );
        CCarte c3 = new CCarte( 13, 3 );
        CCarte c4 = new CCarte( 12, 2 );
        c1.setFaceVisible( true );
        c2.setFaceVisible( true );
        c3.setFaceVisible( true );
        c4.setFaceVisible( true );

        CUsine factory = new CUsine();

        CTasDeCarteAlterne tasDeCarte = (CTasDeCarteAlterne) factory.newTasDeCartesAlternees( "tas", factory );
        tasDeCarte.getPresentation().setXoffset( 0 );
        tasDeCarte.getPresentation().setYoffset( 30 );

        tasDeCarte.empiler( c3 );
        tasDeCarte.empiler( c4 );
        tasDeCarte.empiler( c1 );
        tasDeCarte.empiler( c2 );

        try
        {

        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        frame.getContentPane().add( tasDeCarte.getPresentation() );

        frame.setVisible( true );
        frame.setSize( 200, 400 );
        frame.setLocationRelativeTo( frame.getParent() );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

}
