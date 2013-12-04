package solitaire.controleur;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import solitaire.DnD.IControleurDnD;
import solitaire.application.Carte;
import solitaire.application.TasDeCartesColorees;
import solitaire.application.Usine;
import solitaire.observer.Observable;
import solitaire.observer.Observer;
import solitaire.presentation.PTasDeCarteColoree;
import solitaire.usine.CUsine;

public class CTasDeCarteColorees extends TasDeCartesColorees implements IControleurDnD, Observable
{
    private PTasDeCarteColoree p;
   
    private CTasDeCarte tas;
    private List<Observer> listObserver;

    public CTasDeCarteColorees( String nom, int couleur, Usine usine )
    {
        super( nom, couleur, usine );
        listObserver = new ArrayList<Observer>();
        p = new PTasDeCarteColoree( this );
    }

    public void empiler( Carte c )
    {       
        if ( isEmpilable( c ) )
        {
            super.empiler( c );
            p.empiler( ( (CCarte) c ).getPresentation() );
            notifyObservers();
        }
        else
            System.out.println("impossible d'empiler sur le tas de carte coloree");
    }
    
    public void registerObserver(Observer observer)
    {
        listObserver.add( observer );
    }
    
    @Override
    public void p2c_callDoubleClickCommand( Object carte )
    {// rien car la carte est déjà à sa place finale
    }
   
    
    public int getCouleur()
    {
        return couleur;
    }
    
    public PTasDeCarteColoree getPresentation()
    {
        return p;
    }

    public void setP( PTasDeCarteColoree p )
    {
        this.p = p;
    }

    public CTasDeCarte getTas()
    {
        return tas;
    }

    public void setTas( CTasDeCarte tas )
    {
        this.tas = tas;
    }
    
    public static void main( String[] args )
    {
        JFrame frame = new JFrame( "Test CTasDeCarteColoree" );

        CCarte c1 = new CCarte( 1, 2 );
        CCarte c2 = new CCarte( 2, 2 );
        CCarte c3 = new CCarte( 13, 3 );
        CCarte c4 = new CCarte( 12, 2 );
        c1.setFaceVisible( true );
        c2.setFaceVisible( true );
        c3.setFaceVisible( true );
        c4.setFaceVisible( true );

        CUsine factory = new CUsine();
        CTasDeCarteColorees tasColoree = new CTasDeCarteColorees( "pique", 2, factory );

        try
        {
            tasColoree.empiler( c1 );
            tasColoree.empiler( c2 );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
        frame.getContentPane().add( tasColoree.getPresentation() );

        frame.setVisible( true );
        frame.setSize( 200, 400 );
        frame.setLocationRelativeTo( frame.getParent() );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
    @Override
    public void p2c_debutDnDDrag( CCarte carte )
    {
        CTasDeCarte tas = new CTasDeCarte( "temp", new CUsine() );
        if(carte != null)
        {
            try
            {
                if(this.getSommet()==carte)
                {
                    depiler();   
                    tas.empiler( carte );
                    p.c2p_debutDnDValide(tas.getPresentation());
                }
            }
            catch ( Exception e )
            {
                e.printStackTrace();
            }
        } else {
            p.c2p_debutDnDInvalide();            
        }
    }

    @Override
    public void p2c_finDnD4DragSource( CTasDeCarte tas, boolean dropSuccess )
    {
        if(!dropSuccess)
        {              
            empiler( tas );
        }            
    }

    @Override
    public void p2c_DragEnter( CTasDeCarte tas )
    {
        if ( isEmpilable( tas ) )
        {
            tas.getPresentation().c2p_isEmpilable();
        }
        else
            tas.getPresentation().c2p_isNotEmpilable();
    }
    
    @Override
    public void p2c_DragExit( CTasDeCarte tas )
    {
        tas.getPresentation().c2p_resetColor();        
    }

    @Override
    public void p2c_finDnD4DropTarget( CTasDeCarte tas )
    {
        try
        {
            if ( isEmpilable( tas.getSommet() ) )
            {
                empiler( tas );
                p.finDnDValide();
            }
            else
            {
                p.finDnDInvalid();
            }
        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void addObserver( solitaire.observer.Observer o )
    {
       listObserver.add( o );
    }

    @Override
    public void deleteObserver( solitaire.observer.Observer o )
    {
      listObserver.remove( o );
    }

    @Override
    public void notifyObservers()
    {
       for(Observer o : listObserver)
           o.notifie();
    }

  

}
