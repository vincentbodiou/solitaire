package solitaire.presentation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;

import javax.swing.JPanel;

import listener.MyDragSourceListener;
import solitaire.application.Colonne;
import solitaire.presentation.PCarte;
import solitaire.application.Usine;
import solitaire.controleur.CCarte;
import solitaire.controleur.CColonne;

public class PColonne extends JPanel
{
    private static final long serialVersionUID = 1L;

    private CColonne controlleur;

    private PTasDeCarteAlterne tasVisible;

    private PTasDeCarte tasCachee;

    private DropTarget dropTarget;

    protected DropTargetDropEvent theFinalEvent;

    public PColonne( CColonne c )
    {
        this.setControlleur( c );
        setLayout( new GridLayout( 0, 1 ) );
        tasVisible = (PTasDeCarteAlterne) controlleur.getTasVisible().getPresentation();
        tasCachee = (PTasDeCarte) controlleur.getTasCachee().getPresentation();
        add( tasCachee );
        add( tasVisible );
        dropTarget = new DropTarget( this, new MyDropTargetListener() );

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
        protected PCarte pCarte = null;

        public void dragEnter( DropTargetDragEvent event )
        {
            getControlleur().getTasVisible().getPresentation().setBackground( Color.blue );
            try
            {
                Transferable transferable = event.getTransferable();
                if ( transferable.isDataFlavorSupported( new DataFlavor( DataFlavor.javaJVMLocalObjectMimeType ) ) )
                {
                    event.acceptDrag( DnDConstants.ACTION_MOVE );
                    pCarte = (PCarte) transferable.getTransferData( new DataFlavor( DataFlavor.javaJVMLocalObjectMimeType ) );
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
            
            //( (ICTourInter) controle ).entreeDnDDrop( (ICAnneauInter) pa.getControle() );
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
           controlleur.finDnDDrop((CCarte)pCarte.getControle());
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
