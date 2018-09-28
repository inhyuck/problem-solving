/**
 * Date: 2018. 9. 28.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 2018 하반기 기술부문 신입공채 Pre-Test 1차 모의문제 2
 */

package io.inhyuck.nhn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test2 {
    static int n;
    static int[][] list;
    static boolean[][] check;
    static List<Integer> result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        list = new int[n][n];
        check = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list[i][j] = scanner.nextInt();
            }
        }
        result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.add(dfs(i, j, 0));
            }
        }
        System.out.println(result.stream().filter((x) -> x > 0).count());
        System.out.println(result.stream().filter((x) -> x > 0).sorted()
                .map(x -> x.toString())
                .collect((Collectors.joining(" "))));
    }

    private static int dfs(int i, int j, int count) {
        if (list[i][j] == 0 || check[i][j] == true) {
            return count;
        }
        check[i][j] = true;
        count++;
        if (i < n - 1) {
            count = dfs(i + 1, j, count);
        }
        if (j < n - 1) {
            count = dfs(i, j + 1, count);
        }
        if (i > 0) {
            count = dfs(i - 1, j, count);
        }
        if (j > 0) {
            count = dfs(i, j - 1, count);
        }

        return count;
    }
}
