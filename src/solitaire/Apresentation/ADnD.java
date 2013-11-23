package solitaire.Apresentation;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceMotionListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import listener.ADragSourceListener;
import listener.ADropTargetListener;
import solitaire.controleur.CCarte;
import solitaire.controleur.CTasDeCarte;
import solitaire.presentation.PCarte;
import solitaire.presentation.PTasDeCarte;

public abstract class ADnD extends JPanel
{
    protected DropTarget dropTarget;

    protected DropTargetDropEvent theFinalEvent;

    protected DragSource dragSource = null;

    protected MyDragSourceListener myDragSourceListener = null;

    protected DragGestureEvent theInitialEvent = null;

    protected PCarte selected;

    protected CCarte selectedControl;
    
    protected Point dragOrigin = null;

    protected PTasDeCarte Tastemporaire;

    protected JFrame dragFrame = null;
    
    protected IControleurDnD controlleur;
    
    protected JPanel composantContainDragger;
    
    protected class MyDragGestureListener implements DragGestureListener
    {
        public MyDragGestureListener(){}

        @Override
        public void dragGestureRecognized( DragGestureEvent dge )
        {
            selected = null;
            selectedControl = null;
            theInitialEvent = dge;
            dragOrigin = dge.getDragOrigin();
            try
            {
                selected = (PCarte) composantContainDragger.getComponentAt( dragOrigin );
                selectedControl = selected.getControleur();
            }
            catch ( Exception e )
            {
                e.printStackTrace();
            }
            controlleur.p2c_debutDnDDrag( selectedControl );
        }
    }
    
    protected class MyDragSourceListener extends ADragSourceListener
    {
        public MyDragSourceListener(){}

        @Override
        public void dragDropEnd( DragSourceDropEvent event )
        {
            controlleur.p2c_finDnDDrag( Tastemporaire.getControleur(), event.getDropSuccess() );
            dragFrame.setVisible( false );
            repaint();
        }
        
        @Override
        public void dragEnter( DragSourceDragEvent evt )
        {
            evt.getDragSourceContext().setCursor( new Cursor( Cursor.MOVE_CURSOR ) );
        }
    }
    
    
    protected class MyDragSourceMotionListener implements DragSourceMotionListener
    {

        public MyDragSourceMotionListener(){}       
        

        @Override
        public void dragMouseMoved( DragSourceDragEvent evt )
        {
            int parentX = getRootPane().getParent().getX();
            int parentY = getRootPane().getParent().getY();
            int eventX = evt.getLocation().x + 5;
            int eventY = evt.getLocation().y - 5;
            dragFrame.setLocation( eventX - parentX, eventY - parentY );
            repaint();
        }
    }
    
    protected class MyDropTargetListener extends ADropTargetListener
    {
        protected PTasDeCarte pTas = null;

        public MyDropTargetListener() {     
        }

        @Override
        public void dragEnter( DropTargetDragEvent event )
        {
            try
            {
                Transferable transferable = event.getTransferable();
                if ( transferable.isDataFlavorSupported( new DataFlavor( DataFlavor.javaJVMLocalObjectMimeType ) ) )
                {
                    event.acceptDrag( DnDConstants.ACTION_MOVE );
                    pTas = (PTasDeCarte) transferable.getTransferData( new DataFlavor( DataFlavor.javaJVMLocalObjectMimeType ) );
                    controlleur.p2c_DragEnter( pTas.getControleur() );
                }
            }
            catch ( Exception e)
            {}
        }
        
        @Override
        public void drop( DropTargetDropEvent dtde )
        {
            theFinalEvent = dtde;
            controlleur.finDnDDrop( (CTasDeCarte) pTas.getControleur() );
        }     
    }
    
    public void c2p_debutDnDValide( PTasDeCarte tmp )
    {
        Tastemporaire = tmp;
        dragSource.startDrag( theInitialEvent, DragSource.DefaultMoveNoDrop, tmp, myDragSourceListener );

        dragFrame = new JFrame();

        dragFrame.add( tmp );
        dragFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); // Already
                                                                    // there
        dragFrame.setExtendedState( JFrame.MAXIMIZED_BOTH );
        dragFrame.setUndecorated( true );
        dragFrame.setVisible( true );
        dragFrame.pack();
        repaint();
    }
    
    public void c2p_debutDnDInvalide()
    {
      
    }    
    
    
    public void finDnDValide()
    {
        theFinalEvent.acceptDrop( DnDConstants.ACTION_MOVE );
        theFinalEvent.getDropTargetContext().dropComplete( true );
        repaint();
    }

    public void finDnDInvalid()
    {
        theFinalEvent.rejectDrop();
    }
    
    
}
