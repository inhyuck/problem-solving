/**
 * Date: 2018. 9. 30.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 쿼드트리
 * description: N × N 크기의 영상이 주어질 때, 이 영상을 압축한 결과를 출력하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/1992
 */

package io.inhyuck.divide_conquer;

import java.util.Scanner;

public class Q1992 {
    static StringBuilder builder = new StringBuilder();
    static int[][] origin;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        origin = new int[n][n];
        String temp;
        for (int i = 0; i < n; i++) {
            temp = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                origin[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }
        compression(0, 0, n);
        System.out.println(builder);
    }

    private static void compression(int x, int y, int length) {
        if (sameColor(x, y, length)) {
            builder.append(origin[x][y]);
            return;
        }
        builder.append("(");
        int nextLength = length / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                compression(x + i * nextLength, y + j * nextLength, nextLength);
            }
        }
        builder.append(")");
    }

    private static boolean sameColor(int x, int y, int length) {
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (origin[x][y] != origin[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
