package GameElement.items;

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

    public static Item gryffindorSword = new Item("L'épée de Gryffindor ", 100);
    public static Item firework = new Item("Feu d'artifice ", 50);


}


