package GameElement;

public abstract class AbstractSpell {

    private String name;

    public AbstractSpell(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
