package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;

public class CalcGame {
    public static void start() {
        String name = Engine.getUserName("What is the result of the expression?");

        int i = 1;
        while (i <= 3) {
            String expression = getExpressionForQuestion();
            String expressionResult = getExpressionResult(expression);
            String userAnswer = getUserAnswerByExpression(expression);

            i = Engine.getCounterIfCorrectAnswer(expressionResult, userAnswer, name, i);
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

    private static String getExpressionResult(String expression) {
        String[] tokens = expression.split(" ");

        return switch (tokens[1]) {
            case "+" ->
                    Integer.toString(Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[2]));
            case "-" ->
                    Integer.toString(Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[2]));
            default ->
                    Integer.toString(Integer.parseInt(tokens[0]) * Integer.parseInt(tokens[2]));
        };
    }

    private static String getUserAnswerByExpression(String expression) {
        String message = """
            Question: %s
            Your answer:\s""".formatted(expression);

        System.out.print(message);

        Scanner scanner = new Scanner(System.in);
        return Integer.toString(scanner.nextInt());
    }
}
