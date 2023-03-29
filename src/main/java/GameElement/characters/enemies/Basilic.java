package GameElement.characters.enemies;

import GameElement.characters.Character;
import GameElement.characters.Wizard;
import utils.MathUtils;

public class Basilic extends Enemy {
    public Basilic() {
        super("Basilic de Salazar Serpentard", "Basilic", 3, 30);
    }

    @Override
    public void attack(Character character) {
        Wizard wizard = (Wizard) character;
        int chanceOfSuccess = 70;
        System.out.println("\nLa probabilité qu'il vous touche est de " + chanceOfSuccess + "%.");
        int randomValue = MathUtils.random(100);
        if (randomValue <= chanceOfSuccess) {
            int dommage = this.getDommage() - (this.getDommage() * wizard.getResistanceBonus()) / 100;
            wizard.takeDamage(dommage);
            System.out.println("La queue du Basilic, vous frappe et vous enlève " + dommage + " points de vie.");
            if (!wizard.isAlive()) {
                System.out.println("Vous êtes mort! Le basilic vous a vaincu.");
            }
        } else {
            System.out.println("Le basilic essaie de vous frapper avec ca queue mais vous arrivez à l'éviter.");
        }
    }
}

