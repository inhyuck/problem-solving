/**
 * Date: 2018. 07. 09.
 * URL: https://www.acmicpc.net/problem/10828
 * Title: 스택
 * Problem: 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 *
 * 명령은 총 다섯 가지이다.
 * push X: 정수 X를 스택에 넣는 연산이다.
 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 스택에 들어있는 정수의 개수를 출력한다.
 * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10828 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(reader.readLine());
        while (num-- > 0) {
            String[] messages = reader.readLine().split(" ");
            switch (messages[0]) {
                case "push":
                    stack.push(Integer.valueOf(messages[1]));
                    break;
                case "pop":
                    if (stack.size() == 0) {
                        System.out.println("-1");
                        break;
                    }
                    System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println((stack.empty() ? "1" : "0"));
                    break;
                case "top":
                    if (stack.size() == 0) {
                        System.out.println("-1");
                        break;
                    }
                    System.out.println(stack.peek());
                    break;
            }
        }
    }
}
