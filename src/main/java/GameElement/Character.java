package GameElement;

public abstract class Character {

    private int lifePoint;
    private final int maxLifePoint;

    private final String name;

    private int accuracy;

    private int power;

    private int efficiencyPotions;

    private int resistance;


    public Character(int lifePoint, int maxLifePoint, String name, int accuracy, int power, int efficiencyPotions, int resistance) {
        this.lifePoint = lifePoint;
        this.maxLifePoint = maxLifePoint;
        this.name = name;
        this.accuracy = accuracy;
        this.power = power;
        this.efficiencyPotions = efficiencyPotions;
        this.resistance = resistance;
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

    public void attack(Character character){


    }
}
