/**
 * Date: 2018. 10. 25.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 랜선 자르기
 * description: 기존 랜선, 새롭게 만들어야할 랜선의 갯수가 주어지고 이때 새로운 랜선 길이의 최댓값 구하기
 * Solution Key: 가능한 범위에서 이분 탐색하여 최적해 찾기
 * Problem URL: https://www.acmicpc.net/problem/1654
 */

package io.inhyuck.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = reader.readLine().split(" ");
        int k = Integer.parseInt(temp[0]);
        int n = Integer.parseInt(temp[1]);
        int[] originLines = new int[k];
        int originMaxLength = 0;
        for (int i = 0; i < k; i++) {
            originLines[i] = Integer.parseInt(reader.readLine());
            originMaxLength = Math.max(originLines[i], originMaxLength);
        }
//        Arrays.stream(originLines).forEach(System.out::println); //Log

        long newMaxLength = binarySearch(1, originMaxLength, n, originLines);
        System.out.println(newMaxLength);
    }

    private static long binarySearch(long start, long end, int n, int[] originLines) {
        long newMaxLength = 0, middle;
        while (start <= end) {
            middle = (start + end) / 2;
            if (computeLineCount(middle, originLines) >= n) {
                newMaxLength = middle;
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return newMaxLength;
    }

    private static int computeLineCount(long length, int[] originLines) {
        int count = 0;
        for (int i = 0; i < originLines.length; i++) {
            count += originLines[i] / length;
        }
        return count;
    }
}
