/**
 * Date: 2018. 9. 30.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 종이의 개수
 * description: 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수,
 * 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/1780
 */

package io.inhyuck.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1780 {
    static int[][] papers;
    static int minusOne = 0, zero = 0, plusOne = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        papers = new int[n][n];
        StringTokenizer tokenizer;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                papers[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        countPaper(new Point(0, 0), n);
        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(plusOne);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void countPaper(Point beginPoint, int length) {
        if (samePaper(beginPoint, length)) {
            if (papers[beginPoint.x][beginPoint.y] == -1) minusOne++;
            if (papers[beginPoint.x][beginPoint.y] == 0) zero++;
            if (papers[beginPoint.x][beginPoint.y] == 1) plusOne++;
            return;
        }
        int nextLength = length / 3;
        for (int i = 0; i < length; i += nextLength) {
            for (int j = 0; j < length ; j +=nextLength) {
                countPaper(new Point(beginPoint.x + i, beginPoint.y + j), nextLength);
            }
        }

    }

    private static boolean samePaper(Point beginPoint, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (papers[beginPoint.x][beginPoint.y] != papers[beginPoint.x + i][beginPoint.y + j]) return false;
            }
        }
        return true;
    }
}
