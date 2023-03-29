package GameElement.characters.enemies;

import GameElement.characters.Character;

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
