/**
 * Date: 2018. 9. 10.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 별찍기 - 9
 * Problem: 예제를 보고 별찍는 규칙을 유추한 뒤에 별을 찍어 보세요.
 * URL: https://www.acmicpc.net/problem/2446
 */
package io;

import java.util.Scanner;
import java.util.Stack;

public class Q2446 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        Stack<String> stack = new Stack<>();
        int starCount, spaceCount;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <=  n; i++) {
            spaceCount = (i - 1) * 2;
            starCount = (2 * n - 1) - spaceCount;
            builder.setLength(0);
            for (int j = 0; j < spaceCount / 2; j++) {
                builder.append(" ");
            }
            for (int j = 0; j < starCount; j++) {
                builder.append("*");
            }
            if (i != n) {
                stack.add(builder.toString());
            }
            System.out.println(builder);
        }
        for (int i = 0; i < n - 1; i++) {
            System.out.println(stack.pop());
        }
    }
}
