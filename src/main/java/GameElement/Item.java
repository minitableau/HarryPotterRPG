package GameElement;

public class Item {
    private String name;
    private int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static Item gryffindorSword = new Item("Gryffindor Sword", 20);
//    Item potionDamage = new Item("Potion de dégât", 30);
//    Item potionPrecision = new Item("Potion de précision", 10);
//    Item potionResistance = new Item("Potion de résistance", 15);

}


