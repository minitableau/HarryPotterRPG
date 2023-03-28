package Level;

import GameElement.Boss;
import GameElement.Character;
import GameElement.Wizard;

public class Level7 extends AbstractLevel {

    @Override
    public void startLevel(Wizard wizard) {
        Boss enemy;// & Boss enemy = Boss.voldemort;
        if (Level6.areYouDeathEater) {
            enemy = Boss.minervaMcGonagall;
            Character.fight(wizard, enemy, wizard.getFriends());
        } else {
            enemy = Boss.bellatrixLestrange;
            Character.fight(wizard, enemy, wizard.getFriends());
        }
        wizard.checkIsAlive(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
    }
}


//    Vous êtes face à Voldemort et Bellatrix Lestrange, prêts à en découdre une fois pour toutes. Vous savez que c'est un combat à mort, et que la moindre erreur pourrait vous coûter la vie.
//
//        Voldemort commence à lancer des sorts dès le début du combat, mais vous parvenez à les éviter grâce à vos réflexes. Vous cherchez une ouverture pour lancer votre propre attaque.
//
//        Bellatrix Lestrange tente de vous distraire en lançant des sorts de confusion, mais vous restez concentré sur votre objectif. Vous savez que c'est votre seule chance de vaincre Voldemort et mettre fin à la guerre une fois pour toutes.
//
//        Voldemort utilise son sort de prédilection, Avada Kedavra, mais vous parvenez à le contrer avec le sortilège de Protection, Protego. Bellatrix Lestrange lance alors un sortilège de désarmement, Expelliarmus, mais vous réussissez à esquiver de justesse.
//
//        Vous enchaînez alors avec votre propre sortilège, Sectumsempra, qui atteint Voldemort de plein fouet. Le combat continue de plus belle, avec des sorts lancés dans tous les sens.
//
//        Bellatrix Lestrange tente de vous attaquer par derrière, mais vous vous retournez à temps pour lui lancer un sortilège de désarmement, la mettant hors d'état de nuire.
//
//        Il ne reste plus que vous et Voldemort. Vous vous regardez dans les yeux, sachant que c'est la fin. Vous lancez alors votre ultime sort, Expelliarmus, qui désarme Voldemort.
//
//        Voldemort est vaincu. La guerre est terminée. Vous avez accompli votre mission.
