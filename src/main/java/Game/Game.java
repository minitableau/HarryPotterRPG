package Game;


import GameElement.*;
import Level.Level0;
import Level.Level1;


public class Game {
    private Wizard wizard;

    public static void main(String[] args) throws InterruptedException {
        // initialisation
        Wizard wizard = new Wizard(null, null, null, null);

//                new Wizard("name", Pet.Owl, new Wand(Core.DragonHeartstring, 23), House.GRYFFINDOR);
        new Level0().level0(wizard);
//        wizard.addPotion(Potion.potionHeal);
        wizard.addPotion(Potion.potionHeal);
        wizard.addPotion(Potion.potionHeal);
        wizard.addItem(Item.gryffindorSword);
//        wizard.addItem(Item.gryffindorSword);
//        wizard.addItem(Item.gryffindorSword);
        Level1.level1(wizard);

    }

}