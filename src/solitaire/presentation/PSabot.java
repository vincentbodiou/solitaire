package solitaire.presentation;

import java.awt.Color;
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
        //---INIT SWING----
        this.reserve = s.getTasCache().getPresentation();
        this.visible = s.getTasVisible().getPresentation();
        add( reserve );
        add( visible );
        reserve.setFond( Toolkit.getDefaultToolkit().createImage(".\\ressources\\reserve.jpg"));
        setVisible( true );
        visible.setXoffset( 30 );
        visible.setLocation( PCarte.largeur + 20, 0 );
        setBackground(new Color(13, 131, 53)); // vert
        
        //---INIT classe parent ---
        controlleur = s;       
        composantContainDragger = this.visible;               
        reserve.addMouseListener( new RetournerCarteSabot() );
        visible.addMouseListener( new DoubleClickCarte() );
        myDragSourceListener = new MyDragSourceListener();
        dragSource = new DragSource();
        dragSource.createDefaultDragGestureRecognizer( visible, DnDConstants.ACTION_MOVE, new MyDragGestureListener() );
        dragSource.addDragSourceMotionListener( new MyDragSourceMotionListener() );

    }
   
    public class DoubleClickCarte extends ClickListener
    {
        @Override
        public void mouseClicked(MouseEvent event)
        {
          if (event.getClickCount() == 2) {             
              PCarte selectedCarte = (PCarte) visible.getComponentAt( event.getX(), event.getY() );
             
              if(selectedCarte != null)
              {
                  controlleur.p2c_callDoubleClickCommand( ((PTasDeCarte)selectedCarte.getParent()).getControleur() );                  
              }
          }
        }
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
