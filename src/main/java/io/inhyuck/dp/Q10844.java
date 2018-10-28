/**
 * Date: 28/10/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 쉬운 계단 수
 * description: N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구하는 프로그램을 작성하시오. (0으로 시작하는 수는 없다.)
 * Solution Key: memo[a][b] = memo[a-1][b+1] + memo[a-1][b-1]
 * Problem URL: https://www.acmicpc.net/problem/10844
 */

package io.inhyuck.dp;

import java.util.Scanner;

public class Q10844 {
    static long[][] memo; //memo[a][b] => 길이가 a이고 마지막 숫자가 b로 끝나는 계단수의 갯수

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        memo = new long[n + 1][10];
        for (int i = 1; i < 10; i++) { //길이가 1이고 마지막 숫자가 1-9인경우 계단수는 1개로 초기화
            memo[1][i] = 1;
        }
        long result = 0;
        for (int i = 0; i < 10; i++) { //길이가 n인 계단수 => 길이가 n이고 마지막 숫자가 0-9인 계단수의 합
            dp(n, i);
            result += memo[n][i];
        }
        System.out.println(result % 1000000000);
    }

    private static long dp(int length, int lastNumber) {
        if (length == 1 && lastNumber == 0) { //맨 앞 숫자는 0일수 없으므로 return 0
            return 0;
        }
        if(memo[length][lastNumber] > 0) {
            return memo[length][lastNumber];
        }
        if (lastNumber < 9) { //내려가는 계단
            memo[length][lastNumber] += dp(length - 1, lastNumber + 1) % 1000000000;
        }
        if (lastNumber > 0) { //올라가는 계단
            memo[length][lastNumber] += dp(length - 1, lastNumber - 1) % 1000000000;
        }
        return memo[length][lastNumber] % 1000000000;
    }
}
