/**
 * Date: 2018. 9. 10.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 별찍기 - 7
 * Problem: 예제를 보고 별찍는 규칙을 유추한 뒤에 별을 찍어 보세요.
 * URL: https://www.acmicpc.net/problem/2444
 */
package io;

import java.util.Scanner;
import java.util.Stack;

public class Q2444 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int starCount, leftSpaceCount;
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n * 2 - 1; i++) {
            if (i <= n) {
                starCount = 2 * i - 1;
                leftSpaceCount = (2 * n - 1 - starCount) / 2;
                builder.setLength(0);
                for (int j = 0; j < leftSpaceCount; j++) {
                    builder.append(" ");
                }
                for (int j = 0; j < starCount; j++) {
                    builder.append("*");
                }
                builder.append("\n");
                if (i != n) {
                    stack.add(builder.toString());
                }
                System.out.print(builder);
            } else {
                System.out.print(stack.pop());
            }

        }

    }
}
