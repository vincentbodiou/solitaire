package solitaire.launcher;

import solitaire.application.Usine;
import solitaire.controleur.CSolitaire;
import solitaire.usine.CUsine;

public class launcher
{
    public static void main( String[] args )
    {
        Usine usine = new CUsine();
        CSolitaire solitaire = new CSolitaire( "solitaire", usine );
        solitaire.initialiser(); // init le mod�le
        solitaire.init(); // init la pr�sentation
        solitaire.run();
    }
}
