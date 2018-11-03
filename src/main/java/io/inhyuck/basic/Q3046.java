/**
 * Date: 03/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: R2
 * description: 단순계산
 * Solution Key: -
 * Problem URL: https://www.acmicpc.net/problem/3046
 */

package io.inhyuck.basic;

import java.util.Scanner;

public class Q3046 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r1 = scanner.nextInt();
        int s = scanner.nextInt();
        System.out.println((2 * s) - r1);
    }
}
