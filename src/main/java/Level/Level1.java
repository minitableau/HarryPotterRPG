package Level;

import GameElement.*;
import utils.ConsoleColors;

import java.util.*;

public class Level1 {

    public static void level1(Wizard wizard) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nVous arrivez dans le jardin de Poudlard pour votre premier cours, qui est un cours de vol sur balais. Madame Bibine, votre professeur, vous donne les directives \npour faire voler votre balai et très vite vous remarquez avoir quelques facilités par rapport aux autres élèves. Elle doit par la suite s'absenter pour une urgence \net interdit formellement à quiconque de voler. Mais Bartemius Croupton en a décidé autrement, il vole le collier de Fleur Delacour et s'enfuit avec. \nIl vous met alors au défi de venir le chercher. Que décidez-vous de faire ?");
        int flyingLesson = flyingLesson(wizard);
        int exploreOrMakeNewFriend = exploreOrMakeNewFriend(wizard);
        System.out.println("Vous assistez au cours de levitation où vous apprenez le sort WINGARDIUM LEVIOSA. Vous avez un peu de mal alors que votre amie Fleur réussit du premier coup. \nElle essaie donc de vous aider en vous donnant une meilleure prononciation : \"WINGARDIUM LEVI-OOO-SA\", mais cela fait rire vos camarades. \nElle quitte donc le cours pour aller pleurer dans les toilettes. Le professeur vous explique les modalités pour utiliser le sort lorsque nous somme un élève \nde premiere année : \"il vous faut être à 7 mètres ou moins pour que le sort est une chance de réussir, tout en sachant que plus vous êtes \nproche de l'objet à déplacer plus vos chances sont élevés\n");
        wizard.addSpell(Spell.windgardiumLeviosa);
        List<Friend> listFriendsWithYou = listFriendsWithYou(wizard);
        String friends = nameFriendsWithYou(wizard, listFriendsWithYou);
        System.out.println("Quelque minutes plus tard un professeur arrive en paniquant dans votre cours, il annonce qu'un Troll c'est échappé et ce balade dans l'école. \nTous les élèves se mettent à crier dans tout les sens. Mais pas vous, vous pensez directement à Fleur qui est parti pleurer au toilette et n'a pas l'information. \nAinsi, à la place de suivre tout les autres et évacuer l'école pour se rendre dans le jardin vous allez en direction des toilettes des filles pour aider votre amie.\nVous réussissez à convaincre " + friends + "de venir avec vous.");
        //comnbat troll : vous arrivez proche des toilettes et etendant crier vous courez alors encore plus vite et voyer le troll entrain de fracasser les toilettes. Vous engagez alors le comnat pour sauver votre amie.
        Enemy enemy = Enemy.troll;
        fight(wizard, enemy, listFriendsWithYou);


        //Suite.


        // Peu de temps après un groupe de professeur arrive dans les toilettes et vous trouve avec le troll assommé au sol, il vous demande ce que vous faite là et la votre amie Fleur ce dénonce en disant qu'elle chercher a voir le troll de plus près pour étendre ces compétences et qu'elle pensait pouvoir le vaincre car elle avait beaucoup étudier sur les trolls.
        // Votre maison perd alors 10 points, mais les professeurs reconnaissent que battre ce troll avec les connaissances de premiere année relève de l'exploit. Font gagner à votre maison 10 point par personne ayant permis de battre ce troll.

        // Match de Quidish (pierre feuille ciseau)
        // Lacarum inflamarae -> permet d'enflammer un objet

        // Arrive la moitié de l'année et la période de noel, vous voyait tous les membres de votre maison recevoir des cadeaux et vous vous vous doutiez que vous n'aurait rien car vous n'avez jamais rien eu mais a votre grande surprise quand vous vous rendez à votre dortoir vous trouvez sur votre lit un cadeau d'un inconnu.
        // Il s'agit la d'une cape d'invisibilité.

        // Vous voulez essayer cette cape, choix : se rendre dans la reserve -> En apprendre plus sur Nicolas Flammel createur de la pierre philosopahale - et rend immortel (devenir riche metal en or)

        // Apprendre un sort interdit ? ou apprendre comment endormir fluffy.

        // quete secondaire :
        // if knowEndormir && explorerecole alors peux se rendre à fluffy
        // Vous remarquez que quelqu'un est passé avant vous car fluffy dort deja. Vous décidez donc de passer à votre tour
        // arrivez face à un plateau de TICTACTOE géant.
        // Si perdu vous perdez 24 point de vie et vous etes assomé vous vous retrouvez à l'hoptial votre maison perd 20 point.
        // Faire une partie si gagnée vous passez et rencontrer le Professeur Quirrell et donc VOldemort. Il essaie de vous tuez mais :
        //- vous arrivez a vous defendre, vous recuperer la pierre philosophale mais vous n'avez plus de force et vous vous reveillez à l'hopital. - dumbeldor vous dit qu'il à briser la pierre car trop puissante mais vous offre 100 morilles
        //- vous n'arrivez pas vous defendre, vous perdez -50point de vie et vous vous retrouvez à l'hoptial. Vous etes puni et votre maison perd 20 point


    }

    private static int flyingLesson(Wizard wizard) {
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
                    System.out.println("\nVous ne répondait pas à la provocation de Bartemius Croupton et essayer réconforter Fleur Delacour, cela fonctionne assez bien mais elle reste triste. Vous lui donnez alors 20 mornilles pour qu'elle puisse ce racheter un collier. ");
                    wizard.setMoney(wizard.getMoney() - 20);
                    System.out.println("Madame Bibine revient, félicite la classe pour son sérieux et termine son cours. Elle vous libère quelque minutes en avance car vous avez était discipliné");
                }
                if (choice == 2) {
                    System.out.println("\nVous vous engagez dans une course-poursuite contre Bartemius Croupton. Vous parvenez à le rattraper, mais il décide alors de lancer le collier en direction du lac. \nVous accélérez et réussissez à rattraper le collier juste avant qu'il ne tombe dans l'eau. Vous revenez donc avec le groupe, cependant Madame Bibine est revenu et vous êtes donc \npuni : votre maison perd 20 points. Malgré tout, votre professeur vous propose d'intégrer l'équipe de Quidditch car elle a été impressionnée par votre performance.\n");
                    wizard.setHousePoints(wizard.getHousePoints() - 20);
                    wizard.addKnowledge(Knowledge.quidditch);
                    System.out.println("Après quelques explications en retenu votre professeur comprend les motivations de ce vol interdit, elle vous laisse donc partir quelque minutes en avance.");
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
                    wizard.addKnowledge(Knowledge.fluffy);
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
            String stats = wizard.stats(wizard.getName(), wizard.getLifePoint(), wizard.getMaxLifePoint(), wizard.getMana(), wizard.getResistanceBonus(), wizard.getPowerBonus(), wizard.getAccuracyBonus(), wizard.getEfficiencyPotionsBonus(), wizard.getMoney());
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

    private static void fight(Wizard wizard, Enemy enemy, List<Friend> listFriendsWithYou) {
        boolean trollAlive = false;
        boolean wizardAlive = false;
        while (enemy.getDistance() >= 1 && !trollAlive && !wizardAlive) {
            trollAlive = wizardAttackTroll(wizard, enemy);
            if (enemy.getDistance() < 1) {
                wizardAlive = true;
                break;
            }
            if (trollAlive) {
                break;
            }
            for (int i = 0; i < listFriendsWithYou.size(); i++) {
                System.out.println("\nVotre ami " + listFriendsWithYou.get(i).getName() + " peut aussi attaquer le troll.");
                trollAlive = wizardAttackTroll(wizard, enemy);
                if (enemy.getDistance() < 1) {
                    wizardAlive = true;
                    break;
                }
                if (trollAlive) {
                    break;
                }
            }
            if (enemy.getDistance() < 1) {
                wizardAlive = true;
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
}


