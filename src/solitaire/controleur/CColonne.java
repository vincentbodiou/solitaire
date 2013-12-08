package solitaire.controleur;

import javax.swing.JFrame;

import solitaire.DnD.IControleurDnD;
import solitaire.application.Carte;
import solitaire.application.Colonne;
import solitaire.application.Usine;
import solitaire.command.ICommand;
import solitaire.command.IDoubleClick;
import solitaire.player.Player;
import solitaire.presentation.PColonne;
import solitaire.usine.CUsine;

public class CColonne extends Colonne implements IControleurDnD, IDoubleClick
{
    private static int YOffsetAlt = 30;
    private static int YOffsetCache = 10;
    private static int XOffset = 0;
    private CTasDeCarte tasCachee;
    private CTasDeCarteAlterne tasVisible;
    private PColonne p;
    private ICommand commandDbClic;
    
    public CColonne( String nom, Usine usine )
    {
        super( nom, usine );
        this.tasCachee = (CTasDeCarte) cachees;
        this.tasVisible = (CTasDeCarteAlterne) visibles;
        p = new PColonne( this );
        //je ne trouvai pas ça choquant de "setter" les valeurs de décalage dans le controleur
        p.getTasCachee().setXoffset( XOffset );
        p.getTasCachee().setYoffset( YOffsetCache );
        p.getTasVisible().setXoffset( XOffset );
        p.getTasVisible().setYoffset( YOffsetAlt );
    }

    /*
     * On set la commande associé au double clic
     */
    @Override
    public void setDoubleClickCommand( ICommand cmd )
    {
        commandDbClic = cmd;
    }

    /*
     * la presentation a détecter un double clic sur son tas de carte alterné
     * et le controleur de CColonne récupère la carte au sommet et execute sa commande
     */
    @Override
    public void p2c_callDoubleClickCommand( Object tasDeCarte )
    {       
        if(commandDbClic==null)return;
        
        try
        {
            CTasDeCarteAlterne tas = (CTasDeCarteAlterne)tasDeCarte;
            CCarte c = (CCarte) tas.getSommet();

            if(commandDbClic.execute( c ))
            {
                tasVisible.depiler();
            }
        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }
    
    @Override
    public void retournerCarte() throws Exception
    {
        System.out.println( "retournerCarte de CColonne" );
        if ( isCarteRetournable() )
            super.retournerCarte();
        p.repaint();
    }

    @Override
    public void empiler( Carte c )
    {
        if ( isEmpilable( c ) )
            super.empiler( c );
        else
            System.out.println( "carte non empilable sur ce tas de carte alternee" );
    }

    /*
     * Logique de la colonne quand un DnD commence
     */
    @Override
    public void p2c_debutDnDDrag( CCarte carte )
    {
        CTasDeCarte tmp = new CTasDeCarte( "drag", new CUsine() ); // Tas temporaire dans le mauvais sens
        CTasDeCarte tmp2 = new CTasDeCarte( "drag", new CUsine() ); // Tas ds le bon sens

        //on créer un décalage sinon on ne verrai que la carte au sommet
        tmp2.getPresentation().setYoffset( 20 );
        
        if ( carte != null )
        {
            try
            {
                //on dépile toutes les cartes au dessus de celle selectionné par le DnD
                while ( visibles.getSommet() != carte )
                {
                    Carte tmpCarte = visibles.getSommet();
                    visibles.depiler();
                    tmp.empiler( tmpCarte );
                }
                
                //on dépile cette fois LA carte selectionné par le DnD
                visibles.depiler();
                tmp.empiler( carte );

                // le tas de carte intermediaire (tmp) est dans le mauvais sens donc
                // on le retourne dans un autre tas (tmp2)
                while(!tmp.isVide())
                {
                    Carte c = tmp.getSommet();
                    tmp.depiler();
                    tmp2.empiler( c );
                }                
                
                //on va demander à la présentation de créer une nouvelle frame avec le tas de carte tmp2
                // et on autorise le Drag à s'effectuer
                p.c2p_debutDnDValide( tmp2.getPresentation() );
            }
            catch ( Exception e )
            {
                System.out.println( "empty" );
            }
        }
        else
        {
            p.c2p_debutDnDInvalide();
        }
    }
    
    
    @Override
    public void p2c_finDnD4DragSource( CTasDeCarte tasTemp, boolean dropSuccess )
    {
        //si le drop n'est pas autorisé, alors on rempile le tas de carte en DnD dans le tas de 
        //carte visibles de la colonne
        if(!dropSuccess)
        {          
            Player.playSoundErreur();
            visibles.empiler( tasTemp );
        }            
    }

    //méthode pour la rétro-action lors du survol d'un tas en cours de DND sur la
    @Override
    public void p2c_DragEnter( CTasDeCarte tas )
    {
        //si le tas en DND est empilable, la présentation fait une action montrant qu'il
        //est possible de "drop" dans cette colonne
        if ( isEmpilable( tas ) )
        {
            p.color_isEmpilable();
        }
        else //sinon la présentation fait une action inverse
        {
            System.out.println("iici");
            p.color_isNotEmpilable();
        }
    }
    
    //lorsque le tas de carte en DND sort de la colonne, la colonne remet ses couleurs par défaut
    @Override
    public void p2c_DragExit( CTasDeCarte tas )
    {
       p.color_resetColor();
    }

    
    //le drop est valide => on empile dans le tas de carte visible
    // on signale ensuite la présentation si le drop a réussi
    @Override
    public void p2c_finDnD4DropTarget( CTasDeCarte tas )
    {
        if ( isEmpilable( tas ) )
        {
            empiler( tas );
            p.finDnDValide();
        }
        else
        {
            p.finDnDInvalid();
        }       

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
        frame.setSize( 100, 400 );
        frame.setLocationRelativeTo( frame.getParent() );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

   

   

}
