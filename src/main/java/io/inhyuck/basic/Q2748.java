/**
 * Date: 2018. 10. 10.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 피보나치 수 2
 * description: n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/2748
 */

package io.inhyuck.basic;

import java.util.Scanner;

public class Q2748 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        long[] fibonacci = new long[n + 1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i <= n ; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        System.out.println(fibonacci[n]);
    }
}
