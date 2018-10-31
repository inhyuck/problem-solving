/**
 * Date: 31/10/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 공유기 설치
 * description: C개의 공유기를 N개의 집에 적당히 설치해서, 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 작성하시오.
 * Solution Key: Binary Search
 * Problem URL: https://www.acmicpc.net/problem/2110
 */

package io.inhyuck.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());
        int[] points = new int[n];
        int maxPoint = 0;
        for (int i = 0; i < n; i++) {
            points[i] = Integer.parseInt(reader.readLine());
            maxPoint = Math.max(points[i], maxPoint);
        }
        Arrays.parallelSort(points);

        int left = 0, right = maxPoint, middle;
        int maxLength = -1;
        while (left <= right) {
            middle = (left + right) / 2;
            if (isAvailable(points, middle, c)) {
                maxLength = middle;
                left = middle + 1;
                continue;
            }
            right = middle - 1;
        }
        System.out.println(maxLength);
    }

    private static boolean isAvailable(int[] points, int length, int count) {
        // 0번째 원소는 무조건 선택
        int preIndex = 0;
        count--;
        for (int i = 1; i < points.length; i++) {
            if (points[i] - points[preIndex] >= length) {
                preIndex = i;
                count--;
            }
            if (count == 0) {
                return true;
            }
        }
        return false;
    }
}
