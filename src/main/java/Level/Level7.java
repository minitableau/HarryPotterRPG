package Level;

import GameElement.characters.enemies.BellatrixLestrange;
import GameElement.characters.enemies.Boss;
import GameElement.characters.Character;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.MinervaMcGonagall;
import GameElement.characters.enemies.Voldemort;
import utils.ScrollingText;

import java.util.ArrayList;

public class Level7 extends AbstractLevel {

    public static boolean expelliarmusOn = false;
    public static boolean petrificusTotalus = false;

    @Override
    public void startLevel(Wizard wizard) {
        Boss enemy;
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