package solitaire.command;

import solitaire.controleur.CCarte;
import solitaire.controleur.CTasDeCarteColorees;

/*
 * Concrete Commande pour le double clic
 * La méthode execute va avoir pour but d'appeller le controleur 
 * du tas de carte colorée correspondant à la couleur de la carte en paramètre
 * et d'empiler si possible cette carte. 
 * 
 * @param du contrusteur : les controleurs des 4 tas de cartes colorées
 * 
 * @param de execute() : Controleur de la carte que l'on veut empiler
 * 
 * @return true si la carte est empiler
 */

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
    }
}
