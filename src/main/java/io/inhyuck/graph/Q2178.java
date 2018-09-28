/**
 * Date: 2018. 9. 1.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 미로 탐색
 * Problem: 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때,
 * (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/2178
 */
package io.inhyuck.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2178 {
    static int[][] list;
    static boolean[][] check;
    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();
        String temp;
        list = new int[n][m];
        check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            temp = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                list[i][j] = Integer.parseInt(temp.charAt(j) + "");
            }
        }
//        System.out.println(Arrays.deepToString(list));
        bfs(0, 0);
    }

    private static void bfs(int i, int j) {
        Queue<Miro> queue = new LinkedList<>();
        check[i][j] = true;
        int step = 1;
        queue.offer(new Miro(i, j, 1));
        while (!queue.isEmpty()) {
//            System.out.println(queue.toString());
            Miro obj = queue.poll();
            if (obj.i > 0 && isOk(obj.i - 1, obj.j)) {
                insertQueue(queue, obj.i-1, obj.j, obj.step + 1);
            }
            if (obj.i < n - 1 && isOk(obj.i + 1, obj.j)) {
                insertQueue(queue, obj.i+1, obj.j, obj.step + 1);
            }
            if (obj.j > 0 && isOk(obj.i, obj.j - 1)) {
                insertQueue(queue, obj.i, obj.j-1, obj.step + 1);
            }
            if (obj.j < m - 1 && isOk(obj.i, obj.j + 1)) {
                insertQueue(queue, obj.i, obj.j+1, obj.step + 1);
            }
        }
    }

    private static void insertQueue(Queue queue, int i, int j, int step) {
        if (i == n - 1 && j == m - 1) {
            System.out.println(step);
        }
        check[i][j] = true;
        queue.offer(new Miro(i, j, step));
    }

    private static boolean isOk(int i, int j) {
        if (list[i][j] == 1 && check[i][j] == false) {
            return true;
        }
        return false;
    }

    private static class Miro {
        int i;
        int j;
        int step;

        public Miro(int i, int j, int step) {
            this.i = i;
            this.j = j;
            this.step = step;
        }

        @Override
        public String toString() {
            return "Miro{" +
                    "i=" + i +
                    ", j=" + j +
                    ", step=" + step +
                    '}';
        }
    }
}
