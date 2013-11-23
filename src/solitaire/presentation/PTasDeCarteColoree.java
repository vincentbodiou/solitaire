package solitaire.presentation;

import java.awt.Color;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import javax.swing.JPanel;

import listener.ADragSourceListener;
import solitaire.controleur.*;


public class PTasDeCarteColoree extends JPanel
{
    @SuppressWarnings( "unused" )
    private CTasDeCarteColorees controleur;

    private static final long serialVersionUID = 1L;

    private int Xoffset;

    private int Yoffset;
    
    private DragSource dragSource = null;

    private ColorDragSourceListener myDragSourceListener = null;
    
    private DragGestureEvent theInitialEvent;

    private DropTargetDropEvent theFinalEvent;

    private DropTarget dropTarget = null;

    private PCarte selected;

    private CCarte selectedControl;

    private Point DragOrigin;

    class ColorDragGestureListener implements DragGestureListener
    {

        @Override
        public void dragGestureRecognized( DragGestureEvent evt )
        {
            selected = null;
            selectedControl = null;
            theInitialEvent = evt;
            DragOrigin = evt.getDragOrigin();
            try
            {
                selected = (PCarte) getComponentAt( DragOrigin );
                selectedControl = selected.getControleur();
            }
            catch ( Exception e )
            {
            }
            controleur.debutDnDDrag( selectedControl );
        }
    }

    class ColorDragSourceListener extends ADragSourceListener
    {
        @Override
        public void dragDropEnd( DragSourceDropEvent evt )
        {
            controleur.p2c_finDnDDrag( selectedControl, evt.getDropSuccess() );
            repaint();
        }
    }

    class ColorDropTargetListener implements DropTargetListener
    {
        protected PTasDeCarte pTas = null;

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
                        controleur.p2c_DragEnter( pTas.getControleur() );
                    }
                }
                catch ( java.io.IOException exception )
                {
                }
                catch ( UnsupportedFlavorException ufException )
                {
                }
                catch ( java.lang.ClassNotFoundException e )
                {
                }
            }

            @Override
            public void dragExit( DropTargetEvent dte )
            {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void dragOver( DropTargetDragEvent dtde )
            {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void drop( DropTargetDropEvent dtde )
            {
                theFinalEvent = dtde;
                controleur.finDnDDrop( (CTasDeCarte) pTas.getControleur() );
            }


            @Override
            public void dropActionChanged( DropTargetDragEvent dtde )
            {
                // TODO Auto-generated method stub
                
            }
    }

    public PTasDeCarteColoree( CTasDeCarteColorees c )
    {
        super();
        this.controleur = c;
        setLayout( null );
        
        myDragSourceListener = new ColorDragSourceListener();
        dragSource = new DragSource();
        dragSource.createDefaultDragGestureRecognizer( this, DnDConstants.ACTION_MOVE, new ColorDragGestureListener() );
        dropTarget = new DropTarget(this, new ColorDropTargetListener());
        
        
        setSize( PCarte.largeur, PCarte.hauteur );
        setPreferredSize( getSize() );
        setBackground( Color.red );
    }

    public void empiler( PCarte pCard )
    {
        System.out.println( "empiler de PTasDeCarteColoree" );
        int nbCard = getNbCard();

        int xOffset = getXoffset();
        int yOffset = getYoffset();

        add( pCard, 0 );
        pCard.setLocation( ( nbCard - 1 ) * xOffset, ( ( nbCard - 1 ) * yOffset ) );

        rafraichir();
    }

    private void rafraichir()
    {
        repaint();
    }

    public void depiler( PCarte c )
    {
        System.out.println( "depiler de PTasDeCarteAlterne" );
        remove( c );
        rafraichir();
    }

    private int getNbCard()
    {
        return controleur.getNombre();
    }

    public CTasDeCarteColorees getControleur()
    {
        return controleur;
    }

    public void setControleur( CTasDeCarteColorees controleur )
    {
        this.controleur = controleur;
    }

    public int getXoffset()
    {
        return Xoffset;
    }

    public void setXoffset( int xoffset )
    {
        Xoffset = xoffset;
    }

    public int getYoffset()
    {
        return Yoffset;
    }

    public void setYoffset( int yoffset )
    {
        Yoffset = yoffset;
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
