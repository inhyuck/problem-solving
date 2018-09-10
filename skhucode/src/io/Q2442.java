/**
 * Date: 2018. 9. 10.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 별찍기 - 5
 * Problem: 첫째 줄에는 별 1개, 둘째 줄에는 별 3개, ..., N번째 줄에는 별 2*N-1개를 찍는 문제
 * 별은 가운데를 기준으로 대칭이어야 한다.
 * URL: https://www.acmicpc.net/problem/2442
 */
package io;

import java.util.Scanner;

public class Q2442 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        for (int i = 1; i <= n; i++) {
            int startCount = 2 * i - 1;
            int leftSpaceCount = (2 * n - 1 - startCount) / 2;
            for (int j = 0; j < leftSpaceCount; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < startCount; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
