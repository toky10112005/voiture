package vue;

import javax.swing.*;
import java.awt.*;

import fiara.*;

public class Tableau extends JFrame{

    private JButton acceleration;
    private JButton frein;
    private JButton boite_plus;
    private JButton boite_moins;
    private JLabel aff_V;
    private Voiture voiture;
    private Ecoute ecoute;
    private Boite boite;
     private JLabel aff_Rap;

        public Tableau(){
            boite=new Boite();
            voiture = new Voiture(180, 0,boite);


            ecoute=new Ecoute(this);

            setTitle("Tableau de bord");
            setSize(800,600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel buttonPanel = new JPanel(new FlowLayout());

            JPanel pedale= new JPanel(new FlowLayout());
            JPanel levier= new JPanel(new FlowLayout());

            acceleration=new JButton("Accelerer");    
            acceleration.addMouseListener(ecoute);

            frein=new JButton("Freiner");
            frein.addMouseListener(ecoute);

            boite_plus=new JButton("+");
            boite_plus.addActionListener(ecoute);

            boite_moins=new JButton("-");
            boite_moins.addActionListener(ecoute);

            aff_V = new JLabel("0 km/h", SwingConstants.CENTER);
            aff_Rap = new JLabel("0", SwingConstants.CENTER);

            pedale.add(frein);
            pedale.add(acceleration);

            levier.add(boite_moins);
            levier.add(aff_Rap);
            levier.add(boite_plus);
            update_Rapport();

            buttonPanel.add(levier,BorderLayout.NORTH);
            buttonPanel.add(pedale,BorderLayout.SOUTH);


            add(aff_V,BorderLayout.NORTH);
            add(buttonPanel, BorderLayout.SOUTH);
            
             updateVitesse();
             update_Rapport();
            setVisible(true);
        }

        public Boite getBoite(){
            return this.boite;
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

    public void update_Rapport(){
        aff_Rap.setText(String.format("%d", boite.getRapport()));
    }
}
