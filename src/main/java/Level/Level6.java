package Level;

import GameElement.House;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.DeathEater;
import GameElement.characters.enemies.Enemy;
import GameElement.items.Market;
import utils.ConsoleColors;
import utils.InteractionUtils;
import utils.ScrollingText;

public class Level6 extends AbstractLevel {
    public static boolean areYouDeathEater = false;

    @Override
    public void startLevel(Wizard wizard) {
        String MARKET_LVL6 = "Comme avant chaque rentrée vous décidez de passer au magasin de potion";
        ScrollingText.printWithDelay(MARKET_LVL6);
        Market.market(wizard);

        String INTRO_LVL3 = "Vous êtes de retour à Poudlard, pour une nouvelle année. La directrice à encore changé il s'agit cette fois de votre ancien professeur Minerva McGonagall. Vous savez qu'elle était proche de Dumbledore et vous espérer qu'elle aura crée un programme intéressant pour cette année. L'année avance vous êtes plutôt satisfait mais vous avez envie d'apprendre des sorts plus puissant car vous savez que Voldemort ne va pas rester cacher toute ca vie. Vous allez donc voir votre professeur de potion Severus Rogue qui vous apprécie pour lui demander s'il peut vous apprendre des sorts plus puissant. Il vous apprend alors un sort que les élèves ne sont pas censé connaitre car vraiment très puissant, il s'agit d'un sort interdit et vous met en garde du danger. Il vous fait jurer que vous ne l'utiliserai que dans des conditions de nécessité absolu. Vous avez donc plusieurs cours sur le sort Sectumsempra. L'année continue de s'écouler et vous vous sentez plus puissant car vous arrivez de mieux en mieux à maitriser ce sort. Alors que la fin de l'année approche Poudlard est attaqué par des mangemorts. Vous vous réfugiez dans la tour d'astronomie du chateau. Mais les mangemorts viennent vous chercher, il tue tous les étudiants sur leur passage mais avant il propose au élève Serpentard de les rejoindres. Il arrive à atteindre la tour d'astronomie dans laquelle vous êtes.";
        ScrollingText.printWithDelay(INTRO_LVL3);


        if (wizard.getHouse() == House.SLYTHERIN) {
            String AskDeathEater = "Mais avant d'engager le combat les mangemorts vous proposent donc des les rejoindres car vous êtes un " + wizard.getHouse();
            ScrollingText.printWithDelay(AskDeathEater);
            joinDeathEater(wizard);
        }
        if (areYouDeathEater) return;

        String StartFight = "Vous engagez le combat avec les mangemorts";
        ScrollingText.printWithDelay(StartFight);

        Enemy enemy = new DeathEater();
        wizard.fight(enemy);
        if (!wizard.isAlive()) return;


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

//    Le temps de la guerre est venu. Les DeathEater ont attaqué Poudlard et les élèves doivent se préparer à défendre leur école. Vous êtes prêt à tout pour vaincre les forces du mal.
//
//        En chemin vers le champ de bataille, vous rencontrez des alliés qui se joignent à vous. Ensemble, vous avancez vers les DeathEater.
//
//        Lorsque vous atteignez la Grande Salle, la bataille fait rage. Les sorts fusent de tous les côtés, mais vous êtes prêt à vous battre. Vous devez utiliser le sortilège Sectumsempra pour attaquer les DeathEater.
//
//        Vous pouvez également choisir de rejoindre les rangs des DeathEater si vous êtes de Serpentard. Dans ce cas, vous devrez attaquer les élèves de Poudlard et défendre les DeathEater.
//
//        La bataille est intense, mais vous êtes déterminé à défendre votre école. Utilisez toutes les compétences que vous avez acquises jusqu'à présent pour vaincre les DeathEater et remporter la bataille.
//
//        Le sortilège Sectumsempra sera votre meilleur allié dans cette bataille. Vous devrez être rapide et précis dans vos mouvements pour éviter les sorts ennemis.
//
//        Une fois que vous avez vaincu les DeathEater, vous pouvez célébrer votre victoire avec vos amis et alliés. Mais n'oubliez pas que la guerre n'est pas terminée, il reste encore beaucoup à faire pour vaincre les forces du mal.
