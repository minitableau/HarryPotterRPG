package GameElement;


import java.util.ArrayList;
import java.util.List;

public class Wizard extends Character {
    private Pet pet;

    private Wand wand;

    private House house;

    private List<Spell> knownSpells;

    private List<Potion> potions;

    public void defend() {
    }

    public Wizard(String name, Pet pet, Wand wand, House house, List<Spell> knownSpells, List<Potion> potions) {
        super(200, 200, name, 50, 40, 1, 10);
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.knownSpells = knownSpells;
        this.potions = potions;
    }

    public Wizard(String name, Pet pet, Wand wand, House house) {
        this(name, pet, wand, house, new ArrayList<>(), new ArrayList<>());
    }
}
