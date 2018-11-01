/**
 * Date: 01/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 중량제한
 * description: 한 번의 이동에서 옮길 수 있는 물품들의 중량의 최댓값을 구하는 프로그램을 작성하시오.
 * Solution Key: Binary Search, Graph
 * Problem URL: https://www.acmicpc.net/problem/1939
 */

package io.inhyuck.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1939 {
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        HashMap<Integer, ArrayList<Node>> graph = new HashMap<>();
        int a, b, c, maxWeight = 0;
        for (int i = 0; i < n + 1; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            a = Integer.parseInt(tokenizer.nextToken());
            b = Integer.parseInt(tokenizer.nextToken());
            c = Integer.parseInt(tokenizer.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
            maxWeight = Math.max(maxWeight, c);
        }
//        graph.entrySet().forEach(System.out::println); //graph input Log
        tokenizer = new StringTokenizer(reader.readLine());
        int from = Integer.parseInt(tokenizer.nextToken());
        int to = Integer.parseInt(tokenizer.nextToken());
        int availableMaxWeight = 0;
        int low = 1, high = maxWeight;
        while(low <= high) {
            int middle = (low + high) / 2;
            if (isAvailable(graph, from, to, middle)) {
                availableMaxWeight = middle;
                low = middle + 1;
                continue;
            }
            high = middle - 1;
        }
        System.out.println(availableMaxWeight);
    }

    //BFS로 주어진 중량(middle)으로 도착점까지 이동 가능한지 판단
    private static boolean isAvailable(HashMap<Integer, ArrayList<Node>> graph, int from, int to, int middle) {
        boolean[] check = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        check[from] = true;
        queue.offer(from);
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (Node node : graph.get(num)) {
                if (check[node.to] == true) {
                    continue;
                }
                if (node.weight >= middle) {
                    if (node.to == to) {
                        return true;
                    }
                    check[node.to] = true;
                    queue.offer(node.to);
                }
            }
        }
        return false;
    }

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return String.format("(to:%d, weight:%d)", to, weight);
        }
    }
}
