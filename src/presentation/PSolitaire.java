package presentation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import IPresentation.IP4CarteColoree;
import IPresentation.IP7Colonnes;
import IPresentation.IPSabot;

@SuppressWarnings( "serial" )
public class PSolitaire extends JFrame
{

    private IPSabot pSabot;

    private IP4CarteColoree p4carteColoree;

    private IP7Colonnes p7Colonne;

    public PSolitaire( PSabot pSabot, P4CarteColoree p4carteColoree, P7Colonne p7Colonne )
    {
        this.pSabot = pSabot;
        this.p4carteColoree = p4carteColoree;
        this.p7Colonne = p7Colonne;

        setLayout( new GridBagLayout() );
       

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        pSabot.setMinimumSize( pSabot.getSize() );
        add( pSabot, c );

        c.gridx = 0;
        c.gridy = 1;
        p7Colonne.setMinimumSize( p7Colonne.getMinimumSize() );
        add( p7Colonne, c );

        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 2;
        c.fill = GridBagConstraints.VERTICAL;
        p4carteColoree.setMinimumSize( p4carteColoree.getMinimumSize() );
        add( p4carteColoree, c,0 );

        setSize( 1300, 2000 );
        setPreferredSize( getSize() );
        pack(); // dimensionner le cadre
        setLocation( 0, 0 ); // le positionner
        setVisible( true ); // et le rendre visible
    }

    /*
     * programme de test : à déplacer dans une classe dédiée aux tests
     * @param args
     */
    public static void main( String args[] )
    {
        PSabot sabot = initSabot();
        P7Colonne colonnes = initColonne();
        P4CarteColoree carteColoree = initCarteColoree();

        PSolitaire solitaire = new PSolitaire(sabot,carteColoree,colonnes);
    } // main

    private static P4CarteColoree initCarteColoree()
    {
        int nb_tas = 4;

        List<PTasDeCarte> lTas = new ArrayList<>( nb_tas );

        PTasDeCarte tasPique;
        PTasDeCarte tasCoeur;
        PTasDeCarte tasCarreau;
        PTasDeCarte tasTrefle;

        // PIQUE
        tasPique = new PTasDeCarte( Decalage.SANS_DECALAGE );
        tasPique.setVisible( true );

        PCarte cartePique1 = new PCarte( "2S" );
        cartePique1.setFaceVisible( true );
        tasPique.empiler( cartePique1 );

        PCarte cartePique2 = new PCarte( "3S" );
        cartePique2.setFaceVisible( true );
        tasPique.empiler( cartePique2 );

        // Coeur
        tasCoeur = new PTasDeCarte( Decalage.SANS_DECALAGE );
        tasCoeur.setVisible( true );

        PCarte carteCoeur1 = new PCarte( "2H" );
        carteCoeur1.setFaceVisible( true );
        tasCoeur.empiler( carteCoeur1 );

        PCarte carteCoeur2 = new PCarte( "3H" );
        carteCoeur2.setFaceVisible( true );
        tasCoeur.empiler( carteCoeur2 );

        // Carreau
        tasCarreau = new PTasDeCarte( Decalage.SANS_DECALAGE );
        tasCarreau.setVisible( true );

        PCarte carteCarreau1 = new PCarte( "2D" );
        carteCarreau1.setFaceVisible( true );
        tasCarreau.empiler( carteCarreau1 );

        PCarte carteCarreau2 = new PCarte( "3D" );
        carteCarreau2.setFaceVisible( true );
        tasCarreau.empiler( carteCarreau2 );

        // Trefle
        tasTrefle = new PTasDeCarte( Decalage.SANS_DECALAGE );
        tasTrefle.setVisible( true );

        PCarte carteTrefle1 = new PCarte( "2C" );
        carteTrefle1.setFaceVisible( true );
        tasTrefle.empiler( carteTrefle1 );

        PCarte carteTrefle2 = new PCarte( "3C" );
        carteTrefle2.setFaceVisible( true );
        tasTrefle.empiler( carteTrefle2 );

        lTas.add( tasCarreau );
        lTas.add( tasCoeur );
        lTas.add( tasPique );
        lTas.add( tasTrefle );

        return new P4CarteColoree( lTas );       
    }

    private static P7Colonne initColonne()
    {
        int nb_colonnes = 7;

        List<PColonne> colonnes = new ArrayList<>( nb_colonnes );

        PTasDeCarte tasVisible;
        PTasDeCarte tasCache;

        for ( int i = 0; i < nb_colonnes; i++ )
        {
            tasVisible = new PTasDeCarte( Decalage.BAS );
            tasVisible.setVisible( true );

            // init du tas de carte visible
            PCarte carteVisible1 = new PCarte( "5C" );
            carteVisible1.setFaceVisible( true );
            tasVisible.empiler( carteVisible1 );

            PCarte carteVisible2 = new PCarte( "4D" );
            carteVisible2.setFaceVisible( true );
            tasVisible.empiler( carteVisible2 );

            PCarte carteVisible3 = new PCarte( "3C" );
            carteVisible3.setFaceVisible( true );
            tasVisible.empiler( carteVisible3 );

            PCarte carteVisible4 = new PCarte( "2D" );
            carteVisible4.setFaceVisible( true );
            tasVisible.empiler( carteVisible4 );

            // init du tas de carte de la reserve
            tasCache = new PTasDeCarte( Decalage.BAS );
            tasCache.setVisible( true );

            PCarte carteReserve1 = new PCarte( "1C" );
            carteReserve1.setFaceVisible( false );
            tasCache.empiler( carteReserve1 );

            PCarte carteReserve2 = new PCarte( "1C" );
            carteReserve2.setFaceVisible( false );
            tasCache.empiler( carteReserve2 );

            PCarte carteReserve3 = new PCarte( "1D" );
            carteReserve3.setFaceVisible( false );
            tasCache.empiler( carteReserve3 );

            colonnes.add( new PColonne( tasVisible, tasCache ) );
        }

        return new P7Colonne( colonnes );

    }

    private static PSabot initSabot()
    {
        PTasDeCarte tasVisible = new PTasDeCarte( Decalage.DROITE );
        tasVisible.setVisible( true );

        // init du tas de carte visible
        PCarte carteVisible1 = new PCarte( "1C" );
        carteVisible1.setFaceVisible( true );
        tasVisible.empiler( carteVisible1 );

        PCarte carteVisible2 = new PCarte( "1C" );
        carteVisible2.setFaceVisible( true );
        tasVisible.empiler( carteVisible2 );

        PCarte carteVisible3 = new PCarte( "1D" );
        carteVisible3.setFaceVisible( true );
        tasVisible.empiler( carteVisible3 );

        PCarte carteVisible4 = new PCarte( "1D" );
        carteVisible4.setFaceVisible( true );
        tasVisible.empiler( carteVisible4 );

        // init du tas de carte de la reserve
        PTasDeCarte reserve = new PTasDeCarte( Decalage.SANS_DECALAGE );
        reserve.setVisible( true );

        PCarte carteReserve1 = new PCarte( "1C" );
        carteReserve1.setFaceVisible( true );
        reserve.empiler( carteReserve1 );

        PCarte carteReserve2 = new PCarte( "1C" );
        carteReserve2.setFaceVisible( true );
        reserve.empiler( carteReserve2 );

        PCarte carteReserve3 = new PCarte( "1D" );
        carteReserve3.setFaceVisible( true );
        reserve.empiler( carteReserve3 );

        return new PSabot( reserve, tasVisible );

    }
}
