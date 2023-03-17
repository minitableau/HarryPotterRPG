package GameElement;

import utils.ConsoleColors;

import java.util.Scanner;

public class Market {
    public static void market(Wizard wizard) {
        int money = wizard.getMoney();
        boolean purchaseProgress = true;
        System.out.println(ConsoleColors.ITALIC +"\n\tVous arrivez dans un magasin de potion."+ConsoleColors.RESET);
        while (purchaseProgress) {
            money = wizard.getMoney();
            System.out.println(ConsoleColors.GREEN + "\nVous disposez de " + money + " mornilles." + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE + "Voici les potions disponibles à l'achat :" + ConsoleColors.RESET);
            System.out.println("1 : La " + Potion.potionHeal.getName() + ", vous ajoute : " + Potion.potionHeal.getValue() + " de vie, son coût est de " + Potion.potionHeal.getCost() + " mornilles.");
            System.out.println("2 : La " + Potion.potionDamage.getName() + ", vous ajoute : " + Potion.potionDamage.getValue() + "% de dégât, son coût est de " + Potion.potionDamage.getCost() + " mornilles.");
            System.out.println("3 : La " + Potion.potionPrecision.getName() + ", vous ajoute : " + Potion.potionPrecision.getValue() + "% de précision, son coût est de " + Potion.potionPrecision.getCost() + " mornilles.");
            System.out.println("4 : La " + Potion.potionResistance.getName() + ", vous ajoute : " + Potion.potionResistance.getValue() + "% de résistance, son coût est de " + Potion.potionResistance.getCost() + " mornilles.");
            System.out.println("5 : Quitter le magasin.");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if (money >= Potion.potionHeal.getCost()) {
                        wizard.addPotion(Potion.potionHeal);
                        wizard.setMoney(money - Potion.potionHeal.getCost());
                        System.out.println("Vous avez acheté une potion de soin !");
                    } else {
                        System.out.println("Vous n'avez pas assez d'argent pour acheter cette potion.");
                    }
                    break;
                case 2:
                    if (money >= Potion.potionDamage.getCost()) {
                        wizard.addPotion(Potion.potionDamage);
                        wizard.setMoney(money - Potion.potionDamage.getCost());
                        System.out.println("Vous avez acheté une potion de dégât !");
                    } else {
                        System.out.println("Vous n'avez pas assez d'argent pour acheter cette potion.");
                    }
                    break;
                case 3:
                    if (money >= Potion.potionPrecision.getCost()) {
                        wizard.addPotion(Potion.potionPrecision);
                        wizard.setMoney(money - Potion.potionPrecision.getCost());
                        System.out.println("Vous avez acheté une potion de précision !");
                    } else {
                        System.out.println("Vous n'avez pas assez d'argent pour acheter cette potion.");
                    }
                    break;
                case 4:
                    if (money >= Potion.potionResistance.getCost()) {
                        wizard.addPotion(Potion.potionResistance);
                        wizard.setMoney(money - Potion.potionResistance.getCost());
                        System.out.println("Vous avez acheté une potion de résistance !");
                    } else {
                        System.out.println("Vous n'avez pas assez d'argent pour acheter cette potion.");
                    }
                    break;
                case 5:
                    purchaseProgress = false;
                    break;
                default:
                    System.out.println("Choix invalide, veuillez sélectionner un choix valide.");
                    break;
            }
        }
    }
}
