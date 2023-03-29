package GameElement.characters.enemies;

import GameElement.characters.Character;

public class Boss extends AbstractEnemy {

    public Boss(String name, String type, int distance, int dommage) {
        super(name, type, distance, dommage);
    }

    @Override
    public void attack(Character character) {

    }

//    public static Boss minervaMcGonagall = new Boss("Minerva McGonagall", "Human", 10, 30);
//    public static Boss bellatrixLestrange = new Boss("Bellatrix Lestrange", "Human", 10, 30);
//    public static Boss voldemort = new Boss("Voldemort", "Human", 10, 30);

}


