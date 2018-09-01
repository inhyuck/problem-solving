/**
 * Date: 2018. 9. 1.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 토마토
 * Problem: 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
 * 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라.
 * URL: https://www.acmicpc.net/problem/7576
 */
package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7576 {
    static int[][] list;
    static boolean[][] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        list = new int[n][m];
        check = new boolean[n][m];
        Queue<Tomato> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                list[i][j] = scanner.nextInt();
                if (list[i][j] == 1) {
                    queue.offer(new Tomato(i, j, 0));
                    check[i][j] = true;
                }
            }
        }
        int dayCount = Integer.MIN_VALUE;
        int i, j, day;
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            i = tomato.i;
            j = tomato.j;
            day = tomato.day;
            dayCount = Math.max(day, dayCount);
//            System.out.println(tomato.toString() + " | dayCount : " + dayCount);

            if (i > 0 && isOk(i - 1, j)) {
                insertQueue(queue, i-1, j, day + 1);
            }
            if (i < n - 1 && isOk(i + 1, j)) {
                insertQueue(queue, i+1, j, day + 1);
            }
            if (j > 0 && isOk(i, j - 1)) {
                insertQueue(queue, i, j-1, day + 1);
            }
            if (j < m - 1 && isOk(i, j + 1)) {
                insertQueue(queue, i, j+1, day + 1);
            }
        }
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < m; l++) {
                if (check[k][l] == false && list[k][l] == 0) {
                    dayCount = -1;
                }
            }
        }
        System.out.println(dayCount);
//        System.out.println(Arrays.deepToString(list));
//        System.out.println(Arrays.deepToString(check));
    }

    private static void insertQueue(Queue queue, int i, int j, int day) {
        check[i][j] = true;
        queue.offer(new Tomato(i, j, day));
    }

    private static boolean isOk(int i, int j) {
        if (list[i][j] == 0 && check[i][j] == false) {
            return true;
        }
        return false;
    }

    private static class Tomato {
        int i;
        int j;
        int day;

        public Tomato(int i, int j, int day) {
            this.i = i;
            this.j = j;
            this.day = day;
        }

        @Override
        public String toString() {
            return "Tomato{" +
                    "i=" + i +
                    ", j=" + j +
                    ", day=" + day +
                    '}';
        }
    }
}
