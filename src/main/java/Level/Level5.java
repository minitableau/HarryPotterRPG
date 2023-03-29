package Level;

import GameElement.characters.Character;
import GameElement.characters.enemies.Enemy;
import GameElement.characters.Wizard;
import utils.ScrollingText;

public class Level5 extends AbstractLevel {
    public static boolean firework = false;

    @Override
    public void startLevel(Wizard wizard) {
        String GoMarket = "La rentrée arrive à grand pas et juste avant celle-ci vous décidez d'aller faire le plein de potion au magasin.";
        ScrollingText.printWithDelay(GoMarket);
        String IntroLvl5 = "Vous retournez a Poudlard et vous remarquez que Dolores Ombrage est la nouvelle directrice de l'école. Vous appréciez particulièrement Dumbledore et vous êtes triste de le voir partir. Vous devez faire avec l'année commence par un cours assez différent de ce que vous connaissiez, vous comprenez que la nouvelle directrice à changer le programme d'apprentissage. En effet, vous n'apprenez plus des sorts pour vous battre mais vous apprenez des sorts qui permettent de générer des feux d'artifice. Il s'agit de FeuxfousFuseboum. Vous y arrivez plutôt bien mais vous finissez par quittez le cours car vous n'avez pas envie de travailler un sort qui ne vous servira à rien.\nLe grand jour est arrivé, c'est l'heure de passer le Brevet Universel de Sorcellerie Élémentaire (BUSE). Mais Dolores Ombrage, la nouvelle directrice qui ne souhaite pas voir les élèves de Poudlard progresser dans le domaine du combat est aigri. Elle veille donc au grain et compte bien se mettre au travers de votre chemin surtout qu'elle n'a pas oublié votre attitude à son premier cours.";

        Enemy enemy = Enemy.doloresOmbrage;
        Character.fight(wizard, enemy, wizard.getFriends());
        wizard.checkIsAlive(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
    }
}


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



