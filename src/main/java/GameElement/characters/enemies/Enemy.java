package GameElement.characters.enemies;

import GameElement.characters.Character;

public class Enemy extends AbstractEnemy {


    public Enemy(String name, String type, int distance, int dommage) {
        super(name, type, distance, dommage);
    }

    @Override
    public void attack(Character character) {
    }

//    public static Enemy troll = new Enemy("Troll des montagnes", "Troll", 10, 5);//30
//    public static Enemy basilic = new Enemy("Basilic de Salazar Serpentard", "Basilic", 3, 5);//30
//    public static Enemy dementors = new Enemy("Détraqueurs", "Détraqueurs", 8, 5);//20
//    public static Enemy peterPettigrew = new Enemy("Peter Pettigrew", "Humain", 10, 5);//20
//    public static Enemy doloresOmbrage = new Enemy("Dolores Ombrage", "Humain", 4, 5);//10
//    public static Enemy deathEater = new Enemy("Mangemorts", "Humain", 5, 5);//10
}
