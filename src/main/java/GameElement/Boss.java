package GameElement;

public class Boss extends AbstractEnemy {


    public Boss(String name, String type, int lifePoints, int distance, int dommage) {
        super(name, type, lifePoints, distance, dommage);
    }

    public static Boss minervaMcGonagall = new Boss("Minerva McGonagall", "Human", 100, 10, 30);
    public static Boss bellatrixLestrange = new Boss("Bellatrix Lestrange", "Human", 100, 10, 30);
    public static Boss voldemort = new Boss("Voldemort", "Human", 100, 10, 30);

}


