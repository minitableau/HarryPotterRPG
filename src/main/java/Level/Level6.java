package Level;

import GameElement.House;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.Enemy;
import GameElement.characters.enemies.Mangemorts;
import utils.ConsoleColors;
import utils.InteractionUtils;

public class Level6 extends AbstractLevel {
    public static boolean areYouDeathEater = false;

    @Override
    public void startLevel(Wizard wizard) {
        // Apprend sectumsemprapackage grace a Severus Rogue
        if (wizard.getHouse() == House.SLYTHERIN) {
            System.out.println("Les mangemorts vous proposent des les rejoindres car vous êtes" + wizard.getHouse());
            joinDeathEater(wizard);
        }
        if (areYouDeathEater) {
            return;
        }
        Enemy enemy = new Mangemorts();
        wizard.fight(enemy);
        if (!wizard.isAlive()) {
            return;
        }
    }

    private void joinDeathEater(Wizard wizard) {
        System.out.println(ConsoleColors.BLUE + "\nSouhaitez vous rejoindre les mangemorts  : " + ConsoleColors.RESET);
        System.out.println("1 : Oui.\n2 : Non.");

        int choice = InteractionUtils.askForInt(1, 2);

        if (choice == 1) {
            System.out.println("\nVous rejoignez les mangemorts !");
            areYouDeathEater = true;

        }
        if (choice == 2) {
            System.out.println("\nVous ne rejoignez pas les mangemorts.\n");

        }

    }
}

//    Le temps de la guerre est venu. Les Mangemorts ont attaqué Poudlard et les élèves doivent se préparer à défendre leur école. Vous êtes prêt à tout pour vaincre les forces du mal.
//
//        En chemin vers le champ de bataille, vous rencontrez des alliés qui se joignent à vous. Ensemble, vous avancez vers les Mangemorts.
//
//        Lorsque vous atteignez la Grande Salle, la bataille fait rage. Les sorts fusent de tous les côtés, mais vous êtes prêt à vous battre. Vous devez utiliser le sortilège Sectumsempra pour attaquer les Mangemorts.
//
//        Vous pouvez également choisir de rejoindre les rangs des Mangemorts si vous êtes de Serpentard. Dans ce cas, vous devrez attaquer les élèves de Poudlard et défendre les Mangemorts.
//
//        La bataille est intense, mais vous êtes déterminé à défendre votre école. Utilisez toutes les compétences que vous avez acquises jusqu'à présent pour vaincre les Mangemorts et remporter la bataille.
//
//        Le sortilège Sectumsempra sera votre meilleur allié dans cette bataille. Vous devrez être rapide et précis dans vos mouvements pour éviter les sorts ennemis.
//
//        Une fois que vous avez vaincu les Mangemorts, vous pouvez célébrer votre victoire avec vos amis et alliés. Mais n'oubliez pas que la guerre n'est pas terminée, il reste encore beaucoup à faire pour vaincre les forces du mal.
