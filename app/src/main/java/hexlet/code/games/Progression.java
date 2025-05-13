package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Progression {
    public static void start() {
        String name = Engine.getUserName(
                "What number is missing in the progression?");

        int i = 1;
        while (i <= 3) {
            int[] progressionNums = getProgressionNums();
            String[] progression = getProgressionForQuestion(progressionNums[0], progressionNums[1], progressionNums[2]);
            String userAnswer = getUserAnswerByNumbes(
                    Arrays.toString(progression)
            );

            i = Engine.getCounterIfCorrectAnswer(
                    String.valueOf(progressionNums[3]),
                    userAnswer,
                    name,
                    i
            );
        }

        Cli.congratulation(name);
    }

    private static int[] getProgressionNums() {
        int[] progressionNums = new int[4];

        Random random = new Random();
        final int progressionNum = random.nextInt(20);
        final int firstNum = random.nextInt(100);
        final int skipIndex = 1 + random.nextInt(10 - 1 + 1);
        final int answer = firstNum + progressionNum * skipIndex;

        progressionNums[0] = progressionNum;
        progressionNums[1] = firstNum;
        progressionNums[2] = skipIndex;
        progressionNums[3] = answer;

        return progressionNums;
    }

    private static String[] getProgressionForQuestion(int progressionNum, int firstNum, int skipIndex) {
        String[] progression = new String[10];
        progression[0] = String.valueOf(firstNum);

        for (int i = 1; i < 10; i++) {
            if (i == skipIndex) {
                progression[i] = "..";

                firstNum += progressionNum;
            } else {
                firstNum += progressionNum;

                progression[i] = String.valueOf(firstNum);
            }
        }

        return progression;
    }

    private static String getUserAnswerByNumbes(String progression) {
        String message = """
                Question: %s
                Your answer:\s""".formatted(progression);

        System.out.print(message);

        Scanner scanner = new Scanner(System.in);
        return Integer.toString(scanner.nextInt());
    }
}
