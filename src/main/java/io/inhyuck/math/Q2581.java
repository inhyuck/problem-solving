/**
 * Date: 13/12/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 소수
 * description: 자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을
 * 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
 * Solution Key: math
 * Problem URL: https://www.acmicpc.net/problem/2581
 */

package io.inhyuck.math;

import java.util.Scanner;

public class Q2581 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int sum = 0;
        int minPrimeNumber = Integer.MAX_VALUE;
        for (int i = m; i <= n; i++) {
            if (isPrimeNumber(i)) {
                sum += i;
                minPrimeNumber = Math.min(i, minPrimeNumber);
            }
        }

        if (sum == 0) {
            System.out.println("-1");
            return;
        }
        System.out.println(sum);
        System.out.println(minPrimeNumber);
    }

    private static boolean isPrimeNumber(int number) {
        if (number == 1) {
            return false;
        }
        int rootNumber = (int)Math.sqrt(number);
        for (int i = 2; i <= rootNumber; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
