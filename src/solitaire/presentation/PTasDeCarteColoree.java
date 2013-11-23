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
import solitaire.DnD.ADnD;
import solitaire.controleur.*;


public class PTasDeCarteColoree extends ADnD
{
    private static final long serialVersionUID = 1L;

    private int Xoffset;

    private int Yoffset;
    
    

    
   


    public PTasDeCarteColoree( CTasDeCarteColorees c )
    {
        super();
        this.controlleur = c;
        setLayout( null );
        
        myDragSourceListener = new MyDragSourceListener();
        dragSource = new DragSource();
        dragSource.createDefaultDragGestureRecognizer( this, DnDConstants.ACTION_MOVE, new MyDragGestureListener() );
        dropTarget = new DropTarget(this, new MyDropTargetListener());
        
        
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
        return ((CTasDeCarteColorees)controlleur).getNombre();
    }

    public CTasDeCarteColorees getControleur()
    {
        return ((CTasDeCarteColorees)controlleur);
    }

    public void setControleur( CTasDeCarteColorees controleur )
    {
        this.controlleur = controleur;
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
   

}
