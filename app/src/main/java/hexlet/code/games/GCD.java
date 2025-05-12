package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class GCD {
    public static void start() {
        String name = Engine.getUserName(
                "Find the greatest common divisor of given numbers.");

        int i = 1;
        while (i <= 3) {
            Random random = new Random();

            int firstNum = random.nextInt(100);
            int secondNum = random.nextInt(100);

            String correctAnswer = getMostCommonMultiple(firstNum, secondNum);
            String userAnswer = getUserAnswerByNumbes(firstNum, secondNum);

            i = Engine.getCounterIfCorrectAnswer(
                    correctAnswer,
                    userAnswer,
                    name,
                    i
            );
        }

        Cli.congratulation(name);
    }

    private static String getMostCommonMultiple(int x, int y) {
        while (x != 0 && y != 0) {
            if (x > y) {
                x = x % y;
            } else {
                y = y % x;
            }
        }

        return Integer.toString(x + y);
    }

    private static String getUserAnswerByNumbes(int number1, int number2) {
        String message = """
                Question: %d %d
                Your answer:\s""".formatted(number1, number2);

        System.out.print(message);

        Scanner scanner = new Scanner(System.in);
        return Integer.toString(scanner.nextInt());
    }
}
