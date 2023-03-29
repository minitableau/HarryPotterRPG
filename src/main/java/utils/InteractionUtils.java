package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InteractionUtils {

    public static int askForInt(String message, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("min must be lower than max");
        }

        if (!message.isBlank() && !message.isEmpty()) {
            ScrollingText.printWithDelay(message);
        }

        Scanner scanner = new Scanner(System.in);
        int value;

        while (true) {
            try {
                value = scanner.nextInt();
                if (value < min || value > max) {
                    System.out.println("La valeur doit être comprise entre " + min + " et " + max + ".");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("La valeur doit être un nombre.");
                scanner.nextLine();
            }
        }

        return value;
    }

    public static int askForInt(int min, int max) {
        return askForInt("", min, max);
    }
}
