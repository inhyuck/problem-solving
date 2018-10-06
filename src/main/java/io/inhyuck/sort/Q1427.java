/**
 * Date: 2018. 10. 5.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 소트인사이드
 * description: 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
 * Problem URL: https://www.acmicpc.net/problem/1427
 */

package io.inhyuck.sort;

import java.util.Scanner;

public class Q1427 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        int[] countNumber = new int[10];
        for (int i = 0; i < input.length(); i++) {
            countNumber[input.charAt(i) - '0']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < countNumber[i]; j++) {
                builder.append(i);
            }
        }
        System.out.println(builder);
    }
}
