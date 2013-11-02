package solitaire.controleur;

import java.io.ObjectInputStream.GetField;

import javax.swing.JFrame;
import javax.tools.JavaCompiler.CompilationTask;

import solitaire.application.Colonne;
import solitaire.application.TasDeCartesAlternees;
import solitaire.application.Usine;
import solitaire.presentation.PColonne;
import solitaire.usine.CUsine;

public class CColonne extends Colonne
{

    private static int YOffsetAlt = 30;
    private static int YOffsetCache = 10;
    private static int XOffset = 0;

    private CTasDeCarte tasCachee;

    private CTasDeCarteAlterne tasVisible;

    private PColonne p;

    public CColonne( String nom, Usine usine )
    {
        super( nom, usine );
        this.tasCachee = (CTasDeCarte) cachees;
        this.tasVisible = (CTasDeCarteAlterne) visibles;
        p = new PColonne( this );
        p.getTasCachee().setXoffset( XOffset );
        p.getTasCachee().setYoffset( YOffsetCache );
        p.getTasVisible().setXoffset( XOffset );
        p.getTasVisible().setYoffset( YOffsetAlt );
    }

    public void retournerCarte() throws Exception
    {
        System.out.println( "retournerCarte de CColonne" );
        if ( isCarteRetournable() )
            super.retournerCarte();
    }

    public void empiler(CCarte c)
    {
        if(isEmpilable( c ))
            super.empiler( c );
        else
            System.out.println("carte non empilable sur ce tas de carte alternee");
    }
    
    public void empiler(CTasDeCarte t)
    {
        if(isEmpilable( t ))
            super.empiler( t );
        else
            System.out.println("tas non empilable sur ce tas de carte alternee");
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

    public PColonne getPresentation()
    {
        return p;
    }

    public static void main( String[] args )
    {
        JFrame frame = new JFrame( "Test CColonne" );
        CUsine usine = new CUsine();
        CCarte c1 = new CCarte( 13, 2 );
        CCarte c2 = new CCarte( 12, 1 );
        CCarte c3 = new CCarte( 11, 2 );
        CCarte c4 = new CCarte( 10, 1 );

        CColonne c = new CColonne( "colonne", usine );
        CTasDeCarte tas = new CTasDeCarte( "tas", usine );
        tas.empiler( c1 );
        tas.empiler( c2 );
        tas.empiler( c3 );
        tas.empiler( c4 );

        c.setReserve( tas );

        try
        {            
            c.retournerCarte();
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        frame.getContentPane().add( c.getPresentation() );

        frame.setVisible( true );
        frame.setSize( 100,400);
        frame.setLocationRelativeTo( frame.getParent() );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

}
