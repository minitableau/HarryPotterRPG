package Game;

import GameElement.*;
import utils.ConsoleColors;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        level0();
    }

    public static void level0() {

        int money = 100;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Vous entendez frapper à la porte. En l'ouvrant, vous trouvez un homme gigantesque, un demi-géant, avec une barbe sauvage et des yeux pétillants.\n" +
                "\"Bonjour, je suis Rubeus Hagrid gardien des clés et des lieux à Poudlard\", dit-il en souriant. \"Je viens chercher un jeune sorcier de 11 ans pour l'emmener à Poudlard.\n " + ConsoleColors.BLUE + "Et vous êtes...?" + ConsoleColors.RESET);
        String name = scanner.nextLine();
        System.out.println("Hagrid sourit à votre réponse, puis reprend : \"Très bien, " + ConsoleColors.RED + name + ConsoleColors.RESET + ". Avant de partir pour Poudlard, il y a quelques formalités à régler.\n" +
                "Tout d'abord, il vous faut  vos fournitures un chaudron standard en étain, un animal de compagnie et une baguette. Suivez-moi !");
        System.out.println("\n\t __ Hagrid vous emmène à Londres à l'arrière d'un bar et vous fait découvrir un lieu magique nommé le chemin de traverse __\n");
        Core core1 = Core.values()[random.nextInt(Core.values().length)];
        System.out.println("Vous découvrez une rue pleine de boutiques en tout genre : magasin d'animaux, de balais, baguette magique et une banque. \nVous passez à la Gringotts banque récupérer votre argent dans le coffre 687. Le goblin vous indique que vous disposez de " + ConsoleColors.RED + money + ConsoleColors.RESET + " mornilles.\nVous passez ensuite chez Olivenders acheter votre baguette. Il vous reconnaît directement et se rappelle très bien des baguettes de vos parents,\nil vous tend alors une baguette faite avec un coeur en " + ConsoleColors.RED + core1.type + ConsoleColors.RESET + " et vous demande de faire le geste");

        int gesture = readGesture(scanner);
        System.out.println(ConsoleColors.RED + "\nVous tuez le poisson de M. Olivander \n" + ConsoleColors.RESET);

        Core core2;
        do {
            core2 = Core.values()[random.nextInt(Core.values().length)];
        } while (core2 == core1);

        System.out.println("Heu non sûrement pas celle-ci ! s'exclame-t-il. Il vous tend alors une autre baguette dont le coeur est en " + ConsoleColors.RED + core2.type + ConsoleColors.RESET + " et vous demande de faire à nouveau le geste.");
        gesture = readGesture(scanner);
        System.out.println("\nM. Olivender n'en revient pas ! Il connait toutes les baguettes qu'il vend et celle qui vous à choisi est faite à partir de " + ConsoleColors.RED + core2.type + ConsoleColors.RESET + " il est persuadé \nque vous aller accomplir de grandes choses car il y peu de sorciers qui ont des baguettes faite à partir de " + ConsoleColors.RED + core2.type + ConsoleColors.RESET + " et ils se sont tous démarqués !");
        System.out.println("Vous sortez de la boutique et Hagrid vous attend avec un animal.");
        int choice = animalChoice(scanner);
        Pet animalChosen = Pet.values()[choice - 1];
        System.out.println(ConsoleColors.BLUE +"\nHagrid vous demande alors comment vous allez l'appeler :" + ConsoleColors.RESET);
        String nameAnimal = scanner.nextLine();
        System.out.println("Dites bonjour à " + ConsoleColors.RED + nameAnimal + ConsoleColors.RESET + " votre " + ConsoleColors.RED + animalChosen.type + ConsoleColors.RESET + " !");
        System.out.println("\n\t __ Hagrid vous amène alors à la gare de Londres en vous donnant votre billet pour Poudlard voie 9_3/4 __");


    }

    private static int readGesture(Scanner scanner) {
        int gesture = 0;
        while (gesture != 1 && gesture != 2) {
            System.out.println(ConsoleColors.BLUE +"\nChoisissez un geste : "+ ConsoleColors.RESET);
            System.out.println("1 : Faire un petit geste\n2 : Faire un grand geste");
            try {
                gesture = scanner.nextInt();
                scanner.nextLine();
                if (gesture != 1 && gesture != 2) {
                    System.out.println("Le choix doit être 1 ou 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Le choix doit être un nombre.");
                scanner.nextLine();
            }
        }
        return gesture;
    }

    private static int animalChoice(Scanner scanner) {
        int choice = 0;
        while (choice < 1 || choice > Pet.values().length) {
            System.out.println(ConsoleColors.BLUE +"\nChoisissez un animal : "+ ConsoleColors.RESET);
            for (Pet pet : Pet.values()) {
                System.out.println(pet.index + " : " + pet.type);
            }
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice < 1 || choice > Pet.values().length) {
                    System.out.println("Le choice doit être un nombre entre 1 et " + Pet.values().length + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Le choice doit être un nombre.");
                scanner.nextLine();
            }
        }
        return choice;
    }

}


