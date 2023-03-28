package Level;

import GameElement.*;
import GameElement.Character;
import MiniGame.RockPaperScissors.RockPaperScissors;
import MiniGame.TicTacToe.TicTacToe;
import utils.ConsoleColors;
import utils.ScrollingText;

import java.util.*;

public class Level1 extends AbstractLevel {

    @Override
    public void startLevel(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nVous arrivez dans le jardin de Poudlard pour votre premier cours, qui est un cours de vol sur balais. Madame Bibine, votre professeur, vous donne les directives \npour faire voler votre balai et très vite vous remarquez avoir quelques facilités par rapport aux autres élèves. Elle doit par la suite s'absenter pour une urgence \net interdit formellement à quiconque de voler. Mais Bartemius Croupton en a décidé autrement, il vole le collier de Fleur Delacour et s'enfuit avec. \nIl vous met alors au défi de venir le chercher. Que décidez-vous de faire ?");
        int flyingLesson = flyingLesson(wizard);
        int exploreOrMakeNewFriend = exploreOrMakeNewFriend(wizard);
        System.out.println("Vous assistez au cours de levitation où vous apprenez le sort WINGARDIUM LEVIOSA. Vous avez un peu de mal alors que votre amie Fleur réussit du premier coup. \nElle essaie donc de vous aider en vous donnant une meilleure prononciation : \"WINGARDIUM LEVI-OOO-SA\", mais cela fait rire vos camarades. \nElle quitte donc le cours pour aller pleurer dans les toilettes. Le professeur vous explique les modalités pour utiliser le sort lorsque nous somme un élève \nde premiere année : \"il vous faut être à 7 mètres ou moins pour que le sort est une chance de réussir, tout en sachant que plus vous êtes \nproche de l'objet à déplacer plus vos chances sont élevés\n");
        wizard.addSpell(Spell.windgardiumLeviosa);
        List<Friend> listFriendsWithYou = listFriendsWithYou(wizard);
        String friends = nameFriendsWithYou(wizard, listFriendsWithYou);
        System.out.println("Quelque minutes plus tard un professeur arrive en paniquant dans votre cours, il annonce qu'un Troll c'est échappé et ce balade dans l'école. \nTous les élèves se mettent à crier dans tout les sens. Mais pas vous, vous pensez directement à Fleur qui est parti pleurer au toilette et n'a pas l'information. \nAinsi, à la place de suivre tout les autres et évacuer l'école pour se rendre dans le jardin vous allez en direction des toilettes des filles pour aider votre amie.\nVous réussissez à convaincre " + friends + "de venir avec vous.");
        System.out.println("Vous arrivez proche des toilettes et etendant crier vous courez alors encore plus vite et voyer le troll entrain de fracasser les toilettes. Vous engagez alors le comnbat pour sauver votre amie.");
        Enemy enemy = Enemy.troll;
        Character.fight(wizard, enemy, listFriendsWithYou);
        wizard.checkIsAlive(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }

        String AFTER_TROLL = "Peu de temps après un groupe de professeur arrivent dans les toilettes et vous trouve avec le troll assommé au sol, ils vous demande alors que faites-vous là. Votre amie Fleur Delacour prend la parole et ce dénonce en disant qu'elle chercher à voir le troll de plus près pour étendre ses connaissances et qu'elle pensait pouvoir le vaincre avec ses compétences avancés sur les trolls. Votre maison perd alors 20 points, mais les professeurs reconnaissent que battre ce troll avec les connaissances de premiere année relève de l'exploit. Ils font gagner à votre maison 10 points par personne ayant permis de battre ce troll.";
        ScrollingText.printWithDelay(AFTER_TROLL);
        wizard.setHousePoints(wizard.getHousePoints() - 20);
        wizard.setHousePoints(wizard.getHousePoints() + 10);
        wizard.setHousePoints(wizard.getHousePoints() + 10 * listFriendsWithYou.size());

        simulateQuidditchMatch(wizard);

        String CHRISTMAS = "Arrive la moitié de l'année et la période de noel, vous voyait tous les membres de votre maison recevoir des cadeaux et vous vous vous doutiez que vous n'aurait rien car vous n'avez jamais rien eu. Mais a votre grande surprise quand vous vous rendez à votre dortoir vous trouvez sur votre lit un cadeau d'un inconnu. Il s'agit la d'une cape d'invisibilité.\n";
        ScrollingText.printWithDelay(CHRISTMAS);


        String TRY_CAPE = "Vous mettez la cape de manière à l'essayer et vous partez explorer la reserve de la bibliothèque. Vous choisissez d'en apprendre plus sur :";
        ScrollingText.printWithDelay(TRY_CAPE);
        tryCape(wizard);

        String SECONDARY_QUEST = "Vous retournez dans votre chambre et réfléchissez à comment vous allez mettre cette information à profit. ";
        ScrollingText.printWithDelay(SECONDARY_QUEST);

        exploreForbiddenCorridor(wizard);

        String FIN_ANNEE = "Vous vous remettez de vos blessures et fêtait la fin d'année. Vous vous retrouvez dans la salle principale de Poudlard, \noù le professeur Dumbledore annonce la maisons ayant récolté le plus de points : il s'agit de ";
        ScrollingText.printWithDelay(FIN_ANNEE);

        winnerHouse(wizard);

        String GO_MARKET = "\nVous passez brillamment votre première année et rentrer chez vous durant les vacances. Plusieurs semaines s'écoulent, voilà arriver la rentrée.";
        ScrollingText.printWithDelay(GO_MARKET);
        //TODO Italic

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

    public static List<Friend> listFriendsWithYou(Wizard wizard) {
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

    private static void tryCape(Wizard wizard) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 1 && choice != 2) {
            System.out.println(ConsoleColors.BLUE + "\nChoisissez ce que vous voulez faire : " + ConsoleColors.RESET);
            System.out.println("1 : Nicolas Flammel le créateur de la pierre philosopahale\n2 : Le chien à trois têtes - Fluffy");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice != 1 && choice != 2) {
                    System.out.println("Le choix doit être 1 ou 2.");
                }
                if (choice == 1) {
                    System.out.println("\nVous lisez et apprenez que cette pierre allonge énormément l'espérance de vie  de plus elle permet de transformer n'importe qu'elle métal en or.");
                    wizard.addKnowledge(Knowledge.philosopherStone);

                }
                if (choice == 2) {
                    System.out.println("\nVous lisez et apprenez que cette créature est très puissante mais qu'elle a un point faible. En effet, si elle entend de la musique celle-ci s'endort.\n");
                    wizard.addKnowledge(Knowledge.fluffySleep);

                }
            } catch (InputMismatchException e) {
                System.out.println("Le choix doit être un nombre.");
                scanner.nextLine();
            }
        }
    }

    private static void secondaryQuest(Wizard wizard) {
        String PLAY_TICTACTOE = "Vous arrivez dans une grande salle dans laquelle vous repérer un plateau de jeu dessiné au sol, sur le coté ce situe des ronds et des croix. Vous comprenez que vous allez devoir jouer une partie de TicTacToe.\n";
        ScrollingText.printWithDelay(PLAY_TICTACTOE);
        boolean win = TicTacToe.TicTacToe();
        if (win) {
            String MEET_QUIRRELL = "\nUne porte s'ouvre devant vous, vous passez cette porte et vous voyez le professeur Quirrell celui-ci agit bizarrement, on dirait qu'il à deux personnalités, il enlève sont turban et cela fait apparaitre un autre visage. Vous comprenez qu'il s'agit de Voldemort mais trop faible pour avoir son propre corps, celui cherchait la pierre philosophale. Il ordonne alors au professeur Quirrell de vous tuez. Vous essayez de vous défendre : pour cela vous devez gagnez ce mini-jeu.";
            ScrollingText.printWithDelay(MEET_QUIRRELL);
            //TODO defense
            boolean defend = wizard.defend(wizard);
            if (defend) {
                String DEFENSE_WIN = "\nVous arrivez à vous défendre et faite fuir Voldemort, celui abandonne la pierre philosophale mais vous etes à bout de force. Vous vous effondrez de fatigue et vous réveillez à l'hôpital. Le professeur Dumbledore est présent à votre réveil et choisi et vous explique qu'il à briser la pierre philosophale car elle était trop puissante et trop dangereuse mais ils vous offre 100 morilles car celle-ci vous appartenez.";
                ScrollingText.printWithDelay(DEFENSE_WIN);
                wizard.setMoney(wizard.getMoney() + 100);
            } else {
                String DEFENSE_FAIL = "\nVous n'arrivez pas à vous défendre, vous perdez 50 points de vie";
                ScrollingText.printWithDelay(DEFENSE_FAIL);
                wizard.setLifePoint(wizard.getLifePoint() - 50);
                wizard.checkIsAlive(wizard);
                if (!wizard.getIsAlive()) {
                    return;
                }
                String DEFENSE_FAIL2 = "Vous vous retrouvez à l'hôpital. Le professeur Dumbledore est présent à votre réveil et choisi de punir votre maison car vous avez pris des risques inconsidérés malgré les règles. Celle-ci perd 20 points";
                ScrollingText.printWithDelay(DEFENSE_FAIL2);
                wizard.setHousePoints(wizard.getHousePoints() - 20);
            }


        } else {
            String LOSE_TICTACTOE = "\nVous êtes frappez par un objet, celui-ci vous assomme vous perdez 24 points de vie. Vous vous réveillez à l'hôpital. Le professeur Dumbledore est présent à votre réveil et choisi de punir votre maison car vous avez pris des risques inconsidérés malgré les règles. Celle-ci perd 20 points";
            ScrollingText.printWithDelay(LOSE_TICTACTOE);
            wizard.setLifePoint(wizard.getLifePoint() - 24);
            wizard.setHousePoints(wizard.getHousePoints() - 20);
            wizard.checkIsAlive(wizard);
            if (!wizard.getIsAlive()) {
                return;
            }
        }
    }

    private static void simulateQuidditchMatch(Wizard wizard) {
        if (wizard.getKnowledges().contains(Knowledge.quidditch)) {
            System.out.println("\nVous allez jouez votre premier match de Quidditch avec votre maison : " + wizard.getHouse());
            Boolean resultat = RockPaperScissors.Quidditch(wizard);
            if (resultat) {
                System.out.println("\nVotre maison : " + wizard.getHouse() + " remporte 30 points");
                wizard.setHousePoints(wizard.getHousePoints() + 30);
            } else {
                System.out.println("\nVotre maison : " + wizard.getHouse() + " perd 15 points");
                wizard.setHousePoints(wizard.getHousePoints() - 15);
            }
        } else {
            System.out.println("\nVous assistez pour la première fois à un match de Quidditch de votre maison, cependant ils sont désavantagé car il leur manque un joueur.");
            System.out.println("\nVotre maison : " + wizard.getHouse() + " perd le match et donc 30 points");
            wizard.setHousePoints(wizard.getHousePoints() - 30);
            // Lacarum inflamarae -> permet d'enflammer un objet
        }
    }

    private static void exploreForbiddenCorridor(Wizard wizard) {
        if (wizard.getKnowledges().contains(Knowledge.fluffy) && wizard.getKnowledges().contains(Knowledge.fluffySleep)) {
            String GO_FLUFFY = "Vous vous rendez au troisième étage dans l'aile interdit pour rejoindre le chien à trois têtes, vous entendez de la musique, vous comprenez que quelqu'un est passé avant vous. Vous ouvrez la porte tombez sur fluffy déjà endormi, vous passez alors dans la trappe situez juste à coté de lui. ";
            ScrollingText.printWithDelay(GO_FLUFFY);
            secondaryQuest(wizard);

        } else if (wizard.getKnowledges().contains(Knowledge.fluffy)) {
            String GO_FLUFFY2 = "Vous vous rendez au troisième étage dans l'aile interdit pour rejoindre le chien à trois têtes, car vous vous dites que la pierre philosolophale doit être là bas. Vous entendez de la musique, vous comprenez pas pourquoi. Vous ouvrez la porte tombez sur fluffy endormi, vous vous dirigez vers la trappe situez juste à coté de lui mais le chiens se réveil au moment ou vous vous apprêtiez à passer, vous arrivez à passez mais le chien vous griffe et vous perdez 30 points de vie. ";
            ScrollingText.printWithDelay(GO_FLUFFY2);
            wizard.setLifePoint(wizard.getLifePoint() - 30);
            wizard.checkIsAlive(wizard);
            if (!wizard.getIsAlive()) {
                return;
            }
            secondaryQuest(wizard);

        } else if (wizard.getKnowledges().contains(Knowledge.fluffySleep)) {
            String MISS_SECONDARY_QUEST = "Après votre nuit de sommeil vous vous dites que le chien à 3 têtes à des chances de ce situez dans la forêt interdit. Vous vous dirigez vers la foret mais vous vous faites attaquez sans voir votre agresseur. Vous terminez à l'hôpital et perdez 10 points de vie.";
            ScrollingText.printWithDelay(MISS_SECONDARY_QUEST);
            wizard.setLifePoint(wizard.getLifePoint() - 10);
            wizard.checkIsAlive(wizard);
            if (!wizard.getIsAlive()) {
                return;
            }
        } else {
            String MISS_SECONDARY_QUEST1 = "Après votre nuit de sommeil vous vous dites que la pierre philosophale à des chances de ce situez dans la forêt interdit. Vous vous dirigez vers la foret mais vous vous faites attaquez sans voir votre agresseur. Vous terminez à l'hôpital et perdez 10 points de vie.";
            ScrollingText.printWithDelay(MISS_SECONDARY_QUEST1);
            wizard.setLifePoint(wizard.getLifePoint() - 10);
            wizard.checkIsAlive(wizard);
            if (!wizard.getIsAlive()) {
                return;
            }
            //TODO GAIN ARGENT ?
        }
    }

    private static void winnerHouse(Wizard wizard) {
        if (wizard.getHousePoints() >= 240) {
            String HEAL = wizard.getHouse() + ".\nAinsi, la maison " + wizard.getHouse() + " voit tout ses sorciers soignez au maximum de leur points de vie";
            ScrollingText.printWithDelay(HEAL);
            wizard.setLifePoint(wizard.getMaxLifePoint());
        } else {
            Random rand = new Random();
            House otherHouse;
            do {
                otherHouse = House.values()[rand.nextInt(House.values().length)];
            } while (otherHouse == wizard.getHouse());
            String HEAL_OTHER = otherHouse + ". \nAinsi, la maison " + otherHouse + " voit tout ses sorciers soignez au maximum de leur point de vie";
            ScrollingText.printWithDelay(HEAL_OTHER);
        }
    }
}


