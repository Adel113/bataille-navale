package BatailleNavale;


public class Grille {
    private int nbLig;
    private int nbCol ;
    private Element[][] grille;

    public Grille(int l , int c){
        nbLig = l;
        nbCol = c;
        grille= new Element[nbLig][nbCol];

        for (int i = 0 ; i < nbLig; i++){
            for (int j=0 ; j < nbCol ; j++){

                grille [i][j] = new Element(i, j, Element.EAU) ;

            }
        }
    }
    public void afficher(){
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (i < 10 && j < 10) {
                    System.out.print(" " + grille[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public Element[][] getGrille() {
        return grille;
    }

    public void setGrille(Element[][] grille) {
        this.grille = grille;
    }
}

