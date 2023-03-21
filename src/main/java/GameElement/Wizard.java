package GameElement;


import java.util.ArrayList;
import java.util.List;

public class Wizard extends Character {

    private String name;
    private Pet pet;

    private Wand wand;

    private House house;

    private int housePoints;
    private List<Knowledge> knowledges;

    private List<Spell> knownSpells;

    private List<Potion> potions;

    private List<Item> items;

    private List<Friend> friends;

    public void defend() {
    }

    public String stats(String name, int lifePoint, int maxLifePoint, int mana, int resistance, int power, int accuracy, int EfficiencyPotions, int money) {
        return "\nStatistiques de " + name + " : " + "❤️ " + lifePoint + "/" + maxLifePoint + " |" + " 💧 " + mana + "/100 |" + " 🛡️ + " + resistance + "% |" + " 💪 + " + power + "% |" + " 🎯 + " + accuracy + "% |" + " ⚗️ + " + EfficiencyPotions + "% |" + " 💵 " + money + "$";
    }

    public Wizard(String name, Pet pet, Wand wand, House house, List<Spell> knownSpells, List<Potion> potions, List<Item> items, List<Friend> friends, int housePoints, List<Knowledge> knowledges) {
        super(100, 100, name, 0, 0, 0, 0, 100, 100, true);
        this.name = name;
        this.pet = pet;
        this.wand = wand;
        this.house = house;
        this.knownSpells = knownSpells;
        this.potions = potions;
        this.items = items;
        this.friends = friends;
        this.housePoints = housePoints;
        this.knowledges = knowledges;
    }

    public Wizard(String name, Pet pet, Wand wand, House house) {
        this(name, pet, wand, house, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 200, new ArrayList<>());
    }

    public void CheckIsAlive(Wizard wizard) {
        if (wizard.getLifePoint() <= 0) {
            wizard.setIsAlive(false);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        this.wand = wand;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public List<Spell> getKnownSpells() {
        return knownSpells;
    }

    public void setKnownSpells(List<Spell> knownSpells) {
        this.knownSpells = knownSpells;
    }

    public void addSpell(Spell spell) {
        this.knownSpells.add(spell);
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }

    public void addPotion(Potion potion) {
        this.potions.add(potion);
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    public void addFriend(Friend friend) {
        this.friends.add(friend);
    }

    public int getHousePoints() {
        return housePoints;
    }

    public void setHousePoints(int housePoints) {
        this.housePoints = housePoints;
    }

    public List<Knowledge> getKnowledges() {
        return knowledges;
    }

    public void setKnowledges(List<Knowledge> knowledges) {
        this.knowledges = knowledges;
    }

    public void addKnowledge(Knowledge knowledge) {
        this.knowledges.add(knowledge);
    }

}


