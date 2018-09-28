/**
 * Date: 2018. 08. 09.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 1, 2, 3 더하기
 * Problem: 정수 n이 주어졌을 때, n을 1,2,3의 합으로 나타내는
 * 방법의 수를 구하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/9095
 */
package io.inhyuck.dp;

import java.util.*;

public class Q9095 {
    public static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n;
        // dp[n] | n을 1,2,3 의 합으로 나타내는 방법의 수
        dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        go(10);
        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();
            System.out.println(dp[n]);
        }
    }

    public static int go(int n) {
        if (dp[n] > 0) {
            return dp[n];
        }
        return dp[n] = go(n-3) + go(n-2) + go(n - 1);
    }
}