package GameElement;

public class Potion {
    private String name;
    private String type;
    private int value;

    public Potion(String name, String type, int value) {
        this.name = name;
        this.type = type;
        this.value = value;
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

    public static Potion potionHeal = new Potion("Potion de soin", "soin", 20);
    public static Potion potionDamage = new Potion("Potion de dégât", "dégât", 30);
    public static Potion potionPrecision = new Potion("Potion de précision", "précision", 10);
    public static Potion potionResistance = new Potion("Potion de résistance", "résistance", 15);

}

