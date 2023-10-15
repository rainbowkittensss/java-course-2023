package edu.hw1;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();
    static final int SECONDS = 60;
    static final long MAX_MINUTES = 1000000000000000000L - SECONDS;

    static long minutesToSeconds(String inp) { //task_1
        double minutes;
        double seconds;
        if (inp.contains(":")) {
            try {
                minutes = Double.parseDouble(inp.split(":")[0]);
                seconds = Double.parseDouble(inp.split(":")[1]);
            } catch (NumberFormatException | NullPointerException ex) {
                return -1;
            }
            if (seconds == (int) seconds
                && minutes == (long) minutes
                && seconds < SECONDS
                && minutes <= MAX_MINUTES) {
                return (long) (minutes * SECONDS) + (long) (seconds);
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    final static int LIMIT_OF_CAPACITY = 16;
    final static int DIVIDER = 10;

    static int countDigits(double number) { //task_2
        int ans = 0;
        double numberCopy = Math.abs(number);
        if (number == 0) {
            return 1;
        }
        while (numberCopy >= 1) {
            numberCopy /= DIVIDER;
            ans += 1;
        }
//        number -= (long) number;
//        while (Math.abs(number - (int) number) > 1e-16 && ans <= LIMIT_OF_CAPACITY) {
//
//            number *= DIVIDER;
//            ans += 1;
//        }
//        if (Math.abs(number - (int) number) > 1e-16 && ans == LIMIT_OF_CAPACITY) {
//            return -1;
//        }
        return ans;
    }

    static double min(double[] arr) {
        double min = arr[0];
        for (double value
            : arr) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    static double max(double[] arr) {
        double max = arr[0];
        for (double value
            : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    static boolean isNestable(double[] arr1, double[] arr2) {   //task_3
        return arr2.length > 1
            && arr1.length > 0
            && max(arr1) < max(arr2)
            && min(arr1) > min(arr2);
    }

    static String fixString(String str) {   //task_4
        char[] ans = new char[str.length()];
        if (str.length() == 1) {
            return String.valueOf(str.charAt(0));
        } else {
            int i;
            for (i = 0; i < str.length() - 2; i += 2) {
                ans[i] = str.charAt(i + 1);
                ans[i + 1] = str.charAt(i);
            }
            if (i == str.length() - 1) {
                ans[i] = str.charAt(i);
            } else {
                ans[i] = str.charAt(i + 1);
                ans[i + 1] = str.charAt(i);

            }
        }
        return String.copyValueOf(ans);
    }

    static boolean isPalindromeStringBuilder(StringBuilder string, int length) {
        StringBuilder temporary = new StringBuilder(string);
        return length > 1 && string.substring(0, length / 2).equals(temporary.reverse().substring(0, length / 2));
    }

    static boolean isPalindromeDescendant(long number) {    //task_5
        StringBuilder strDigits = new StringBuilder(String.valueOf(number));
        StringBuilder resultString = new StringBuilder();
        int length = strDigits.length();
        if (length == 1) {
            return true;
        }
        while (length > 1 && !isPalindromeStringBuilder(strDigits, length)) {
            resultString.delete(0, length);
            int i;
            for (i = 0; i < length - 1; i += 2) {

                resultString.append(Integer.parseInt(strDigits.substring(i, i + 1))
                    + Integer.parseInt(strDigits.substring(i + 1, i + 2)));
            }
            if (i < length) {
                resultString.append(strDigits.charAt(i));
            }
            strDigits.delete(0, length);
            length = resultString.length();
            strDigits.append(resultString);

        }
        return isPalindromeStringBuilder(strDigits, length);
    }

    static char[] maxNumberStr;
    static char[] minNumberStr;
    static final int FINAL_VALUE = 6174;
    static final int MIN = 1000;
    static final int MAX = 10000;
    static final int LENGTH_OF_NUMBER = 4;
    static final int FACTOR = 10;

    static int countKIterations(int number) {
        if (number == FINAL_VALUE) {
            return 0;
        }
        minNumberStr = String.valueOf(number).toCharArray();
        if (minNumberStr.length < LENGTH_OF_NUMBER) {
            minNumberStr =
                String.valueOf(number * (int) Math.pow(FACTOR, LENGTH_OF_NUMBER - minNumberStr.length)).toCharArray();
        }
        Arrays.sort(minNumberStr);
        maxNumberStr = new StringBuilder(String.valueOf(minNumberStr)).reverse().toString().toCharArray();
        return countKIterations(Integer.parseInt(String.valueOf(maxNumberStr))
            - Integer.parseInt(String.valueOf(minNumberStr))) + 1;
    }

    static int countK(int number) { //task_6 ????????????????????????????
        if (number <= MIN || number >= MAX) {
            return -1;
        }
        minNumberStr = String.valueOf(number).toCharArray();
        if (minNumberStr[0] == minNumberStr[1]
            && minNumberStr[0] == minNumberStr[2]
            && minNumberStr[0] == minNumberStr[LENGTH_OF_NUMBER - 1]) {
            return -1;
        }
        return countKIterations(number);
    }

    static int rotateLeft(int n, int shift) { //task_7
        if (n < 0 || shift < 0) {
            return -1;
        }
        String binDigits = Integer.toBinaryString(n);
        int finalShift = shift % binDigits.length();
        return Integer.parseInt(binDigits.substring(finalShift).concat(binDigits.substring(0, finalShift)), 2);
    }

    static int rotateRight(int n, int shift) {  //task_7
        if (n < 0 || shift < 0) {
            return -1;
        }
        String binDigits = Integer.toBinaryString(n);
        int finalShift = shift % binDigits.length();
        return Integer.parseInt(binDigits.substring(binDigits.length() - finalShift)
            .concat(binDigits.substring(0, binDigits.length() - finalShift)), 2);
    }

    static final int FIELD_SIZE = 8;
    static final int BIG_FIELD_SIZE = 12;
    static final int LONG_STEP = 2;
    static final int SHORT_STEP = 1;

    static boolean oneKnightCheck(int[][] field, int xCrd, int yCrd) {
        return !(field[xCrd + LONG_STEP][yCrd + SHORT_STEP] == 0
            && field[xCrd + SHORT_STEP][yCrd + LONG_STEP] == 0
            && field[xCrd - LONG_STEP][yCrd - SHORT_STEP] == 0
            && field[xCrd - SHORT_STEP][yCrd - LONG_STEP] == 0
            && field[xCrd + LONG_STEP][yCrd - SHORT_STEP] == 0
            && field[xCrd + SHORT_STEP][yCrd - LONG_STEP] == 0
            && field[xCrd - LONG_STEP][yCrd + SHORT_STEP] == 0
            && field[xCrd - SHORT_STEP][yCrd + LONG_STEP] == 0);
    }   //можно, пожалуйста, какой-нибудь совет по этой задаче?
    //Это выглядит плохо, и я не могу придумать вариантов лучше

    static boolean knightBoardCapture(int[][] field) {  //task_8
        if (field.length != FIELD_SIZE || field[0].length != FIELD_SIZE) {
            return false;
        }
        int[][] fieldSimpleChk = new int[BIG_FIELD_SIZE][BIG_FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; ++i) {
            System.arraycopy(field[i], 0, fieldSimpleChk[i + LONG_STEP], 2, FIELD_SIZE);
        }
        for (int i = LONG_STEP; i < BIG_FIELD_SIZE - LONG_STEP; ++i) {
            for (int j = LONG_STEP; j < BIG_FIELD_SIZE - LONG_STEP; ++j) {
                if (fieldSimpleChk[i][j] == 1) {
                    if (oneKnightCheck(fieldSimpleChk, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private Main() {
    }

    public static void main(String[] args) {
        LOGGER.info("Привет, мир"); //task_0
    }
}
