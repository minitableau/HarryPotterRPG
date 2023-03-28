package Level;

import GameElement.Character;
import GameElement.Enemy;
import GameElement.Wizard;

public class Level5 extends AbstractLevel {
    public static boolean firework = false;

    @Override
    public void startLevel(Wizard wizard) {
        Enemy enemy = Enemy.doloresOmbrage;
        Character.fight(wizard, enemy, wizard.getFriends());
        wizard.checkIsAlive(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
    }
}


//    Le grand jour est arrivé, c'est l'heure de passer le Brevet Universel de Sorcellerie Élémentaire (BUSE). Mais Dolores Ombrage, l'inquisitrice impitoyable, veille au grain et compte bien mettre des bâtons dans les roues des élèves de Poudlard.
//
//        Votre objectif est de distraire Ombrage pour que vos amis puissent préparer les feux d'artifice qui seront utilisés pour créer une diversion. Mais attention, Ombrage est redoutable et ses yeux perçants scrutent tous les recoins de la salle d'examen.
//
//        Vous commencez à chercher une opportunité de distraire Ombrage. Soudain, vous remarquez que son chat, croquant un biscuit, s'est échappé de sa cage. C'est votre chance !
//
//        Vous décidez d'utiliser votre sortilège de distraction préféré : "Accio biscuit !" Vous lancez votre sortilège avec toute votre concentration et votre baguette brille d'une lumière rouge. Le biscuit s'envole des mains du chat et se dirige droit vers vous.
//
//        Ombrage se retourne pour voir ce qui s'est passé et vous en profitez pour lui poser une question. Elle commence à parler, et vous remarquez que ses yeux sont désormais tournés vers vous. C'est le moment pour vos amis de lancer les feux d'artifice.
//
//        Vous entendez des explosions derrière vous et Ombrage, surprise, se tourne pour voir ce qui se passe. Vous en profitez pour vous éclipser discrètement avec vos amis.
//
//        Félicitations, vous avez réussi à distraire Ombrage et permis à vos amis de créer une diversion réussie. Vous pouvez maintenant vous concentrer sur votre examen en toute tranquillité.
//



