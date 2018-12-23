/**
 * Date: 23/12/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 파도반 수열
 * description: 파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이. N이 주어졌을 때, P(N)을 구하는 프로그램 (링크참조)
 * Solution Key: dp
 * Problem URL: https://www.acmicpc.net/problem/9461
 */

package io.inhyuck.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class Q9461 {
    public static void main(String[] args) throws IOException {
        long memo[] = initMemo();
        solve(100, memo);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner joiner = new StringJoiner("\n");
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            joiner.add(String.valueOf(memo[Integer.parseInt(reader.readLine())]));
        }

        System.out.println(joiner.toString());
    }

    private static long[] initMemo() {
        long memo[] = new long[101];
        memo[1] = 1;
        memo[2] = 1;
        memo[3] = 1;
        memo[4] = 2;
        memo[5] = 2;
        return memo;
    }

    private static long solve(int n, long[] memo) {
        if (memo[n] > 0) {
            return memo[n];
        }

        return memo[n] = solve(n - 1, memo) + solve(n - 5, memo);
    }
}
