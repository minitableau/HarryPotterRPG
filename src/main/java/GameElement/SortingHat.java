package GameElement;

import utils.ConsoleColors;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class SortingHat {
    public final String[] houses = {ConsoleColors.RED + "Gryffondor" + ConsoleColors.RESET, ConsoleColors.YELLOW + "Poufsouffle" + ConsoleColors.RESET, ConsoleColors.BLUE + "Serdaigle" + ConsoleColors.RESET, ConsoleColors.GREEN + "Serpentard" + ConsoleColors.RESET};

    //methode pour Eloise Midgen & Vincent Crabbe
    public String sort() {
        Random random = new Random();
        int index = random.nextInt(houses.length);
        return houses[index];
    }

    //methode pour notre perso
    public String sort(Scanner scanner) {
        System.out.println("\t- " + ConsoleColors.ORANGE + "Choixpeau" + ConsoleColors.RESET + " : \"Humm, difficile, très difficile, beaucoup de courage, des facilités, une soif de faire tes preuves. Où puis je te mettre ?\"");
        System.out.println(ConsoleColors.BLUE + "\nChoisissez le numéro de la maison que vous ne souhaitez pas :" + ConsoleColors.RESET);
        for (int i = 0; i < houses.length; i++) {
            System.out.println((i + 1) + ". " + houses[i]);
        }

        int excludedHouseIndex = 0;
        boolean isExcludedHouseValid = false;
        while (!isExcludedHouseValid) {
            try {
                excludedHouseIndex = scanner.nextInt();
                scanner.nextLine();
                if (excludedHouseIndex < 1 || excludedHouseIndex > houses.length) {
                    System.out.println("Numéro de maison invalide !");
                } else {
                    isExcludedHouseValid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Numéro de maison invalide !");
                scanner.nextLine();
            }
        }
        Random random = new Random();
        int index = random.nextInt(houses.length - 1);
        if (index >= excludedHouseIndex - 1) {
            index++;
        }
        return houses[index];
    }

}

