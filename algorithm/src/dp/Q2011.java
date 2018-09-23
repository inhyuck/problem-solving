/**
 * Date: 2018. 9. 3.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 암호코드
 * Problem: 어떤 암호가 주어졌을 때, 그 암호의 해석이 몇 가지가 나올 수 있는지 구하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/2011
 */
package dp;

import java.util.Arrays;
import java.util.Scanner;

public class Q2011 {
    static int[] memo;
    static int[] password;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String passwordStr = scanner.next();
        if (passwordStr.length() == 1) { //1자리수 일 때
            if (passwordStr.charAt(0) == '0') {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
            return;
        }
        password = new int[passwordStr.length()];
        for (int i = 0; i < passwordStr.length(); i++) {
            password[i] = Integer.parseInt(passwordStr.charAt(i) + "");
        }
//        System.out.println(Arrays.toString(password));
        memo = new int[password.length];
        memo[0] = 1;
        if (password[1] == 0) {
            if (password[0] == 1 || password[0] == 2) {
                memo[1] = 1;
            }
        } else {
            memo[1] = ((password[0] * 10 + password[1] <= 26 ) && (password[0] * 10 + password[1] >= 10) ? 2 : 1);
        }
        System.out.println(dp(password.length - 1));
    }

    private static int dp(int i) {
        if (memo[i] != 0) {
            return memo[i];
        }
        if (password[i] > 0) {
            memo[i] += dp(i - 1) % 1000000;
        }
        if (password[i-1] * 10 + password[i] >= 10 && password[i-1] * 10 + password[i] <= 26) {
            memo[i] += dp(i - 2) % 1000000;
        }
        return memo[i] % 1000000;
    }
}
