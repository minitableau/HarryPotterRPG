package GameElement.characters.enemies;

import GameElement.Friend;
import GameElement.characters.Character;
import GameElement.characters.Wizard;
import utils.MathUtils;

import java.util.List;

public class DoloresOmbrage extends Enemy {
    public DoloresOmbrage() {
        super("Dolores Ombrage", "Humain", 4, 10);
    }

    @Override
    public void attack(Character character) {
        Wizard wizard = (Wizard) character;
        List<Friend> sameHomeWizardFriends = wizard.getFriendsSameHome();
        int chanceOfSuccess = 40 + sameHomeWizardFriends.size() * 20;
        System.out.println("\nVous êtes " + (sameHomeWizardFriends.size() + 1) + " contre Dolores Ombrage. La probabilité qu'elle vous touche est de " + chanceOfSuccess + "%.");
        int randomValue = MathUtils.random(100);
        if (randomValue <= chanceOfSuccess) {
            int dommage = this.getDommage() - (this.getDommage() * wizard.getResistanceBonus()) / 100;
            wizard.takeDamage(dommage);
            System.out.println("Dolores Ombrage, vous touche et vous enlève " + dommage + " points de vie.");
            if (!wizard.isAlive()) {
                System.out.println("Vous êtes mort! Dolores Ombrage vous à vaincu.");
            }
        } else {
            System.out.println("Dolores Ombrage lance un sort mais vous arrivez à l'éviter.");
        }
    }
}
