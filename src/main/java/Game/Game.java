package Game;


import GameElement.*;
import Level.Level0;
import Level.Level1;
import MiniGame.TicTacToe.TicTacToe;


public class Game {
    private Wizard wizard;

    public static void main(String[] args) throws InterruptedException {
        // initialisation
        Wizard wizard = new Wizard(null, null, null, null);

//        new Wizard("name", Pet.Owl, new Wand(Core.DragonHeartstring, 23), House.GRYFFINDOR);
//        new Level0().level0(wizard);
//        Market.market(wizard);
        wizard.addItem(Item.gryffindorSword);
        Level1.level1(wizard);

    }

}