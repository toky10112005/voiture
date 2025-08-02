package fiara;


public class Boite {
    int rapport;
    int max_rapport;

    public Boite(){
        this.rapport=0;
        this.max_rapport=5;
    }

    public int getRapport(){
        return this.rapport;
    }
    public void setRapport(int r){
        this.rapport=r;
    }
    public int get_max(){
        return this.max_rapport;
    }
}
