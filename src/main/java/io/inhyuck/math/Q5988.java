/**
 * Date: 25/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 홀수일까 짝수일까
 * description: 홀수짝수 판별
 * Solution Key: -
 * Problem URL: https://www.acmicpc.net/problem/5988
 */

package io.inhyuck.math;

import java.util.Arrays;
import java.util.Scanner;

public class Q5988 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] numbers = new String[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLine();
        }

        StringBuilder result = new StringBuilder();
        Arrays.stream(numbers).forEach(x -> {
            int lastIndexNumber = Character.getNumericValue(x.charAt(x.length() - 1));
            if (lastIndexNumber % 2 == 0) {
                result.append("even").append("\n");
            } else {
                result.append("odd").append("\n");
            }
        });

        System.out.println(result.toString());
    }
}
