package IPresentation;

import presentation.PCarte;
import presentation.PTasDeCarte;

public interface IPSabot
{

    public abstract void depilerTasVisible( PCarte carte );

    public abstract void depilerReserve( PCarte carte );

    public abstract void empilerTasVisible( PCarte carte );

    public abstract void empilerReserve( PCarte carte );

    public abstract IPTasDeCarte getReserve();

    public abstract void setReserve( PTasDeCarte reserve );

    public abstract IPTasDeCarte getTasVisible();

    public abstract void setTasVisible( PTasDeCarte tasVisible );

}