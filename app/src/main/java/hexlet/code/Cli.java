package hexlet.code;

import java.util.Scanner;

public final class Cli {
    public static void greetings() {
        System.out.println("Welcome to the Brain Games!");

        Scanner scanner = new Scanner(System.in);

        System.out.print("May I have your name: ");
        String name = scanner.nextLine();

        System.out.print("Hello, " + name + "!");
    }
}
