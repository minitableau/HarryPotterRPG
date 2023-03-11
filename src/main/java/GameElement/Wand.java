package GameElement;

public class Wand {
    private Core core;

    private int Size;

    public Wand(Core core, int size) {
        this.core = core;
        Size = size;
    }

    public Core getCore() {
        return core;
    }
}
