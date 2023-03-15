package GameElement;

public class Friend {
    private String name;
    private House house;

    public Friend(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

//    public static Friend eloiseMidgen = new Friend("Eloise Midgen", null);
//    public static Friend vincentCrabbe = new Friend("Vincent Crabbe", null);
}
