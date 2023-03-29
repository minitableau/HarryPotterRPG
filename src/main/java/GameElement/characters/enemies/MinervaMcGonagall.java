

package GameElement.characters.enemies;

import GameElement.characters.Character;
import GameElement.characters.Wizard;
import utils.MathUtils;

public class MinervaMcGonagall extends Boss {

    public MinervaMcGonagall() {
        super("Minerva McGonagall", "Humain", 7, 30);
    }

    @Override
    public void attack(Character character) { // same Peter mais modif texte
        Wizard wizard = (Wizard) character;
        int chanceOfSuccess = 70;
        System.out.println("\nLa probabilité qu'elle vous touche est de " + chanceOfSuccess + "%.");
        int randomValue = MathUtils.random(100);
        if (randomValue <= chanceOfSuccess) {
            int dommage = this.getDommage() - (this.getDommage() * wizard.getResistanceBonus()) / 100;
            wizard.takeDamage(dommage);
            System.out.println("Le professeur McGonagall, vous touche et vous enlève " + dommage + " points de vie.");
            if (!wizard.isAlive()) {
                System.out.println("Vous êtes mort! Minerva McGonagall vous a vaincu.");
            }
        } else {
            System.out.println("Minerva McGonagall lance un sort mais vous arrivez à l'éviter.");
        }

    }
}

