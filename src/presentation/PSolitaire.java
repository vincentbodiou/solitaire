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
     * programme de test : à déplacer dans une classe dédiée aux tests
     * 
     * @param args
     */
    public static void main(String args[])
    {
        JFrame f = new JFrame("Test PSolitaire");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
        f.getContentPane().setBackground(new Color(143, 143, 195)); // violet                                                                   // pâle


        f.pack(); // dimensionner le cadre
        f.setLocation(200, 100); // le positionner
        f.setVisible(true); // et le rendre visible
    } // main
}
