package Level;

import GameElement.Character;
import GameElement.Enemy;
import GameElement.Market;
import GameElement.Wizard;

public class Level3 extends AbstractLevel {

    //Utilisez votre Patronus (Expecto Patronum) pour mettre les Détraqueurs en fuite !

    @Override
    public void startLevel(Wizard wizard) {
        // Mais avant vous souhaitez faire le plein de fourniture pour cela vous utilisez une cheminée qui permet de transplaner, vous prononcez votre destination : \"chemin de traverse\". Et vous arrivez dans un petit magasin de potions :
        Market.market(wizard);
        //RDV au train
        // Après plusieurs heures de voyage. Vous arrivez enfin à Poudlard, avec le retard.


        Enemy enemy = Enemy.dementors;
        Character.fight(wizard, enemy, wizard.getFriends());
        wizard.checkIsAlive(wizard);
        if (!wizard.getIsAlive()) {
            return;
        }
    }
}


//
//        Int. Grande Salle - Jour
//
//        Vous êtes de retour à Poudlard, et vous vous rendez à la Grande Salle pour une réunion d'urgence. Le professeur Dumbledore vous informe que les Détraqueurs se sont échappés de la prison d'Azkaban et qu'ils errent maintenant librement dans les rues et les campagnes, aspirant l'espoir et le bonheur de quiconque croise leur chemin. Cependant, il y a un sort qui peut les mettre en fuite : Expecto Patronum. Dumbledore vous demande de vous entraîner à ce sort et de vous préparer à affronter les Détraqueurs.
//
//        Int. Cours de Sortilèges - Jour
//
//        Vous assistez au cours de Sortilèges donné par le professeur Lupin. Il vous apprend les bases de la fabrication d'un Patronus, et vous explique comment le lancer correctement. Vous vous entraînez ensuite avec vos camarades de classe.
//
//        Ext. Terrain de Quidditch - Jour
//
//        Vous pratiquez votre sortilège sur des cibles volantes qui ressemblent aux Détraqueurs, tout en évitant les obstacles sur le terrain de Quidditch. Vous devez faire preuve de précision et de rapidité pour vaincre vos ennemis.
//
//        Int. Forêt interdite - Nuit
//
//        Vous êtes envoyé dans la forêt interdite pour affronter de véritables Détraqueurs.
//        Vous utilisez votre Patronus pour les vaincre et sauver les étudiants qui ont été piégés par les créatures. Vous retournez à Poudlard en triomphant, avec le sentiment d'avoir accompli une grande mission.
//
//        Int. Grande Salle - Jour
//
//        Vous êtes félicité par Dumbledore et vos camarades de classe pour avoir sauvé Poudlard des Détraqueurs. Vous vous sentez fier d'avoir appris à maîtriser un sort aussi puissant et vous vous préparez à affronter de nouveaux défis dans l'avenir.
