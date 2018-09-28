/**
 * Date: 2018. 9. 10.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 별찍기 - 12
 * Problem: 예제를 보고 별찍는 규칙을 유추한 뒤에 별을 찍어 보세요.
 * URL: https://www.acmicpc.net/problem/2522
 */
package io.inhyuck.io;

import java.util.Scanner;

public class Q2522 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int spaceCount, starCount;
        for (int i = 1; i <= 2 * n - 1; i++) {
            spaceCount = Math.abs(n - i);
            starCount = n - spaceCount;
            for (int j = 0; j < spaceCount; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < starCount; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
