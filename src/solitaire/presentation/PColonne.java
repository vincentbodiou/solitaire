package solitaire.presentation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

import javax.swing.JPanel;

import solitaire.application.Colonne;
import solitaire.presentation.PCarte;
import solitaire.application.Usine;
import solitaire.controleur.CColonne;

public class PColonne extends JPanel implements DragGestureListener, DragSourceListener 
{
    private static final long serialVersionUID = 1L;
    private CColonne controlleur;
    private PTasDeCarteAlterne tasVisible;
    private PTasDeCarte tasCachee;
    private DragSource dragSource;
    private DragGestureEvent initialEvent;
    
    public PColonne( CColonne c )
    {
        this.setControlleur( c );
        setLayout( new GridLayout( 0, 1 ) );
        tasVisible = (PTasDeCarteAlterne) controlleur.getTasVisible().getPresentation();
        tasCachee = (PTasDeCarte) controlleur.getTasCachee().getPresentation();
        add(tasCachee);
        add(tasVisible);
        setPreferredSize( getSize() );
        setSize(getSize());
        setVisible( true );
        setBackground( Color.red );
        dragSource = new DragSource();
        
        dragSource.createDefaultDragGestureRecognizer(
                    this, // component where drag originates
                    DnDConstants.ACTION_COPY_OR_MOVE, // actions
                    new MyDragGestureListener()); // drag gesture recognizer
    }  
    
    protected class MyDragGestureListener implements DragGestureListener {

        @Override
        public void dragGestureRecognized( DragGestureEvent dge )
        {
           //(PCarte) carte = dge.getComponent();
           
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



    @Override
    public void dragGestureRecognized( DragGestureEvent e )
    {
       
    }



    @Override
    public void dragDropEnd( DragSourceDropEvent dsde )
    {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void dragEnter( DragSourceDragEvent dsde )
    {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void dragExit( DragSourceEvent dse )
    {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void dragOver( DragSourceDragEvent dsde )
    {
        // TODO Auto-generated method stub
        
    }



    @Override
    public void dropActionChanged( DragSourceDragEvent dsde )
    {
        // TODO Auto-generated method stub
        
    }

}
