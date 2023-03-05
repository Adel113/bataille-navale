package BatailleNavale;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class maFenetre extends JFrame {

    private static final int TAILLE_CASE = 50;
    private static final int NB_LIGNES = 10;
    private static final int NB_COLONNES = 10;

    private JPanel panneau;

    public maFenetre() {
        setTitle("Ma fenêtre");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panneau = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                dessinerGrille(g);
            }
        };
        panneau.setBorder(new EmptyBorder(50, 50, 50, 50)); // Ajoute une bordure vide avec une taille de 50 pixels
        panneau.setPreferredSize(new Dimension(NB_COLONNES * TAILLE_CASE, NB_LIGNES * TAILLE_CASE)); // Définit la taille préférée du panneau

        add(panneau, BorderLayout.CENTER); // Ajoute le panneau centré à la fenêtre en utilisant BorderLayout

        pack(); // Redimensionne la fenêtre pour qu'elle s'adapte à la taille préférée du panneau
        setLocationRelativeTo(null); // Centre la fenêtre sur l'écran
        setVisible(true);
    }

    private void dessinerGrille(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i <= NB_LIGNES; i++) {
            g.drawLine(0, i * TAILLE_CASE, NB_COLONNES * TAILLE_CASE, i * TAILLE_CASE);
        }
        for (int j = 0; j <= NB_COLONNES; j++) {
            g.drawLine(j * TAILLE_CASE, 0, j * TAILLE_CASE, NB_LIGNES * TAILLE_CASE);
        }
    }

    public static void main(String[] args) {
        new maFenetre();
    }
}
