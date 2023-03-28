package GameElement;

public class Enemy extends AbstractEnemy {


    public Enemy(String name, String type, int lifePoints, int distance, int dommage) {
        super(name, type, lifePoints, distance, dommage);
    }


    public static Enemy troll = new Enemy("Troll des montagnes", "Troll", 100, 10, 5);//30
    public static Enemy basilic = new Enemy("Basilic de Salazar Serpentard", "Basilic", 100, 3, 5);//30
    public static Enemy dementors = new Enemy("Détraqueurs", "Détraqueurs", 100, 8, 5);//20
    public static Enemy peterPettigrew = new Enemy("Peter Pettigrew", "Humain", 100, 10, 5);//20
    public static Enemy doloresOmbrage = new Enemy("Dolores Ombrage", "Humain", 100, 4, 5);//10
    public static Enemy deathEater = new Enemy("des Mangemorts", "Humain", 100, 5, 5);//10


}
