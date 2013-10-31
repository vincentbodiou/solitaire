package presentation;

import presentation.Interface.IPTasDeCarte;

public interface IPColonne
{

    public abstract IPTasDeCarte getTasCache();

    public abstract void setTasCache( IPTasDeCarte tasCache );

    public abstract IPTasDeCarte getTasVisible();

    public abstract void setTasVisible( IPTasDeCarte tasVisible );

}