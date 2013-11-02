package solitaire.presentation;

import java.awt.Color;

import javax.swing.JPanel;

import solitaire.controleur.CTasDeCarteAlterne;

public class PTasDeCarteAlterne extends JPanel
{
  private int Xoffset;
  private int Yoffset;
  private CTasDeCarteAlterne controleur;
  private static final long serialVersionUID = 1L;

  
  public PTasDeCarteAlterne(CTasDeCarteAlterne c)
  {
      super();
      this.controleur = c;
      setLayout( null );
      setSize( PCarte.largeur, PCarte.hauteur );
      setPreferredSize( getSize() );
      setBackground( Color.yellow );     
  }
  
  public void empiler(PCarte pCard) {
      System.out.println("empiler de PTasDeCarteAlterne");
      int nbCard = getNbCard();
      
      int xOffset = getXoffset();
      int yOffset = getYoffset();

      add(pCard, 0);
      pCard.setLocation((nbCard - 1) * xOffset,   ((nbCard - 1) * yOffset));

      rafraichir();
  }

  private void rafraichir() {     
      repaint();
  }
  
  public void depiler(PCarte c) {
      System.out.println("depiler de PTasDeCarteAlterne");
      remove(c);
      rafraichir();
  }


  private int getNbCard() {
      return controleur.getNombre();
  }
  
  public CTasDeCarteAlterne getControleur() {
      return controleur;
  }

  public void setControleur(CTasDeCarteAlterne controleur) {
      this.controleur = controleur;
  }

  public int getXoffset() {
      return Xoffset;
  }

  public void setXoffset(int xoffset) {
      Xoffset = xoffset;
  }

  public int getYoffset() {
      return Yoffset;
  }

  public void setYoffset(int yoffset) {
      Yoffset = yoffset;
  }

}
