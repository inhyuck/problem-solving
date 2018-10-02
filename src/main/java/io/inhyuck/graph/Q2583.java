/**
 * Date: 2018. 10. 2.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 영역 구하기
 * description: M, N과 K 그리고 K개의 직사각형의 좌표가 주어질 때,
 * K개의 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어지는지,
 * 그리고 분리된 각 영역의 넓이가 얼마인지를 구하여 이를 출력하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/2583
 */

package io.inhyuck.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q2583 {
    static int[][] area;
    static boolean[][] check;
    static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        m = Integer.parseInt(tokenizer.nextToken());
        n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        area = new int[m][n];
        check = new boolean[m][n];

        String[] rectanglePoint;
        for (int i = 0; i < k; i++) {
            rectanglePoint = reader.readLine().split(" ");
            drawRectangle(Stream.of(rectanglePoint).mapToInt(Integer::parseInt).toArray());
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (area[i][j] == 0 && check[i][j] == false) {
                    result.add(dfs(i, j));
                }
            }
        }
        System.out.println(result.stream().filter((x) -> x > 0).count());
        System.out.println(result.stream().filter((x) -> x > 0).sorted().map(x -> Integer.toString(x)).collect(Collectors.joining(" ")));
    }

    private static int dfs(int i, int j) {
        if (area[i][j] == 1 || check[i][j] == true) {
            return 0;
        }
        check[i][j] = true;
        int count = 1;
        if (i > 0) {
            count += dfs(i - 1, j);
        }
        if (i < m - 1) {
            count += dfs(i + 1, j);
        }
        if (j > 0) {
            count += dfs(i, j - 1);
        }
        if (j < n - 1) {
            count += dfs(i, j + 1);
        }
        return count;
    }

    private static void drawRectangle(int[] rectanglePoint) {
        int bottomLeftPointX = rectanglePoint[0];
        int bottomLeftPointY = rectanglePoint[1];
        int upperRightPointX = rectanglePoint[2];
        int upperRightPointY = rectanglePoint[3];

        for (int i = bottomLeftPointY; i < upperRightPointY; i++) {
            for (int j = bottomLeftPointX; j < upperRightPointX; j++) {
                area[i][j] = 1;
            }
        }
    }


}
