package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Prime {
    public static void start() {
        String name = Engine.getUserName(
                "Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        int i = 1;
        while (i <= 3) {
            int number = getNumberForQuestion();
            String correctAnswer = getCorrectAnswer(number);
            String userAnswer = getUserAnswerByNumber(number);

            i = Engine.getCounterIfCorrectAnswer(
                    correctAnswer,
                    userAnswer,
                    name,
                    i
            );
        }

        Cli.congratulation(name);
    }

    private static int getNumberForQuestion() {
        Random random = new Random();

        return random.nextInt(100000);
    }

    private static String getCorrectAnswer(int number) {
        BigInteger bigInteger = BigInteger.valueOf(number);
        return bigInteger.isProbablePrime((int) Math.log(number)) ? "yes" : "no";
    }

    private static String getUserAnswerByNumber(int number) {
        String message = """
            Question: %d
            Your answer:\s""".formatted(number);

        System.out.print(message);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
