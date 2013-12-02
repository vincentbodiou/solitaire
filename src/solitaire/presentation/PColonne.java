package solitaire.presentation;

//rendu au drag Enter
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.event.MouseEvent;

import listener.ClickListener;
import solitaire.DnD.ADnD;
import solitaire.controleur.CColonne;

public class PColonne extends ADnD
{
    private static final long serialVersionUID = 1L;

    private PTasDeCarteAlterne tasVisible;

    private PTasDeCarte tasCachee;

    public PColonne( CColonne c )
    {
        controlleur = c;
        
        setLayout( new GridLayout( 0, 1 ) );
        tasVisible = (PTasDeCarteAlterne) ( (CColonne) controlleur ).getTasVisible().getPresentation();
        tasCachee = (PTasDeCarte) ( (CColonne) controlleur ).getTasCachee().getPresentation();
        composantContainDragger = tasVisible;
        add( tasCachee );
        add( tasVisible );
        tasCachee.setBackground(new Color(13, 131, 53)); // vert
        tasVisible.setBackground(new Color(13, 131, 53)); // vert
        dropTarget = new DropTarget( this, new MyDropTargetListener() );
        myDragSourceListener = new MyDragSourceListener();
        dragSource = new DragSource();
        dragSource.createDefaultDragGestureRecognizer( tasVisible, DnDConstants.ACTION_MOVE, new MyDragGestureListener() );
        dragSource.addDragSourceMotionListener( new MyDragSourceMotionListener() );
        setPreferredSize( getSize() );
        setSize( getSize() );
        setVisible( true );
        setBackground(new Color(13, 131, 53)); // vert
        tasCachee.addMouseListener( new RetournerCarteColonne() );
        tasCachee.setFond( Toolkit.getDefaultToolkit().createImage(".\\ressources\\cartevide.png"));
        tasVisible.addMouseListener( new DoubleClickCarte() );
    }
    
    public class DoubleClickCarte extends ClickListener
    {
        @Override
        public void mouseClicked(MouseEvent event)
        {
          if (event.getClickCount() == 2) {             
              PCarte selectedCarte = (PCarte) tasVisible.getComponentAt( event.getX(), event.getY() );
             
              if(selectedCarte != null)
              {
                  controlleur.callDoubleClickCommand( ((PTasDeCarteAlterne)selectedCarte.getParent()).getControleur() );                  
              }
          }
        }
    } 
    
    
    private class RetournerCarteColonne extends ClickListener
    {
        @Override
        public void mouseClicked( MouseEvent e )
        {
            try
            {
                ((CColonne)controlleur).retournerCarte();
                repaint();
                
            }
            catch ( Exception e1 )
            {
                e1.printStackTrace();
            }
        }
    }     

    public CColonne getControlleur()
    {
        return (CColonne) controlleur;
    }

    public void setControlleur( CColonne controlleur )
    {
        this.controlleur = controlleur;
    }

    public PTasDeCarteAlterne getTasVisible()
    {
        return tasVisible;
    }

    public void setTasVisible( PTasDeCarteAlterne tasVisible )
    {
        this.tasVisible = tasVisible;
    }

    public PTasDeCarte getTasCachee()
    {
        return tasCachee;
    }

    public void setTasCachee( PTasDeCarte tasCachee )
    {
        this.tasCachee = tasCachee;
    }

    

}
