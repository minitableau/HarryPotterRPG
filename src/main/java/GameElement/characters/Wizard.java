package GameElement.characters;


import GameElement.*;
import GameElement.characters.enemies.AbstractEnemy;
import GameElement.characters.enemies.Troll;
import GameElement.items.Backpack;
import GameElement.spells.AbstractSpell;
import GameElement.spells.ForbiddenSpell;
import Level.Level2;
import MiniGame.ThirteenStick.ThirteenStick;
import utils.ConsoleColors;
import utils.InteractionUtils;

import java.util.ArrayList;
import java.util.List;

public class Wizard extends Character {

    private String name;
    private Pet pet;
    private Wand wand;
    private House house;
    private final Backpack backpack;
    private int housePoints = 200;
    private final ArrayList<Knowledge> knowledges = new ArrayList<>();
    private final ArrayList<AbstractSpell> knownSpells = new ArrayList<>();
    private final ArrayList<Friend> friends = new ArrayList<>();
    private int accuracyBonus;
    private int powerBonus;
    private int efficiencyPotionsBonus;
    private int resistanceBonus;
    private int mana;
    private int money;

    public Wizard(String name, Pet pet, Wand wand, House house) {
        super(name);
        this.name = name;
        this.pet = pet;
        this.wand = wand;
        this.house = house;

        this.backpack = new Backpack(this);
    }

    @Override
    public void attack(Character character) {
        if (character instanceof Troll characterTroll) {
            attackTroll(characterTroll);
        }
    }

    private void attackTroll(Troll characterTroll) {
        while (true) {
            System.out.println(this);
            System.out.println(ConsoleColors.BLUE + "\nQue voulez-vous faire sachant que le " + characterTroll.getName() + " se situe à " + characterTroll.getDistance() + " mètres et à " + characterTroll.getLifePoint() + " points de vie ?" + ConsoleColors.RESET);
            System.out.println("1 : Jeter des bouts de bois");
            System.out.println("2 : Se rapprocher");
            System.out.println("3 : Utiliser un sort");
            System.out.println("4 : Ouvrir votre sac");

            int choice = InteractionUtils.askForInt(1, 4);

            if (choice == 1) {
                int dommage = 20 + (20 * this.getPowerBonus()) / 100;
                System.out.println("Vous jetez des bouts de bois sur le troll. Il perd " + dommage + " points de vie");
                characterTroll.takeDamage(dommage);
                if (!characterTroll.isAlive()) {
                    break;
                }
            } else if (choice == 2) {
                System.out.println("Vous vous rapprochez du " + characterTroll.getName() + ".");
                characterTroll.setDistance(characterTroll.getDistance() - 1);
            } else if (choice == 3) {
                AbstractSpell spell = this.selectSpell();
                if (spell != null) {
                    spell.cast(this, characterTroll);
                    if (!characterTroll.isAlive()) {
                        break;
                    }
                }
            } else if (choice == 4) {
                this.getBackpack().open(characterTroll);
            }
        }
    }

    public void fight(AbstractEnemy enemy) {
        while (enemy.getDistance() >= 1 && !enemy.isAlive() && !this.isAlive()) {
            attack(enemy);
            if (enemy.getDistance() < 1) {
                break;
            }
            if (enemy.isAlive()) {
                break;
            }
            for (Friend friend : this.friends) {
                System.out.println("\nVotre ami " + friend.getName() + " peut aussi attaquer le " + enemy.getName() + ".");
                attack(enemy);
                if (enemy.getDistance() < 1 || enemy.isAlive()) {
                    break;
                }
            }
            if (enemy.getDistance() < 1 || enemy.isAlive()) {
                break;
            }

            enemy.attack(this);
        }

        if (enemy.getDistance() < 1) {
            this.die();
            if (enemy.getType().equals("Humain")) {
                System.out.println("Quel idée de se coller à " + enemy.getName() + " ! Celui-ci vous attrape et vous tue.");
            } else {
                System.out.println("Quel idée de se coller au " + enemy.getName() + " ! Celui-ci vous mange.");
            }
        }

        if (!enemy.isAlive()) {
            if (enemy.getType().equals("Humain")) {
                System.out.println("Vous avez vaincu " + enemy.getName() + " !");
            } else {
                System.out.println("Vous avez vaincu le " + enemy.getName() + " !");
                Level2.tooth = false;
            }
        }
    }

    public boolean defend(Wizard wizard) {
        return ThirteenStick.thirteenStick();
    }

    private AbstractSpell selectSpell() {
        int numSpells = this.getKnownSpells().size();

        AbstractSpell spell = null;
        if (numSpells == 0) {
            System.out.println("Vous n'avez appris aucun sort.");
        } else {
            System.out.println(ConsoleColors.BLUE + "\nVeuillez choisir un sort :" + ConsoleColors.RESET);
            for (int i = 0; i < numSpells; i++) {
                System.out.println((i + 1) + " : " + this.getKnownSpells().get(i).getName());
            }
            System.out.println((numSpells + 1) + " : Ne pas utiliser de sort.");

            int choice = InteractionUtils.askForInt(1, numSpells + 1);
            if (choice < numSpells + 1) {
                spell = this.getKnownSpells().get(choice - 1);
                System.out.println("Vous avez choisi le sort " + spell.getName() + ".");
            } else {
                System.out.println("Vous avez choisi de ne pas utiliser de sort.");
            }
        }

        return spell;
    }

    @Override
    public String toString() {
        return "Statistiques de " + name + " : " + "❤️ " + getLifePoint() + "/" + getMaxLifePoint() + " |" + " 💧 " + mana + "/100 |" + " 🛡️ + " + resistanceBonus + "% |" + " 💪 + " + powerBonus + "% |" + " 🎯 + " + accuracyBonus + "% |" + " ⚗️ + " + efficiencyPotionsBonus + "% |" + " 💵 " + money + "$";
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

    public List<AbstractSpell> getKnownSpells() {
        return knownSpells;
    }

    public boolean hasKnownSpell(String name) {
        return knownSpells.stream().anyMatch(spell -> spell.getName().equalsIgnoreCase(name));
    }

    public void addSpell(AbstractSpell spell) {
        this.knownSpells.add(spell);
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public List<Friend> getFriendsSameHome() {
        return getFriendsSameHome(new ArrayList<>());
    }

    public List<Friend> getFriendsSameHome(List<Friend> excludes) {
        List<Friend> friendsSameHome = new ArrayList<>();
        for (Friend friend : friends) {
            if (friend.getHouse() == house && !excludes.contains(friend)) {
                friendsSameHome.add(friend);
            }
        }
        return friendsSameHome;
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

    public void addKnowledge(Knowledge knowledge) {
        this.knowledges.add(knowledge);
    }

    public List<ForbiddenSpell> getForbiddenSpells() {
        return forbiddenSpells;
    }

    public Backpack getBackpack() {
        return backpack;
    }


    public int getPowerBonus() {
        return powerBonus;
    }

    public void setPowerBonus(int powerBonus) {
        this.powerBonus = powerBonus;
    }

    public int getAccuracyBonus() {
        return accuracyBonus;
    }

    public void setAccuracyBonus(int accuracyBonus) {
        this.accuracyBonus = accuracyBonus;
    }

    public int getEfficiencyPotionsBonus() {
        return efficiencyPotionsBonus;
    }

    public void setEfficiencyPotionsBonus(int efficiencyPotionsBonus) {
        this.efficiencyPotionsBonus = efficiencyPotionsBonus;
    }

    public int getResistanceBonus() {
        return resistanceBonus;
    }

    public void setResistanceBonus(int resistanceBonus) {
        this.resistanceBonus = resistanceBonus;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}


