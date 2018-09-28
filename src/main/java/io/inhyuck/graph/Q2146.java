/**
 * Date: 2018. 9. 1.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 다리 만들기
 * Problem: 지도가 주어질 때, 가장 짧은 다리 하나를 놓아 두 대륙을 연결하는 방법을 찾으시오.
 * URL: https://www.acmicpc.net/problem/2146
 */
package io.inhyuck.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2146 {
    static int[][] list;
    static boolean[][] check;
    static int n;
    static Queue<Island> queue;
    static Island[][] islands;
    static int minNumber;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        list = new int[n][n];
        check = new boolean[n][n];
        islands = new Island[n][n]; //섬 행렬을 통해 내부 상태 기록.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list[i][j] = scanner.nextInt();
            }
        }
        int islandNumber = 1; //섬끼리 구분짓기 위한 고유번호 (같은 섬끼리는 같은 번호 부여됨)
        queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j] == false && list[i][j] == 1) {
                    dfs(i, j, islandNumber++);
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(islands[i]));
//        }
        int i, j, step;
        minNumber = Integer.MAX_VALUE; //섬 사이의 거리 최솟값
        while (!queue.isEmpty()) { //BFS
            Island island = queue.poll();
            i = island.i;
            j = island.j;
            step = island.step;
            islandNumber = island.islandNumber;

            if (i > 0 && isOkForBfs(i - 1, j, step, islandNumber)) {
                insertQueue(queue, i - 1, j, step + 1, islandNumber);
            }
            if (i < n - 1 && isOkForBfs(i + 1, j, step, islandNumber)) {
                insertQueue(queue, i + 1, j, step + 1, islandNumber);
            }
            if (j > 0 && isOkForBfs(i, j - 1, step, islandNumber)) {
                insertQueue(queue, i, j - 1, step + 1, islandNumber);
            }
            if (j < n - 1 && isOkForBfs(i, j + 1, step, islandNumber)) {
                insertQueue(queue, i, j + 1, step + 1, islandNumber);
            }

        }
        System.out.println(minNumber);
    }

    private static class Island { //섬 클래스
        int i;
        int j;
        int step; //섬 내부로 부터 거리
        int islandNumber; //섬 고유번호

        public Island(int i, int j, int step, int islandNumber) {
            this.i = i;
            this.j = j;
            this.step = step;
            this.islandNumber = islandNumber;
        }

        @Override
        public String toString() {
            return "Island{" +
                    "i=" + i +
                    ", j=" + j +
                    ", step=" + step +
                    ", islandNumber=" + islandNumber +
                    '}';
        }
    }

    private static void dfs(int i, int j, int islandNumber) {
        check[i][j] = true;
        queue.add(new Island(i, j, 0, islandNumber));
        islands[i][j] = new Island(i, j, 0, islandNumber);
        if (i > 0 && isOkForDfs(i-1, j)) {
            dfs(i-1, j, islandNumber);
        }
        if (i < n - 1 && isOkForDfs(i+1, j)) {
            dfs(i + 1, j, islandNumber);
        }
        if (j > 0 && isOkForDfs(i, j-1)) {
            dfs(i, j-1, islandNumber);
        }
        if (j < n - 1 && isOkForDfs(i, j+1)) {
            dfs(i, j + 1, islandNumber);
        }
    }

    private static boolean isOkForDfs(int i, int j) {
        if (list[i][j] == 1 && check[i][j] == false) {
            return true;
        }
        return false;
    }

    private static void insertQueue(Queue queue, int i, int j, int step, int islandNumber) {
        check[i][j] = true;
        islands[i][j] = new Island(i, j, step, islandNumber);
        queue.offer(new Island(i, j, step, islandNumber));
    }

    private static boolean isOkForBfs(int i, int j, int nowStep, int islandNumber) {
        //이미 탐색했지만 해당 섬과 고유번호가 다른경우 => 다른섬에서 그 전에 탐색했음, 섬 사이간 거리를 구할 수 있다.
        if (check[i][j] == true && islandNumber != islands[i][j].islandNumber) {
            minNumber = Math.min(minNumber, nowStep + islands[i][j].step);
            return false;
        }
        if (list[i][j] == 0 && check[i][j] == false) {
            return true;
        }
        return false;
    }
}
