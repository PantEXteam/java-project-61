package hexlet.code.games;

import hexlet.code.Cli;

public class Engine {
    public static String getUserName(String taskText) {
        String name = Cli.greetings();

        Cli.taskText(taskText);

        return name;
    }

    public static int getCounterIfCorrectAnswer(
            String correctAnswer,
            String userAnswer,
            String name,
            int i)
    {
        isCorrectAnswer(correctAnswer, userAnswer, name);

        return i + 1;
    }

    private static void isCorrectAnswer(
            String correctAnswer,
            String userAnswer,
            String name
    ) {
        if (correctAnswer.equals(userAnswer)) {
            System.out.println("Correct!");
        } else {
            String message = """
                    '%s' is wrong answer ;(. Correct answer was '%s'.
                    Let's try again, %s!
                    """.formatted(userAnswer, correctAnswer, name);
            System.out.println(message);

            System.exit(0);
        }

    }
}
