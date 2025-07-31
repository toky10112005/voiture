package vue;

import javax.swing.*;
import java.awt.*;

import fiara.*;

public class Tableau extends JFrame{

    private JButton acceleration;
    private JButton frein;
    private JLabel aff_V;
    private Voiture voiture;
    private Ecoute ecoute;

        public Tableau(){
            voiture = new Voiture(180, 0);

            ecoute=new Ecoute(this);

            setTitle("Tableau de bord");
            setSize(800,600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel buttonPanel = new JPanel(new FlowLayout());

            acceleration=new JButton("Accelerer");
            
            acceleration.addMouseListener(ecoute);

            frein=new JButton("Freiner");
           
            frein.addMouseListener(ecoute);

            buttonPanel.add(frein);
            buttonPanel.add(acceleration);

            aff_V = new JLabel("0 km/h", SwingConstants.CENTER);
            updateVitesse();

            add(aff_V,BorderLayout.NORTH);
            add(buttonPanel, BorderLayout.SOUTH);
            
            setVisible(true);
        }

        public JButton getAcceleratorButton() {
            return this.acceleration;
        }
        public JButton getFreinage(){
            return this.frein;
        }

        public Voiture getVoiture(){
            return this.voiture;
        }
        public void updateVitesse() {
        aff_V.setText(String.format("%.0f km/h", voiture.getV_actuel()));
        
        // Changement de couleur selon la vitesse
        if (voiture.getV_actuel() > 100) {
            aff_V.setForeground(Color.RED);
        } else if (voiture.getV_actuel() > 50) {
            aff_V.setForeground(Color.ORANGE);
        } else {
            aff_V.setForeground(Color.GREEN);
        }
    }
}
