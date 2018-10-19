/**
 * Date: 2018. 10. 19.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 설탕 배달
 * description: 상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때,
 * 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/2839
 */

package io.inhyuck.dp;

import java.util.Scanner;

public class Q2839 {
    static int[] memo;

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        if (n == 7 || n == 4) { //정확하게 N 킬로그램을 만들 수 없는 경우
            System.out.println("-1");
            return;
        }
        if (n == 3) {
            System.out.println("1");
            return;
        }
        memo = new int[n + 1]; //memo[i] => i 킬로그램의 설탕을 배달할 때 3kg 봉지의 갯수
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        //1, 2, 4 로 남은 경우 잘못된 분류이므로 선택하지 못하도록 적당히 큰 수 5000 설정.
        memo[0] = 0; memo[1] = 5000; memo[2] = 5000; memo[3] = 1;
        memo[4] = 5000; memo[5] = 0;
        int countOfThree = dp(n);
        int countOfFive = (n - 3 * countOfThree) / 5;
        System.out.println(countOfThree + countOfFive);
    }

    private static int dp(int n) {
        if (memo[n] >= 0) {
            return memo[n];
        }
        return memo[n] = Math.min(dp(n - 3) + 1, dp(n - 5));
    }
}
