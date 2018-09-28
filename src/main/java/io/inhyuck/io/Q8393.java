/**
 * Date: 2018. 9. 11.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 합
 * Problem: n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/8393
 */
package io.inhyuck.io;

import java.util.Scanner;

public class Q8393 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println(sum(n));
    }

    private static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n -1);
    }
}
