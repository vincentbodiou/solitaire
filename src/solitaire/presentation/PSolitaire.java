package solitaire.presentation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import solitaire.controleur.CCarte;
import solitaire.controleur.CSolitaire;
import solitaire.controleur.CTasDeCarteColorees;
import solitaire.usine.CUsine;

public class PSolitaire extends JFrame
{

    private static final long serialVersionUID = 1L;
    private CSolitaire controleur;
      
    public PSolitaire (CSolitaire c)
    {
        controleur = c ;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout( new GridBagLayout() );
        getContentPane().setBackground(new Color(143, 143, 195)); // violet 
        
           
        setVisible( true );
        setSize( 800, 600 );
        setLocationRelativeTo( getParent() );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    public void init()
    {
        P7Colonne p7c = controleur.getColonnes();
        PSabot pSabot = controleur.getcSabot().getPresentation();
        //P7Colonne colonnes = controleur.get
       
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        
        
        pSabot.setMinimumSize( pSabot.getSize() );
        add( pSabot, c );

        c.gridx = 0;
        c.gridy = 1;
        p7c.setMinimumSize( p7c.getMinimumSize() );
        add( p7c, c );
//
//        c.gridx = 1;
//        c.gridy = 0;
//        c.gridheight = 2;
//        c.fill = GridBagConstraints.VERTICAL;
//        p4carteColoree.setMinimumSize( p4carteColoree.getMinimumSize() );
//        add( p4carteColoree, c,0 );
//
        setSize( 1300, 2000 );
        setPreferredSize( getSize() );
        this.pack(); // dimensionner le cadre
        setLocation( 0, 0 ); // le positionner
        setVisible( true ); // et le rendre visible
    }
    
    public CSolitaire getControleur()
    {
        return controleur;
    }

    public void setControleur( CSolitaire controleur )
    {
        this.controleur = controleur;
    }

}
