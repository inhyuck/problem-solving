/**
 * Date: 2018. 8. 31.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 연결 요소의 개수
 * Problem: 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/11724
 */
package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Q11724 {
    static ArrayList<Integer>[] list;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //정점의 갯수
        int m = scanner.nextInt(); //간선의 갯수

        list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        int u, v;
        for (int i = 0; i < m; i++) {
            u = scanner.nextInt();
            v = scanner.nextInt();
            list[u].add(v);
            list[v].add(u);
        }

        int count = 0;
        check = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (check[i] == false) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int i) {
        check[i] = true;
        for (int j = 0; j < list[i].size(); j++) {
            if (check[list[i].get(j)] == false) {
                dfs(list[i].get(j));
            }
        }
    }
}
