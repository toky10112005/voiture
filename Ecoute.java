package vue;

import java.awt.event.*;
import javax.swing.*;
import fiara.*;

public class Ecoute implements ActionListener,MouseListener{

    private Tableau t;
    private Voiture voiture;
    private Timer accTimer;
    private Timer fTimer;
    private Timer physicsTimer;
    private long lastTime;

    public Ecoute(Tableau t) {
        this.t = t;
        this.voiture = t.getVoiture(); 
        this.lastTime = System.nanoTime();

       
          // Timer pour la physique (60 fois/seconde)
        this.physicsTimer = new Timer(16, e -> {
            long now = System.nanoTime();
            double deltaTime = (now - lastTime) / 1_000_000_000.0;
            lastTime = now;
            
            voiture.updatePhysique(deltaTime);
            voiture.freignage(deltaTime);

            t.updateVitesse();
        });
        physicsTimer.start();
        
    }

    @Override
    public void mousePressed(MouseEvent e){
         if (e.getSource() == t.getAcceleratorButton()) {
            voiture.setAccelerateurAppuye(true);
        }else if(e.getSource() == t.getFreinage()){
            voiture.setFreinAppuye(true);
        }
    }
      @Override
    public void mouseReleased(MouseEvent e) {
         if (e.getSource() == t.getAcceleratorButton()) {
            voiture.setAccelerateurAppuye(false);
        }else if(e.getSource() == t.getFreinage()){
            voiture.setFreinAppuye(false);
        }
    }

    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e){
        
    }

}
