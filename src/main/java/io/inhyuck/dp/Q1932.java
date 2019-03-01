/**
 * Date: 02/03/2019
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 정수 삼각형
 * description: 정수 삼각형이 주어졌을때 경로의 최댓값 구하기 (링크 참조)
 * Solution Key: dp
 * Problem URL: https://www.acmicpc.net/problem/1932
 */

package io.inhyuck.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Integer>[] tryangle = new List[n];
        for (int i = 0; i < n; i++) {
            tryangle[i] = Arrays.stream(toIntArray(reader.readLine()))
                                .boxed()
                                .collect(Collectors.toList());
        }
//        printTryangle(tryangle); //Log
        
        int[][] memo = new int[n][n]; //memoization
        int maxSum = computeMaxSum(tryangle, 0, 0, memo);

        System.out.println(maxSum);
    }

    private static int computeMaxSum(List<Integer>[] tryangle, int layer, int order, int[][] memo) {
        if (memo[layer][order] > 0) {
            return memo[layer][order];
        }

        int nowPoint = tryangle[layer].get(order);
        if (layer == tryangle.length - 1) { //가장 최하단 layer
            return nowPoint;
        }

        return memo[layer][order] = nowPoint + Math.max(computeMaxSum(tryangle, layer + 1, order, memo)
                                 , computeMaxSum(tryangle, layer + 1, order + 1, memo));
    }

    private static void printTryangle(List<Integer>[] tryangle) {
        for (int i = 0; i < tryangle.length; i++) {
            tryangle[i].forEach(System.out::print);
            System.out.println();
        }
    }

    private static int[] toIntArray(String readLine) {
        String[] strings = readLine.split(" ");
        int[] result = new int[strings.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(strings[i]);
        }
        return result;
    }
}
