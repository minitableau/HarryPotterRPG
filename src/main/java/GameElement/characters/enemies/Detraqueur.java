package GameElement.characters.enemies;

import GameElement.Friend;
import GameElement.characters.Character;
import GameElement.characters.Wizard;
import utils.MathUtils;

import java.util.List;

public class Detraqueur extends Enemy {
    public Detraqueur() {
        super("Détraqueurs", "Détraqueurs", 8, 20);
    }

    @Override
    public void attack(Character character) {
        Wizard wizard = (Wizard) character;
        List<Friend> sameHomeWizardFriends = wizard.getFriendsSameHome();

        int chanceOfSuccess = 40 + sameHomeWizardFriends.size() * 20;
        System.out.println("\nVous êtes " + (sameHomeWizardFriends.size() + 1) + " contre le détraqueur. La probabilité qu'il vous touche est de " + chanceOfSuccess + "%.");

        int randomValue = MathUtils.random(100);
        if (randomValue <= chanceOfSuccess) {
            int dommage = this.getDommage() - (this.getDommage() * wizard.getResistanceBonus()) / 100;
            wizard.takeDamage(dommage);
            System.out.println("Le détraqueur reveille en vous des souvenirs très douloureux vous perdez " + dommage + " points de vie.");
            if (!wizard.isAlive()) {
                System.out.println("Vous êtes mort! Le détraqueur vous a vaincu.");
            }
        } else {
            System.out.println("Le détraqueur essaie de vous rappelez de mauvais souvenir mais vous arrivez à résister.");
        }
    }
}
