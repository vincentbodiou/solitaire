package presentation;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class PSolitaire
{
    public PSolitaire()
    {
        
    }
    
    /**
     * programme de test : � d�placer dans une classe d�di�e aux tests
     * 
     * @param args
     */
    public static void main(String args[])
    {
        JFrame f = new JFrame("Test PSolitaire");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout()); // au lieu de BorderLayout par d�faut
        f.getContentPane().setBackground(new Color(143, 143, 195)); // violet                                                                   // p�le


        f.pack(); // dimensionner le cadre
        f.setLocation(200, 100); // le positionner
        f.setVisible(true); // et le rendre visible
    } // main
}
