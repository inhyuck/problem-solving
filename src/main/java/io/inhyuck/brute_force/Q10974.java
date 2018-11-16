/**
 * Date: 16/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 모든 순열
 * description: N이 주어졌을 때, 1부터 N까지의 수로 이루어진 순열을 사전순으로 출력하는 프로그램을 작성하시오.
 * Solution Key: Brute Force
 * Problem URL: https://www.acmicpc.net/problem/10974
 */

package io.inhyuck.brute_force;

import java.util.Arrays;
import java.util.Scanner;

public class Q10974 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

        StringBuilder builder = new StringBuilder();
        appendNumbers(builder, numbers);
        while (nextPermutation(numbers)) {
            appendNumbers(builder, numbers);
        }

        System.out.println(builder.toString());
    }

    private static void appendNumbers(StringBuilder builder, int[] numbers) {
        Arrays.stream(numbers).forEach(x -> builder.append(x).append(" "));
        builder.append("\n");
    }

    /**
     * Q10972 다음 순열 Logic
     */
    private static boolean nextPermutation(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) {
                swap(numbers, i - 1, getSwapNumber(numbers, i, numbers[i - 1]));
                reverseArray(numbers, i, numbers.length - 1);
                return true;
            }
        }
        return false;
    }

    private static void reverseArray(int[] numbers, int fromIndex, int toIndex) {
        int length = toIndex - fromIndex + 1;
        for (int i = 0; i < length / 2; i++) {
            swap(numbers, fromIndex + i, toIndex - i);
        }
    }

    private static int getSwapNumber(int[] numbers, int index, int preValue) {
        for (int i = numbers.length - 1; i > index; i--) {
            if (numbers[i] > preValue) {
                return i;
            }
        }
        return index;
    }

    private static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

}
