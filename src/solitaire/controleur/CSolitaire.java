package solitaire.controleur;


import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import solitaire.application.Solitaire;
import solitaire.application.Usine;
import solitaire.command.DoubleClickCommand;
import solitaire.command.ICommand;
import solitaire.observer.Observer;
import solitaire.player.Player;
import solitaire.presentation.P4TasColoree;
import solitaire.presentation.P7Colonne;
import solitaire.presentation.PSolitaire;

public class CSolitaire extends Solitaire implements Observer
{

    private PSolitaire p;

    private CSabot cSabot; 
    private P7Colonne colonnes;
    private P4TasColoree tasColorees;

    public CSolitaire( String nom, Usine usine )
    {
        super( nom, usine );
        p = new PSolitaire( this );
    }

    public void init()
    {
        /*
         * ------tas de carte colorée----
         */       
        CTasDeCarteColorees[] tabColore = new CTasDeCarteColorees[4];
        for ( int i = 0; i < pilesColorees.length; i++ )
        {
            CTasDeCarteColorees tmp = (CTasDeCarteColorees) (pilesColorees[i]);
            tabColore[i] = tmp;
           tabColore[i].addObserver( this );
        }        
        this.tasColorees = new P4TasColoree( tabColore );
        
        
        /*
         * ------Commande pour le double clic----
         */
        ICommand command = new DoubleClickCommand( tabColore );
        
        
        /*
         * ------Colonnes----
         */
        CColonne[] tab = new CColonne[7];
        for ( int i = 0; i < pilesAlternees.length; i++ )
        {
            tab[i] = (CColonne) pilesAlternees[i];
            tab[i].setDoubleClickCommand( command ); // on set la commande du double clic
        }
        colonnes = new P7Colonne( tab );

        
        /*
         * ------Sabot----
         */
        cSabot = (CSabot) sabot;
        cSabot.setDoubleClickCommand( command ); // on set la commande du double clic
        
        p.init(); // on initialise la présentation du solitaire
    }

    @Override
    public void notifie()
    {
       if(gagne())
         Player.playSoundVictoire();
    }
   
    public CSabot getcSabot()
    {
        return cSabot;
    }

    public void setcSabot( CSabot cSabot )
    {
        this.cSabot = cSabot;
    }

    public P7Colonne getColonnes()
    {
        return colonnes;
    }

    public void setColonnes( P7Colonne colonnes )
    {
        this.colonnes = colonnes;
    }

    public P4TasColoree getTasColorees()
    {
        return tasColorees;
    }

    public void setTasColorees( P4TasColoree tasColorees )
    {
        this.tasColorees = tasColorees;
    }

   
  
}
