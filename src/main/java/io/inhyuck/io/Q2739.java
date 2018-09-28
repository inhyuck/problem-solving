/**
 * Date: 2018. 9. 11.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 구구단
 * Problem: N을 입력받은 뒤, 구구단 N단을 출력하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/2739
 */
package io.inhyuck.io;

import java.util.Scanner;

public class Q2739 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        for (int i = 1; i <= 9; i++) {
            System.out.println(n + " * " + i + " = " + n * i);
        }
    }
}
