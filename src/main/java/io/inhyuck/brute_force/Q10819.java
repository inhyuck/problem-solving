/**
 * Date: 07/12/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 차이를 최대로
 * description: 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오.
 * |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
 * Solution Key: brute force, 순열 다 해보기
 * Problem URL: https://www.acmicpc.net/problem/10819
 */

package io.inhyuck.brute_force;

import java.util.Arrays;
import java.util.Scanner;

public class Q10819 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);
        int maxValue = computeValue(numbers);
        while (nextPermutation(numbers)) {
            maxValue = Math.max(computeValue(numbers), maxValue);
        }

        System.out.println(maxValue);
    }

    private static int computeValue(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            sum += Math.abs(numbers[i] - numbers[i + 1]);
        }
        return sum;
    }

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
