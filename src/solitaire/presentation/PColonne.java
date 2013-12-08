package solitaire.presentation;

//rendu au drag Enter
import java.awt.BorderLayout;
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
        
        //----INIT SWING----/
        setLayout( new BorderLayout( 0, 1 ) );
        tasVisible = (PTasDeCarteAlterne) c.getTasVisible().getPresentation();
        tasCachee = (PTasDeCarte) c.getTasCachee().getPresentation();
        add( tasCachee, BorderLayout.NORTH );
        add( tasVisible, BorderLayout.CENTER );
        tasCachee.setBackground(new Color(13, 131, 53)); // vert
        tasVisible.setBackground(new Color(13, 131, 53)); // vert       
        setPreferredSize( getSize() );
        setSize( getSize() );
        setVisible( true );
        setBackground(new Color(13, 131, 53)); // vert
        
        //----INIT Classe parent de DnD----/
        controlleur = c;
        composantContainDragger = tasVisible;     
        dropTarget = new DropTarget( this, new MyDropTargetListener() );
        myDragSourceListener = new MyDragSourceListener();
        dragSource = new DragSource();
        dragSource.createDefaultDragGestureRecognizer( tasVisible, DnDConstants.ACTION_MOVE, new MyDragGestureListener() );
        dragSource.addDragSourceMotionListener( new MyDragSourceMotionListener() );        
        tasCachee.addMouseListener( new RetournerCarteColonne() );
        tasCachee.setFond( Toolkit.getDefaultToolkit().createImage(".\\ressources\\cartevide.png"));
        tasVisible.addMouseListener( new DoubleClickCarte() );

        
    }
    
    
    //on signale au controleur CColonne que l'on a un double clic sur le tas visible
    public class DoubleClickCarte extends ClickListener
    {
        @Override
        public void mouseClicked(MouseEvent event)
        {
          if (event.getClickCount() == 2) {             
              PCarte selectedCarte = (PCarte) tasVisible.getComponentAt( event.getX(), event.getY() );
             
              if(selectedCarte != null)
              {
                  controlleur.p2c_callDoubleClickCommand( ((PTasDeCarteAlterne)selectedCarte.getParent()).getControleur() );                  
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
