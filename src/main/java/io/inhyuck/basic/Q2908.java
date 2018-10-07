/**
 * Date: 2018. 10. 5.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 상수
 * description: 두 수가 주어졌을 때, 상수의 대답을 출력하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/2908
 */

package io.inhyuck.basic;

import java.util.Scanner;

public class Q2908 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder a = new StringBuilder(scanner.next());
        StringBuilder b = new StringBuilder(scanner.next());

        if (Integer.parseInt(a.reverse().toString()) > Integer.parseInt(b.reverse().toString())) {
            System.out.println(a);
            return;
        }
        System.out.println(b);
    }
}
