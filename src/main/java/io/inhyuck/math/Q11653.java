/**
 * Date: 22/12/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 소인수분해
 * description: 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
 * Solution Key: Math
 * Problem URL: https://www.acmicpc.net/problem/11653
 */

package io.inhyuck.math;

import java.util.Scanner;

public class Q11653 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        if (n == 1) {
            return;
        }

        String result = solve(n);

        System.out.println(result);
    }

    private static String solve(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return new StringBuilder(String.valueOf(i)).append("\n").append(solve(n / i)).toString();
            }
        }

        return String.valueOf(n);
    }
}
