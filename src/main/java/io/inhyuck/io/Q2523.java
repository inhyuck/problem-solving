/**
 * Date: 04/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 별찍기 - 13
 * description: 예제를 보고 별찍는 규칙을 유추한 뒤에 별을 찍어 보세요.
 * Solution Key: -
 * Problem URL: https://www.acmicpc.net/problem/2523
 */

package io.inhyuck.io;

import java.util.Scanner;

public class Q2523 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        StringBuilder tempBuilder = new StringBuilder();
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            resultBuilder.append(tempBuilder.append("*")).append("\n");
        }
        for (int i = 0; i < n - 1; i++) {
            resultBuilder.append(tempBuilder.deleteCharAt(0)).append("\n");
        }
        System.out.println(resultBuilder);
    }
}