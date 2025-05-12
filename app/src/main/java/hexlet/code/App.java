package hexlet.code;

import java.util.Scanner;

public class App {
    private static final String[] games = new String[] {
            "1 - Greet",
            "2 - Even",
            "0 - Exit",
    };

    public static void main(String[] args) {
        int gameNumber = getUserChoiceNumber();
        System.out.println("Your choice: " + gameNumber + (gameNumber == 0 ? ". Exiting..." : ""));

        switch (gameNumber) {
            case 1:
                Cli.greetings();

                break;
            case 2:
                IsEvenGame.start();

                break;
            default:
                System.exit(0);
        }
    }

    public static int getUserChoiceNumber() {
        System.out.println("Please enter the game number and press Enter.");

        for (String game : games) {
            System.out.println(game);
        }

        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }
}
