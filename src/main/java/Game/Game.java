package Game;


import GameElement.*;
import Level.Level0;
import Level.Level1;


public class Game {
    private Wizard wizard;

    public static void main(String[] args) throws InterruptedException {

        Wizard wizard = new Wizard("name", Pet.Owl, new Wand(Core.DragonHeartstring, 23), House.GRYFFINDOR);
//        new Level0().level0(wizard);
        Level1.level1(wizard);

    }

}