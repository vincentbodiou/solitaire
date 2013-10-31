package IPresentation;

import javax.swing.ImageIcon;

public interface IPCarte
{

    /**
     * changer la visibilité de la carte
     * @param faceVisible : vrai si la face est visible, faux sinon
     */
    public abstract void setFaceVisible( boolean faceVisible );

    public abstract ImageIcon getIcone();

}