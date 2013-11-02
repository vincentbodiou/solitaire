package solitaire.presentation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

import solitaire.application.Colonne;
import solitaire.application.Usine;
import solitaire.controleur.CColonne;

public class PColonne extends JPanel
{
    private static final long serialVersionUID = 1L;
    private CColonne controlleur;
    private PTasDeCarteAlterne tasVisible;
    private PTasDeCarte tasCachee;
    
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
