package solitaire.controleur;

import solitaire.application.Solitaire;
import solitaire.application.Usine;
import solitaire.presentation.P7Colonne;
import solitaire.presentation.PSabot;
import solitaire.presentation.PSolitaire;

public class CSolitaire extends Solitaire
{

    private PSolitaire p;
    private CSabot cSabot;
    private P7Colonne colonnes;
    
    
    
    public CSolitaire( String nom, Usine usine )
    {
        super( nom, usine );        
        p = new PSolitaire( this );          
        
    }
    
    public void init()
    {
       cSabot = (CSabot) sabot;
       CColonne[] tab = new CColonne[7];
       for(int i =0;i<pilesAlternees.length;i++) tab[i]=(CColonne) pilesAlternees[i];       
       setColonnes( new P7Colonne(tab) );
       p.init();
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
}
