/**
 * Date: 2018. 9. 12.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 계단 오르
 * Problem: 각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는
 * 총 점수의 최대값을 구하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/2579
 */
package io.inhyuck.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Q2579 {
    static int[][] memo;
    static int[] stairs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        stairs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stairs[i] = scanner.nextInt();
        }
        memo = new int[n + 1][3];
        //memo[i][j] => i번째 계단을 마지막으로, 그리고 연속으로 j번째 밟았을 때 점수 최댓값
        memo[1][1] = stairs[1];
        memo[1][2] = stairs[1];
        memo[2][1] = stairs[2];
        memo[2][2] = stairs[1] + stairs[2];
        System.out.println(Math.max(dp(n, 1), dp(n, 2)));
//        System.out.println(Arrays.deepToString(memo));
    }

    private static int dp(int i, int j) {
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        if (j == 1) { //직전 계단 안 밟은 경우
            return memo[i][j] = Math.max(dp(i - 2, 1), dp(i -2, 2)) + stairs[i];
        }
        return memo[i][j] = dp(i - 1, 1) + stairs[i]; //직전 계단 밟은 경우
    }
}
