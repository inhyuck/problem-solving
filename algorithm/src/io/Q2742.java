/**
 * Date: 2018. 9. 11.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 기찍 N
 * Problem: 자연수 N이 주어졌을 때, N부터 1까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/2742
 */
package io;

import java.util.Scanner;

public class Q2742 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        for (int i = n; i >= 1; i--) {
            System.out.println(i);
        }
    }
}
