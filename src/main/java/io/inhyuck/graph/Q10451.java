/**
 * Date: 2018. 9. 1.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 순열 사이클
 * Problem: N개의 정수로 이루어진 순열이 주어졌을 때, 순열 사이클의 개수를 구하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/10451
 */
package io.inhyuck.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q10451 {
    static ArrayList<Integer>[] list;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n, count;
        while (t-- > 0) {
            n = scanner.nextInt();
            count = 0;
            list = (ArrayList<Integer>[]) new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                list[i + 1].add(scanner.nextInt());
            }
            check = new boolean[n + 1];
            for (int i = 1; i < n + 1; i++) {
                if (check[i] == false) {
                    bfs(i);
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static void bfs(int i) {
        check[i] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        while (!queue.isEmpty()) {
            int j = queue.poll();
            for (int k : list[j]) {
                if (check[k] == false) {
                    check[k] = true;
                    queue.offer(k);
                }
            }
        }
    }
}
