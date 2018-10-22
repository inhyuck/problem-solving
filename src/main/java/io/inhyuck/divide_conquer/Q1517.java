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

public class Q1517 {
    static long swapCount = 0;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        numbers = new int[n];
        String[] temp = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(temp[i]);
        }
        mergeSort(0, n - 1);
//        System.out.println(Arrays.toString(numbers)); //정렬 확인
        System.out.println(swapCount);
    }

    private static void mergeSort(int first, int last) {
        if (first >= last) {
            return;
        }
        int middle = (first + last) / 2;
        mergeSort(first, middle);
        mergeSort(middle + 1, last);
        merge(first, middle, last);
    }

    private static void merge(int first, int middle, int last) {
        int[] sortedNumbers = new int[last - first + 1];
        int sortedNumbersPointer = 0;
        int p1 = first, p2 = middle + 1;
        while (p1 <= middle && p2 <= last) {
            if (numbers[p1] <= numbers[p2]) {
                sortedNumbers[sortedNumbersPointer++] = numbers[p1++];
            } else {
                sortedNumbers[sortedNumbersPointer++] = numbers[p2++];
                swapCount += (middle - p1 + 1);
            }
        }
        while (p1 <= middle) {
            sortedNumbers[sortedNumbersPointer++] = numbers[p1++];
        }
        while (p2 <= last) {
            sortedNumbers[sortedNumbersPointer++] = numbers[p2++];
        }
        for (int i = 0; i < sortedNumbers.length; i++) {
            numbers[i + first] = sortedNumbers[i];
        }
    }
}
