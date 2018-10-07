/**
 * Date: 2018. 10. 7.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 별찍기 - 11
 * description: 예제를 보고 별찍는 규칙을 유추한 뒤에 별을 찍어 보세요.
 * Problem URL: https://www.acmicpc.net/problem/2448
 */

package io.inhyuck.divide_conquer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q2448 {
    static Map<Integer, StringBuilder[]> memo;

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        memo = new HashMap<>();
        memo.put(3, defaultBuildStar());
        Arrays.stream(buildStar(n)).forEach(System.out::println);
    }

    private static StringBuilder[] buildStar(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        StringBuilder[] builders = new StringBuilder[n];
        for (int i = 0; i < n / 2; i++) {
            builders[i] = new StringBuilder();
            for (int j = 0; j < n / 2; j++) {
                builders[i].append(" ");
            }
            builders[i].append(buildStar(n / 2)[i]);
            for (int j = 0; j < n / 2; j++) {
                builders[i].append(" ");
            }
        }
        for (int i = n / 2; i < n; i++) {
            builders[i] = new StringBuilder();
            builders[i].append(buildStar(n / 2)[i - n / 2]);
            builders[i].append(" ");
            builders[i].append(buildStar(n / 2)[i - n / 2]);
        }
        memo.put(n, builders);
        return builders;
    }

    private static StringBuilder[] defaultBuildStar() {
        StringBuilder[] defaultBuilders = new StringBuilder[3];
        defaultBuilders[0] = new StringBuilder("  *  ");
        defaultBuilders[1] = new StringBuilder(" * * ");
        defaultBuilders[2] = new StringBuilder("*****");
        return defaultBuilders;
    }
}
