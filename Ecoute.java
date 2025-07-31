package vue;

import java.awt.event.*;
import javax.swing.JButton;
import java.awt.*;
import fiara.*;

public class Ecoute implements ActionListener{

         private Tableau t;
    private Voiture voiture;

    public Ecoute(Tableau t) {
        this.t = t;
        this.voiture = t.getVoiture(); 
    }

     @Override
    public void actionPerformed(ActionEvent e) {
        JButton boutton=(JButton) e.getSource();

        if(boutton.getText().equals("Accelerer")){
            acceleration();
        }
        else if(boutton.getText().equals("Freiner")){
            freinage();
        }
          t.updateVitesse();
    }
        public void acceleration(){
            voiture.setV_actuel(voiture.getV_actuel()+5);
        }
        public void freinage(){
            voiture.setV_actuel(Math.max(0,voiture.getV_actuel()-5));
        }
}
