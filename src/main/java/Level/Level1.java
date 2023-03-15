package Level;

import GameElement.Item;
import GameElement.Potion;
import GameElement.Wizard;
import utils.ConsoleColors;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Level1 {

    public static void level1(Wizard wizard) throws InterruptedException {
//        Scanner scanner = new Scanner(System.in);
//        // Cours de balais votre professeur s'abscente, ennemy vole la colier de votre ami et s'envole avec, vous met au defi de venir le chercher alors que c'est interdit.
//        System.out.println("Vous arrivez dans le jardin de Poudlard pour votre premier cours, qui est un cours de vol sur balais. Madame Bibine, votre professeur, vous donne les directives \npour faire voler votre balai et très vite vous remarquez avoir quelques facilités par rapport aux autres élèves. Elle doit par la suite s'absenter pour une urgence \net interdit formellement à quiconque de voler. Mais Bartemius Croupton en a décidé autrement, il vole le collier de Fleur Delacour et s'enfuit avec. \nIl vous met alors au défi de venir le chercher. Que décidez-vous de faire ?");
//        // reconforter ou aller chercher le colier -> si chercher alors + amité + quiditch mais reprerer par M. magnonagan -point pour votre maison
//        int flyingLesson = flyingLesson();
//        // explorer l'ecole ou se faire de nouveau ami. -> si explorer l'ecole vous vous retrouver au 3 etages apprener l'existance de fluffy chien a 3 tete qui garde une trape sinon vous devenz ami avec  Dean Thomas
//        int exploreOrMakeNewFriend = exploreOrMakeNewFriend();
//        // Cours de levitation - apprentissage du sort WINGARDIUM levi oooo sa Fleur reussi du premier coup et essaye de vous aider, elle vous donne une meilleure prononciation mais cela fait rire vos camarades. Elle quitte donc le cours pour aller pleurer dans les toilettes.
//        System.out.println("Vous assistez au cours de levitation où vous apprenez le sort WINGARDIUM LEVIOSA. Vous avez un peu de mal alors que votre amie Fleur réussit du premier coup. \nElle essaie donc de vous aider en vous donnant une meilleure prononciation : \"WINGARDIUM LEVI-OOO-SA\", mais cela fait rire vos camarades. \nElle quitte donc le cours pour aller pleurer dans les toilettes. Le professeur vous explique les modalités pour utiliser le sort lorsque nous somme un élève \nde premiere année : \"il vous faut être à 7 mètres ou moins pour que le sort est une chance de réussir, tout en sachant que plus vous êtes \nproche de l'objet à déplacer plus vos chances sont élevés\n");
//        // FAIRE EN SORTE QUE SI AMIE ALORS NE PAS ETre SEUL ET ARRIVER AVEC SES AMIs
//        System.out.println("Quelque minutes plus tard un professeur arrive en paniquant dans votre cours, il annonce qu'un Troll c'est échappé et ce balade dans l'école. \nTous les élèves se mettent à crier dans tout les sens. Mais pas vous, vous pensez directement à Fleur qui est parti pleurer au toilette et n'a pas l'information. \nAinsi, à la place de suivre tout les autres et évacuer l'école pour se rendre dans le jardin vous allez en direction des toilettes des filles pour aider votre amie.");
//        //comnbat troll : vous arrivez proche des toilettes et etendant crier vous courez alors encore plus vite et voyer le troll entrain de fracasser les toilettes. Vous engageez alors le comnat pour sauver votre amie.
////        wizard.addPotion(Potion.potionHeal);
//
        attackTroll(wizard);
//        if (exploreOrMakeNewFriend == 2){
//            System.out.println("Votre ami peut aussi attaquer le troll.");
//        }
    }

    private static int flyingLesson() {
        Scanner scanner = new Scanner(System.in);
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

    private static int exploreOrMakeNewFriend() {
        Scanner scanner = new Scanner(System.in);
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

    private static void attackTroll(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        int distanceFromTroll = 10;
        int trollLife = 100;
        boolean success = false;
        boolean comeback = true;

        while (distanceFromTroll >= 1 && !success && comeback) {
            String stats = wizard.stats(wizard.getName(), wizard.getLifePoint(), wizard.getMaxLifePoint(), wizard.getMana(), wizard.getResistance(), wizard.getPower(), wizard.getMoney());
            System.out.println(stats);
            System.out.println(ConsoleColors.BLUE + "\nQue voulez-vous faire sachant que le troll se situe à " + distanceFromTroll + " mètres et à " + trollLife + " points de vie ?" + ConsoleColors.RESET);
            System.out.println("1 : Jeter des bouts de bois");
            System.out.println("2 : Se rapprocher");
            System.out.println("3 : Utiliser Windgardium Leviosa");
            System.out.println("4 : Ouvrir l'inventaire");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice < 1 || choice > 4) {
                    System.out.println("Le choix doit être 1, 2, 3 ou 4.");
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
                    // s'occuper de ca avec creation des sorts
                    case 3 -> {
                        int chanceOfSuccess = 0;
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
                    case 4 -> {
                        comeback = openBackpack(wizard);
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

    private static boolean openBackpack(Wizard wizard) {
        boolean comeback2 = true;
        Scanner scanner = new Scanner(System.in);
        while (comeback2) {
            System.out.println(ConsoleColors.BLUE + "\nVous ouvrez votre sac, souhaitez-vous prendre quelque chose ?" + ConsoleColors.RESET);
            System.out.println("1 : Chercher une potion");
            System.out.println("2 : Chercher un objet");
            System.out.println("3 : Refermer le sac");

            try {
                int backpackChoice = scanner.nextInt();
                scanner.nextLine();

                if (backpackChoice < 1 || backpackChoice > 3) {
                    System.out.println("Le choix doit être 1, 2, ou 3.");
                }

                switch (backpackChoice) {
                    case 1 -> {
                        comeback2 = findPotions(wizard);
                    }
                    case 2 -> {
                        comeback2 = findItems(wizard);
                    }
                    case 3 -> {
                        return true;
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Le choix doit être un nombre.");
                scanner.nextLine();
            }
        }
        return false;
    }

    private static boolean findPotions(Wizard wizard) {
        System.out.println("Potions disponibles :");
        if (wizard.getPotions().size() < 1) {
            System.out.println("Vous n'avez pas de potion");
            return true;
        }
        for (Potion potion : wizard.getPotions()) {
            System.out.println("- " + potion.getName());
            // proposer un choix de potion attention retour dispo
        }
        return false;
    }

    private static boolean findItems(Wizard wizard) {
        System.out.println("Objets disponibles :");
        if (wizard.getItems().size() < 1) {
            System.out.println("Vous n'avez pas d'objet");
            return true;
        }
        for (Item item : wizard.getItems()) {
            System.out.println("- " + item.getName());
            // proposer un choix d'objet attention retour dispo
        }
        return false;
    }
}


