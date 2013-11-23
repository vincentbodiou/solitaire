package solitaire.presentation;

//rendu au drag Enter
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;

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
        dropTarget = new DropTarget( this, new MyDropTargetListener() );
        myDragSourceListener = new MyDragSourceListener();
        dragSource = new DragSource();
        dragSource.createDefaultDragGestureRecognizer( tasVisible, DnDConstants.ACTION_MOVE, new MyDragGestureListener() );
        dragSource.addDragSourceMotionListener( new MyDragSourceMotionListener() );
        setPreferredSize( getSize() );
        setSize( getSize() );
        setVisible( true );
        setBackground( Color.red );
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
