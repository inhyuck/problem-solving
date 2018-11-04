/**
 * Date: 04/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 피보나치 수 5
 * description: n번째 피보나치 수를 구하는 프로그램 작성
 * Solution Key: dp
 * Problem URL: https://www.acmicpc.net/problem/10870
 */

package io.inhyuck.dp;

import java.util.Scanner;

public class Q10870 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int[] fiboNumbers = new int[n + 1];
        fiboNumbers[0] = 0;
        if (n > 0) {
            fiboNumbers[1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            fiboNumbers[i] = fiboNumbers[i - 1] + fiboNumbers[i - 2];
        }
        System.out.println(fiboNumbers[n]);
    }
}
