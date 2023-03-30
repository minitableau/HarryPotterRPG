package GameElement.characters.enemies;

import GameElement.characters.Character;
import GameElement.characters.Wizard;
import utils.MathUtils;

public class Mangemorts extends Enemy {

    public Mangemorts() {
        super("Mangemorts", "Humain", 5, 10);
    }

    @Override
    public void attack(Character character) { // same Peter mais modif texte
        Wizard wizard = (Wizard) character;
        int chanceOfSuccess = 70;
        System.out.println("\nLa probabilité qu'ils vous touchent est de " + chanceOfSuccess + "%.");
        int randomValue = MathUtils.random(100);
        if (randomValue <= chanceOfSuccess) {
            int dommage = this.getDommage() - (this.getDommage() * wizard.getResistanceBonus()) / 100;
            wizard.takeDamage(dommage);
            System.out.println("Les mangemorts, vous touchent et vous enlèvent " + dommage + " points de vie.");
            if (!wizard.isAlive()) {
                System.out.println("Vous êtes mort! Les mangemorts vous ont vaincu.");
            }
        } else {
            System.out.println("Les mangemorts lancent des sorts mais vous arrivez à les éviter.");
        }
    }

    @Override
    public void onWizardAttack(Wizard wizard) {
        int dommage = 5 + (5 * wizard.getPowerBonus()) / 100;
        System.out.println("Vous jetez des compas sur les mangemorts. Ils perdent " + dommage + " points de vie");
        this.takeDamage(dommage);
    }

    @Override
    public String whatAWizardCanDoAgainstMe() {
        return "Jeter des compas";
    }
}
