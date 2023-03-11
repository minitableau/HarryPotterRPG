package GameElement;

public enum Core {
    DragonHeartstring(1, "Fil de coeur de dragon"),
    PhoenixFeather(2, "Plume de phénix"),
    UnicornTailHair(3, "Poil de queue de licorne"),
    VeelaHair(4, "Poils de Veela"),
    ThestralTailHair(5, "Poils de queue du Thestral"),
    TrollWhisker(6, "Moustache de troll");

    public final int index;
    public final String type;

    Core(int index, String type) {
        this.index = index;
        this.type = type;
    }
}


//Toutes les baguettes vendues par Garrick Ollivander coûtent sept galions, indépendamment du noyau ou du bois.[23]
// Cheveux de queue de licorne, cependant, valait dix galions par cheveux[24] as confirmed by Horace Slughorn in 1996.
// In 1926, wands sold by Shikoba Wolfe cost five dragots.