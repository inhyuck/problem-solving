/**
 * Date: 2018. 8. 31.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 이분 그래프
 * Problem: 그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때,
 * 그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.
 * 그래프가 입력으로 주어졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/1707
 */
package io.inhyuck.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1707 {
    static ArrayList<Integer>[] list;
    static int[] check; //0 : 미방문, 1: 방문했고 1팀, 2: 방문했고 2팀

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt(); //테스트 케이스 갯수
        int n, m;
        for (int i = 0; i < k; i++) {
            n = scanner.nextInt(); //정점의 갯수
            m = scanner.nextInt(); //간선의 갯수
            list = new ArrayList[n + 1];
            check = new int[n + 1];
            for (int j = 0; j < n + 1; j++) {
                list[j] = new ArrayList<>();
            }
            int u, v;
            for (int j = 0; j < m; j++) {
                u = scanner.nextInt();
                v = scanner.nextInt();
                list[u].add(v);
                list[v].add(u);
            }
            boolean bool = true;
            for (int j = 0; j < n + 1; j++) {
                if (check[j] == 0) {
                    dfs(j, 1);
                }
            }
            for (int j = 1; j < n + 1; j++) {
                for (int l : list[j]) {
                    if (check[j] == check[l]) {
                        bool = false;
                        break;
                    }
                }
            }
            System.out.println(bool ? "YES" : "NO");
        }
    }

    private static void dfs(int i, int number) {
        check[i] = number;
        for (int j = 0; j < list[i].size(); j++) {
            if (check[list[i].get(j)] == 0) {
                dfs(list[i].get(j), 3 - number); //number가 1인경우 2, 2인경우 1
            }
        }
    }
}
