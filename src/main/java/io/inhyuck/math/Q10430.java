/**
 * Date: 2018. 08. 14.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 나머지
 * Problem:
 * (A+B)%C는 (A%C + B%C)%C 와 같을까?
 * (A×B)%C는 (A%C × B%C)%C 와 같을까?
 * URL: https://www.acmicpc.net/problem/10430
 */
package io.inhyuck.math;

import java.util.*;

public class Q10430 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println((a+b)%c);
        System.out.println( ( (a%c) + (b%c) ) % c);
        System.out.println((a*b)%c);
        System.out.println( ( (a%c) * (b%c) ) % c);
    }
}