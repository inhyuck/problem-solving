/**
 * Date: 2018. 08. 09.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 2 x n 타일링
 * Problem: 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는
 * 방법의 수를 구하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/11726
 */
package dp;

import java.util.*;

public class Q11726 {
    public static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // dp[n] | 2 x n 크기의 직사각형을 채우는 방법의 수
        dp = new int[n + 1];
        dp[0] = 1; // dp[n] = dp[n-1] + dp[n-2] 를 위한 명시적 조건
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[n]);
    }
}