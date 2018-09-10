/**
 * Date: 2018. 9. 11.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 별찍기 - 17
 * Problem: 예제를 보고 별찍는 규칙을 유추한 뒤에 별을 찍어 보세요.
 * URL: https://www.acmicpc.net/problem/10992
 */
package io;

import java.util.Scanner;

public class Q10992 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int leftSpaceCount, middleSpaceCount;
        for (int i = 1; i < n; i++) {
            leftSpaceCount = n - i;
            middleSpaceCount = 2 * i - 3;
            for (int j = 0; j < leftSpaceCount; j++) {
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < middleSpaceCount; j++) {
                System.out.print(" ");
                if (j == middleSpaceCount - 1) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < 2 * n - 1; i++) {
            System.out.print("*");
        }
    }
}
