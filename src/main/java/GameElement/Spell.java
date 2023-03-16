package GameElement;

import javax.swing.plaf.SplitPaneUI;

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
    public static Spell aloomora = new Spell("Aloomora");
    // appris au lvl1 dans makefriendorexplore si choix 1

}
