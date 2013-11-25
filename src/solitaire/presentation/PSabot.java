package solitaire.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.event.MouseEvent;

import listener.ClickListener;
import solitaire.DnD.ADnD;
import solitaire.DnD.IControleurDnD;
import solitaire.controleur.CSabot;


public class PSabot extends ADnD
{
    private static final long serialVersionUID = 1L;

    private PTasDeCarte reserve;

    private PTasDeCarte visible;

    public PSabot( CSabot s )
    {
        controlleur = s;
        this.reserve = s.getTasCache().getPresentation();
        this.visible = s.getTasVisible().getPresentation();
        composantContainDragger = this.visible;
        add( reserve );
        add( visible );
        reserve.setFond( Toolkit.getDefaultToolkit().createImage(".\\ressources\\reserve.jpg"));
        setVisible( true );
        //setLayout( null );
        visible.setXoffset( 30 );
        visible.setLocation( PCarte.largeur + 20, 0 );
        
        
        reserve.addMouseListener( new RetournerCarteSabot() );
        myDragSourceListener = new MyDragSourceListener();
        dragSource = new DragSource();
        dragSource.createDefaultDragGestureRecognizer( visible, DnDConstants.ACTION_MOVE, new MyDragGestureListener() );
        dragSource.addDragSourceMotionListener( new MyDragSourceMotionListener() );
        setBackground(new Color(13, 131, 53)); // vert
    }
   
    private class RetournerCarteSabot extends ClickListener
    {
        @Override
        public void mouseClicked( MouseEvent e )
        {
            try
            {
                ((CSabot)controlleur).retournerCarte();
            }
            catch ( Exception e1 )
            {
                e1.printStackTrace();
            }
        }
    } 
    
    public CSabot getControleur()
    {
        return ((CSabot)controlleur);
    }

    public void setControleur( IControleurDnD controleur )
    {
        controlleur = controleur;
    }

    public PTasDeCarte getReserve()
    {
        return reserve;
    }

    public void setReserve( PTasDeCarte reserve )
    {
        this.reserve = reserve;
    }

    public PTasDeCarte getVisible()
    {
        return visible;
    }

    public void setVisible( PTasDeCarte visible )
    {
        this.visible = visible;
    }

   
    
    
}
