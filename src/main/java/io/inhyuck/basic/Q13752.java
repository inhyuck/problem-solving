/**
 * Date: 25/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 히스토그램
 * description: 숫자 입력받아 히스토그램으로 변환하여 출력
 * Solution Key: -
 * Problem URL: https://www.acmicpc.net/problem/13752
 */

package io.inhyuck.basic;

import java.util.Scanner;

public class Q13752 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(toHistogram(numbers[i])).append("\n");
        }
        
        System.out.println(builder.toString());
    }

    private static String toHistogram(int number) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number; i++) {
            builder.append("=");
        }
        
        return builder.toString();
    }
}
