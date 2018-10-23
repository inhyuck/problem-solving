/**
 * Date: 2018. 10. 23.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 평균
 * description: 새로운 평균을 구하는 프로그램
 * Solution Key: -
 * Problem URL: https://www.acmicpc.net/problem/1546
 */

package io.inhyuck.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] numbers = new int[n];
        String[] temp = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(temp[i]);
        }
        int maxNum = Arrays.stream(numbers).max().getAsInt();
        double sum = Arrays.stream(numbers).mapToDouble(x -> (x / (double)maxNum) * 100).sum();
        System.out.println(String.format("%.2f", sum / n));
    }
}
