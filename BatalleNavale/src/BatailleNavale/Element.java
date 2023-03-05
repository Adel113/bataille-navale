package BatailleNavale;

public class Element {

    public static final String EAU = "-";
    private int abcisse;
    private int ordonnee;
    private String etat;

    private Bateau bateau;

    public Element(int i, int j, Bateau bateau) {
        abcisse=i;
        ordonnee=j;
        etat="intact";
        this.bateau = bateau;
    }

    public Element(int i, int j, String etat) {
        abcisse=i;
        ordonnee=j;
        this.etat=etat;
    }
    public int getabcisse(){

        return abcisse;
    }
    public int getordonnee(){

        return ordonnee;
    }
    public void touche(int i , int j) {
        if(abcisse==i && ordonnee==j) {
            if(etat=="intact"){
                etat="abime";
            }else if(etat=="abime")
                etat="detruit";
        }
    }
    public String getEtat() {

        return etat;
    }
    public String toString() {
        String s=" ";

        if (etat == EAU) {
            s = "-";
        } else if(bateau != null) {
            if(etat=="intact"){
                s="$";
            }else{
                if(etat=="abime"){
                    s="a";
                }else{
                    s="d";
                }

            }
        }
        return s;
    }

}