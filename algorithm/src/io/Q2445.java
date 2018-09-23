/**
 * Date: 2018. 9. 10.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 별찍기 - 8
 * Problem: 예제를 보고 별찍는 규칙을 유추한 뒤에 별을 찍어 보세요.
 * URL: https://www.acmicpc.net/problem/
 */
package io;

import java.util.Scanner;
import java.util.Stack;

public class Q2445 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int starCount, spaceCount, builderLength;
        for (int i = 1; i <= 2 * n - 1; i++) {
            if (i <= n) {
                starCount = 2 * i;
                spaceCount = (2 * n) - starCount;
                builder.setLength(0);
                for (int j = 0; j < starCount / 2; j++) {
                    builder.append("*");
                }
                for (int j = 0; j < spaceCount; j++) {
                    builder.append(" ");
                }
                builderLength = builder.length();
                for (int j = 0; j < (2 * n) - builderLength; j++) {
                    builder.append("*");
                }
                builder.append("\n");
                if(i != n) {
                    stack.add(builder.toString());
                }
                System.out.print(builder);
            } else {
                System.out.print(stack.pop());
            }
        }

    }
}
