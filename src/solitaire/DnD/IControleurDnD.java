package solitaire.DnD;

import solitaire.controleur.CCarte;
import solitaire.controleur.CTasDeCarte;
import solitaire.controleur.CTasDeCarteAlterne;

public interface IControleurDnD
{
    public void p2c_debutDnDDrag( CCarte carte );
    public void p2c_finDnD4DragSource( CTasDeCarte tasTemp, boolean dropSuccess );
    public void p2c_DragEnter( CTasDeCarte tas );
    public void p2c_finDnD4DropTarget( CTasDeCarte tas );
    public void p2c_DragExit( CTasDeCarte controleur );
    public void p2c_callDoubleClickCommand(Object tas);
}

