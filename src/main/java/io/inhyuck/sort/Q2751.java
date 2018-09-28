/**
 * Date: 2018. 08. 16.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 수 정렬하기2
 * Problem: N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/2751
 */
package io.inhyuck.sort;

import java.io.*;
import java.util.Arrays;

public class Q2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        int[] numbers = new int[t];
        for (int i = 0; i < t; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(numbers);
        for (int n : numbers) {
            System.out.println(n);
        }
    }
}
