package BatailleNavale;

public class Croiseur extends Bateau {


    public Croiseur(int x, int y, boolean h) {
        
        super(3,4,h,3, null);
    }


    public String   toString(){
        
        return "croiseur"+super.toString();
    }
}
