/**
 * Date: 2018. 10. 17.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 별찍기 - 10
 * description: 예제를 보고 별찍는 규칙을 유추한 뒤에 별을 찍어 보세요.
 * Problem URL: https://www.acmicpc.net/problem/2447
 */

package io.inhyuck.divide_conquer;

import java.util.Scanner;

public class Q2447 {
    static boolean[][] isStar;

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        isStar = new boolean[n + 1][n + 1];
        drawStar(new Point(1, 1), n);
        printStar(n);
    }

    private static void drawStar(Point start, int size) {
        if (size == 1) {
            isStar[start.x][start.y] = true;
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < size; i += newSize) {
            for (int j = 0; j < size; j += newSize) {
                if(i == newSize && j == newSize) { //가운데 빈 공간
                   continue;
                }
                drawStar(new Point(start.x + j, start.y + i), newSize);
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private static void printStar(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (isStar[i][j]) {
                    builder.append("*");
                } else {
                    builder.append(" ");
                }
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }
}
