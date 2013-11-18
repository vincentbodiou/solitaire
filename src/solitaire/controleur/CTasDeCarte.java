package solitaire.controleur;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import solitaire.application.Carte;
import solitaire.application.TasDeCartes;
import solitaire.application.Usine;
import solitaire.presentation.PTasDeCarte;
import solitaire.usine.CUsine;

public class CTasDeCarte extends TasDeCartes
{

    private PTasDeCarte p;

    public CTasDeCarte( String nom, Usine usine )
    {
        super( nom, usine );
        p = new PTasDeCarte( nom, usine, this );

    }

    public void empiler( Carte c )
    {
        System.out.println( "empiler CTasDeCarte" );
        if ( isEmpilable( c ) )
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
    }

    public void depiler() throws Exception
    {
        System.out.println( "depiler CTasDeCarte" );
        if ( !isVide() )
        {
            CCarte c = (CCarte) getSommet();
            super.depiler();
            p.depiler( c.getPresentation() );
        }
    }

    public PTasDeCarte getPresentation()
    {
        return p;
    }

    public static void main( String[] args )
    {
        JFrame frame = new JFrame( "Test CTasDeCarte" );

        CCarte c1 = new CCarte( 1, 1 );
        CCarte c2 = new CCarte( 11, 1 );
        CCarte c3 = new CCarte( 13, 1 );
        CCarte c4 = new CCarte( 12, 3 );
        c1.setFaceVisible( true );
        c2.setFaceVisible( true );
        c3.setFaceVisible( true );
        c4.setFaceVisible( true );

        CUsine factory = new CUsine();

        CTasDeCarte tasDeCarte = (CTasDeCarte) factory.newTasDeCartes( "tas", factory );
        tasDeCarte.getPresentation().setXoffset( 30 );
        tasDeCarte.getPresentation().setYoffset( 0 );
        tasDeCarte.empiler( c1 );
        tasDeCarte.empiler( c2 );
//        tasDeCarte.empiler(c3);
//        tasDeCarte.empiler(c4);
        try
        {
           
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Dimension d = tasDeCarte.getPresentation().getSize();
        frame.getContentPane().add( tasDeCarte.getPresentation() );
        frame.setSize( d );
        frame.pack () ;      // dimensionner le cadre
        frame.setLocation(200,100); // le positionner
        
        frame.setVisible (true) ;   // et le rendre visible

    }
}
