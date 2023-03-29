package Level;

import GameElement.*;
import GameElement.characters.Character;
import GameElement.characters.enemies.Enemy;
import GameElement.characters.Wizard;
import GameElement.items.Item;
import GameElement.items.Market;
import GameElement.spells.Spell;
import utils.ConsoleColors;
import utils.ScrollingText;

import java.util.*;

public class Level2 extends AbstractLevel {

    public static boolean tooth = false;

    @Override
    public void startLevel(Wizard wizard) {
        String Potions = " Avant vous souhaitez faire le plein de fourniture pour cela vous utilisez une cheminée qui permet de transplaner, vous prononcez votre destination : \"chemin de traverse\". Et vous arrivez dans un petit magasin de potions :";
        ScrollingText.printWithDelay(Potions);
        Market.market(wizard);
        String WarningElfDobby = "Avant de partir vous rencontrez un elfe de maison nommée Dobby qui vous met en garde qu'il ne faut pas retourner à Poudlard cette année, car un complot se prépare. Vous ne prêtez pas attention, puisque c'est là-bas que vous êtes heureux. Vous sortez de la boutique pour vous rendre à la gare de Londres, mais vous ratez le train à cause de ce petit elfe qui vous a retardé chez le marchant de potion. Vous devez donc vous rendre à Poudlard par un autre moyen.";
        ScrollingText.printWithDelay(WarningElfDobby);

        //PROPOSER LE CHOIX DE NE PAS VOLER LA VOITURE MAIS RATEZ SON ANNEE ET REDOUBLER ?

        // Vous savez qu'il existe une voiture volante appartenant au parent de Fleur ainsi vous allez chez fleur et emprunter pour une durée indéterminée cette fameuse voiture.

        String FirstClass = "Après plusieurs heures de voyage. Vous arrivez enfin à Poudlard, il est déjà l'heure de votre premier cours, il s'agit d'un cours de botanique avec le professeur Chourave.";
        ScrollingText.printWithDelay(FirstClass);

        skipSchool(wizard);
        String AccioLearning = "Vous assistez ensuite au cours de \"Défense contre les forces du mal\" où vous rencontrez le professeur Gilderoy Lockhart. Au cours de la séance, il libère des lutins de Cornouailles dans la classe pour observer comment vous vous débrouillez. Grâce à votre amie Fleur, qui a continué à pratiquer durant les vacances, vous apprenez le sortilège Immobulus qui permet de ralentir le temps et de les attraper. Vous réalisez également qu'apprendre le sort Accio pourrait être utile pour récupérer des objets à distance. Vous profitez de l'exercice pour pratiquer le sort Accio.";
        ScrollingText.printWithDelay(AccioLearning);
        wizard.addSpell(Spell.accio);
        wizard.addSpell(Spell.immobulus);

        if (!wizard.getKnowledges().contains(Knowledge.quidditch)) {
            joinQuidditch(wizard);
        }


        String SecretRoom = "En vous promenant dans le couloir vous etendez une voix etrange provenant du mur. Peu de temps apres d'autre etudiant arrive, mais eux n'entende rien. La voix provenant du mur s'arrete et vous ecoutez la disscuiton des élèves a coté de vous. Ils font circuler la rumeurs qu'une certaine chambre des Secrets aurait été ouverte, dans laquel ce siturai un monstre. Cependant, vous n'y croyait pas et retourner a vos occupation en vous questionant sur la voix provenant du mur";
        ScrollingText.printWithDelay(SecretRoom);
        metamorphosisOrLibrary(wizard);

        String ConvocationAtDumbledore = "Vous vous dirigez à nouveau vers votre dortoir et trouvez le chat de M. Rusard pétrifié à coté d'une eleve elle aussi pétrifié. M. Rusard arrive quelques secondes après et vous accuse d'avoir pétrifié son chat et cette élève. Vous etes donc convoqué chez M. Dumberldor. Vous arrivez dans son bureau, et appercevais sur une étagère le choixpeau magique qui vous parle de votre maison. Et vous demande si vous etes satisfait.";
        ScrollingText.printWithDelay(ConvocationAtDumbledore);
        goodHouse(wizard);

        String FindSword = "Vous trouvez aussi sous celle-ci une magnifique épée";
        ScrollingText.printWithDelay(FindSword);
        stealSword(wizard);


        String Innocent = " Dumbledore arrive enfin. Il vous parle, mais ne vous soupçonne pas d'avoir pétrifié ce gens. Il pense que vous n'êtes l'auteur de ces actes. Il vous laisse donc partir mais vous demande d'être très prudent.";
        ScrollingText.printWithDelay(Innocent);

        String TomJournal = "Vous trouvez en sortant sur une commode un journal intitulé \"Journal de Tom Jedusor\". Une fois arrivé dans votre chambre vous l'ouvrer pour le lire, mais remarqué qu'il n'y a rien d'écrit dedans. Vous vous posez des questions et essayer d'écrire votre nom. Le journal efface instantanément ce que vous avez écrit et vous répond : Bonjour, " + wizard.name + ". Vous essayez de confirmer les bruits de couloir sur la chambre des secrets et demandez au journal où se situe celle-ci. Celui-ci vous répond qu'elle est située dans les toilettes des filles au deuxième étage celle qui sont abandonnées, il vous précise que pour l'ouvrir il faudra faire preuve d'observation et parlé une langue que très peu maitrise : le fourchelangue. Vous décidez de vous rendre dans ces toilettes et essayer de trouver l'entrée de cette chambre des secrets. Mais soudain, la voix qui venait du mur se remet à parler. En lui répondant, cela ouvre un passage, dans lequel vous pénétrez. Vous arrivez alors dans une salle gigantesque avec plein de statue de serpent sur les côtés. Vous comprenez que la voie que vous entendiez à travers les murs était du fourche langue et donc que vous aviez le don qui permettait d'ouvrir le passage des toilettes.";
        ScrollingText.printWithDelay(TomJournal);

        String BasilicFight = "Après quelque minutes passé seul dans cette grande salle un enorme Basilic apparait vous engagez alors le combat.";
        ScrollingText.printWithDelay(BasilicFight);

        Enemy enemy = Enemy.basilic;
        Character.fight(wizard, enemy, new ArrayList<>());
        wizard.checkIsAlive(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }

        String Escape = "Vous sortez de la chambre des secrets, très fiers de vous car vous avez réussi à vaincre le basilic. Vous retournez à votre chambre détruire le journal que vous avez trouvez car vous vous rendez compte du pouvoir potentiellement dangereux qu'il possède. \nVous vous endormez et rêvez de votre deuxième année à Poudlard. Pour finir, cette année un grand match de Quidditch est organisé.";
        ScrollingText.printWithDelay(Escape);
        Level1.simulateQuidditchMatch(wizard);

        String AnnonceWinnerHouse = "Par la suite, vous vous rendez dans la grande salle pour le repas de fin d'année. Dumbledore annonce que la maison gagnante cette année est la maison ";
        ScrollingText.printWithDelay(AnnonceWinnerHouse);
        Level1.winnerHouse(wizard);

        String GO_MARKET = "\nVous passez brillamment votre deuxième année et rentrer chez vous durant les vacances. Plusieurs semaines s'écoulent, voilà déjà la rentrée arriver.";
        ScrollingText.printWithDelay(GO_MARKET);
        //TODO Italic

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
            String Quidditch = "A la fin du cours, un groupe d'élèves vous approche pour vous inviter à rejoindre l'équipe de Quidditch.";
            ScrollingText.printWithDelay(Quidditch);
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
                    System.out.println("\nVous ne rejoignez pas l'équipe quidditch.\n");

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
                    System.out.println("\nC'est normal je ne me trompe jamais ! Pour votre fidélité à votre maison je vous offre 10 points de maison.\n");
                    wizard.setHousePoints(wizard.getHousePoints() + 10);
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
}