/**
 * Date: 12/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 이친수
 * description:
 * 1. 이친수는 0으로 시작하지 않는다.
 * 2. 이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
 * N(1 ≤ N ≤ 90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.
 * Solution Key: DP
 * Problem URL: https://www.acmicpc.net/problem/2193
 */

package io.inhyuck.dp;

import java.util.Scanner;

public class Q2193 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        long[][] memo = new long[n + 1][2];
        System.out.println(dp(memo, n, 0) + dp(memo, n, 1));
    }

    private static long dp(long[][] memo, int n, int lastNumber) {
        if (n == 1) {
            return lastNumber;
        }
        if (memo[n][lastNumber] > 0) {
            return memo[n][lastNumber];
        }

        memo[n][lastNumber] = dp(memo, n - 1, 0);
        if (lastNumber == 0) {
            memo[n][lastNumber] += dp(memo, n - 1, 1);
        }
        return memo[n][lastNumber];
    }
}
