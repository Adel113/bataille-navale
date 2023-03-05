package BatailleNavale;
import javax.swing.*;
import java.util.Scanner;

public class Jeu extends JPanel {


    Grille g1= new Grille(10,10);
    Grille g2= new Grille(10,10);

    public void launch() {
        //Lancement du jeu

        int bateauxPlacesJoueur1 = 0;
        int bateauxPlacesJoueur2 = 0;

        //1. Placement des bateaux
        //Récupération des coordonnées saisies par l'utilisateur
        Scanner sc = new Scanner(System.in);

        while (bateauxPlacesJoueur1 < 5 ) {
            System.out.print("Player 1 : ");
            System.out.print("Entrez la coordonnée x : ");
            int x = sc.nextInt();
            System.out.print("Entrez la coordonnée y : ");
            int y = sc.nextInt();
            System.out.print("entrez l'orientation du bateau (true pour horizontal, false pour vertical) : ");
            boolean orientation = sc.nextBoolean();
            boolean h =! orientation;
            System.out.print("entrez la taille du bateau : ");
            int taille = sc.nextInt();

            boolean result = checkBateau(x, y, h, taille);
            if (!result) {
                System.out.println("impossible de placer un bateau à cet emplacement.");
                continue;
            }

            System.out.print("voulez vous continuer a ajouter des bateaux ? y/n : ");
            String answer = sc.next();
            if (answer.equals("n")) {
                break;
            }
            bateauxPlacesJoueur1++;
            g1.afficher();
        }
        System.out.println("Player 2 :");
        while (bateauxPlacesJoueur2 < 5) {
            System.out.print("Entrez la coordonnée x : ");
            int x = sc.nextInt();
            System.out.print("Entrez la coordonnée y : ");
            int y = sc.nextInt();
            System.out.print("entrez l'orientation du bateau (true pour horizontal, false pour vertical) : ");
            boolean orientation = sc.nextBoolean();
            boolean h =! orientation;
            System.out.print("entrez la taille du bateau : ");
            int taille = sc.nextInt();

            boolean result = checkBateau(x, y, h, taille);
            if (!result) {
                System.out.println("impossible de placer un bateau à cet emplacement.");
                continue;
            }

            System.out.print("voulez vous continuer a ajouter des bateaux ? y/n : ");
            String answer = sc.next();
            if (answer.equals("n")) {
                break;
            }
            bateauxPlacesJoueur2++;
            g2.afficher();
        }
    }
    public boolean checkBateau(int x, int y, boolean h,int taille) {

        boolean result = false;

        if (x >= 0 && y >= 0 && x < 10 && y < 10 && taille < 6 && taille > 0) {
            //Vérification si on peut placer le bateau sur la carte
            if (g1.getGrille()[x][y].getEtat() == Element.EAU) {

                //verification si tous les elements d la grille sont pris
                boolean Elements = false;
                for (int i = 0; i < g1.getGrille().length; i++) {
                    for (int j = 0; j < g1.getGrille()[i].length; j++) {
                        if (g1.getGrille()[i][j].getEtat() != Element.EAU) {
                            Elements = true;
                            break;
                        }
                    }
                }



                result = true;
                Bateau b = new Bateau(x,y, h, taille, g1);
            }
        }


        return result;
    }
   /* public boolean checkBateau2(int x2, int y2, boolean h2,int taille2) {

        boolean result = false;

        if (x2 >= 0 && y2 >= 0 && x2 < 10 && y2 < 10 && taille2 < 6 && taille2 > 0) {
            //Vérification si on peut placer le bateau sur la carte
            if (g1.getGrille()[x2][y2].getEtat() == Element.EAU) {

                //verification si tous les elements d la grille sont pris
                boolean Elements2 = false;
                for (int i = 0; i < g1.getGrille().length; i++) {
                    for (int j = 0; j < g1.getGrille()[i].length; j++) {
                        if (g1.getGrille()[i][j].getEtat() != Element.EAU) {
                            Elements2 = true;
                            break;
                        }
                    }
                }



                result = true;
                Bateau b2 = new Bateau(x2,y2, h2, taille2, g2);
            }
        }


        return result;
    }*/

}
