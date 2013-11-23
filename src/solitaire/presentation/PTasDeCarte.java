package solitaire.presentation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.border.Border;

import solitaire.application.TasDeCartes;
import solitaire.application.Usine;
import solitaire.controleur.CTasDeCarte;

public class PTasDeCarte extends JPanel implements Transferable
{

    private static final long serialVersionUID = 1L;

    private CTasDeCarte controleur;

    private int Xoffset;

    private int Yoffset;

    public PTasDeCarte( String nom, Usine usine, CTasDeCarte cTasDeCarte )
    {
        super();
        this.controleur = cTasDeCarte;
        setLayout( null );
        setBackground( Color.green );
    }

    public void c2p_isNotEmpilable()
    {
        setBackground( Color.red );
    }

    public void c2p_isEmpilable()
    {
        setBackground( Color.yellow );
        
    }
    public void empiler( PCarte pCard )
    {
        System.out.println( "empiler de PTasDeCarte" );
        int nbCard = getNbCard();

        int xOffset = getXoffset();
        int yOffset = getYoffset();

        add( pCard, 0 );
        pCard.setLocation( ( nbCard - 1 ) * xOffset, ( ( nbCard - 1 ) * yOffset ) );

        rafraichir();
    }

    private void rafraichir()
    {
        int nbCarte = controleur.getNombre();
        int x = PCarte.largeur + ( Xoffset * ( nbCarte - 1 ) );
        int y = PCarte.hauteur + ( Yoffset * ( nbCarte - 1 ) );
        System.out.println( "x = " + x + " y =" + y );

        setSize( x, y );
        setPreferredSize( getSize() );

        repaint();
    }

    public void depiler( PCarte c )
    {
        System.out.println( "depiler de PTasDeCarte" );
        remove( c );
        rafraichir();
    }

    private int getNbCard()
    {
        return controleur.getNombre();
    }

    public CTasDeCarte getControleur()
    {
        return controleur;
    }

    public void setControleur( CTasDeCarte controleur )
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

    @Override
    public Object getTransferData( DataFlavor flavor ) throws UnsupportedFlavorException, IOException
    {
        Object result = null;
        if (flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType)) {
            result = this;
        }
        return (result);
    }

    @Override
    public DataFlavor[] getTransferDataFlavors()
    {
        DataFlavor data[] = new DataFlavor[1];
        try {
            data[0] = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType);
        } catch (java.lang.ClassNotFoundException e) {
        }
        return (data);
    }

    @Override
    public boolean isDataFlavorSupported( DataFlavor flavor )
    {
        boolean result = false;
        if (flavor.isMimeTypeEqual(DataFlavor.javaJVMLocalObjectMimeType)) {
            result = true;
        }
        return (result);
    }

   

}
