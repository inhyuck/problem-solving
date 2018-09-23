/**
 * Date: 2018. 08. 09.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 붕어빵 판매하기
 * Problem: 세트 메뉴의 가격이 주어졌을 때, 해빈이가 얻을 수 있는
 * 최대 수익을 구하는 프로그램을 작성하시오. (링크참고)
 * URL: https://www.acmicpc.net/problem/11052
 */
package dp;

import java.util.*;

public class Q11052 {
    //dp[n] | n개의 붕어빵을 팔 때 최대수익
    public static int[] dp, p;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strings = scanner.nextLine().split(" ");
        p = new int[n + 1];
        for (int i = 0; i < n; i++) {
            p[i + 1] = Integer.parseInt(strings[i]);
        }
        dp = new int[n + 1];
        System.out.println(go(n));
    }

    public static int go(int n) {
        if (dp[n] > 0) {
            return dp[n];
        }
        for (int i = 1; i <= n; i++) {
            dp[n] = Math.max(dp[n], go(n - i) + p[i]);
        }
        return dp[n];
    }
}
