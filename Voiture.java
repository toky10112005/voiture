package fiara;

public class Voiture{
    private int V_Max;
    private double V_actuel;
    private Boite boite;

     double forceMoteur = 10000; 
    private final double coef_frot=1;  // N/(m/s)
    private final double masse=1500;
    private final double frein_moteur=-3000;
    private final double f_freignage=-10000;

    private boolean accelerateurAppuye = false;
     private boolean freinAppuye = false;

    public Voiture(int V_Max,int V_actuel,Boite boite){
        this.V_Max=V_Max;
        this.V_actuel=V_actuel;
        this.boite=boite;
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
    public void setFreinAppuye(boolean appuye){
        this.freinAppuye = appuye;
    }

        public void updatePhysique(double deltaTime) {
        double rapportMultiplier =  (boite.getRapport() * 0.5);
        double forceEff = forceMoteur * rapportMultiplier;

        if (accelerateurAppuye) {
            double acceleration = forceEff / masse;
            V_actuel = Math.min(V_actuel + acceleration * deltaTime, V_Max);
        } else {
            double forceFrottement = coef_frot * V_actuel;
            double acceleration = (frein_moteur + forceFrottement) / masse;
            V_actuel = Math.max(0, V_actuel + acceleration * deltaTime);
        }
    }

        public void freignage(double deltaTime){
            if(freinAppuye){
                double forceFrottement = coef_frot * V_actuel;
                double acceleration = ((frein_moteur + forceFrottement)+f_freignage) / masse;
                V_actuel = Math.max(0, V_actuel + acceleration * deltaTime);
            }   
        }
}