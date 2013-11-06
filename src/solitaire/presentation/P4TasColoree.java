package solitaire.presentation;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import solitaire.application.Usine;
import solitaire.controleur.CTasDeCarte;
import solitaire.controleur.CTasDeCarteColorees;
import solitaire.usine.CUsine;

public class P4TasColoree extends JPanel
{

    private static final long serialVersionUID = 1L;
    private CTasDeCarteColorees[] tab;
    private static int NBTAS = 4;
    private static int MARGE = 5;
    private static int LARGEUR = PCarte.largeur + 2 *MARGE ;
    private static int HAUTEUR = PSolitaire.HAUTEUR;
    
    public P4TasColoree(CTasDeCarteColorees[] tas)
    {
        this.tab = tas;
        for(int i =0; i<tab.length;i++) add(tab[i].getPresentation());
       
        GridLayout gridTasColoree = new GridLayout( 0, 1 );
        setLayout( gridTasColoree );
        
        setSize( LARGEUR, HAUTEUR );
        setPreferredSize( getSize() );
        setBackground( Color.white );
        setVisible( true );
    }
    
    public static void main( String[] args )
    {
       JFrame f = new JFrame();
       f.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
       f.getContentPane().setBackground( Color.yellow );
       
       CTasDeCarteColorees tasPique;
       CTasDeCarteColorees tasCarreau;
       CTasDeCarteColorees tasTrefle;
       CTasDeCarteColorees tasCoeur;
       Usine u = new CUsine();
       // PIQUE
       tasPique = new CTasDeCarteColorees( "pique" , 1, u );


       PCarte cartePique1 = new PCarte( "2S" );
       cartePique1.setFaceVisible( true );
       tasPique.getPresentation().empiler( cartePique1 );

       PCarte cartePique2 = new PCarte( "3S" );
       cartePique2.setFaceVisible( true );
       tasPique.getPresentation().empiler( cartePique2 );

       // Coeur
       tasCoeur = new CTasDeCarteColorees( "coeur",2,u );

       PCarte carteCoeur1 = new PCarte( "2H" );
       carteCoeur1.setFaceVisible( true );
       tasCoeur.getPresentation().empiler( carteCoeur1 );

       PCarte carteCoeur2 = new PCarte( "3H" );
       carteCoeur2.setFaceVisible( true );
       tasCoeur.getPresentation().empiler( carteCoeur2 );

       // Carreau
       tasCarreau = new CTasDeCarteColorees( "carreau", 0, u );

       PCarte carteCarreau1 = new PCarte( "2D" );
       carteCarreau1.setFaceVisible( true );
       tasCarreau.getPresentation().empiler( carteCarreau1 );

       PCarte carteCarreau2 = new PCarte( "3D" );
       carteCarreau2.setFaceVisible( true );
       tasCarreau.getPresentation().empiler( carteCarreau2 );

       // Trefle
       tasTrefle = new CTasDeCarteColorees( "trefle", 3, u );

       PCarte carteTrefle1 = new PCarte( "2C" );
       carteTrefle1.setFaceVisible( true );
       tasTrefle.getPresentation().empiler( carteTrefle1 );

       PCarte carteTrefle2 = new PCarte( "3C" );
       carteTrefle2.setFaceVisible( true );
       tasTrefle.getPresentation().empiler( carteTrefle2 );

       
       CTasDeCarteColorees [] tab = new CTasDeCarteColorees[4];
       tab[0] = tasCarreau;
       tab[1] = tasCoeur;
       tab[2] = tasPique;
       tab[3] = tasTrefle;
       
       P4TasColoree tas4 = new P4TasColoree( tab );
       
       tas4.setVisible( true );
       f.getContentPane().add( tas4 );
       f.pack();
       f.setVisible( true );
      
    }

}
