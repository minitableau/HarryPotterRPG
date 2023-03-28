package Level;

import GameElement.Character;
import GameElement.Enemy;
import GameElement.Wizard;

import java.util.ArrayList;

public class Level4 extends AbstractLevel {

    @Override
    public void startLevel(Wizard wizard) {
        Enemy enemy = Enemy.peterPettigrew;
        Character.fight(wizard, enemy, new ArrayList<>());
        wizard.checkIsAlive(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
    }
// Vous appercevais un portkey qui est votre seul chance du survie car vous n'etes pas assez puissant vos sorts et autre sont inecficace

}
//    Vous êtes le grand gagnant du Tournoi des Trois Sorciers, mais votre victoire s'est avérée être une malédiction. Vous vous retrouvez maintenant face à Voldemort et Peter Pettigrew dans un cimetière sombre et lugubre.
//
//        Voldemort est furieux et il se prépare à vous éliminer. Vous devez trouver un moyen de vous échapper rapidement. Vous apercevez un objet brillant au loin, qui pourrait être le Portkey que vous avez besoin d'atteindre pour vous échapper.
//
//        Mais atteindre le Portkey ne sera pas facile. Vous devez d'abord affronter Voldemort et Peter Pettigrew. Vous devrez utiliser toutes les compétences que vous avez acquises jusqu'à présent pour les vaincre. Utilisez des sorts défensifs tels que Protego pour vous protéger contre leurs attaques.
//
//        Une fois que vous les aurez vaincus, concentrez-vous sur le Portkey. Vous ne pouvez pas vous permettre de manquer votre coup. Utilisez le sort Accio pour attirer l'objet vers vous. Mais attention, Voldemort se relève et vous attaque à nouveau. Vous devez être rapide et efficace pour éviter ses attaques et saisir le Portkey avant qu'il ne soit trop tard.
//
//        Vous vous retrouvez alors soudainement de retour au château de Poudlard, en sécurité. Vous avez réussi à échapper à Voldemort, mais vous savez que vous n'en avez pas fini avec lui. Vous vous préparez pour l'ultime bataille qui aura lieu bientôt.
//
