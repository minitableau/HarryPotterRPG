package GameElement;

public enum Pet {
    Owl(1, "Owl"),
    Rat(2,"Rat"),
    Cat(3,"Cat"),
    Toad(4,"Toad");

    public final int index;
    public final String type;

    Pet(int index, String type){
        this.index = index;
        this.type = type;
    }
}
