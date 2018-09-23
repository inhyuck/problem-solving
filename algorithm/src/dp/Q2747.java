/**
 * Date: 2018. 07. 30.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 피보나치 수
 * Problem: 피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다.
 * 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
 * 이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n>=2)가 된다.
 * n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
 *
 * URL: https://www.acmicpc.net/problem/2747
 */
package dp;

import java.util.*;

public class Q2747 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        /**
         * Top-down
         */
        dp = new int[n + 1];
        System.out.println(fibonacci(n));

        /**
         * Bottom-up
         */
//        dp = new int[n + 1];
//        dp[0] = 0;
//        dp[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//        System.out.println(dp[n]);
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] > 0) {
            return dp[n];
        }
        return dp[n] = fibonacci(n-1 ) + fibonacci(n-2 );
    }
}