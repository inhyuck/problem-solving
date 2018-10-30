/**
 * Date: 30/10/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 나무 자르기
 * description: 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성하시오
 * Solution Key: Binary Search
 * Problem URL: https://www.acmicpc.net/problem/2805
 */

package io.inhyuck.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        long[] heights = new long[n];
        long end = 0; //주어진 나무 높이 중 최댓값
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(tokenizer.nextToken());
            if (end < heights[i]) {
                end = heights[i];
            }
        }
        long start = 0, middle;
        long maxHeight = -1; //주어진 나무길이를 얻을 수 있는 최대 높이
        while (start <= end) {
            middle = (start + end) / 2;
            if (cutTrees(heights, middle) < m) {
                end = middle - 1;
            } else {
                maxHeight = middle;
                start = middle + 1;
            }
        }
        System.out.println(maxHeight);
    }

    //middle 높이로 나무를 잘랐을 때 얻을 수 있는 길이 return
    private static long cutTrees(long[] heights, long middle) {
        return Arrays.stream(heights).map(h -> (h - middle) < 0 ? 0 : h - middle).sum();
    }
}
