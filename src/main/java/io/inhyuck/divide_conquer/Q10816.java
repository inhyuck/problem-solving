/**
 * Date: 2018. 9. 29.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 숫자 카드 2
 * description: 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다.
 * 숫자 M개가 주어졌을 때, 이 숫자가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/10816
 */

package io.inhyuck.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] ownCards = new int[n];
        for (int i = 0; i < n; i++) {
            ownCards[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int m = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] compareCards = new int[m];
        for (int i = 0; i < m; i++) {
            compareCards[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        mergeSort(ownCards, 0, n - 1);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            stringBuilder.append(countSameCard(ownCards, 0, n - 1, compareCards[i]) +  " ");
        }
        System.out.println(stringBuilder);
    }

    private static void mergeSort(int[] ownCards, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(ownCards, start, middle);
        mergeSort(ownCards, middle + 1, end);
        merge(ownCards, start, middle, end);
//        System.out.println(Arrays.toString(ownCards) + " " + start + " " + end);
    }

    private static void merge(int[] ownCards, int start, int middle, int end) {
        if (ownCards[middle] < ownCards[middle + 1]) {
            return;
        }
        int[] temp = new int[end - start + 1];
        int k = 0;
        int i = start;
        int j = middle + 1;
        while (i <= middle && j <= end) {
            if (ownCards[i] <= ownCards[j]) {
                temp[k++] = ownCards[i++];
            } else {
                temp[k++] = ownCards[j++];
            }
        }
        while (j <= end) temp[k++] = ownCards[j++];
        while (i <= middle) temp[k++] = ownCards[i++];
        for (int l = 0; l < end - start + 1; l++) {
            ownCards[start + l] = temp[l];
        }
    }

    private static int countSameCard(int[] ownCards, int start, int end, int compareCard) {
        int findIndex = binarySearch(ownCards, start, end, compareCard);
        if (findIndex == -1) {
            return  0;
        }
        if (ownCards[findIndex] == ownCards[start] && ownCards[findIndex] == ownCards[end]) {
            return end - start + 1;
        }
        int count = 1;
        count += countSameCard(ownCards, start, findIndex - 1, compareCard);
        count += countSameCard(ownCards, findIndex + 1, end, compareCard);
        return count;
    }

    private static int binarySearch(int[] ownCards, int start, int end, int compareCard) {
        if (start > end) {
            return -1;
        }
        int middle = start + (end - start) / 2;
        if (ownCards[middle] < compareCard) {
            return binarySearch(ownCards, middle + 1, end, compareCard);
        }
        if (ownCards[middle] > compareCard) {
            return binarySearch(ownCards, start, middle - 1, compareCard);
        }
        return middle;
    }
}
