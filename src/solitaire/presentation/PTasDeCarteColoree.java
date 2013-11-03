package solitaire.presentation;

import java.awt.Color;

import javax.swing.JPanel;

import solitaire.controleur.*;

public class PTasDeCarteColoree extends JPanel
{
    @SuppressWarnings( "unused" )
    private CTasDeCarteColorees controleur;

    private static final long serialVersionUID = 1L;

    private int Xoffset;

    private int Yoffset;

    public PTasDeCarteColoree( CTasDeCarteColorees c )
    {
        super();
        this.controleur = c;
        setLayout( null );
        setSize( PCarte.largeur, PCarte.hauteur );
        setPreferredSize( getSize() );
        setBackground( Color.green );
    }

    public void empiler( PCarte pCard )
    {
        System.out.println( "empiler de PTasDeCarteAlterne" );
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

}
