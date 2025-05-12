package hexlet.code;

import java.util.Scanner;

public final class Cli {
    public static String greetings() {
        System.out.println("Welcome to the Brain Games!");

        Scanner scanner = new Scanner(System.in);

        System.out.print("May I have your name: ");
        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "!");

        return name;
    }

    public static void congratulation(String name) {
        System.out.println("Congratulations, " + name + "!");
    }

    public static void taskText(String text) {
        System.out.println(text);
    }
}
