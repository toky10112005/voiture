package fiara;

public class Voiture{
    private int V_Max;
    private double V_actuel;

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
}