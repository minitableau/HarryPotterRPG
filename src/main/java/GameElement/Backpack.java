package GameElement;

import utils.ConsoleColors;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Backpack {


    public static boolean openBackpack(Wizard wizard, Enemy enemy) {
        boolean comeback2 = true;
        Scanner scanner = new Scanner(System.in);
        while (comeback2) {
            System.out.println(ConsoleColors.BLUE + "\nVous ouvrez votre sac, souhaitez-vous prendre quelque chose ?" + ConsoleColors.RESET);
            System.out.println("1 : Chercher une potion");
            System.out.println("2 : Chercher un objet");
            System.out.println("3 : Refermer le sac");

            try {
                int backpackChoice = scanner.nextInt();
                scanner.nextLine();

                if (backpackChoice < 1 || backpackChoice > 3) {
                    System.out.println("Le choix doit être 1, 2, ou 3.");
                }

                switch (backpackChoice) {
                    case 1 -> {
                        comeback2 = findPotions(wizard);
                    }
                    case 2 -> {
                        comeback2 = findItems(wizard, enemy);
                    }
                    case 3 -> {
                        return true;
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Le choix doit être un nombre.");
                scanner.nextLine();
            }
        }
        return false;
    }

    private static boolean findPotions(Wizard wizard) {
        int numPotions = wizard.getPotions().size();
        if (numPotions == 0) {
            System.out.println("Vous n'avez aucune potion disponible.");
            return true;
        } else {
            System.out.println(ConsoleColors.BLUE + "\nVeuillez choisir une potion :" + ConsoleColors.RESET);
            for (int i = 0; i < numPotions; i++) {
                System.out.println((i + 1) + " : " + wizard.getPotions().get(i).getName());
            }
            System.out.println((numPotions + 1) + " : Retourner dans le sac");
            int choice = -1;
            do {
                Scanner scanner = new Scanner(System.in);
                try {
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > numPotions + 1) {
                        System.out.println("Veuillez entrer un choix valide.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer un choix valide.");
                    scanner.next();
                }
            } while (choice < 1 || choice > numPotions + 1);
            if (choice == numPotions + 1) {
                return true;
            }
            Potion chosenPotion = wizard.getPotions().get(choice - 1);
            System.out.println("Vous avez choisi la " + chosenPotion.getName() + ".");
            if (chosenPotion == Potion.potionHeal) {
                if (wizard.getLifePoint() >= 80) {
                    wizard.setLifePoint(wizard.getMaxLifePoint());
                } else
                    wizard.setLifePoint(wizard.getLifePoint() + chosenPotion.getValue() + (chosenPotion.getValue() * wizard.getEfficiencyPotionsBonus()) / 100);
                wizard.getPotions().remove(choice - 1);
            } else if (chosenPotion == Potion.potionDamage) {
                wizard.setPowerBonus(wizard.getPowerBonus() + chosenPotion.getValue() + (chosenPotion.getValue() * wizard.getEfficiencyPotionsBonus()) / 100);
                wizard.getPotions().remove(choice - 1);
            } else if (chosenPotion == Potion.potionResistance) {
                wizard.setResistanceBonus(wizard.getResistanceBonus() + chosenPotion.getValue() + (chosenPotion.getValue() * wizard.getEfficiencyPotionsBonus()) / 100);
                wizard.getPotions().remove(choice - 1);
            } else if (chosenPotion == Potion.potionPrecision) {
                wizard.setAccuracyBonus(wizard.getAccuracyBonus() + chosenPotion.getValue() + (chosenPotion.getValue() * wizard.getEfficiencyPotionsBonus()) / 100);
                wizard.getPotions().remove(choice - 1);
            }

        }
        return false;
    }

    private static boolean findItems(Wizard wizard, Enemy enemy) {
        int numItems = wizard.getItems().size();
        if (numItems == 0) {
            System.out.println("Vous n'avez aucun objet disponible.");
            return true;
        } else {
            System.out.println(ConsoleColors.BLUE + "\nVeuillez choisir un objet :" + ConsoleColors.RESET);
            for (int i = 0; i < numItems; i++) {
                System.out.println((i + 1) + " : " + wizard.getItems().get(i).getName());
            }
            System.out.println((numItems + 1) + " : Retourner dans le sac");
            int choice = -1;
            do {
                Scanner scanner = new Scanner(System.in);
                try {
                    choice = scanner.nextInt();
                    if (choice < 1 || choice > numItems + 1) {
                        System.out.println("Veuillez entrer un choix valide.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Veuillez entrer un choix valide.");
                    scanner.next();
                }
            } while (choice < 1 || choice > numItems + 1);
            if (choice == numItems + 1) {
                return true;
            }
            Item chosenItem = wizard.getItems().get(choice - 1);
            System.out.println("Vous avez choisi " + chosenItem.getName() + ".");
            if (wizard.getKnowledges().contains(Knowledge.gryffindorSword)) {
                if (enemy.getDistance() != 1) {
                    System.out.println("Vous frappez dans le vide avec votre épée car vous êtes trop loin.");
                } else {
                    if (wizard.getHouse() == House.GRYFFINDOR) {
                        System.out.println("Vous prenez de la hauteur en montant sur une statue proche de vous et essayer de portez un coup en utilisant l'épee volé dans le bureau de Dumbledore, celle-ci transperse le basilic et le tue.");
                        enemy.setLifePoints(0);
                    } else {
                        System.out.println("Vous prenez de la hauteur en montant sur une statue proche de vous et essayer de portez un coup en utilisant l'épee volé dans le bureau de Dumbledore, celle-ci se brise au contact du basilic.");
                        wizard.getItems().remove(choice - 1);
                    }
                }

            }
        }
        return false;
    }
}
