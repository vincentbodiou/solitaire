package solitaire.controleur;

import javax.swing.JFrame;

import solitaire.DnD.IControleurDnD;
import solitaire.application.Sabot;
import solitaire.application.Usine;
import solitaire.command.ICommand;
import solitaire.command.IDoubleClick;
import solitaire.player.Player;
import solitaire.presentation.PSabot;
import solitaire.usine.CUsine;

public class CSabot extends Sabot implements IControleurDnD, IDoubleClick
{
    @SuppressWarnings( "unused" )
    private CSolitaire solitaire;
    
    private CTasDeCarte tasVisible;

    private CTasDeCarte tasCache;

    private PSabot p;

    private static int XOffset = 30;
    
    private ICommand command;

    public CSabot( String nom, Usine usine )
    {
        super( nom, usine );
        this.tasCache = (CTasDeCarte) cachees;
        this.tasVisible = (CTasDeCarte) visibles;

        p = new PSabot( this );
        tasVisible.getPresentation().setXoffset( XOffset );
        
    }

    /*
     * On set la commande associé au double clic
     */
    @Override
    public void setDoubleClickCommand( ICommand cmd )
    {
        command = cmd;
    }

    /*
     * la presentation a détecter un double clic sur son tas de carte visible du sabot
     * donc le controleur de CSabot récupère la carte au sommet et execute sa commande
     */
    @Override
    public void p2c_callDoubleClickCommand( Object tasDeCarte )
    {        
        try
        {
            CTasDeCarte tas = (CTasDeCarte) tasDeCarte;
            CCarte c = (CCarte) tas.getSommet() ;

            if(command.execute( c ))
            {
                tasVisible.depiler();
            }
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }            
    }
    
    public void retournerCarte() throws Exception
    {
        System.out.println( "retournerCarte de Csabot" );
        if ( !isRetournable() )
            super.retournerCarte();
        else
            super.retourner();
        p.repaint();
    }

    public void retourner() throws Exception
    {
        if ( isRetournable() ){
            super.retourner();
            
        }
    }
    
    /*
     * Logique du sabot quand un DnD commence
     */
    @Override
    public void p2c_debutDnDDrag( CCarte carte )
    {
        // on va mettre ds ce tas la carte au sommet du tas visible du sabot
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
        //si le drop n'est pas autorisé, alors on rempile le tas de carte en DnD dans le tas de 
        //carte visibles du sabot
        if(!dropSuccess)
        {
            empiler(tas);
            Player.playSoundErreur();
        }  

    }
    
    /*
     * rien car on est pas sensé survolé le sabot : on pourrait ajouter ici une couleur de background .... 
     */
    @Override
    public void p2c_DragEnter( CTasDeCarte tas )
    {         
    }
    
    /*
     * rien car on est pas sensé survolé le sabot : on pourrait ajouter ici une couleur de background .... 
     */
    @Override
    public void p2c_DragExit( CTasDeCarte controleur )
    {        
    }
    /*
     * rien car on est pas sensé "dropper" dans le sabot : : on pourrait ajouter ici une couleur de background .... 
     */
    @Override
    public void p2c_finDnD4DropTarget( CTasDeCarte tas )
    {        
    }

    public CTasDeCarte getTasVisible()
    {
        return tasVisible;
    }

    public void setTasVisible( CTasDeCarte tasVisible )
    {
        this.tasVisible = tasVisible;
    }

    public CTasDeCarte getTasCache()
    {
        return tasCache;
    }

    public void setTasCache( CTasDeCarte tasCache )
    {
        this.tasCache = tasCache;
    }

    public PSabot getPresentation()
    {
        return p;
    }

    public static void main( String[] args )
    {
        JFrame frame = new JFrame( "Test CSabot" );
        CUsine usine = new CUsine();
        CCarte c1 = new CCarte( 2, 1 );
        CCarte c2 = new CCarte( 3, 2 );
        CCarte c3 = new CCarte( 4, 2 );
        CCarte c4 = new CCarte( 5, 1 );

        CSabot sabot = new CSabot( "sabot", usine );
        CTasDeCarte tas = new CTasDeCarte( "tas", usine );
        tas.empiler( c1 );
        tas.empiler( c2 );
        tas.empiler( c3 );
        tas.empiler( c4 );

        sabot.setReserve( tas );
        try
        {
            sabot.retournerCarte();
            sabot.retournerCarte();

        }
        catch ( Exception e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        frame.getContentPane().add( sabot.getPresentation() );

        frame.setVisible( true );
        frame.setSize( 400, 500 );
        frame.setLocationRelativeTo( frame.getParent() );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    }

   
}
