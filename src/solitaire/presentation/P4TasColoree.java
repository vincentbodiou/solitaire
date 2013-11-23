package solitaire.presentation;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import listener.ADragSourceListener;
import solitaire.application.Usine;
import solitaire.controleur.CCarte;
import solitaire.controleur.CTasDeCarte;
import solitaire.controleur.CTasDeCarteColorees;
import solitaire.usine.CUsine;

public class P4TasColoree extends JPanel
{

    private static final long serialVersionUID = 1L;

    private CTasDeCarteColorees[] tab;

    private static int NBTAS = 4;

    private static int MARGE = 5;

    private static int LARGEUR = PCarte.largeur + 2 * MARGE;

    private static int HAUTEUR = PSolitaire.HAUTEUR;

   

    public P4TasColoree( CTasDeCarteColorees[] tas )
    {
        this.tab = tas;
        for ( int i = 0; i < tab.length; i++ )
        {
            add( tab[i].getPresentation() );
        }
        tab[0].getPresentation().setBackground( Color.blue );
        tab[1].getPresentation().setBackground( Color.gray );
        tab[2].getPresentation().setBackground( Color.magenta );
        tab[3].getPresentation().setBackground( Color.orange );
        
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
        tasPique = new CTasDeCarteColorees( "pique", 1, u );

        CCarte cartePique1 = new CCarte( 2, 0 );
        cartePique1.setFaceVisible( true );
        tasPique.getPresentation().empiler( cartePique1.getPresentation() );

        CCarte cartePique2 = new CCarte( 3, 0 );
        cartePique2.setFaceVisible( true );
        tasPique.getPresentation().empiler( cartePique2.getPresentation() );

        // Coeur
        tasCoeur = new CTasDeCarteColorees( "coeur", 2, u );

        CCarte carteCoeur1 = new CCarte( 2, 1 );
        carteCoeur1.setFaceVisible( true );
        tasCoeur.getPresentation().empiler( carteCoeur1.getPresentation() );

        CCarte carteCoeur2 = new CCarte( 3, 1 );
        carteCoeur2.setFaceVisible( true );
        tasCoeur.getPresentation().empiler( carteCoeur2.getPresentation() );

        // Carreau
        tasCarreau = new CTasDeCarteColorees( "carreau", 0, u );

        CCarte carteCarreau1 = new CCarte( 2, 4 );
        carteCarreau1.setFaceVisible( true );
        tasCarreau.getPresentation().empiler( carteCarreau1.getPresentation() );

        CCarte carteCarreau2 = new CCarte( 2, 4 );
        carteCarreau2.setFaceVisible( true );
        tasCarreau.getPresentation().empiler( carteCarreau2.getPresentation() );

        // Trefle
        tasTrefle = new CTasDeCarteColorees( "trefle", 3, u );

        CCarte carteTrefle1 = new CCarte( 2, 4 );
        carteTrefle1.setFaceVisible( true );
        tasTrefle.getPresentation().empiler( carteTrefle1.getPresentation() );

        CCarte carteTrefle2 = new CCarte( 3, 3 );
        carteTrefle2.setFaceVisible( true );
        tasTrefle.getPresentation().empiler( carteTrefle2.getPresentation() );

        CTasDeCarteColorees[] tab = new CTasDeCarteColorees[4];
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
