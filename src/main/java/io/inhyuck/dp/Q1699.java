/**
 * Date: 17/12/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title:
 * description:
 * Solution Key:
 * Problem URL: https://www.acmicpc.net/problem/
 * Test Code URL: htpps://github.com/inhyuck/algorithm/blob/master/src/test/java/io/inhyuck/pakageName/Q1699Test.java
 */

package io.inhyuck.dp;

import java.util.Scanner;

public class Q1699 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] memo = new int[n + 1]; //제곱수 항의 최소 갯수 memo
        memo[1] = 1;
        memo[0] = 0;

        int result = dp(n, memo);

        System.out.println(result);
    }

    private static int dp(int n, int[] memo) {
        if (memo[n] > 0 || n == 0) {
            return memo[n];
        }

        int number = (int)Math.sqrt(n);
        int minCount = Integer.MAX_VALUE;
        for (int i = number; i >= 1; i--) {
            minCount = Math.min(dp(n - (number * number), memo), minCount);
        }

        return memo[n] = minCount + 1;
    }
}
