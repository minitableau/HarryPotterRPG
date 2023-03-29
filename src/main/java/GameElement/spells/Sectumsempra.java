package GameElement.spells;

import GameElement.characters.Character;
import GameElement.characters.Wizard;
import GameElement.characters.enemies.Mangemorts;
import GameElement.characters.enemies.MinervaMcGonagall;
import utils.MathUtils;

public class Sectumsempra extends ForbiddenSpell {
    public Sectumsempra() {
        super("Sectumsempra");
    }

    @Override
    public void cast(Wizard wizard, Character target) {

        if (target instanceof Mangemorts mangemorts) {
            castOnMangemorts(wizard, mangemorts);
        } else {
            System.out.println("Votre sort n'a rien fait au " + target.getName());
        }

    }

    private void castOnMangemorts(Wizard wizard, Mangemorts mangemorts) {
        int chanceOfSuccess = 0;
        if (mangemorts.getDistance() <= 5) {
            System.out.println("Vous utilisez sectumsempra sur un des mangemorts!");
            chanceOfSuccess = getChanceOfSuccess(wizard, mangemorts);
            System.out.println("Vous êtes à " + mangemorts.getDistance() + " mètres des mangemorts. Votre chance de réussite est de " + chanceOfSuccess + "%.");
            int randomValue = MathUtils.random(100);
            if (randomValue <= chanceOfSuccess) {
                System.out.println("Votre sort atteint les mangemorts, ils perdents " + (30 + (30 * wizard.getPowerBonus()) / 100) + " points de vie.");
                int damage = 30 + (30 * wizard.getPowerBonus()) / 100;
                mangemorts.takeDamage(damage);
            } else {
                System.out.println("Vous ratez votre sort de justesse.");
            }
        }
    }

    private void castOnMinervaMcGonagall(Wizard wizard, MinervaMcGonagall minervaMcGonagall) {
        int chanceOfSuccess = 0;
        if (minervaMcGonagall.getDistance() <= 5) {
            System.out.println("Vous utilisez sectumsempra sur Minerva McGonagall!");
            chanceOfSuccess = getChanceOfSuccess(wizard, minervaMcGonagall);
            System.out.println("Vous êtes à " + minervaMcGonagall.getDistance() + " mètres de Minerva McGonagall. Votre chance de réussite est de " + chanceOfSuccess + "%.");
            int randomValue = MathUtils.random(100);
            if (randomValue <= chanceOfSuccess) {
                System.out.println("Votre sort atteint Minerva McGonagall, elle perd " + (30 + (30 * wizard.getPowerBonus()) / 100) + " points de vie.");
                int damage = 30 + (30 * wizard.getPowerBonus()) / 100;
                minervaMcGonagall.takeDamage(damage);
            } else {
                System.out.println("Vous ratez votre sort de justesse.");
            }
        }
    }
}
