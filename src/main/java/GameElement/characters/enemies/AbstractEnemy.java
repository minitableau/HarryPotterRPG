package GameElement.characters.enemies;

import GameElement.characters.Character;
import GameElement.characters.Wizard;

public abstract class AbstractEnemy extends Character {
    private final String type;
    private int distance;
    private int dommage;

    public AbstractEnemy(String name, String type, int distance, int dommage) {
        super(name);
        this.type = type;
        this.distance = distance;
        this.dommage = dommage;
    }

    public abstract String whatAWizardCanDoAgainstMe();

    public abstract void onWizardAttack(Wizard wizard);

    public abstract void onWizardBackpackOpen(Wizard wizard);

    public String getType() {
        return type;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDommage() {
        return dommage;
    }

    public void setDommage(int dommage) {
        this.dommage = dommage;
    }
}
