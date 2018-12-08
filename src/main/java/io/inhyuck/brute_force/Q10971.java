/**
 * Date: 08/12/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 외판원 순회2
 * description: N과 비용 행렬이 주어졌을 때, 가장 적은 비용을 들이는 외판원의 순회 여행 경로를 구하는 프로그램
 * Solution Key: brute force, 순열 다 해보기
 * Problem URL: https://www.acmicpc.net/problem/10971
 */

package io.inhyuck.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10971 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
//        Arrays.stream(graph).forEach(x -> System.out.println(Arrays.toString(x))); //input log

        //도시 경로 순열
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i;
        }

        int minDistance = computeTraveling(numbers, graph);
        while (nextPermutation(numbers)) {
            minDistance = Math.min(computeTraveling(numbers, graph), minDistance);
        }

        System.out.println(minDistance);
    }

    private static int computeTraveling(int[] numbers, int[][] graph) {
        int sum = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            int distance = graph[numbers[i]][numbers[i + 1]];
            if (distance == 0) {
                return Integer.MAX_VALUE;
            }
            sum += distance;
        }

        //마지막도시에서 처음도시로 갈때 distance
        int lastDistance = graph[numbers[numbers.length - 1]][numbers[0]];
        if (lastDistance == 0) {
            return Integer.MAX_VALUE;
        }
        return sum + lastDistance;
    }

    private static boolean nextPermutation(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) {
                swap(numbers, i - 1, getSwapNumber(numbers, i, numbers[i - 1]));
                reverseArray(numbers, i, numbers.length - 1);
                return true;
            }
        }
        return false;
    }

    private static void reverseArray(int[] numbers, int fromIndex, int toIndex) {
        int length = toIndex - fromIndex + 1;
        for (int i = 0; i < length / 2; i++) {
            swap(numbers, fromIndex + i, toIndex - i);
        }
    }

    private static int getSwapNumber(int[] numbers, int index, int preValue) {
        for (int i = numbers.length - 1; i > index; i--) {
            if (numbers[i] > preValue) {
                return i;
            }
        }
        return index;
    }

    private static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}
