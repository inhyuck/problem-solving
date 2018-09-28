/**
 * Date: 2018. 9. 2.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 트리의 지름
 * Problem: 트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다.
 * 트리의 지름을 구하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/1967
 */
package io.inhyuck.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1967 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        ArrayList<Edge>[] list = new ArrayList[v + 1];
        for (int i = 0; i < v + 1; i++) {
            list[i] = new ArrayList<>();
        }
        int from, to, length;
        for (int i = 0; i < v - 1; i++) {
            from = scanner.nextInt();
            to = scanner.nextInt();
            length = scanner.nextInt();
            list[from].add(new Edge(to, length));
            list[to].add(new Edge(from, length));
        }
        int[] lengthFromRoot = new int[v + 1];
        bfs(v, list, lengthFromRoot, 1);
        //System.out.println(Arrays.toString(lengthFromOne));
        int maxLength = 0;
        int maxLengthNumber = 1;
        for (int i = 2; i < v + 1; i++) {
            if (maxLength < lengthFromRoot[i]) {
                maxLengthNumber = i;
                maxLength = lengthFromRoot[i];
            }
        }
//        System.out.println(maxLengthNumber);
        int[] lengthFromMaxLengthNumber = new int[v + 1];
        bfs(v, list, lengthFromMaxLengthNumber, maxLengthNumber);
        maxLength = 0;
        for (int i = 1; i < v + 1; i++) {
            maxLength = Math.max(maxLength, lengthFromMaxLengthNumber[i]);
        }
//        System.out.println(Arrays.toString(lengthFromMaxLengthNumber));
        System.out.println(maxLength);
    }

    private static void bfs(int v, ArrayList<Edge>[] list, int[] lengthFromOne, int start) {
        lengthFromOne[start] = 0;
        boolean[] check = new boolean[v + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        check[start] = true;
        while (!queue.isEmpty()) {
            int item = queue.poll();
            for (Edge edge : list[item]) {
                if (check[edge.to] == false) {
                    check[edge.to] = true;
                    lengthFromOne[edge.to] = lengthFromOne[item] + edge.length;
                    queue.offer(edge.to);
                }
            }
        }
    }

    private static class Edge {
        int to;
        int length;

        public Edge(int to, int length) {
            this.to = to;
            this.length = length;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "to=" + to +
                    ", length=" + length +
                    '}';
        }
    }
}
