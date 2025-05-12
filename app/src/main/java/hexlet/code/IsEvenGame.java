package hexlet.code;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class IsEvenGame {
    public static void start() {
        String name = Cli.greetings();

        Cli.taskText("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int i = 1;
        while (i <= 3) {
            int number = getNumberForQuestion();
            String userAnswer = getUserAnswerByNumber(number);

            if (isCorrectAnswer(number, userAnswer)) {
                System.out.println("Correct!");

                i++;
            } else {
                String correctAnswer =
                        Objects.equals(userAnswer, "yes") ? "no" : "yes";

                String message = """
                        '%s' is wrong answer ;(. Correct answer was '%s'.
                        Let's try again, %s!
                        """.formatted(userAnswer, correctAnswer, name);
                System.out.println(message);

                System.exit(0);
            }
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
