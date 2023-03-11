package GameElement;

public enum Pet {
    Owl(1, "Chouette"),
    Rat(2,"Rat"),
    Cat(3,"Chat"),
    Toad(4,"Crapaud");

    public final int index;
    public final String type;

    Pet(int index, String type){
        this.index = index;
        this.type = type;
    }


}
