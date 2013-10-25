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

        
        PTasDeCarte tasVisible = new PTasDeCarte(Decalage.DROITE);
        tasVisible.setVisible(true);

        // init du tas de carte visible 
        PCarte carteVisible1 = new PCarte("1C");
        carteVisible1.setFaceVisible(true);
        tasVisible.empiler(carteVisible1);

        PCarte carteVisible2 = new PCarte("1C");
        carteVisible2.setFaceVisible(true);
        tasVisible.empiler(carteVisible2);

        PCarte carteVisible3 = new PCarte("1D");
        carteVisible3.setFaceVisible(true);
        tasVisible.empiler(carteVisible3);

        PCarte carteVisible4 = new PCarte("1D");
        carteVisible4.setFaceVisible(true);
        tasVisible.empiler(carteVisible4);

        // init du tas de carte de la reserve 
        PTasDeCarte reserve = new PTasDeCarte(Decalage.SANS_DECALAGE);
        reserve.setVisible(true);

        PCarte carteReserve1 = new PCarte("1C");
        carteReserve1.setFaceVisible(false);
        reserve.empiler(carteReserve1);

        PCarte carteReserve2 = new PCarte("1C");
        carteReserve2.setFaceVisible(false);
        reserve.empiler(carteReserve2);

        PCarte carteReserve3 = new PCarte("1D");
        carteReserve3.setFaceVisible(false);
        reserve.empiler(carteReserve3);
        
        //ajout dans le sabot
        PSabot sabot = new PSabot(reserve, tasVisible);

        //sabot.empilerTasVisible(new PCarte("10C"));
        sabot.depilerTasVisible(carteVisible4);
        
        //sabot.depilerReserve(carteReserve3);
        //sabot.empilerReserve(new PCarte("2H"));

        f.getContentPane().add(sabot);
        f.pack(); // dimensionner le cadre
        f.setLocation(200, 100); // le positionner
        f.setVisible(true); // et le rendre visible
    } // main
}
