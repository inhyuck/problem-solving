/**
 * Date: 2018. 08. 09.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 1로 만들기
 * Problem: 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 * 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * 2. X가 2로 나누어 떨어지면, 2로 나눈다.
 * 3. 1을 뺀다.
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다.
 * 연산을 사용하는 횟수의 최솟값을 출력하시오.
 * URL: https://www.acmicpc.net/problem/1463
 */

package io.inhyuck.dp;

import java.util.*;

public class Q1463 {
    public static int[] dp; //memo | dp[i] : i를 1로 만드는 최소 연삿 횟수

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new int[n + 1];
        System.out.println(go(n));
    }

    public static int go(int n) {
        if (n == 1)
            return 0;
        if (dp[n] > 0) {
            return dp[n];
        }

        dp[n] = go(n - 1) + 1;
        if (n % 3 == 0) {
            dp[n] = Math.min(dp[n], go(n / 3) + 1);
        }
        if (n % 2 == 0) {
            dp[n] = Math.min(dp[n], go(n / 2) + 1);
        }

        return dp[n];
    }
}

