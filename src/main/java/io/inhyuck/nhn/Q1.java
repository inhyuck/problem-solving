/**
 * Date: 2018. 9. 28.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 2018 하반기 기술부문 신입공채 Pre-Test 1차 문제 Q1 카드 섞기
 */

package io.inhyuck.nhn;

import java.util.Scanner;
import java.util.Stack;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int p = scanner.nextInt();
        int n;
        Stack<Integer> mainStack = new Stack<>();
        for (int i = c; i > 0; i--) {
            mainStack.push(i);
        }
        Stack<Integer> temp1 = new Stack<>();
        Stack<Integer> temp2 = new Stack<>();

        while (p-- > 0) {
            n = scanner.nextInt();
            game(c, n, mainStack, temp1, temp2);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(mainStack.pop());
        }
    }

    private static void game(int c, int n, Stack<Integer> mainStack, Stack<Integer> temp1, Stack<Integer> temp2) {
        for (int i = 0; i < n; i++) {
            temp1.push(mainStack.pop());
        }
        for (int i = 0; i < c - 2 * n; i++) {
            temp2.push(mainStack.pop());
        }
        for (int i = 0; i < n; i++) {
            mainStack.push(temp1.pop());
        }
        for (int i = 0; i < c - 2 * n; i++) {
            mainStack.push(temp2.pop());
        }
        if (c > 4 * n) {
            game(c - 2 * n, n, mainStack, temp1, temp2);
        }
    }
}
