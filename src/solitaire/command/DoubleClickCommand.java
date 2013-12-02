package solitaire.command;

import solitaire.controleur.CCarte;
import solitaire.controleur.CTasDeCarteColorees;

public class DoubleClickCommand implements ICommand
{
    private CTasDeCarteColorees[] tabColore;

    public DoubleClickCommand( CTasDeCarteColorees[] tabColore )
    {
        this.tabColore = tabColore;
    }

    @Override
    public boolean execute( CCarte carte )
    {
       if(!tabColore[carte.getCouleur()-1].isEmpilable( carte ))
           return false;
       else
           tabColore[carte.getCouleur()-1].empiler( carte );
       
       return true;
//        switch ( carte.getCouleur() )
//        {
//        case 1:
//            if ( tabColore[0].isEmpilable( carte ) ) return false;
//                tabColore[0].empiler( carte );
//            ;
//            break; // Carreau
//        case 2:
//            if ( tabColore[1].isEmpilable( carte ) ) return false;
//            tabColore[1].empiler( carte );
//            ;
//            break; // Pique
//        case 3:
//            if ( tabColore[2].isEmpilable( carte ) ) return false;
//            tabColore[2].empiler( carte );
//            ;
//            break; // Coeur
//        case 4:
//            if ( tabColore[3].isEmpilable( carte ) ) return false;
//            tabColore[3].empiler( carte );
//            ;
//            break; // Club
//        }
//        
    }
}
