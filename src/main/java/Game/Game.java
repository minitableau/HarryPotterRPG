package Game;

import GameElement.*;
import utils.ConsoleColors;

import java.util.Random;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        level0();
    }

    public static void level0() {

        int money = 100;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Vous entendez frapper à la porte. En l'ouvrant, vous trouvez un homme gigantesque, un demi-géant, avec une barbe sauvage et des yeux pétillants.\n" +
                "\"Bonjour, je suis Rubeus Hagrid gardien des clés et des lieux à Poudlard\", dit-il en souriant. \"Je viens chercher un jeune sorcier de 11 ans pour l'emmener à Poudlard.\n" + ConsoleColors.BLUE + "Et vous êtes...?" + ConsoleColors.RESET);
        String name = scanner.nextLine();
        System.out.println("Hagrid sourit à votre réponse, puis reprend : \"Très bien, " + ConsoleColors.RED + name + ConsoleColors.RESET + ". Avant de partir pour Poudlard, il y a quelques formalités à régler.\n" +
                "Tout d'abord, il vous faut  vos fournitures un chaudron standard en étain, un animal de compagnie et une baguette. Suivez-moi !");
        System.out.println(ConsoleColors.ITALIC + "\n\tHagrid vous emmène à Londres à l'arrière d'un bar et vous fait découvrir un lieu magique nommé le chemin de traverse.\n" + ConsoleColors.RESET);
        Core core1 = Core.values()[random.nextInt(Core.values().length)];
        System.out.println("Vous découvrez une rue pleine de boutiques en tout genre : magasin d'animaux, de balais, baguette magique et une banque. \nVous passez à la Gringotts banque récupérer votre argent dans le coffre 687. Le goblin vous indique que vous disposez de " + ConsoleColors.RED + money + ConsoleColors.RESET + " mornilles.\nVous passez ensuite chez Olivenders acheter votre baguette. Il vous reconnaît directement et se rappelle très bien des baguettes de vos parents,\nil vous tend alors une baguette faite avec un coeur en " + ConsoleColors.RED + core1.type + ConsoleColors.RESET + " et vous demande de faire le geste.");

        int gesture = readGesture(scanner);
        System.out.println(ConsoleColors.RED + "\nVous tuez le poisson de M. Olivander \n" + ConsoleColors.RESET);

        Core core2;
        do {
            core2 = Core.values()[random.nextInt(Core.values().length)];
        } while (core2 == core1);

        System.out.println("\"Heu non sûrement pas celle-ci !\" s'exclame-t-il. Il vous tend alors une autre baguette dont le coeur est en " + ConsoleColors.RED + core2.type + ConsoleColors.RESET + " et vous demande de faire à nouveau le geste.");
        gesture = readGesture(scanner);
        System.out.println("\nM. Olivender n'en revient pas ! Il connait toutes les baguettes qu'il vend et celle qui vous à choisi est faite à partir de " + ConsoleColors.RED + core2.type + ConsoleColors.RESET + " il est persuadé \nque vous aller accomplir de grandes choses car il y peu de sorciers qui ont des baguettes faite à partir de " + ConsoleColors.RED + core2.type + ConsoleColors.RESET + " et ils se sont tous démarqués !");
        System.out.println("Vous sortez de la boutique et Hagrid vous attend avec un animal.");
        int animalChoice = animalChoice(scanner);
        Pet animalChosen = Pet.values()[animalChoice - 1];
        System.out.println(ConsoleColors.BLUE + "\nHagrid vous demande alors comment vous allez l'appeler :" + ConsoleColors.RESET);
        String nameAnimal = scanner.nextLine();
        System.out.println("Dites bonjour à " + ConsoleColors.RED + nameAnimal + ConsoleColors.RESET + " votre " + ConsoleColors.RED + animalChosen.type + ConsoleColors.RESET + " !");
        System.out.println(ConsoleColors.ITALIC + "\n\tHagrid vous amène alors à la gare de Londres en vous donnant votre billet pour Poudlard voie 9_3/4" + ConsoleColors.RESET);
        System.out.println("\nVous demandez à un groupe de jeunes un peu plus âgés qui ont le même style de bagage que vous : Comment se rendre à la voie 9_3/4. \nTrès gentiment, ils vous montrent le chemin : il faut foncer dans un pilier ! \nVous foncez dans le pilier avec un peu d'appréhension, mais vous arrivez bien sur le quai. Le train s'apprête à partir, vous décidez alors de monter à bord du Poudlard Express. \nVous rejoignez votre cabine, déposez vos affaires et choisissez : ");
        int trainChoice = trainChoice(scanner);
        SortingHat sortingHat = new SortingHat();
        String[] houses = sortingHat.houses;
        System.out.println("Vous retrouvez Hagrid sur le quai qui demande a tous les passagers de le suivre pour les amener au porte de Poudlard où le professeur McGonagall vous attend.\nUne fois arriver professeur McGonagall vous souhaite la bienvenue à Poudlard et vous explique que vous aller être réparti dans différentes maison, \nelles ont pour nom : "
                + houses[0] + ", " + houses[1] + ", " + houses[2] + ", " + houses[3]
                + ". \nPendant votre séjour à l'école, votre maison sera comme votre deuxième famille. Vos réussites rapporteront des points à votre maison et les infractions vous en feront perdre. \nÀ la fin de chaque année, la maison avec le plus de points gagnera une coupe. Tout est près vous allez pouvoir rentrer !\nVous entrez et arrivez dans une grande salle de reception où les élèves plus agés vous attendent, au bout de celle-ci vous apercevais un chapeau étrange \navec derrière lui plusieurs professeurs. Un très vielle homme au centre se lève prend la parole : \nBonjour à tous ! Je suis Albus Dumbledore le directeur de Poudlard, avant que la cérémonie de répartition ne commence je souhaite vous énoncer quelques règles à respecter : \n\tIl est formellement interdit de pénétrer dans la foret.\n\tD'autre part, le consierge M. Rusard souhaite vous rappelez que le couloir du troisième étage de l'aile droite est également interdit à toute personne qui ne veut pas mourir !\nJe déclare la cérémonie de répartition ouverte. Lorsque je vous appellerai, avancez-vous, je placerai alors le choixpeau magique sur votre tête et il vous donnera votre maison.\nCommençons," + ConsoleColors.RED + " Eloise Midgen" + ConsoleColors.RESET + " !");
        String eloiseHouse = sortingHat.sort();
        System.out.println("\t- " + ConsoleColors.ORANGE + "Choixpeau" + ConsoleColors.RESET + " : \"Hhhaa voyons voir, Hummm ok " + eloiseHouse + " !\"");
        System.out.println("Au tour de : " + ConsoleColors.RED + "Vincent Crabbe" + ConsoleColors.RESET + " !");
        String vincentHouse = sortingHat.sort();
        System.out.println("\t- " + ConsoleColors.ORANGE + "Choixpeau" + ConsoleColors.RESET + " : \"Hummm avec toi pas la moindre hesitation " + vincentHouse + " !\"");
        System.out.println("Puis : " + ConsoleColors.RED + name + ConsoleColors.RESET + " !");
        String characterHouse = sortingHat.sort(scanner);
        System.out.println("\n\t- " + ConsoleColors.ORANGE + "Choixpeau" + ConsoleColors.RESET + " : \"Disons " + characterHouse + " !\"");
    }

    private static int readGesture(Scanner scanner) {
        int gesture = 0;
        while (gesture != 1 && gesture != 2) {
            System.out.println(ConsoleColors.BLUE + "\nChoisissez un geste : " + ConsoleColors.RESET);
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
            System.out.println(ConsoleColors.BLUE + "\nChoisissez un animal : " + ConsoleColors.RESET);
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

    private static int trainChoice(Scanner scanner) {
        int choice = 0;
        while (choice != 1 && choice != 2) {
            System.out.println(ConsoleColors.BLUE + "\nChoisissez ce que vous voulez faire : " + ConsoleColors.RESET);
            System.out.println("1 :de dormir\n2 : d'aller à la rencontre des autres passagers");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice != 1 && choice != 2) {
                    System.out.println("Le choix doit être 1 ou 2.");
                }
                if (choice == 1) {
                    System.out.println("\nVous vous couchez dans votre cabine et dormez jusqu'à ce que le train freine brutalement et qu'une voix vous annonce que vous êtes arrivé.");
                }
                // Eloise Midgen & Vincent Crabbe
                if (choice == 2) {
                    System.out.println("\nVous vous rendez à la cabine voisine ou vous apercevais deux jeunes plus ou moins de votre age. Vous décidez de toqué, vous entrez et entamé une discussion. \nVous faites la connaissance de " + ConsoleColors.RED + "Eloise Midgen " + ConsoleColors.RESET + "& " + ConsoleColors.RED + "Vincent Crabbe" + ConsoleColors.RESET + " tous deux en première année comme toi. Après plusieurs heures de discussion celle-ci s'interrompe \npour laisser place au bruit du train qui freine brutalement et à une voix qui vous annonce que vous êtes arrivé.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Le choix doit être un nombre.");
                scanner.nextLine();
            }
        }
        return choice;
    }
}


