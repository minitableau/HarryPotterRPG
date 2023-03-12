package GameElement;

import utils.ConsoleColors;

public enum House {
    GRYFFINDOR(ConsoleColors.RED, "Gryffondor"),
    HUFFLEPUFF(ConsoleColors.YELLOW, "Poufsouffle"),
    RAVENCLAW(ConsoleColors.BLUE, "Serdaigle"),
    SLYTHERIN(ConsoleColors.GREEN, "Serpentard");

    final String color;

    final String name;

    House(String color, String name) {
        this.color = color;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.color + this.name + ConsoleColors.RESET;
    }

    public boolean isTheMostEfficiencyPotion() {
        return this == HUFFLEPUFF;
    }

}
