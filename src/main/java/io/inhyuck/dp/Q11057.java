/**
 * Date: 29/10/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 오르막 수
 * description: 수의 길이 N이 주어졌을 때, 오르막 수의 개수를 구하는 프로그램을 작성하시오. 수는 0으로 시작할 수 있다.
 * Solution Key: dp | memo[a][b] = memo[a-1][0] + memo[a-1][1] + ... + memo[a-1][b]
 * Problem URL: https://www.acmicpc.net/problem/11057
 */

package io.inhyuck.dp;

import java.util.Scanner;

public class Q11057 {
    //memo[a][b] -> 길이가 a이고 마지막 수가 b인 오르막 수의 갯수
    //memo[a][b] = memo[a-1][0] + memo[a-1][1] + ... + memo[a-1][b]
    static long[][] memo;
    static final int DIVISOR = 10007;

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        memo = new long[n + 1][10];
        long result = 0;
        for (int i = 0; i < 10; i++) {
            memo[1][i] = 1;
            result += dp(n, i) % DIVISOR;
        }
        System.out.println(result % DIVISOR);
    }

    private static long dp(int length, int lastNumber) {
        if (memo[length][lastNumber] > 0) {
            return memo[length][lastNumber];
        }
        for (int i = 0; i <= lastNumber; i++) {
            memo[length][lastNumber] += dp(length - 1, i) % DIVISOR;
        }
        return memo[length][lastNumber] % DIVISOR;
    }
}
