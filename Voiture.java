package fiara;

public class Voiture{
    private int V_Max;
    private double V_actuel;

    private final double coef_frot=0.5;  // N/(m/s)
    private final double masse=1500;
    private final double frein_moteur=-1000;

    private boolean accelerateurAppuye = false;

    public Voiture(int V_Max,int V_actuel){
        this.V_Max=V_Max;
        this.V_actuel=V_actuel;
    }

    public int getV_Max(){
        return this.V_Max;
    }
    public void setV_Max(int V){
        this.V_Max=V;
    }
    public double getV_actuel(){
        return this.V_actuel;
    }
    public void setV_actuel(double V_act){
        this.V_actuel=Math.min(V_act, V_Max);;
    }

    public void setAccelerateurAppuye(boolean appuye) {
        this.accelerateurAppuye = appuye;
    }

        public void updatePhysique(double deltaTime) {
        if (accelerateurAppuye) {
            double forceMoteur = 10000; 
            double acceleration = forceMoteur / masse;
            V_actuel = Math.min(V_actuel + acceleration * deltaTime, V_Max);
        } else {
            double forceFrottement = coef_frot * V_actuel;
            double acceleration = (frein_moteur + forceFrottement) / masse;
            V_actuel = Math.max(0, V_actuel + acceleration * deltaTime);
        }
    }
}