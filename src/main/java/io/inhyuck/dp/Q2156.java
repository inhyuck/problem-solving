/**
 * Date: 13/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 포도주 시식
 * description:
 * 1. 포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
 * 2. 연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
 * 1부터 n까지의 번호가 붙어 있는 n개의 포도주 잔이 순서대로 테이블 위에 놓여 있고,
 * 각 포도주 잔에 들어있는 포도주의 양이 주어졌을 때, 가장 많은 양의 포도주를 마실 수 있도록 하는 프로그램을 작성하시오.
 * Solution Key: dp
 * Problem URL: https://www.acmicpc.net/problem/2156
 */

package io.inhyuck.dp;

import java.util.Scanner;

public class Q2156 {
    static int[] wines;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        wines = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wines[i] = scanner.nextInt();
        }

        if (n == 1) {
            System.out.println(wines[1]);
            return;
        }
        int[][] memo = new int[n + 1][3]; //memo[n][m] => n번째 포도주가 m번 연속일때 마실 수 있는 최댓값
        int maxValue = max(dp(memo, n, 2), dp(memo, n, 1), dp(memo, n, 0));

        System.out.println(maxValue);
    }

    private static int dp(int[][] memo, int n, int m) {
        if (memo[n][m] > 0) {
            return memo[n][m];
        }
        if (n == 2) {
            if (m == 0) return wines[1];
            if (m == 1) return wines[2];
            return wines[1] + wines[2];
        }

        if (m == 2) {
            return memo[n][2] = dp(memo, n - 1, 1) + wines[n];
        }
        if (m == 1) {
            return memo[n][1] = dp(memo, n - 1, 0) + wines[n];
        }
        //m == 0
        return memo[n][0] = max(dp(memo, n - 1, 2), dp(memo, n - 1, 1), dp(memo, n - 1, 0));
    }

    private static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}
