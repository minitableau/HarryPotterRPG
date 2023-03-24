package GameElement;

public class Enemy {
    private String name;
    private String type;
    private int lifePoints;
    private int distance;

    private int dommage;

    public Enemy(String name, String type, int lifePoints, int distance, int dommage) {
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

    public static Enemy troll = new Enemy("Troll des montagnes", "Troll", 100, 10, 30);
    public static Enemy basilic = new Enemy("Basilic de Salazar Serpentard", "Basilic", 100, 3, 20);
}
