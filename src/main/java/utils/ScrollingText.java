package utils;

public class ScrollingText {

private static int DEFAULT_SPEED = 0;

    public static void printWithDelay(String message, int speed) throws InterruptedException {
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
            Thread.sleep(speed);
        }
        System.out.println();
    }

    public static void printWithDelay(String message) throws InterruptedException {
        printWithDelay(message, DEFAULT_SPEED);
    }
}

