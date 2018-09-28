/**
 * Date: 2018. 07. 28.
 * URL: https://www.acmicpc.net/problem/10799
 * Title: 쇠막대기
 * Problem: 링크 참고
 */
package io.inhyuck.collections;

import java.util.*;

public class Q10799 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (i == stack.peek() + 1) { //레이저인 경우
                    count += stack.size() - 1;
                } else { //쇠막대기 하나가 끝남
                    count++;
                }
                stack.pop();
            }
        }
        System.out.println(count);
    }
}
