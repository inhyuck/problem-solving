/**
 * Date: 21/12/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: Base Conversion
 * description: A진법 수를 B진법 수로 변환
 * Solution Key: Math
 * Problem URL: https://www.acmicpc.net/problem/11576
 */

package io.inhyuck.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(reader.readLine());
        tokenizer = new StringTokenizer(reader.readLine());
        int[] numbers = new int[m];
        for (int i = 0; i < m; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        reverseArray(numbers);
        int sum = 0;
        for (int i = 0; i < m; i++) { //a진법 수를 10진수로 변환
            sum += numbers[i] * Math.pow(a, i);
        }
        String result = convert(sum, b); //10진수를 b진법으로 변환

        System.out.println(result);
    }

    private static void reverseArray(int[] numbers) {
        for (int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
        }
    }

    private static String convert(int n, int b) {
        if (n < b) {
            return String.valueOf(n);
        }
        return new StringBuilder(convert(n / b, b)).append(" ").append(n % b).toString();
    }
}
