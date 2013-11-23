package solitaire.presentation;

//rendu au drag Enter
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DragSourceMotionListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import listener.MyDragSourceListener;
import solitaire.application.Colonne;
import solitaire.presentation.PCarte;
import solitaire.presentation.PSabot.SabotDragGestureListener;
import solitaire.presentation.PSabot.SabotDragSourceListener;
import solitaire.presentation.PSabot.SabotDragSourceMotionListener;
import solitaire.application.Usine;
import solitaire.controleur.CCarte;
import solitaire.controleur.CColonne;
import solitaire.controleur.CTasDeCarte;
import solitaire.controleur.CTasDeCarteAlterne;

public class PColonne extends JPanel
{
    private static final long serialVersionUID = 1L;

    private CColonne controlleur;

    private PTasDeCarteAlterne tasVisible;

    private PTasDeCarte tasCachee;

    private DropTarget dropTarget;

    protected DropTargetDropEvent theFinalEvent;

    protected DragSource dragSource = null;

    protected ColonneDragSourceListener myDragSourceListener = null;

    protected DragGestureEvent theInitialEvent = null;

    private PCarte selected;

    private CCarte selectedControl;

    private Point dragOrigin = null;

    private PTasDeCarte Tastemporaire;

    private JFrame dragFrame = null;

    protected class ColonneDragSourceMotionListener implements DragSourceMotionListener
    {

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

    public class ColonneDragSourceListener extends MyDragSourceListener
    {
        @Override
        public void dragDropEnd( DragSourceDropEvent event )
        {
            controlleur.p2c_finDnDDrag( Tastemporaire.getControleur(), event.getDropSuccess() );
            dragFrame.setVisible( false );
            repaint();
        }
    }

    protected class ColonneDragGestureListener implements DragGestureListener
    {

        @Override
        public void dragGestureRecognized( DragGestureEvent dge )
        {
            selected = null;
            selectedControl = null;
            theInitialEvent = dge;
            dragOrigin = dge.getDragOrigin();
            try
            {
                selected = (PCarte) tasVisible.getComponentAt( dragOrigin );
                selectedControl = selected.getControleur();
                System.out.println( "LALALALAL" );
                // System.out.println(selectedControl.getNombre() + " point " +
                // dragOrigin);
            }
            catch ( Exception e )
            {
                e.printStackTrace();
            }
            controlleur.p2c_debutDnDDrag( selectedControl );
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
        // TODO Auto-generated method stub

    }

    public PColonne( CColonne c )
    {
        this.setControlleur( c );
        setLayout( new GridLayout( 0, 1 ) );
        tasVisible = (PTasDeCarteAlterne) controlleur.getTasVisible().getPresentation();
        tasCachee = (PTasDeCarte) controlleur.getTasCachee().getPresentation();
        add( tasCachee );
        add( tasVisible );
        dropTarget = new DropTarget( this, new MyDropTargetListener() );
        myDragSourceListener = new ColonneDragSourceListener();
        dragSource = new DragSource();
        dragSource.createDefaultDragGestureRecognizer( tasVisible, DnDConstants.ACTION_MOVE, new ColonneDragGestureListener() );
        dragSource.addDragSourceMotionListener( new ColonneDragSourceMotionListener() );
        setPreferredSize( getSize() );
        setSize( getSize() );
        setVisible( true );
        setBackground( Color.red );
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

    private class MyDropTargetListener implements DropTargetListener
    {
        protected PTasDeCarte pTas = null;

        public void dragEnter( DropTargetDragEvent event )
        {
            getControlleur().getTasVisible().getPresentation().setBackground( Color.blue );
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
            catch ( java.io.IOException exception )
            {
            }
            catch ( UnsupportedFlavorException ufException )
            {
            }
            catch ( java.lang.ClassNotFoundException e )
            {
            }

            // ( (ICTourInter) controle ).entreeDnDDrop( (ICAnneauInter)
            // pa.getControle() );
        }

        @Override
        public void dragExit( DropTargetEvent dte )
        {
        }

        @Override
        public void dragOver( DropTargetDragEvent dtde )
        {
        }

        @Override
        public void drop( DropTargetDropEvent dtde )
        {
            theFinalEvent = dtde;
            controlleur.finDnDDrop( (CTasDeCarte) pTas.getControleur() );
        }

        @Override
        public void dropActionChanged( DropTargetDragEvent dtde )
        {
            // TODO Auto-generated method stub

        }
    }

    public CColonne getControlleur()
    {
        return controlleur;
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
