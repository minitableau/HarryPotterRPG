package GameElement;

import utils.ConsoleColors;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public abstract class Character {

    private int lifePoint;
    private final int maxLifePoint;

    private final String name;

    private int accuracy;

    private int power;

    private int efficiencyPotions;

    private int resistance;
    private int mana;

    private int money;


    public Character(int lifePoint, int maxLifePoint, String name, int accuracy, int power, int efficiencyPotions, int resistance, int mana, int money) {
        this.lifePoint = lifePoint;
        this.maxLifePoint = maxLifePoint;
        this.name = name;
        this.accuracy = accuracy;
        this.power = power;
        this.efficiencyPotions = efficiencyPotions;
        this.resistance = resistance;
        this.mana = mana;
        this.money = money;
    }

    public int getLifePoint() {
        return lifePoint;
    }

    public void setLifePoint(int lifePoint) {
        this.lifePoint = lifePoint;
    }

    public int getMaxLifePoint() {
        return maxLifePoint;
    }

    public String getName() {
        return name;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getEfficiencyPotions() {
        return efficiencyPotions;
    }

    public void setEfficiencyPotions(int efficiencyPotions) {
        this.efficiencyPotions = efficiencyPotions;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
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

    public void attack(Character character) {
        //Gérer deux cas : Wizard ou AbstractEnemy

    }

}
