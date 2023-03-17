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

    public void setHouseBonus(Wizard wizard) {
        House house = wizard.getHouse();
        switch (house) {
            case HUFFLEPUFF:
                wizard.setEfficiencyPotionsBonus(10);
                break;
            case SLYTHERIN:
                wizard.setPowerBonus(10);
                break;
            case GRYFFINDOR:
                wizard.setResistanceBonus(10);
                break;
            case RAVENCLAW:
                wizard.setAccuracyBonus(10);
                break;
        }
    }


}
