package vue;

import java.awt.event.*;
import javax.swing.*;
import fiara.*;

public class Ecoute implements ActionListener,MouseListener{

    private Tableau t;
    private Voiture voiture;
    private Timer accTimer;
    private Timer fTimer;

    public Ecoute(Tableau t) {
        this.t = t;
        this.voiture = t.getVoiture(); 

        accTimer=new Timer(100,e->{
            acceleration();
            t.updateVitesse();
        });

        fTimer=new Timer(100,e->{
            freinage();
            t.updateVitesse();
        });
        
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
       
    @Override
    public void mousePressed(MouseEvent e){
         JButton boutton=(JButton) e.getSource();

         if(boutton.getText().equals("Accelerer")){
            accTimer.start();
        }
        else if(boutton.getText().equals("Freiner")){
            fTimer.start();
        }
    }
      @Override
    public void mouseReleased(MouseEvent e) {
        JButton bouton = (JButton) e.getSource();
        if(bouton.getText().equals("Accelerer")) {
            accTimer.stop();
        } else if(bouton.getText().equals("Freiner")) {
            fTimer.stop();
        }
    }

    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

     public void acceleration(){
            voiture.setV_actuel(voiture.getV_actuel()+2);
        }
        public void freinage(){
            voiture.setV_actuel(Math.max(0,voiture.getV_actuel()-2));
        }
}
