package solitaire.DnD;

import solitaire.controleur.CCarte;
import solitaire.controleur.CTasDeCarte;

public interface IControleurDnD
{
    public abstract void p2c_debutDnDDrag( CCarte carte );
    public abstract void p2c_finDnDDrag( CTasDeCarte tasTemp, boolean dropSuccess );
    public abstract void p2c_DragEnter( CTasDeCarte tas );
    public abstract void finDnDDrop( CTasDeCarte tas );
}
