package GameElement.characters.enemies;

import GameElement.characters.Character;
import GameElement.characters.Wizard;
import Level.Level2;
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

    @Override
    public String whatAWizardCanDoAgainstMe() {
        return "Jeter des pierres";
    }

    @Override
    public void onWizardAttack(Wizard wizard) {
        int dommage = 1 + (1 * wizard.getPowerBonus()) / 100;
        System.out.println("Vous jetez des pierre sur le Basilic. Il perd " + dommage + " points de vie");
        this.takeDamage(dommage);
    }

    @Override
    public void onWizardBackpackOpen(Wizard wizard) {
        if (this.getDistance() == 1 && Level2.tooth) {
            System.out.println("Vous ramassez la dent du basilic pour le frappez ce qui lui enlève 50 points de vie.");
            this.takeDamage(50 + (50 * wizard.getPowerBonus()) / 100);
            if (this.isAlive()) {
                System.out.println("mais vous repoussez d'un mètre.");
                this.setDistance(2);
            }
        }
    }
}

