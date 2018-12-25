/**
 * Date: 25/12/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 타일 채우기
 * description: 3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수
 * Solution Key: dp, 점화식 세우기
 * Problem URL: https://www.acmicpc.net/problem/2133
 */

package io.inhyuck.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Q2133 {
    static final int MAX_WIDTH = 30;

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        if (n % 2 == 1) { //홀수인 경우 채울수 없음
            System.out.println("0");
            return;
        }
        int[] memo = new int[MAX_WIDTH + 1]; //memo[i] => 가로 크기가 i인 벽을 타일로 채울때 경우의 수
        memo[0] = 1;
        solve(n, memo);

        System.out.println(memo[n]);
    }

    private static int solve(int i, int[] memo) {
        if (memo[i] > 0) {
            return memo[i];
        }

        int result = solve(i - 2, memo) * 3;
        for (int j = 4; i - j >= 0; j += 2) {
            result += solve(i - j, memo) * 2;
        }
        return memo[i] = result;
    }
}
