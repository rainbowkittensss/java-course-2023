package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Homework1Test {

    @Test
    @DisplayName("task_1_testing")
    void task_1Testing() {

        String[] times = {"1:23", "1000000080:23", "14:60", "there_is_no_time_:D",
            "0;1", "0:1", "1.23:1.23", "9999999999999:11", "0:0"};
        long[] correct_answers = {83, 60000004823L, -1, -1, -1, 1, -1, 599999999999951L, 0};

        long[] seconds = new long[correct_answers.length];
        for (int i = 0; i < times.length; ++i) {
            seconds[i] = Main.minutesToSeconds(times[i]);
        }

        assertThat(seconds).isEqualTo(correct_answers);
    }

    @Test
    @DisplayName("task_2_testing")
    void task_2Testing() {

        double[] numbers = {12345678, 0, -23467345678999999999999999999999997654322D, 0.123456789123456, 1, -1234.1234,
            1.12345612345623456};
        int[] correct_answers = {8, 1, 41, 0, 1, 4, 1};
        //для нецелых чисел постоянно получаются неправильные ответы,
        //поэтому считается только целая часть. Можете, пожалуйста,
        //подсказать как посчитать цифры после точки?

        int[] answers = new int[correct_answers.length];
        for (int i = 0; i < numbers.length; ++i) {
            answers[i] = Main.countDigits(numbers[i]);
        }

        assertThat(answers).isEqualTo(correct_answers);
    }

    @Test
    @DisplayName("task_3_testing")
    void task_3Testing() {

        double[][] first_arrays = {{1, 2, 3, 4}, {0}, {1, 4, 16}, {1, 2}};
        double[][] second_arrays = {{0, 3, 5}, {0, 1}, {1, 2, 1, 1}, {14}};
        boolean[] correct_answers = {true, false, false, false};

        boolean[] answers = new boolean[correct_answers.length];
        for (int i = 0; i < first_arrays.length; ++i) {
            answers[i] = Main.isNestable(first_arrays[i], second_arrays[i]);
        }

        assertThat(answers).isEqualTo(correct_answers);
    }

    @Test
    @DisplayName("task_4_testing")
    void task_4Testing() {

        String[] lines = {"ъСше ьще ётэхим гяикх", "рфнауцсзик хуболк", "адв пыйеч юа", "bacaa"};
        String[] correct_answers = {"Съешь ещё этих мягких", "французских булок", "да выпей чаю", "abaca"};

        String[] answers = new String[correct_answers.length];
        for (int i = 0; i < lines.length; ++i) {
            answers[i] = Main.fixString(lines[i]);
        }

        assertThat(answers).isEqualTo(correct_answers);
    }

    @Test
    @DisplayName("task_5_testing")
    void task_5Testing() {

        int[] numbers = {101010, 10101, 23532, 1221, 1113, 5479876, 23452, 9876, 0};
        boolean[] correct_answers = {true, true, true, true, false, true, false, false, true};

        boolean[] answers = new boolean[correct_answers.length];
        for (int i = 0; i < numbers.length; ++i) {
            answers[i] = Main.isPalindromeDescendant(numbers[i]);
        }

        assertThat(answers).isEqualTo(correct_answers);
    }

    @Test
    @DisplayName("task_6_testing")
    void task_6Testing() {

        int[] numbers =
            {1000, 1001, 9999, 10000, 1234, 6174, 7777, 6666, 6777, 8352, 8082, 8991, 9099, 2088, 7998, 1393, 5994,
                8442, 9721, 1089};
        int[] correct_answers = {-1, 4, -1, -1, 3, 0, -1, -1, 5, 1, 2, 3, 4, 2, 3, 6, 5, 6, 7};

        int[] answers = new int[correct_answers.length];
        for (int i = 0; i < correct_answers.length; ++i) {
            answers[i] = Main.countK(numbers[i]);
        }

        assertThat(answers).isEqualTo(correct_answers);
    }

    @Test
    @DisplayName("task_7_testing")
    void task_7Testing() {

        int[][] numbers_and_moves = {{135, 12, 108, 111, 65, 9, -1} //значения
            , {5, 1, 11, 6, 10, 5, 5, -1}}; //сдвиги
        int[][] results_left_right = {{240, 9, 77, 119, 12, 3, -1}, //ответы для rotateLeft
            {60, 6, 102, 95, 24, 12, -1}};  //ответы для rotateRight

        int[][] answers_left_right = new int[2][results_left_right[0].length];
        for (int i = 0; i < results_left_right[0].length; ++i) {
            answers_left_right[0][i] = Main.rotateLeft(numbers_and_moves[0][i], numbers_and_moves[1][i]);
            answers_left_right[1][i] = Main.rotateRight(numbers_and_moves[0][i], numbers_and_moves[1][i]);
        }

        assertThat(answers_left_right).isEqualTo(results_left_right);
    }

    @Test
    @DisplayName("task_8_testing")
    void task_8Testing() {

        int[][][] fields = {
            {
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 1}
            },
            {
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0, 1, 0, 1},
                {1, 0, 0, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 1}
            },
            {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
            },
            {
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 0, 1}
            },
            {},
            {
                {0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0}
            }
        };
        boolean[] correct_answers = {false, false, true, false, false, true};

        boolean[] answers = new boolean[correct_answers.length];
        for (int i = 0; i < correct_answers.length; ++i) {
            answers[i] = Main.knightBoardCapture(fields[i]);
        }

        assertThat(answers).isEqualTo(correct_answers);
    }
}
