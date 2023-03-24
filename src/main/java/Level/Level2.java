package Level;

import GameElement.*;
import GameElement.Character;
import utils.ConsoleColors;

import java.util.*;

public class Level2 {

    public static boolean tooth = false;

    public static void level2(Wizard wizard) throws InterruptedException {
        // Mais avant vous souhaitez faire le plein de fourniture pour cela vous utilisez une cheminée qui permet de transplaner, vous prononcez votre destination : \"chemin de traverse\". Et vous arrivez dans un petit magasin de potions :
        Market.market(wizard);
        // Dans cette meme boutique vous rencontrez un elfe de maison nommée Dobby qui vous met en garde qu'il ne faut pas retourner
        // à Poudlard cette année, car un complot se prépare. Vous ne prêtez pas attention, puisque c'est là-bas que vous êtes heureux.

        //Voilà les vacances terminées
        // Apprentissage d'oculuss reparo.

        //PROPOSER LE CHOIX DE NE PAS VOLER LA VOITURE MAIS RATEZ SON ANNEE ET REDOUBLER ?
        // Vous vous rendez à la gare, mais ratez le train à cause de ce petit elfe que vous avez rencontré chez le marchant de potion. Vous devez donc vous rendre à Poudlard par un autre moyen.
        // Vous savez qu'il existe une voiture volante appartenant au parent de Fleur ainsi vous allez chez fleur et emprunter
        // pour une durée indéterminée cette fameuse voiture.

        // Après plusieurs heures de voyage. Vous arrivez enfin à Poudlard, avec le retard que vous avez pris il est déjà l'heure de votre premier cours, il s'agit d'un cours de botanique avec le professeur Chourave.


        skipSchool(wizard);


        // Vous vous rendez ensuite au cours \"contre les forces du mal\" ou vous rencontrez le professeur Gilderoy Lockhart,
        // ce professeur lâche alors des lutins de Cornouaille dans la classe et vous observe vous débrouiller.
        // Heureusement votre amie fleur à continuer de progresser durant les vacances et utilise le Sort Immobulus qui
        // permet de ralentir très fortement le temps et vous permet de tous les attrapez. -> apprend Immobulus
        // + apprendre accio
        wizard.addSpell(Spell.accio);
        wizard.addSpell(Spell.immobulus);

        if (!wizard.getKnowledges().contains(Knowledge.quidditch)) {
            joinQuidditch(wizard);
        }


        // En vous promenant dans le couloir vous etendez une voix etrange provenant du mur. Peu de temps apres d'autre etudiant arrive, mais eux n'entende rien. La voix provenant du mur s'arrete et vous ecoutez la disscuiton des élèves a coté de vous ils font circuler la rumeurs qu'une certaine chambre des Secrets aurait été ouverte, dans laquel ce siturai un monstre. Cependant, vous n'y croyait pas et retourner a vos occupation en vous questionant sur la voix provenant du mur

        metamorphosisOrLibrary(wizard);

        // Vous vous dirigez vers votre dortoir et trouvez le chat de M. Rusard pétrifié à coté d'une eleve elle aussi pétrifié. M. Rusard arrive quelques secondes après et vous accuse d'avoir pétrifié son chat et cette élève. Vous etes donc convoqué chez M. Dumberldor.
        // Vous arrivez dans son bureau, et appercevais sur une étagère le choixpeau magique qui vous parle de votre maison. Et vous demande si vous etes satisfait.

        //repondre Oui ou Non.
        goodHouse(wizard);

        // Vous trouvez aussi sous celle-ci une magnifique épée
        stealSword(wizard);
        // CHOIX : Volée l'épée ou attendre patiament.

        // Dumbledore arrive enfin. Il vous parle, mais ne vous soupçonne pas il pense que vous n'êtes l'auteur de ces actes. Il vous laisse donc partir mais vous demande d'être très prudent.


        // Vous trouvez en sortant un journal : le journal de Tom Jedusor. Une fois arrivé dans votre chambre vous l'ouvrer pour le lire, mais remarqué qu'il n'y a rien d'écrit dedans. Vous vous posez des questions et essayer d'ecrire votre nom. Le journal efface instantanément ce que vous avez ecrit et vous repond Bonjour : wizard.name .
        // Vous demandez alors au journal où se situe la chambre des secrets et celui-ci vous répond qu'elle est située dans les toilettes abandonnées des filles au Deuxième étage, mais que pour l'ouvrir il faudra faire preuve d'observation et parlé une langue que très peu maitrise : le fourchelangue.
        // Vous décidez de vous rendre dans ces toilettes et essayer de trouver l'entrée de cette chambre. Mais soudain, vous entendez la meme voix que précédemment qui venez du mur. En lui répondant, cela ouvre un passage, vous entrez donc à l'intérieur.

        // Vous arrivez alors dans une salle gigantesque avec plein de statue de serpent sur les côtés. Vous comprenez que la voie que vous entendiez à travers les murs été du fourche langue et donc que vous aviez le don qui permettait d'ouvrir le passage des toilettes.

        // Quelque minutes après un basilic apparait vous engagez alors le combat.
        Enemy enemy = Enemy.basilic;
        Character.fight(wizard, enemy, new ArrayList<>());

        // utiliser des pierres = 0 degats
        // se rapprocher.

        // utilisez un sort : Accio fait tomber une dent du basilic 2 m devant vous.
        // if dent + 1m : vous ramassez la dent et frappez le basilic avec vous lui transpersé la gorge, celui-ci vous frappe et vous repouse de 1m il perd la moitié de ca vie.

        // if gryphondor + Library.    ( volé épée) + distance = 1m de base 3m
        // Vous prenez de la hauteur en montant sur une statue proche de vous et essayer de portez un coup en utilisant l'épee volé dans le bureau de Dumbeldor, celle-ci transperse le basilic et le tue
        // else  Vous prenez de la hauteur en montant sur une statue proche de vous et essayer de portez un coup en utilisant l'épee volé dans le bureau de Dumbeldor, celle-ci se brise au contact du basilic .


    }

    private static void skipSchool(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 1 && choice != 2) {
            System.out.println(ConsoleColors.BLUE + "\nChoisissez ce que vous voulez faire : " + ConsoleColors.RESET);
            System.out.println("1 : Vous vous rendez au cours de Mme Chourave.\n2 : Vous séchez le cours pour vous entrainer avec les sorts que vous connaissez deja.");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice != 1 && choice != 2) {
                    System.out.println("Le choix doit être 1 ou 2.");
                }
                if (choice == 1) {
                    System.out.println("\nVous apprenez qu'il existe des plantes nommé mandragores qui permettent de guérir les gens si par malheur il se font pétrifier.");
                    wizard.addKnowledge(Knowledge.mandragores);

                }
                if (choice == 2) {
                    System.out.println("\nVous séchez le cours de Mme Chourave pour vous entrainer avec les sorts que vous connaissez deja. Vous gagner 2% de dégâts.\n");
                    wizard.setPowerBonus(wizard.getPowerBonus() + 2);

                }
            } catch (InputMismatchException e) {
                System.out.println("Le choix doit être un nombre.");
                scanner.nextLine();
            }
        }
    }

    private static void joinQuidditch(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 1 && choice != 2) {
            System.out.println(ConsoleColors.BLUE + "\nSouhaitez vous rejoindre l'équipe de quidditch  : " + ConsoleColors.RESET);
            System.out.println("1 : Oui.\n2 : Non.");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice != 1 && choice != 2) {
                    System.out.println("Le choix doit être 1 ou 2.");
                }
                if (choice == 1) {
                    System.out.println("\nVous rejoignez l'équipe quidditch !");
                    wizard.addKnowledge(Knowledge.quidditch);

                }
                if (choice == 2) {
                    System.out.println("\nVous ne rejoignez l'équipe quidditch.\n");

                }
            } catch (InputMismatchException e) {
                System.out.println("Le choix doit être un nombre.");
                scanner.nextLine();
            }
        }
    }

    private static void metamorphosisOrLibrary(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 1 && choice != 2) {
            System.out.println(ConsoleColors.BLUE + "\nChoisissez ce que vous voulez faire : " + ConsoleColors.RESET);
            System.out.println("1 : Vous allez au cours de metamorphose de McGonagall.\n2 : Séchez les cours pour aller à la bibliothèque en apprendre plus sur la chambre de secret.");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice != 1 && choice != 2) {
                    System.out.println("Le choix doit être 1 ou 2.");
                }
                if (choice == 1) {
                    System.out.println("\nVous allez en cours de metamorphose, donnez par le professeur McGonagall, où vous apprenez à transformer votre animal de compagnie en verre à vin avec le sort Vera verto.");
                    wizard.addKnowledge(Knowledge.veraVerto);
                }
                if (choice == 2) {
                    System.out.println("\nVous séchez les cours pour aller à la bibliothèque en apprendre plus sur la chambre de secret. Vous apprenez l'existence d'un basilic qui tue si on le regarde mais pouvant être tué en un coup par une épée à condition d'etre membre de la maison Gryffondor.\n");
                    wizard.addKnowledge(Knowledge.gryffindorSword);

                }
            } catch (InputMismatchException e) {
                System.out.println("Le choix doit être un nombre.");
                scanner.nextLine();
            }
        }
    }

    private static void goodHouse(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 1 && choice != 2) {
            System.out.println(ConsoleColors.BLUE + "\nEtes-vous satisfait de votre maison  : " + ConsoleColors.RESET);
            System.out.println("1 : Oui.\n2 : Non.");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice != 1 && choice != 2) {
                    System.out.println("Le choix doit être 1 ou 2.");
                }
                if (choice == 1) {
                    System.out.println("\nC'est normal je ne me trompe jamais !");


                }
                if (choice == 2) {
                    System.out.println("\nVotre cas ne fut pas simple à traiter mais vous verrez, vous comprendrez mon choix.\n");

                }
            } catch (InputMismatchException e) {
                System.out.println("Le choix doit être un nombre.");
                scanner.nextLine();
            }
        }
    }

    private static void stealSword(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 1 && choice != 2) {
            System.out.println(ConsoleColors.BLUE + "\nChoisissez ce que vous voulez faire  : " + ConsoleColors.RESET);
            System.out.println("1 : Voler l'épée.\n2 : Attendre l'arrivé de Dumbledore.");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice != 1 && choice != 2) {
                    System.out.println("Le choix doit être 1 ou 2.");
                }
                if (choice == 1) {
                    System.out.println("\nVous volez l'épee et la mettez dans votre sac.");
                    wizard.addItem(Item.gryffindorSword);
                }
                if (choice == 2) {
                    System.out.println("\nVous patientez quelques minutes.\n");

                }
            } catch (InputMismatchException e) {
                System.out.println("Le choix doit être un nombre.");
                scanner.nextLine();
            }
        }
    }

//    private static boolean wizardAttackBasilic(Wizard wizard, Enemy enemy) {
//        Scanner scanner = new Scanner(System.in);
//        boolean success = false;
//        boolean comeback = true;
//
//        while (comeback) {
//            String stats = wizard.stats(wizard.getName(), wizard.getLifePoint(), wizard.getMaxLifePoint(), wizard.getMana(), wizard.getResistanceBonus(), wizard.getPowerBonus(), wizard.getAccuracyBonus(), wizard.getEfficiencyPotionsBonus(), wizard.getMoney());
//            System.out.println(stats);
//            System.out.println(ConsoleColors.BLUE + "\nQue voulez-vous faire sachant que le " + enemy.getName() + " se situe à " + enemy.getDistance() + " mètres et à " + enemy.getLifePoints() + " points de vie ?" + ConsoleColors.RESET);
//            System.out.println("1 : Jeter des pierres"); //action dif
//            System.out.println("2 : Se rapprocher");
//            System.out.println("3 : Utiliser un sort");
//            System.out.println("4 : Ouvrir votre sac");
//
//
//            try {
//                int choice = scanner.nextInt();
//                scanner.nextLine();
//
//                if (choice < 1 || choice > 4) {
//                    System.out.println("Le choix doit être 1, 2, 3 ou 4.");
//                    continue;
//                }
//
//                switch (choice) {
//                    case 1 -> { //dif
//                        int dommage = 1 + (1 * wizard.getPowerBonus()) / 100;
//                        System.out.println("Vous jetez des pierre sur le Basilic. Il perd " + dommage + " points de vie");
//                        enemy.setLifePoints(enemy.getLifePoints() - dommage);
//                        if (enemy.getLifePoints() <= 0) {
//                            return true;
//                        }
//                        comeback = false;
//                    }
//                    case 2 -> {
//                        System.out.println("Vous vous rapprochez du " + enemy.getName() + ".");
//                        enemy.setDistance(enemy.getDistance() - 1);
//                        comeback = false;
//                    }
//
//                    case 3 -> {
//                        comeback = spellList(wizard, enemy);
//                        if (enemy.getLifePoints() <= 0) {
//                            return true;
//                        }
//                    }
//                    case 4 -> {
//                        comeback = openBackpack(wizard, enemy);
//                    }
//
//                }
//
//
//            } catch (InputMismatchException e) {
//                System.out.println("Le choix doit être un nombre.");
//                scanner.nextLine();
//            }
//
//            if (enemy.getDistance() == 1 && Level2.tooth) {
//                System.out.println("Vous ramassez la dent du basilic pour le frappez ce qui lui enlève 50 points de vie.");
//                enemy.setLifePoints(enemy.getLifePoints() - 50 - (50 * wizard.getPowerBonus()) / 100);
//                if (enemy.getLifePoints() > 0) {
//                    System.out.println("mais vous repoussez d'un mètre.");
//                    enemy.setDistance(2);
//                } else {
//                    return true;
//                }
//
//
//            }
//        }
//        return false;
//    }

//    private static boolean spellList(Wizard wizard, Enemy enemy) {
//        int numSpells = wizard.getKnownSpells().size();
//        if (numSpells == 0) {
//            System.out.println("Vous n'avez appris aucun sort.");
//            return true;
//        } else {
//            System.out.println(ConsoleColors.BLUE + "\nVeuillez choisir un sort :" + ConsoleColors.RESET);
//            for (int i = 0; i < numSpells; i++) {
//                System.out.println((i + 1) + " : " + wizard.getKnownSpells().get(i).getName());
//            }
//            System.out.println((numSpells + 1) + " : Ne pas utiliser de sort.");
//            int choice = -1;
//            do {
//                Scanner scanner = new Scanner(System.in);
//                try {
//                    choice = scanner.nextInt();
//                    if (choice < 1 || choice > numSpells + 1) {
//                        System.out.println("Veuillez entrer un choix valide.");
//                    }
//                } catch (InputMismatchException e) {
//                    System.out.println("Veuillez entrer un choix valide.");
//                    scanner.next();
//                }
//            } while (choice < 1 || choice > numSpells + 1);
//            if (choice == numSpells + 1) {
//                return true;
//            }
//            Spell chosenSpell = wizard.getKnownSpells().get(choice - 1);
//            System.out.println("Vous avez choisi le sort " + chosenSpell.getName() + ".");
//            if (chosenSpell == Spell.windgardiumLeviosa && Enemy.troll == enemy) {
//                int chanceOfSuccess = 0;
//                if (enemy.getDistance() <= 7) {
//                    System.out.println("Vous utilisez Windgardium Leviosa sur la massue du troll !");
//                    chanceOfSuccess = 100 - (enemy.getDistance() * 5) + wizard.getAccuracyBonus();
//                    System.out.println("Vous êtes à " + enemy.getDistance() + " mètres du troll. Votre chance de réussite est de " + chanceOfSuccess + "%.");
//                    Random random = new Random();
//                    int randomValue = random.nextInt(101);
//                    if (randomValue <= chanceOfSuccess) {
//                        System.out.println("Votre sort atteint la massue du troll, vous diriger alors la massue plusieurs mètres au dessus de ca tete et la laisser tombé ce qui assomme le troll.");
//                        return true;
//                    } else {
//                        System.out.println("Vous ratez votre sort de justesse.");
//                    }
//                } else {
//                    System.out.println("Vous êtes à " + enemy.getDistance() + " mètres du troll. Votre chance de réussite est de " + chanceOfSuccess + "%., si vous aviez mieux écouter le cours vous sauriez que pour utiliser Windgarium leviosa \nil faut etre à 7 mètres ou moins pour que le sort est une chance de reussir et que plus vous etes proche plus vous augementer vos chances.");
//                }
//            } else if (chosenSpell == Spell.aloomora) {
//                //effet aloomora
//            } else if (chosenSpell == Spell.immobulus) {
//                // effet imobulus
//            } else if (chosenSpell == Spell.accio && enemy == Enemy.basilic) {
//                int chanceOfSuccess = 0;
//                if (enemy.getDistance() <= 7) {
//                    System.out.println("Vous utilisez Accio en visant la machoire du basilic !");
//                    chanceOfSuccess = 100 - (enemy.getDistance() * 5) + wizard.getAccuracyBonus();
//                    System.out.println("Vous êtes à " + enemy.getDistance() + " mètres du basilic. Votre chance de réussite est de " + chanceOfSuccess + "%.");
//                    Random random = new Random();
//                    int randomValue = random.nextInt(101);
//                    if (randomValue <= chanceOfSuccess) {
//                        System.out.println("Votre sort atteint les dents du basilic, une d'entre elles se décroche commence à venir vers vous mais vous la faite tomber au sol à 1m du basilic.");
//                        Level2.tooth = true;
//                        return true;
//                    } else {
//                        System.out.println("Vous ratez votre sort de justesse.");
//                    }
//                }
//            }
//            System.out.println("Votre sort n'a rien fait au " + enemy.getName());
//        }
//        return false;
//    }
//
//    private static boolean openBackpack(Wizard wizard, Enemy enemy) {
//        boolean comeback2 = true;
//        Scanner scanner = new Scanner(System.in);
//        while (comeback2) {
//            System.out.println(ConsoleColors.BLUE + "\nVous ouvrez votre sac, souhaitez-vous prendre quelque chose ?" + ConsoleColors.RESET);
//            System.out.println("1 : Chercher une potion");
//            System.out.println("2 : Chercher un objet");
//            System.out.println("3 : Refermer le sac");
//
//            try {
//                int backpackChoice = scanner.nextInt();
//                scanner.nextLine();
//
//                if (backpackChoice < 1 || backpackChoice > 3) {
//                    System.out.println("Le choix doit être 1, 2, ou 3.");
//                }
//
//                switch (backpackChoice) {
//                    case 1 -> {
//                        comeback2 = findPotions(wizard);
//                    }
//                    case 2 -> {
//                        comeback2 = findItems(wizard, enemy);
//                    }
//                    case 3 -> {
//                        return true;
//                    }
//                }
//
//            } catch (InputMismatchException e) {
//                System.out.println("Le choix doit être un nombre.");
//                scanner.nextLine();
//            }
//        }
//        return false;
//    }
//
//    private static boolean findPotions(Wizard wizard) {
//        int numPotions = wizard.getPotions().size();
//        if (numPotions == 0) {
//            System.out.println("Vous n'avez aucune potion disponible.");
//            return true;
//        } else {
//            System.out.println(ConsoleColors.BLUE + "\nVeuillez choisir une potion :" + ConsoleColors.RESET);
//            for (int i = 0; i < numPotions; i++) {
//                System.out.println((i + 1) + " : " + wizard.getPotions().get(i).getName());
//            }
//            System.out.println((numPotions + 1) + " : Retourner dans le sac");
//            int choice = -1;
//            do {
//                Scanner scanner = new Scanner(System.in);
//                try {
//                    choice = scanner.nextInt();
//                    if (choice < 1 || choice > numPotions + 1) {
//                        System.out.println("Veuillez entrer un choix valide.");
//                    }
//                } catch (InputMismatchException e) {
//                    System.out.println("Veuillez entrer un choix valide.");
//                    scanner.next();
//                }
//            } while (choice < 1 || choice > numPotions + 1);
//            if (choice == numPotions + 1) {
//                return true;
//            }
//            Potion chosenPotion = wizard.getPotions().get(choice - 1);
//            System.out.println("Vous avez choisi la " + chosenPotion.getName() + ".");
//            if (chosenPotion == Potion.potionHeal) {
//                if (wizard.getLifePoint() >= 80) {
//                    wizard.setLifePoint(wizard.getMaxLifePoint());
//                } else
//                    wizard.setLifePoint(wizard.getLifePoint() + chosenPotion.getValue() + (chosenPotion.getValue() * wizard.getEfficiencyPotionsBonus()) / 100);
//                wizard.getPotions().remove(choice - 1);
//            } else if (chosenPotion == Potion.potionDamage) {
//                wizard.setPowerBonus(wizard.getPowerBonus() + chosenPotion.getValue() + (chosenPotion.getValue() * wizard.getEfficiencyPotionsBonus()) / 100);
//                wizard.getPotions().remove(choice - 1);
//            } else if (chosenPotion == Potion.potionResistance) {
//                wizard.setResistanceBonus(wizard.getResistanceBonus() + chosenPotion.getValue() + (chosenPotion.getValue() * wizard.getEfficiencyPotionsBonus()) / 100);
//                wizard.getPotions().remove(choice - 1);
//            } else if (chosenPotion == Potion.potionPrecision) {
//                wizard.setAccuracyBonus(wizard.getAccuracyBonus() + chosenPotion.getValue() + (chosenPotion.getValue() * wizard.getEfficiencyPotionsBonus()) / 100);
//                wizard.getPotions().remove(choice - 1);
//            }
//
//        }
//        return false;
//    }
//
//    private static boolean findItems(Wizard wizard, Enemy enemy) {
//        int numItems = wizard.getItems().size();
//        if (numItems == 0) {
//            System.out.println("Vous n'avez aucun objet disponible.");
//            return true;
//        } else {
//            System.out.println(ConsoleColors.BLUE + "\nVeuillez choisir un objet :" + ConsoleColors.RESET);
//            for (int i = 0; i < numItems; i++) {
//                System.out.println((i + 1) + " : " + wizard.getItems().get(i).getName());
//            }
//            System.out.println((numItems + 1) + " : Retourner dans le sac");
//            int choice = -1;
//            do {
//                Scanner scanner = new Scanner(System.in);
//                try {
//                    choice = scanner.nextInt();
//                    if (choice < 1 || choice > numItems + 1) {
//                        System.out.println("Veuillez entrer un choix valide.");
//                    }
//                } catch (InputMismatchException e) {
//                    System.out.println("Veuillez entrer un choix valide.");
//                    scanner.next();
//                }
//            } while (choice < 1 || choice > numItems + 1);
//            if (choice == numItems + 1) {
//                return true;
//            }
//            Item chosenItem = wizard.getItems().get(choice - 1);
//            System.out.println("Vous avez choisi " + chosenItem.getName() + ".");
//            if (wizard.getKnowledges().contains(Knowledge.gryffindorSword)) {
//                if (enemy.getDistance() != 1) {
//                    System.out.println("Vous frappez dans le vide avec votre épée car vous êtes trop loin.");
//                } else {
//                    if (wizard.getHouse() == House.GRYFFINDOR) {
//                        System.out.println("Vous prenez de la hauteur en montant sur une statue proche de vous et essayer de portez un coup en utilisant l'épee volé dans le bureau de Dumbledore, celle-ci transperse le basilic et le tue.");
//                        enemy.setLifePoints(0);
//                    } else {
//                        System.out.println("Vous prenez de la hauteur en montant sur une statue proche de vous et essayer de portez un coup en utilisant l'épee volé dans le bureau de Dumbledore, celle-ci se brise au contact du basilic.");
//                        wizard.getItems().remove(choice - 1);
//                    }
//                }
//
//            }
//        }
//        return false;
//    }

//    private static boolean basilicAttackWizard(Wizard wizard, Enemy enemy) {
//        Scanner scanner = new Scanner(System.in);
//        int wizardLife = wizard.getLifePoint();
//        int chanceOfSuccess = 0;
//        chanceOfSuccess = 70;
//        System.out.println("\nLa probabilité qu'il vous touche est de " + chanceOfSuccess + "%.");
//        Random random = new Random();
//        int randomValue = random.nextInt(101);
//        if (randomValue <= chanceOfSuccess) {
//            int dommage = Enemy.basilic.getDommage() - (Enemy.basilic.getDommage() * wizard.getResistanceBonus()) / 100;
//            wizard.setLifePoint(wizardLife - dommage);
//            System.out.println("La queue du Basilic, vous frappe et vous enlève " + dommage + " points de vie.");
//            if (wizard.getLifePoint() <= 0) {
//                System.out.println("Vous êtes mort! Le basilic vous a vaincu.");
//                return true;
//            }
//        } else {
//            System.out.println("Le basilic essaie de vous frapper avec ca queue mais vous arrivez à l'éviter.");
//        }
//        return false;
//    }
//
//    private static void fight(Wizard wizard, Enemy enemy, List<Friend> listFriendsWithYou) {
//        boolean enemyAlive = false;
//        boolean wizardAlive = false;
//        while (enemy.getDistance() >= 1 && !enemyAlive && !wizardAlive) {
//            enemyAlive = wizardAttackBasilic(wizard, enemy);
//            if (enemy.getDistance() < 1) {
//                wizardAlive = true;
//                break;
//            }
//            if (enemyAlive || enemy.getLifePoints() <= 0) {
//                break;
//            }
//            for (int i = 0; i < listFriendsWithYou.size(); i++) {
//                System.out.println("\nVotre ami " + listFriendsWithYou.get(i).getName() + " peut aussi attaquer le " + enemy.getName() + ".");
//                enemyAlive = wizardAttackBasilic(wizard, enemy);
//                if (enemy.getDistance() < 1) {
//                    wizardAlive = true;
//                    break;
//                }
//                if (enemyAlive) {
//                    break;
//                }
//            }
//            if (enemy.getDistance() < 1) {
//                wizardAlive = true;
//                break;
//            }
//            if (enemyAlive || enemy.getLifePoints() <= 0) {
//                break;
//            }
//            wizardAlive = basilicAttackWizard(wizard, enemy);
//
//        }
//
//        if (enemy.getDistance() < 1) {
//            System.out.println("Quel idée de se coller au " + enemy.getName() + " ! Celui-ci vous mange.");
//        }
//
//        if (enemyAlive || enemy.getLifePoints() <= 0) {
//            System.out.println("Vous avez vaincu le " + enemy.getName() + " !");
//        }
//    }

}
