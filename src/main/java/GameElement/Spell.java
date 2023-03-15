package GameElement;

public class Spell {
    private String name;

    public Spell(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Spell windgardiumLeviosa = new Spell("Windgardium Leviosa");

}
