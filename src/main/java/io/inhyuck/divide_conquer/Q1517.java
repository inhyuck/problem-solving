/**
 * Date: 2018. 10. 20.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 버블 소트
 * description: swap 횟수 구하기. 링크 참조.
 * Problem URL: https://www.acmicpc.net/problem/1517
 */

package io.inhyuck.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1517 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] originNumber = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            originNumber[i] = Integer.parseInt(tokenizer.nextToken());
            map.put(originNumber[i], i);
        }
        int[] sortedNumber = Arrays.copyOf(originNumber, n);
        Arrays.sort(sortedNumber);

        int swapCount = 0;
        for (int i = 0; i < n; i++) {
            int sortedIndex = Arrays.binarySearch(sortedNumber, originNumber[i]);
            for (int j = 0; j < sortedIndex; j++) {
                if (map.get(sortedNumber[sortedIndex]) < map.get(sortedNumber[j])) {
                    swapCount++;
                }
            }
        }
        System.out.println(swapCount);

    }
}
