/**
 * Date: 16/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 이전 순열
 * description: 1부터 N까지의 수로 이루어진 순열이 있다. 이때, 사전순으로 바로 이전에 오는 순열을 구하는 프로그램을 작성하시오.
 * Solution Key: Brute Force
 * Problem URL: https://www.acmicpc.net/problem/10973
 */

package io.inhyuck.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10973 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] numbers = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        boolean hasPrevPermutation = prevPermutation(numbers);
        if (!hasPrevPermutation) {
            System.out.println("-1");
            return;
        }

        StringJoiner joiner = new StringJoiner(" ");
        Arrays.stream(numbers).forEach(x -> joiner.add(Integer.toString(x)));
        System.out.println(joiner.toString());
    }

    private static boolean prevPermutation(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] < numbers[i - 1]) {
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
            if (numbers[i] < preValue) {
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
