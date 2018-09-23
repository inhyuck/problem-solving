/**
 * Date: 2018. 9. 2.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 트리의 지름
 * Problem: 트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다.
 * 트리의 지름을 구하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/1167
 */
package tree;

import java.util.*;

public class Q1167 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        List<Edge>[] list = (List<Edge>[]) new List[v + 1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<Edge>();
        }
        int from, to;
        for (int i = 0; i < v; i++) {
            from = scanner.nextInt();
            while ((to = scanner.nextInt()) != -1) {
                list[from].add(new Edge(to, scanner.nextInt()));
            }
        }
        int[] dist = bfs(v, list, 1);
        int maxLength = 0;
        int maxLengthNumber = 1;
        for (int i = 2; i <= v; i++) {
            if (maxLength < dist[i]) {
                maxLengthNumber = i;
                maxLength = dist[i];
            }
        }
//        System.out.println(maxLengthNumber);
        dist = bfs(v, list, maxLengthNumber);
        maxLength = dist[1];
        for (int i = 2; i <= v; i++) {
            maxLength = Math.max(maxLength, dist[i]);
        }
//        System.out.println(Arrays.toString(lengthFromMaxLengthNumber));
        System.out.println(maxLength);
    }

    private static int[] bfs(int v, List<Edge>[] list, int start) {
        boolean[] check = new boolean[v + 1];
        int[] dist = new int[v + 1];
        Queue<Integer> queue = new LinkedList<>();
        check[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int item = queue.poll();
            for (Edge edge : list[item]) {
                if (check[edge.to] == false) {
                    check[edge.to] = true;
                    dist[edge.to] = dist[item] + edge.length;
                    queue.offer(edge.to);
                }
            }
        }
        return dist;
    }

    /**
     * private static void dfs(int v, List<Edge>[] list, int[] dist, int start, boolean[] check) {
        check[start] = true;
        for (Edge edge : list[start]) {
            if (check[edge.to] == false) {
                check[edge.to] = true;
                dist[edge.to] = dist[start] + edge.length;
                dfs(v, list, dist, edge.to, check);
            }
        }
    }
     */

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
