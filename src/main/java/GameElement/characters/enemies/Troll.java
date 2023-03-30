package GameElement.characters.enemies;

import GameElement.Friend;
import GameElement.characters.Character;
import GameElement.characters.Wizard;
import utils.MathUtils;

import java.util.List;

public class Troll extends Enemy {
    public Troll() {
        super("Troll des montagnes", "Troll", 10, 30);
    }

    @Override
    public void attack(Character character) {
        Wizard wizard = (Wizard) character;
        List<Friend> sameHomeWizardFriends = wizard.getFriendsSameHome(List.of("Fleur Delacour"));

        int chanceOfSuccess = 40 + sameHomeWizardFriends.size() * 20;
        System.out.println("\nVous êtes " + (int) (sameHomeWizardFriends.size() + 1) + " contre le troll. La probabilité qu'il vous touche est de " + chanceOfSuccess + "%.");
        int randomValue = MathUtils.random(100);
        if (randomValue <= chanceOfSuccess) {
            int dommage = this.getDommage() - (this.getDommage() * wizard.getResistanceBonus()) / 100;
            wizard.takeDamage(dommage);
            System.out.println("La massue du troll, vous frappe et vous enlève " + dommage + " points de vie.");
            if (!wizard.isAlive()) {
                System.out.println("Vous êtes mort! Le troll vous a vaincu.");
            }
        } else {
            System.out.println("Le troll essaie de vous frapper avec ca massue mais vous arrivez à l'éviter.");
        }
    }

    @Override
    public void onWizardAttack(Wizard wizard) {
        int dommage = 20 + (20 * wizard.getPowerBonus()) / 100;
        System.out.println("Vous jetez des bouts de bois sur le troll. Il perd " + dommage + " points de vie");
        this.takeDamage(dommage);
    }

    @Override
    public String whatAWizardCanDoAgainstMe() {
        return "Jeter des bouts de bois";
    }
}
