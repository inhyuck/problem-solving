/**
 * Date: 2018. 10. 12.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 수 찾기
 * description: N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때,
 * 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/1920
 */

package io.inhyuck.divide_conquer;

import java.util.Arrays;
import java.util.Scanner;

public class Q1920 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] inputNumbers = new int[n];
        for (int i = 0; i < n; i++) {
            inputNumbers[i] = scanner.nextInt();
        }
        Arrays.parallelSort(inputNumbers);
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.binarySearch(inputNumbers, scanner.nextInt()) < 0 ? 0 : 1);
        }
    }
}
