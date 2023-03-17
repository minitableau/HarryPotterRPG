package Level;

import GameElement.*;
import utils.ConsoleColors;

import java.util.*;

public class Level1 {

    public static void level1(Wizard wizard) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nVous arrivez dans le jardin de Poudlard pour votre premier cours, qui est un cours de vol sur balais. Madame Bibine, votre professeur, vous donne les directives \npour faire voler votre balai et très vite vous remarquez avoir quelques facilités par rapport aux autres élèves. Elle doit par la suite s'absenter pour une urgence \net interdit formellement à quiconque de voler. Mais Bartemius Croupton en a décidé autrement, il vole le collier de Fleur Delacour et s'enfuit avec. \nIl vous met alors au défi de venir le chercher. Que décidez-vous de faire ?");
        // reconforter ou aller chercher le colier -> si chercher alors + amité + quiditch mais reprerer par M. magnonagan -point pour votre maison
        int flyingLesson = flyingLesson();
        // explorer l'ecole ou se faire de nouveau ami. -> si explorer l'ecole vous vous retrouver au 3 etages apprener l'existance de fluffy chien a 3 tete qui garde une trape sinon vous devenz ami avec  Dean Thomas
        int exploreOrMakeNewFriend = exploreOrMakeNewFriend(wizard);
        System.out.println("Vous assistez au cours de levitation où vous apprenez le sort WINGARDIUM LEVIOSA. Vous avez un peu de mal alors que votre amie Fleur réussit du premier coup. \nElle essaie donc de vous aider en vous donnant une meilleure prononciation : \"WINGARDIUM LEVI-OOO-SA\", mais cela fait rire vos camarades. \nElle quitte donc le cours pour aller pleurer dans les toilettes. Le professeur vous explique les modalités pour utiliser le sort lorsque nous somme un élève \nde premiere année : \"il vous faut être à 7 mètres ou moins pour que le sort est une chance de réussir, tout en sachant que plus vous êtes \nproche de l'objet à déplacer plus vos chances sont élevés\n");
        wizard.addSpell(Spell.windgardiumLeviosa);
        // FAIRE EN SORTE QUE SI AMIE ALORS NE PAS ETre SEUL ET ARRIVER AVEC SES AMIs
        List<Friend> listFriendsWithYou = listFriendsWithYou(wizard);
        String friends = nameFriendsWithYou(wizard, listFriendsWithYou);

        // à la place de retourner la chaine de caractère retourner la liste des amis concerner pour pouvoir reutiliser apres.

        System.out.println("Quelque minutes plus tard un professeur arrive en paniquant dans votre cours, il annonce qu'un Troll c'est échappé et ce balade dans l'école. \nTous les élèves se mettent à crier dans tout les sens. Mais pas vous, vous pensez directement à Fleur qui est parti pleurer au toilette et n'a pas l'information. \nAinsi, à la place de suivre tout les autres et évacuer l'école pour se rendre dans le jardin vous allez en direction des toilettes des filles pour aider votre amie.\nVous réussissez à convaincre " + friends + "de venir avec vous.");
        //comnbat troll : vous arrivez proche des toilettes et etendant crier vous courez alors encore plus vite et voyer le troll entrain de fracasser les toilettes. Vous engagez alors le comnat pour sauver votre amie.

        //SET TROLL ICI
        Enemy enemy = Enemy.troll;
        boolean trollAlive = false;
        boolean wizardAlive = false;
        while (enemy.getDistance() >= 1 && !trollAlive && !wizardAlive) {
            trollAlive = wizardAttackTroll(wizard, enemy);
            if (enemy.getDistance() < 1) {
                break;
            }
            if (trollAlive) {
                break;
            }
            for (int i = 0; i < listFriendsWithYou.size(); i++) {
                System.out.println("\nVotre ami " + listFriendsWithYou.get(i).getName() + " peut aussi attaquer le troll.");
                trollAlive = wizardAttackTroll(wizard, enemy);
                if (enemy.getDistance() < 1) {
                    break;
                }
                if (trollAlive) {
                    break;
                }
            }
            if (enemy.getDistance() < 1) {
                break;
            }
            if (trollAlive) {
                break;
            }
            wizardAlive = trollAttackWizard(wizard, enemy);

        }

        if (enemy.getDistance() < 1) {
            System.out.println("Quel idée de se coller à un troll ! Celui-ci vous attrape et vous mange.");
        }

        if (trollAlive) {
            System.out.println("Vous avez vaincu le troll !");
        }

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
                    // gagner point d'amitié ?
                    System.out.println("Madame Bibine revient, félicite la classe pour son sérieux et termine son cours. Elle vous libère quelque minutes en avance car vous avez était discipliné");
                }
                if (choice == 2) {
                    System.out.println("\nVous vous engagez dans une course-poursuite contre Bartemius Croupton. Vous parvenez à le rattraper, mais il décide alors de lancer le collier en direction du lac. \nVous accélérez et réussissez à rattraper le collier juste avant qu'il ne tombe dans l'eau. Vous revenez donc avec le groupe, cependant Madame Bibine est revenu et vous êtes donc \npuni : votre maison perd 30 points. Malgré tout, votre professeur vous propose d'intégrer l'équipe de Quidditch car elle a été impressionnée par votre performance.\n");
                    // faire maison perd 30 points
                    // faire intégrer équipe Quidditch
                    System.out.println("Après quelque explication en retenu votre professeur comprend les motivations de ce vol interdit, elle vous laisse donc partir quelque minutes en avance.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Le choix doit être un nombre.");
                scanner.nextLine();
            }
        }
        return choice;
    }

    private static int exploreOrMakeNewFriend(Wizard wizard) {
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
                    System.out.println("\nVous explorez l'école avec votre ami Fleur Delacour. Vous vous perdez plus ou moins et vous vous retrouver devant une porte verrouillé au 3ème étage \ndans la zone interdite au élève. Soudain vous entendez, des bruits de pas derriere vous. Fleur Delacour utilise un sort qu'elle connait qui permet de déverrouiller \ndes portes : \"Aloomora\". Vous vous cachez derrière celle-ci. Vous vous retournez et apercevais un énorme chien à trois têtes qui dort sur une trappe. \nVous ne faite pas de bruit et attendais un peu jusqu'a ce qu'il n'y ai plus de bruit de pas.\n");
                    // ajouter une nouvelle information
                    wizard.addSpell(Spell.aloomora);
                }
                if (choice == 2) {
                    System.out.println("\nVous essayer de sociabiliser, sympathisé avec un élève de votre maison prénommé Dean Thomas.");
                    wizard.addFriend(new Friend("Dean Thomas", wizard.getHouse()));
                }
            } catch (InputMismatchException e) {
                System.out.println("Le choix doit être un nombre.");
                scanner.nextLine();
            }
        }
        return choice;
    }

    private static List<Friend> listFriendsWithYou(Wizard wizard) {
        List<Friend> listFriendsWithYou = new ArrayList<>();
        if (wizard.getFriends().size() != 0) {
            for (int i = 0; i < wizard.getFriends().size(); i++) {
                House house = wizard.getFriends().get(i).getHouse();
                if (house == wizard.getHouse() && wizard.getFriends().get(i).getName() != "Fleur Delacour") {
                    listFriendsWithYou.add(wizard.getFriends().get(i));

                }
            }
        }
        return listFriendsWithYou;
    }

    private static String nameFriendsWithYou(Wizard wizard, List<Friend> listFriendsWithYou) {
        String friends = "";
        if (listFriendsWithYou.size() != 0) {
            for (Friend friend : listFriendsWithYou) {
                friends += friend.getName() + ", ";
            }
        } else {
            friends += "personne ";
        }
        return friends;
    }

    private static boolean wizardAttackTroll(Wizard wizard, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        int distanceFromTroll = enemy.getDistance();
        int trollLife = enemy.getLifePoints();
        boolean success = false;
        boolean comeback = true;

        while (comeback) { //distanceFromTroll >= 1 && !success &&
            String stats = wizard.stats(wizard.getName(), wizard.getLifePoint(), wizard.getMaxLifePoint(), wizard.getMana(), wizard.getResistanceBonus(), wizard.getPowerBonus(),wizard.getAccuracyBonus(), wizard.getEfficiencyPotionsBonus(), wizard.getMoney());
            System.out.println(stats);
            System.out.println(ConsoleColors.BLUE + "\nQue voulez-vous faire sachant que le troll se situe à " + distanceFromTroll + " mètres et à " + trollLife + " points de vie ?" + ConsoleColors.RESET);
            System.out.println("1 : Jeter des bouts de bois");
            System.out.println("2 : Se rapprocher");
            System.out.println("3 : Utiliser Windgardium Leviosa");
            System.out.println("4 : Ouvrir votre sac");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice < 1 || choice > 4) {
                    System.out.println("Le choix doit être 1, 2, 3 ou 4.");
                    continue;
                }

                switch (choice) {
                    case 1 -> {
                        int dommage = 20 + (20 * wizard.getPowerBonus()) / 100;
                        System.out.println("Vous jetez des bouts de bois sur le troll. Il perd " + dommage + " points de vie");
                        enemy.setLifePoints(enemy.getLifePoints() - dommage);
                        if (enemy.getLifePoints() <= 0) {
                            return true;
                        }
                        comeback = false;
                    }
                    case 2 -> {
                        System.out.println("Vous vous rapprochez du troll.");
                        enemy.setDistance(enemy.getDistance() - 1);
                        comeback = false;
                    }
                    // s'occuper de ca avec creation des sorts
                    case 3 -> {
                        int chanceOfSuccess = 0;
                        if (enemy.getDistance() <= 7) {
                            System.out.println("Vous utilisez Windgardium Leviosa sur la massue du troll !");
                            chanceOfSuccess = 100 - (enemy.getDistance() * 5) + wizard.getAccuracyBonus();
                            System.out.println("Vous êtes à " + enemy.getDistance() + " mètres du troll. Votre chance de réussite est de " + chanceOfSuccess + "%.");
                            Random random = new Random();
                            int randomValue = random.nextInt(101);
                            if (randomValue <= chanceOfSuccess) {
                                System.out.println("Votre sort atteint la massue du troll, vous diriger alors la massue plusieurs mètres au dessus de ca tete et la laisser tombé ce qui assomme le troll.");
                                return true;
                            } else {
                                System.out.println("Vous ratez votre sort de justesse.");
                            }
                        } else {
                            System.out.println("Vous êtes à " + enemy.getDistance() + " mètres du troll. Votre chance de réussite est de " + chanceOfSuccess + "%., si vous aviez mieux écouter le cours vous sauriez que pour utiliser Windgarium leviosa \nil faut etre à 7 mètres ou moins pour que le sort est une chance de reussir et que plus vous etes proche plus vous augementer vos chances.");
                        }
                        comeback = false;
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
        return false;
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
        int numPotions = wizard.getPotions().size();
        if (numPotions == 0) {
            System.out.println("Vous n'avez aucune potion disponible.");
            return true;
        } else {
            System.out.println(ConsoleColors.BLUE + "\nVeuillez choisir une potion :" + ConsoleColors.RESET);
            for (int i = 0; i < numPotions; i++) {
                System.out.println((i + 1) + " : " + wizard.getPotions().get(i).getName());
            }
            System.out.println((numPotions + 1) + " : Retourner dans le sac");
            int choice = -1;
            do {
                Scanner scanner = new Scanner(System.in);
                try {
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > numPotions + 1) {
                        System.out.println("Veuillez entrer un choix valide.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer un choix valide.");
                    scanner.next();
                }
            } while (choice < 1 || choice > numPotions + 1);
            if (choice == numPotions + 1) {
                return true;
            }
            Potion chosenPotion = wizard.getPotions().get(choice - 1);
            System.out.println("Vous avez choisi la " + chosenPotion.getName() + ".");
            if (chosenPotion == Potion.potionHeal) {
                wizard.setLifePoint(wizard.getLifePoint() + chosenPotion.getValue());
//                wizard.setMaxLifePoint(wizard.getMaxLifePoint() + chosenPotion.getValue());
                wizard.getPotions().remove(choice - 1);
            } else if (chosenPotion == Potion.potionDamage) {
                wizard.setPowerBonus(wizard.getPowerBonus() + chosenPotion.getValue());
                wizard.getPotions().remove(choice - 1);
            } else if (chosenPotion == Potion.potionResistance) {
                wizard.setResistanceBonus(wizard.getResistanceBonus() + chosenPotion.getValue());
                wizard.getPotions().remove(choice - 1);
            } else if (chosenPotion == Potion.potionPrecision) {
                wizard.setAccuracyBonus(wizard.getAccuracyBonus() + chosenPotion.getValue());
                wizard.getPotions().remove(choice - 1);
            }

        }
        return false;
    }

    private static boolean findItems(Wizard wizard) {
        int numItems = wizard.getItems().size();
        if (numItems == 0) {
            System.out.println("Vous n'avez aucun objet disponible.");
            return true;
        } else {
            System.out.println(ConsoleColors.BLUE + "\nVeuillez choisir un objet :" + ConsoleColors.RESET);
            for (int i = 0; i < numItems; i++) {
                System.out.println((i + 1) + " : " + wizard.getItems().get(i).getName());
            }
            System.out.println((numItems + 1) + " : Retourner dans le sac");
            int choice = -1;
            do {
                Scanner scanner = new Scanner(System.in);
                try {
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > numItems + 1) {
                        System.out.println("Veuillez entrer un choix valide.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer un choix valide.");
                    scanner.next();
                }
            } while (choice < 1 || choice > numItems + 1);
            if (choice == numItems + 1) {
                return true;
            }
            Item chosenItem = wizard.getItems().get(choice - 1);
            // Appliquer l'effet + .remove(choice-1)
            System.out.println("Vous avez choisi la " + chosenItem.getName() + ".");


        }
        return false;
    }

    private static boolean trollAttackWizard(Wizard wizard, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        int wizardLife = wizard.getLifePoint();
        int chanceOfSuccess = 0;
        chanceOfSuccess = 40 + listFriendsWithYou(wizard).size() * 20;
        System.out.println("\nVous êtes " + (int) (listFriendsWithYou(wizard).size() + 1) + " contre le troll. La probabilité qu'il vous touche est de " + chanceOfSuccess + "%.");
        Random random = new Random();
        int randomValue = random.nextInt(101);
        if (randomValue <= chanceOfSuccess) {
            int dommage = Enemy.troll.getDommage() - (Enemy.troll.getDommage() * wizard.getResistanceBonus()) / 100;
            wizard.setLifePoint(wizardLife - dommage);
            System.out.println("La massue du troll, vous frappe et vous enlève " + dommage + " points de vie.");
            if (wizard.getLifePoint() <= 0) {
                System.out.println("Vous êtes mort! Le troll vous a vaincu.");
                return true;
            }
        } else {
            System.out.println("Le troll essaie de vous frapper avec ca massue mais vous arrivez à l'éviter.");
        }
        return false;
    }
}


