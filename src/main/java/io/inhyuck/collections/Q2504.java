/**
 * Date: 2018. 10. 3.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 괄호의 값
 * description: 주어진 괄호열을 읽고 그 괄호값을 앞에서 정의한대로 계산하여 출력 (링크참조)
 * Problem URL: https://www.acmicpc.net/problem/2504
 */

/**
 * 논리를 제대로 세울 수 없음 ㅠㅠ 쉽지 않다 ㅠ 다시 풀어 볼 것!
 */

package io.inhyuck.collections;

import java.util.*;

public class Q2504 {
    static String input;
    static Stack<Character> stack;
    static boolean[] check;

    public static void main(String[] args) {
        input = new Scanner(System.in).nextLine();
        stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            result += calculate(i);
        }
        System.out.println(result > 0 ? result : 0);
    }

    private static int calculate(int i) {
        if (check[i] == true) {
            return 0;
        }
        check[i] = true;
        int temp = 0;
        do {
            switch (input.charAt(i)) {
                case '(' :
                    stack.push('(');
                    temp += calculate(i + 1) * 2;
                    break;
                case '[' :
                    stack.push('[');
                    temp += calculate(i + 1) * 3;
                    break;
                case ')' :
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return Integer.MIN_VALUE;
                    }

                    break;

                case ']' :
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return Integer.MIN_VALUE;
                    }
                    break;
            }
        } while (!stack.isEmpty());
        return result;
    }
}
