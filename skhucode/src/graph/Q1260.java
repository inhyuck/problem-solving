/**
 * Date: 2018. 08. 21.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: DFS와 BFS
 * Problem: 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
 * 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 * URL: https://www.acmicpc.net/problem/1260
 */
package graph;

import java.util.*;

public class Q1260 {
    static ArrayList<Integer>[] list;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int start = scanner.nextInt();
        int temp1, temp2;

        list = (ArrayList<Integer>[]) new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            temp1 = scanner.nextInt();
            temp2 = scanner.nextInt();
            list[temp1].add(temp2);
            list[temp2].add(temp1);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(list[i]);
        }

//        System.out.println(Arrays.toString(list));
        check = new boolean[n + 1];
        dfs(start);

        System.out.println();
        check = new boolean[n + 1];
        bfs(start);
    }

    private static void dfs(int v) {
        System.out.print(v + " ");
        check[v] = true;
        for (int i = 0; i < list[v].size(); i++) {
            if (check[list[v].get(i)] == false) {
                dfs(list[v].get(i));
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        check[start] = true;
        System.out.print(start + " ");
        int v, temp;
        while (!queue.isEmpty()) {
            v = queue.poll();
            for (int i = 0; i < list[v].size(); i++) {
                temp = list[v].get(i);
                if (check[temp] == false) {
                    check[temp] = true;
                    System.out.print(temp + " ");
                    queue.offer(temp);
                }
            }
        }
    }
}