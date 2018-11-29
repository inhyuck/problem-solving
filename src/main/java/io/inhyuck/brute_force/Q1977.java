/**
 * Date: 29/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 완전제곱수
 * description: 주어진 범위내의 완전제곱수 찾아서 문제 해결하기
 * Solution Key: Brute Force
 * Problem URL: https://www.acmicpc.net/problem/1977
 */

package io.inhyuck.brute_force;

import java.util.Scanner;

public class Q1977 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int sum = 0;
        int minNumber = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            int squareNumber = i * i;
            if (squareNumber >= m && squareNumber <= n) {
                sum += squareNumber;
                if (squareNumber < minNumber) {
                    minNumber = squareNumber;
                }
            }
        }

        if (sum == 0) {
            System.out.println("-1");
            return;
        }
        System.out.println(sum);
        System.out.println(minNumber);
    }
}
