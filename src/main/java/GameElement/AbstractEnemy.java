package GameElement;

public abstract class AbstractEnemy {
    private String name;
    private String type;
    private int lifePoints;
    private int distance;
    private int dommage;

    public AbstractEnemy(String name, String type, int lifePoints, int distance, int dommage) {
        this.name = name;
        this.type = type;
        this.lifePoints = lifePoints;
        this.distance = distance;
        this.dommage = dommage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
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
