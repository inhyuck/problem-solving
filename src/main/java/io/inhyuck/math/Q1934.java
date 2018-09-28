/**
 * Date: 2018. 08. 14.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 최소공배수
 * Problem:
 * 두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/1934
 */
package io.inhyuck.math;

import java.util.*;

public class Q1934 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int a, b, gcd, lcm;

        for (int i = 0; i < t; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            gcd = gcd(a, b);
            lcm = (a * b) / gcd;
            System.out.println(lcm);
        }
    }

    //유클리드 호제법
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}