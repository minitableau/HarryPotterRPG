package Game;

import GameElement.*;
import utils.ConsoleColors;
import utils.ScrollingText;


import java.util.Random;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws InterruptedException {
//        level0();
        level1();
    }

    public static void level0() throws InterruptedException {

        int money = 100;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String hagridArrivalMessage = "Vous entendez frapper à la porte. En l'ouvrant, vous trouvez un homme gigantesque, un demi-géant, avec une barbe sauvage et des yeux pétillants.\n" +
                "\"Bonjour, je suis Rubeus Hagrid gardien des clés et des lieux à Poudlard\", dit-il en souriant. \"Je viens chercher un jeune sorcier de 11 ans pour l'emmener à Poudlard.\n" + ConsoleColors.BLUE + "Et vous êtes...?" + ConsoleColors.RESET;

        ScrollingText.printWithDelay(hagridArrivalMessage);
        String name = scanner.nextLine();
        String messageFournitures = "Hagrid sourit à votre réponse, puis reprend : \"Très bien, " + ConsoleColors.RED + name + ConsoleColors.RESET + ". Avant de partir pour Poudlard, il y a quelques formalités à régler.\n" +
                "Tout d'abord, il vous faut  vos fournitures un chaudron standard en étain, un animal de compagnie et une baguette. Suivez-moi !\"\n" + ConsoleColors.ITALIC + "\n\tHagrid vous emmène à Londres à l'arrière d'un bar et vous fait découvrir un lieu magique nommé le chemin de traverse.\n" + ConsoleColors.RESET;
        ;
        System.out.println(messageFournitures);

        Wand wand1 = new Wand();
        Core core1 = wand1.getCore();

        System.out.println("Vous découvrez une rue pleine de boutiques en tout genre : magasin d'animaux, de balais, baguette magique et une banque. \nVous passez à la Gringotts banque récupérer votre argent dans le coffre 687. Le goblin vous indique que vous disposez de " + ConsoleColors.RED + money + ConsoleColors.RESET + " mornilles.\nVous passez ensuite chez Olivenders acheter votre baguette. Il vous reconnaît directement et se rappelle très bien des baguettes de vos parents,\nil vous tend alors une baguette faite avec un coeur en " + ConsoleColors.RED + wand1.getCore().type + ConsoleColors.RESET + " faisant " + ConsoleColors.RED + wand1.getSize() + " cm" + ConsoleColors.RESET + " et vous demande de faire le geste.");
        int gesture = readGesture(scanner);
        System.out.println(ConsoleColors.RED + "\nVous tuez le poisson de M. Olivander \n" + ConsoleColors.RESET);

        Core core;
        Wand wand;
        do {
            wand = new Wand();
            core = wand.getCore();
        } while (core == core1);

        int size = wand.getSize();
        System.out.println("\"Heu non sûrement pas celle-ci !\" s'exclame-t-il. \nIl vous tend alors une autre baguette dont le coeur est en " + ConsoleColors.RED + wand.getCore().type + ConsoleColors.RESET + " faisant " + ConsoleColors.RED + wand.getSize() + " cm" + ConsoleColors.RESET + " et vous demande de faire à nouveau le geste.");
        gesture = readGesture(scanner);
        System.out.println("\nM. Olivender n'en revient pas ! Il connait toutes les baguettes qu'il vend et celle qui vous à choisi est faite à partir de " + ConsoleColors.RED + core.type + ConsoleColors.RESET + " il est persuadé \nque vous aller accomplir de grandes choses car il y peu de sorciers qui ont des baguettes faite à partir de " + ConsoleColors.RED + core.type + ConsoleColors.RESET + " et ils se sont tous démarqués !\nVous sortez de la boutique et Hagrid vous attend avec un animal.");
        int animalChoice = animalChoice(scanner);
        Pet animalChosen = Pet.values()[animalChoice - 1];
        System.out.println(ConsoleColors.BLUE + "\nHagrid vous demande alors comment vous allez l'appeler :" + ConsoleColors.RESET);
        String nameAnimal = scanner.nextLine();
        System.out.println("Dites bonjour à " + ConsoleColors.RED + nameAnimal + ConsoleColors.RESET + " votre " + ConsoleColors.RED + animalChosen.type + ConsoleColors.RESET + " !\n" + ConsoleColors.ITALIC + "\n\tHagrid vous amène alors à la gare de Londres en vous donnant votre billet pour Poudlard voie 9_3/4" + ConsoleColors.RESET + "\n\nVous demandez à un groupe de jeunes un peu plus âgés qui ont le même style de bagage que vous : Comment se rendre à la voie 9_3/4. \nTrès gentiment, ils vous montrent le chemin : il faut foncer dans un pilier ! \nVous foncez dans le pilier avec un peu d'appréhension, mais vous arrivez bien sur le quai. Le train s'apprête à partir, vous décidez alors de monter à bord du Poudlard Express. \nVous rejoignez votre cabine, déposez vos affaires et : ");
        int trainChoice = trainChoice(scanner);
        SortingHat sortingHat = new SortingHat();
        House[] houses = sortingHat.houses;
        System.out.println("Vous retrouvez Hagrid sur le quai qui demande a tous les passagers de le suivre pour les amener au porte de Poudlard où le professeur McGonagall vous attend.\nUne fois arriver professeur McGonagall vous souhaite la bienvenue à Poudlard et vous explique que vous aller être réparti dans différentes maison, \nelles ont pour nom : "
                + houses[0] + ", " + houses[1] + ", " + houses[2] + ", " + houses[3]
                + ". \nPendant votre séjour à l'école, votre maison sera comme votre deuxième famille. Vos réussites rapporteront des points à votre maison et les infractions vous en feront perdre. \nÀ la fin de chaque année, la maison avec le plus de points gagnera une coupe. Tout est près vous allez pouvoir rentrer !\nVous entrez et arrivez dans une grande salle de reception où les élèves plus agés vous attendent, au bout de celle-ci vous apercevais un chapeau étrange \navec derrière lui plusieurs professeurs. Un très vielle homme au centre se lève prend la parole : \nBonjour à tous ! Je suis Albus Dumbledore le directeur de Poudlard, avant que la cérémonie de répartition ne commence je souhaite vous énoncer quelques règles à respecter : \n\tIl est formellement interdit de pénétrer dans la foret.\n\tD'autre part, le consierge M. Rusard souhaite vous rappelez que le couloir du troisième étage de l'aile droite est également interdit à toute personne qui ne veut pas mourir !\nJe déclare la cérémonie de répartition ouverte. Lorsque je vous appellerai, avancez-vous, je placerai alors le choixpeau magique sur votre tête et il vous donnera votre maison.\nCommençons," + ConsoleColors.RED + " Eloise Midgen" + ConsoleColors.RESET + " !");
        House eloiseHouse = sortingHat.sort();
        System.out.println("\t- " + ConsoleColors.ORANGE + "Choixpeau" + ConsoleColors.RESET + " : \"Hhhaa voyons voir, Hummm ok " + eloiseHouse + " !\"\nAu tour de : " + ConsoleColors.RED + "Vincent Crabbe" + ConsoleColors.RESET + " !");
        House vincentHouse = sortingHat.sort();
        System.out.println("\t- " + ConsoleColors.ORANGE + "Choixpeau" + ConsoleColors.RESET + " : \"Hummm avec toi pas la moindre hesitation " + vincentHouse + " !\"\nPuis : " + ConsoleColors.RED + name + ConsoleColors.RESET + " !");
        House characterHouse = sortingHat.sort(scanner);
        System.out.println("\n\t- " + ConsoleColors.ORANGE + "Choixpeau" + ConsoleColors.RESET + " : \"Disons " + characterHouse + " !\"");
        Wizard wizard = new Wizard(name, animalChosen, wand, characterHouse);
        System.out.println("Vous allez vous asseoir avec votre maison et rencontrer : Fleur Delacour qui à l'air de connaitre beaucoup de chose sur la magie. Elle devient votre ami. Vous rencontrer aussi Bartemius Croupton qui se moque de vous et votre amie.");

    }

    public static void level1() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        // Cours de balais votre professeur s'abscente, ennemy vole la colier de votre ami et s'envole avec, vous met au defi de venir le chercher alors que c'est interdit.
        System.out.println("Vous arrivez dans le jardin de Poudlard pour votre premier cours, qui est un cours de vol sur balais. Madame Bibine, votre professeur, vous donne les directives \npour faire voler votre balai et très vite vous remarquez avoir quelques facilités par rapport aux autres élèves. Elle doit par la suite s'absenter pour une urgence \net interdit formellement à quiconque de voler. Mais Bartemius Croupton en a décidé autrement, il vole le collier de Fleur Delacour et s'enfuit avec. \nIl vous met alors au défi de venir le chercher. Que décidez-vous de faire ?");
        // reconforter ou aller chercher le colier -> si chercher alors + amité + quiditch mais reprerer par M. magnonagan -point pour votre maison
        int flyingLesson = flyingLesson(scanner);
        // explorer l'ecole ou se faire de nouveau ami. -> si explorer l'ecole vous vous retrouver au 3 etages apprener l'existance de fluffy chien a 3 tete qui garde une trape sinon vous devenz ami avec  Dean Thomas
        int exploreOrMakeNewFriend = exploreOrMakeNewFriend(scanner);
        // Cours de levitation - apprentissage du sort WINGARDIUM levi oooo sa Fleur reussi du premier coup et essaye de vous aider, elle vous donne une meilleure prononciation mais cela fait rire vos camarades. Elle quitte donc le cours pour aller pleurer dans les toilettes.
        System.out.println("Vous assistez au cours de levitation où vous apprenez le sort WINGARDIUM LEVIOSA. Vous avez un peu de mal alors que votre amie Fleur réussit du premier coup. Elle essaie donc de vous aider en vous donnant une meilleure prononciation : \"WINGARDIUM LEVI-OOO-SA\", mais cela fait rire vos camarades. Elle quitte donc le cours pour aller pleurer dans les toilettes. Le professeur vous explique les modalités pour utiliser le sort lorsque nous somme un élève de premiere année : \"il vous faut être à 7 mètres ou moins pour que le sort est une chance de réussir, tout en sachant que plus vous êtes proche de l'objet à déplacer plus vos chances sont élevés\n");
        // FAIRE EN SORTE QUE SI AMIE ALORS NE PAS ETre SEUL ET ARRIVER AVEC SES AMIs
        System.out.println("Quelque minutes plus tard un professeur arrive en paniquant dans votre cours, il annonce qu'un Troll c'est échappé et ce balade dans l'école. Tout les élèves se mettent à crier dans tout les sens. Mais pas vous, vous pensez directement à Fleur qui est parti pleurer au toilette et n'a pas l'information. Ainsi, à la place de suivre tout les autres et évacuer l'école pour se rendre dans le jardin vous allez en direction des toilettes des filles pour aider votre amie.");
        // comnbat troll : vous arrivez proche des toilettes et etendant crier vous courez alors encore plus vite et voyer le troll entrain de fracasser les toilettes. Vous engageez alors le comnat pour sauver votre amie.
        attackTroll(scanner);
//        if (exploreOrMakeNewFriend == 2){
//            System.out.println("Votre ami peut aussi attaquer le troll.");
//        }
    }

    //level0

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
            System.out.println("1 : choisissez de dormir\n2 : choisissez d'aller à la rencontre des autres passagers");
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

    //level1 flyingLesson
    private static int flyingLesson(Scanner scanner) {
        int choice = 0;
        while (choice != 1 && choice != 2) {
            System.out.println(ConsoleColors.BLUE + "\nChoisissez ce que vous voulez faire : " + ConsoleColors.RESET);
            System.out.println("1 : Réconforter Fleur Delacour\n2 : Désobéir et s'envoler pour aller récupérer le collier");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice != 1 && choice != 2) {
                    System.out.println("Le choix doit être 1 ou 2.");
                }
                if (choice == 1) {
                    System.out.println("\nVous ne répondait pas à la provocation de Bartemius Croupton et essayer réconforter Fleur Delacour, cela fonctionne assez bien mais elle reste triste. ");
                    // gagner point d'amité
                    System.out.println("Madame Bibine revient, félicite la classe pour son sérieux et termine son cours. Elle vous libère quelque minutes en avance car vous avez était discipliné");
                }
                if (choice == 2) {
                    System.out.println("\nVous vous engagez dans une course-poursuite contre Bartemius Croupton. Vous parvenez à le rattraper, mais il décide alors de lancer le collier en direction du lac. \nVous accélérez et réussissez à rattraper le collier juste avant qu'il ne tombe dans l'eau. Vous revenez donc avec le groupe, cependant Madame Bibine est revenu et vous êtes donc \npuni : votre maison perd 30 points. Malgré tout, votre professeur vous propose d'intégrer l'équipe de Quidditch car elle a été impressionnée par votre performance.\n");
                    // faire maison perd 30 points
                    // faire intégrer équipe Quidditch
                    // gagner nouveau ami ?
                    System.out.println("Après quelque explication en retenu votre professeur comprend les motivations de ce vol interdit, elle vous laisse donc partir quelque minutes en avance.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Le choix doit être un nombre.");
                scanner.nextLine();
            }
        }
        return choice;
    }

    private static int exploreOrMakeNewFriend(Scanner scanner) {
        int choice = 0;
        while (choice != 1 && choice != 2) {
            System.out.println(ConsoleColors.BLUE + "\nChoisissez ce que vous voulez faire : " + ConsoleColors.RESET);
            System.out.println("1 : Explorer l'école\n2 : Se faire de nouveaux amis");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice != 1 && choice != 2) {
                    System.out.println("Le choix doit être 1 ou 2.");
                }
                if (choice == 1) {
                    System.out.println("\nVous explorez l'école avec votre ami Fleur Delacour. Vous vous perdez plus ou moins et vous vous retrouver devant une porte verrouillé au 3ème étage \ndans la zone interdite au élève. Soudain vous entendez, des bruits de pas derriere vous. Fleur Delacour utilise un sort qu'elle connait qui permet de déverrouiller \ndes portes : \"Aloomora\". Vous vous cachez derrière celle-ci. Vous vous retournez et apercevais un énorme chien à trois têtes qui dort sur une trappe. \nVous ne faite pas de bruit et attendais un peu jusqu'a ce qu'il n'y ai plus de bruit de pas.");
                    // ajouter une nouvelle information
                    // ajouter le sort aloomora
                }
                if (choice == 2) {
                    System.out.println("\nVous essayer de sociabiliser, sympathisé avec un élève de votre maison prénommé Dean Thomas.");
                    // ajouter nouveau ami + amitié
                }
            } catch (InputMismatchException e) {
                System.out.println("Le choix doit être un nombre.");
                scanner.nextLine();
            }
        }
        return choice;
    }

    private static void attackTroll(Scanner scanner) {
        int distanceFromTroll = 10;
        int chanceOfSuccess = 0;
        int trollLife = 100;
        boolean success = false;

        while (distanceFromTroll >= 1 && !success) {
            //Indiquez la vie du troll
            System.out.println(ConsoleColors.BLUE + "\nQue voulez-vous faire sachant que le troll se situe à " + distanceFromTroll + " mètres et à " + trollLife + " points de vie ?" + ConsoleColors.RESET);
            System.out.println("1 : Jeter des bouts de bois");
            System.out.println("2 : Se rapprocher");
            System.out.println("3 : Utiliser Windgardium Leviosa");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice < 1 || choice > 3) {
                    System.out.println("Le choix doit être 1, 2, ou 3.");
                    continue;
                }

                switch (choice) {
                    case 1 -> {
                        int dommage = 20;
                        System.out.println("Vous jetez des bouts de bois sur le troll. Il perd " + dommage + " points de vie");
                        trollLife -= dommage;
                        if (trollLife <= 0) {
                            success = true;
                        }
                    }
                    case 2 -> {
                        System.out.println("Vous vous rapprochez du troll.");
                        distanceFromTroll -= 1;
                    }
                    case 3 -> {
                        if (distanceFromTroll <= 7) {
                            System.out.println("Vous utilisez Windgardium Leviosa sur la massue du troll !");
                            chanceOfSuccess = 100 - (distanceFromTroll * 5);
                            System.out.println("Vous êtes à " + distanceFromTroll + " mètres du troll. Votre chance de réussite est de " + chanceOfSuccess + "%.");
                            Random random = new Random();
                            int randomValue = random.nextInt(101);
                            if (randomValue <= chanceOfSuccess) {
                                success = true;
                                System.out.println("Votre sort atteint la massue du troll, vous diriger alors la massue plusieurs mètres au dessus de ca tete et la laisser tombé ce qui assomme le troll.");
                            } else {
                                System.out.println("Vous ratez votre sort de justesse.");
                            }
                        } else {
                            System.out.println("Vous êtes à " + distanceFromTroll + " mètres du troll. Votre chance de réussite est de " + chanceOfSuccess + "%., si vous aviez mieux écouter le cours vous sauriez que pour utiliser Windgarium leviosa il faut etre à 7 mètres ou moins pour que le sort est une chance de reussir et que plus vous etes proche plus vous augementer vos chances.");
                        }
                    }
                }


            } catch (InputMismatchException e) {
                System.out.println("Le choix doit être un nombre.");
                scanner.nextLine();
            }
        }

        if (distanceFromTroll < 1) {
            System.out.println("Quel idée de se coller à un troll ! Celui-ci vous attrape et vous mange.");
        }

        if (success) {
            System.out.println("Vous avez vaincu le troll !");
        }
    }


}


