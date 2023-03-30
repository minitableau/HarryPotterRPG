

package GameElement.characters.enemies;

import GameElement.characters.Character;
import GameElement.characters.Wizard;
import utils.MathUtils;

public class BellatrixLestrange extends Boss {

    public BellatrixLestrange() {
        super("Bellatrix Lestrange", "Human", 10, 30);
    }

    @Override
    public void attack(Character character) { // same McGonagall mais modif texte
        Wizard wizard = (Wizard) character;
        int chanceOfSuccess = 70;
        System.out.println("\nLa probabilité qu'elle vous touche est de " + chanceOfSuccess + "%.");
        int randomValue = MathUtils.random(100);
        if (randomValue <= chanceOfSuccess) {
            int dommage = this.getDommage() - (this.getDommage() * wizard.getResistanceBonus()) / 100;
            wizard.takeDamage(dommage);
            System.out.println("Bellatrix Lestrange, vous touche et vous enlève " + dommage + " points de vie.");
            if (!wizard.isAlive()) {
                System.out.println("Vous êtes mort! Bellatrix Lestrange vous a vaincu.");
            }
        } else {
            System.out.println("Bellatrix Lestrange lance un sort mais vous arrivez à l'éviter.");
        }
    }

    @Override
    public String whatAWizardCanDoAgainstMe() {
        return null;
    }
}

