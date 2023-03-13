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
        // Contexte vous êtes à 10 metre du troll or vous savez que pour utiliser Windgarium leviosa il faut etre a 7metre ou moins pour que le sort est une chance de reussir, plus vous etes proche + les chances sont élevés
        //Jetez des bouts de bois -20
        //Se rapprocher
        // utiliser WINDGARIUM LEviOSA


    }
}
