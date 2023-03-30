package Level;

import GameElement.characters.enemies.BellatrixLestrange;
import GameElement.characters.enemies.Boss;
import GameElement.characters.Character;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.MinervaMcGonagall;
import GameElement.characters.enemies.Voldemort;
import GameElement.spells.Confringo;
import GameElement.spells.Expelliarmus;
import GameElement.spells.PetrificusTotalus;
import utils.ScrollingText;

import java.util.ArrayList;

public class Level7 extends AbstractLevel {

    public static boolean expelliarmusOn = false;
    public static boolean petrificusTotalus = false;

    @Override
    public void startLevel(Wizard wizard) {
        Boss enemy;
        String LearnSpell = "Depuis la tour, vous pouvez apercevoir et entendre des étudiants ce battre dans les jardins ceux-ci utilisent des sorts dont vous avez déjà entendu parler mais pas pratiqué : PetrificusTotalus qui permet d'immobiliser quelqu'un, Confringo qui permet de faire exploser quelque chose ou quelqu'un et pour finir Expelliarmus qui permet de se protéger du sort Avada Kedavra . Vous les retenez car ils pourraient vous être utile.";
        wizard.addSpell(new Confringo());
        wizard.addSpell(new PetrificusTotalus());
        wizard.addSpell(new Expelliarmus());
        if (Level6.areYouDeathEater) {
            String NewFight = "Vous décendez dans la cours de Poudlard dans laquelle vous trouvez le professeur McGonagall qui essaie de vous arretez. Vous engagez le combat seul contre elle pour montrer de quoi vous etes capable.";
            ScrollingText.printWithDelay(NewFight);
            enemy = new MinervaMcGonagall();
            wizard.fight(enemy);
        } else {
            String NewFight = "Vous décendez dans la cours de Poudlard dans laquelle vous trouvez Voldmort et Bellatrix Lestrange. Bellatrix Lestrange se place alors devant Voldemort. Vous allez donc devoir vaincre Bellatrix Lestrange pour pouvoir atteindre Voldemort.";
            ScrollingText.printWithDelay(NewFight);
            enemy = new BellatrixLestrange();
            wizard.fight(enemy);
            if (!wizard.isAlive()) return;
            String FightContinue = "Vous pouvez désormais attaquer Voldemort.";
            ScrollingText.printWithDelay(FightContinue);
            enemy = new Voldemort();
            wizard.fight(enemy);
        }
        if (!wizard.isAlive()) return;
        String Victory = "Vous avez réussi à survive à tous les niveaux, vous avez fini le jeu. Bravo !";
        ScrollingText.printWithDelay(Victory);
    }
}