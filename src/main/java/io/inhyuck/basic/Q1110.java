/**
 * Date: 2018. 10. 18.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 더하기 사이클
 * description: 주어진 규칙에 따라 더하기 사이클을 만들 때 사이클의 길이를 구하는 프로그램
 * Problem URL: https://www.acmicpc.net/problem/1110
 */

package io.inhyuck.basic;

import java.util.Scanner;

public class Q1110 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int count = 0;
        int a = n;
        int b;
        do {
            count++;
            b = a/10 + a%10;
            a = a%10 * 10 + b%10;
        } while(a != n);
        System.out.println(count);
    }
}
