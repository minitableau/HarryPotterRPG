package GameElement;

public class Potion {
    private String name;
    private String type;
    private int value;
    private int cost;

    public Potion(String name, String type, int value, int cost) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.cost = cost;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public static Potion potionHeal = new Potion("Potion de soin", "soin", 20, 10);
    public static Potion potionDamage = new Potion("Potion de dégât", "dégât", 10, 30);
    public static Potion potionPrecision = new Potion("Potion de précision", "précision", 5, 30);
    public static Potion potionResistance = new Potion("Potion de résistance", "résistance", 5, 30);

}

