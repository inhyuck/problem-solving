/**
 * Date: 18/12/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 제곱수의 합
 * description: 주어진 자연수 N을 제곱수들의 합으로 표현할 때에 그 항의 최소개수를 구하는 프로그램을 작성하시오.
 * Solution Key: dp
 * Problem URL: https://www.acmicpc.net/problem/1699
 */

package io.inhyuck.dp;

import java.util.Scanner;

public class Q1699 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] memo = new int[n + 1]; // 제곱수 항의 최소 갯수 memo
        memo[1] = 1;
        int minCount = computeMinCount(n, memo);

        System.out.println(minCount);
    }

    // n을 제곱수의 합으로 나타낼 때 항의 최소 갯수 리턴
    private static int computeMinCount(int n, int[] memo) {
        if (memo[n] > 0 || n == 0) {
            return memo[n];
        }

        int number = (int)Math.sqrt(n);
        int minCount = Integer.MAX_VALUE;
        for (int i = number; i >= 1; i--) {
            minCount = Math.min(computeMinCount(n - (i * i), memo), minCount);
        }

        return memo[n] = minCount + 1;
    }
}
