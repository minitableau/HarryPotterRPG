package GameElement;

import java.util.Random;
import java.util.Scanner;

public class PierreFeuilleCiseau {
    // règle du jeu Bienvenue dans un match de Quidditch :
    //règle du jeu
//    Il s'agit d'une variante du jeu "Pierre-Feuille-Ciseaux". Au lieu des trois objets classiques,
//    les joueurs doivent choisir entre trois personnages : le Batteur, le Poursuiveur et l'Attrapeur. Les règles du jeu sont simples :
//    le Batteur bat l'Attrapeur, l'Attrapeur bat le Poursuiveur, et le Poursuiveur bat le Batteur.
//    Le premier joueur à atteindre un score de 3 points gagne la partie. Pour jouer, chaque joueur choisit secrètement un personnage,
//    puis les deux choix sont révélés simultanément. Le joueur qui a choisi le personnage qui bat l'autre remporte un point.
//    En cas d'égalité, aucun point n'est attribué. Le jeu continue jusqu'à ce qu'un joueur atteigne le score de 3 points.

    //Idée si choix Quidditch au niveau 1 alors commencé la partie avec 1-0.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[] choix = {"Batteur", "Poursuiveur", "Attrapeur"};
        int scoreJoueur = 0;
        int scoreOrdinateur = 0;

        while (scoreJoueur < 3 && scoreOrdinateur < 3) {
            int ordi = rand.nextInt(3);

            System.out.print("Entrez votre choix (Batteur, Poursuiveur, Attrapeur) : ");
            String joueur = sc.nextLine();
            joueur = joueur.substring(0, 1).toUpperCase() + joueur.substring(1).toLowerCase();

            System.out.println("Ordinateur : " + choix[ordi]);
            System.out.println("Joueur : " + joueur);

            if (joueur.equals(choix[ordi])) {
                System.out.println("Egalite !");
            } else if ((joueur.equals("Batteur") && choix[ordi].equals("Attrapeur")) ||
                    (joueur.equals("Poursuiveur") && choix[ordi].equals("Batteur")) ||
                    (joueur.equals("Attrapeur") && choix[ordi].equals("Poursuiveur"))) {
                System.out.println("Vous avez gagne !");
                scoreJoueur++;
            } else {
                System.out.println("L'ordinateur a gagne !");
                scoreOrdinateur++;
            }

            System.out.println("Score : Joueur " + scoreJoueur + " - " + scoreOrdinateur + " Ordinateur");
        }

        if (scoreJoueur > scoreOrdinateur) {
            System.out.println("Vous avez gagne la partie !");
        } else {
            System.out.println("L'ordinateur a gagne la partie !");
        }
    }
}
