package solitaire.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

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
    public static int LARGEUR = 800;
    public static int HAUTEUR = 600;
    private static final long serialVersionUID = 1L;
    private CSolitaire controleur;
      
    public PSolitaire (CSolitaire c)
    {
        controleur = c ;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout( new BorderLayout());
        getContentPane().setBackground(new Color(143, 143, 195)); // violet 
                   
        setVisible( true );
        setSize( LARGEUR, HAUTEUR );
        setLocationRelativeTo( getParent() );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    public void init()
    {
        P7Colonne p7c = controleur.getColonnes();
        PSabot pSabot = controleur.getcSabot().getPresentation();
        P4TasColoree p4c = controleur.getTasColorees();

       
        
       getContentPane().add(p7c, BorderLayout.CENTER);
       getContentPane(). add(pSabot, BorderLayout.NORTH);
       getContentPane().add(p4c, BorderLayout.WEST);


        setSize( LARGEUR, HAUTEUR );
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
