package solitaire.presentation;

import java.awt.Color;

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
        setLayout( null );
        tasVisible = (PTasDeCarteAlterne) controlleur.getTasVisible().getPresentation();
        tasCachee = (PTasDeCarte) controlleur.getTasCachee().getPresentation();
        add(tasVisible);
        add(tasCachee);
        setSize( PCarte.largeur, PCarte.hauteur );
        setPreferredSize( getSize() );
        
        setBackground( Color.yellow );
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
