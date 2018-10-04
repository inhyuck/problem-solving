/**
 * Date: 2018. 10. 3.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 스택 수열
 * description: 스택으로 수열 만들기 (링크 참조)
 * Problem URL: https://www.acmicpc.net/problem/1874
 */

package io.inhyuck.collections;

import java.io.*;
import java.util.Stack;

public class Q1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] numberList = new int[n];
        for (int i = 0; i < n; i++) {
            numberList[i] = Integer.parseInt(reader.readLine());
        }
        StringBuilder builder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int number, k = 0;
        for (int i = 0; i < n; i++) {
            number = numberList[i];
            if (k < number) {
                for (int j = k + 1; j <= number; j++) {
                    stack.push(j);
                    builder.append("+\n");
                    k = j;
                }
            }
            if (number != stack.pop()) {
                System.out.println("NO");
                return;
            }
            builder.append("-\n");
        }
        System.out.println(builder);
    }
}
