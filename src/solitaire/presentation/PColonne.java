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

import listener.ADragSourceListener;
import listener.ADropTargetListener;
import solitaire.Apresentation.ADnD;
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
