/**
 * Date: 03/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 별찍기 - 6
 * description: 첫째 줄에는 별 2*N-1개, 둘째 줄에는 별 2*N-3개, ..., N번째 줄에는 별 1개를 찍는 문제
 * Solution Key: -
 * Problem URL: https://www.acmicpc.net/problem/2443
 */

package io.inhyuck.basic;

import java.util.Scanner;

public class Q2443 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                resultBuilder.append(" ");
            }
            for (int j = 0; j < (2 * n - 1) - (2 * i); j++) {
                resultBuilder.append("*");
            }
            resultBuilder.append("\n");
        }
        System.out.println(resultBuilder.toString());
    }
}
