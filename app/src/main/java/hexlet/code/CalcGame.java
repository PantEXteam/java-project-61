package hexlet.code;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;

public class CalcGame {
    public static void start() {
        String name = Cli.greetings();

        Cli.taskText("What is the result of the expression?");

        int i = 1;
        while (i <= 3) {
            String expression = getExpressionForQuestion();
            int expressionResult = getExpressionResult(expression);
            int userAnswer = getUserAnswerByExpression(expression);

            if (expressionResult == userAnswer) {
                System.out.println("Correct!");

                i++;
            } else {
                String message = """
                        '%d' is wrong answer ;(. Correct answer was '%d'.
                        Let's try again, %s!
                        """.formatted(userAnswer, expressionResult, name);
                System.out.println(message);

                System.exit(0);
            }
        }

        Cli.congratulation(name);
    }

    private static String getExpressionForQuestion() {
        Random random = new Random();

        int firstNum = random.nextInt(100);
        int secondNum = random.nextInt(100);
        char[] signs = new char[] {'+', '-', '*'};
        char randSign = signs[random.nextInt(signs.length)];

        StringJoiner resString = new StringJoiner(" ");
        resString.add(String.valueOf(firstNum));
        resString.add(String.valueOf(randSign));
        resString.add(String.valueOf(secondNum));

        return resString.toString();
    }

    private static int getExpressionResult(String expression) {
        String[] tokens = expression.split(" ");

        return switch (tokens[1]) {
            case "+" ->
                    Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[2]);
            case "-" ->
                    Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[2]);
            default ->
                    Integer.parseInt(tokens[0]) * Integer.parseInt(tokens[2]);
        };
    }

    private static int getUserAnswerByExpression(String expression) {
        String message = """
            Question: %s
            Your answer:\s""".formatted(expression);

        System.out.print(message);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
