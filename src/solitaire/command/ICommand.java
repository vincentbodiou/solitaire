package solitaire.command;

import solitaire.controleur.CCarte;

public interface ICommand
{
    boolean execute(CCarte carte);
}
