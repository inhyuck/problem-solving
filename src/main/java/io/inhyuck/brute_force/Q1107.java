/**
 * Date: 04/12/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 리모컨
 * description: 0-9 까지 숫자와 +,- 버튼 존재. 고장난 버튼과 원하는 채널이 주어졌을 때, 가장 짧게 버튼 눌러서 이동
 * Solution Key: Brute Force
 * Problem URL: https://www.acmicpc.net/problem/1107
 * Test Code URL: htpps://github.com/inhyuck/algorithm/blob/master/src/test/java/io/inhyuck/brute_force/Q1107Test.java
 */

package io.inhyuck.brute_force;

import java.util.Arrays;
import java.util.Scanner;

public class Q1107 {
    static final int MAX_CHANNEL = 1000000;
    static final int INIT_CHANNEL = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] wrongButtons = new int[m];
        for (int i = 0; i < m; i++) {
            wrongButtons[i] = scanner.nextInt();
        }
        Arrays.parallelSort(wrongButtons);
//        System.out.printf("n = %d, m = %d, wrong buttons = %s\n", n, m, Arrays.toString(wrongButtons)); //Input Log

        int minButtonCount = Math.abs(n - INIT_CHANNEL);
        for (int c = 0; c <= MAX_CHANNEL; c++) {
            if (isAvailableMoveChannel(c, wrongButtons)) {
                int buttonCount = Math.abs(n - c) + String.valueOf(c).length();
                if (buttonCount < minButtonCount) {
                    minButtonCount = buttonCount;
                }
            }
        }

        System.out.println(minButtonCount);
    }

    static boolean isAvailableMoveChannel(int channel, int[] wrongButtons) {
        String strChannel = String.valueOf(channel);
        for (char c : strChannel.toCharArray()) {
            int num = Character.getNumericValue(c);
            if (Arrays.binarySearch(wrongButtons, num) >= 0) {
                return false;
            }
        }
        return true;
    }
}
