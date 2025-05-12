package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class IsEvenGame {
    public static void start() {
        String name = Engine.getUserName("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int i = 1;
        while (i <= 3) {
            int number = getNumberForQuestion();
            String correctAnswer = isCorrectAnswer(number, "yes") ? "yes" : "no";
            String userAnswer = getUserAnswerByNumber(number);

            i = Engine.getCounterIfCorrectAnswer(correctAnswer, userAnswer, name, i);
        }

        Cli.congratulation(name);
    }

    private static int getNumberForQuestion() {
        Random random = new Random();

        return random.nextInt(100);
    }

    private static String getUserAnswerByNumber(int number) {
        String message = """
            Question: %d
            Your answer:\s""".formatted(number);

        System.out.print(message);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static boolean isCorrectAnswer(int number, String answer) {
        boolean isEven = number % 2 == 0;

        return isEven && answer.equals("yes") || !isEven && answer.equals("no");
    }
}
