/**
 * Date: 28/12/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 다리 놓기
 * description: n개의 지점과 m개의 지점이 있을 때, 교차하지 않게 최대한 많은 다리를 놓을 수 있는 경우의 수 구하기
 * Solution Key: dp
 * Problem URL: https://www.acmicpc.net/problem/1010
 */

package io.inhyuck.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Q1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        StringJoiner joiner = new StringJoiner("\n");
        while (t-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());
            int[][] memo = new int[n + 1][m + 1];
            joiner.add(String.valueOf(solve(n, m, memo)));
        }

        System.out.println(joiner.toString());
    }

    private static int solve(int n, int m, int[][] memo) {
        if (n == m) { //같은 갯수만 남은 경우
            return 1;
        }
        if (n == 1) { //n이 1개만 남은 경우
            return m;
        }
        if (memo[n][m] > 0) { //memoization
            return memo[n][m];
        }

        for (int i = 0; i <= m - n; i++) {
            memo[n][m] += solve(n - 1, m - 1 - i, memo);
        }
        return memo[n][m];
    }
}
