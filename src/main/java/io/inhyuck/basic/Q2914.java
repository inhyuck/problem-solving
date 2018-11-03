/**
 * Date: 03/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 저작권
 * description: 단순계산
 * Solution Key: -
 * Problem URL: https://www.acmicpc.net/problem/2914
 */

package io.inhyuck.basic;

import java.util.Scanner;

public class Q2914 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSong = scanner.nextInt();
        int average = scanner.nextInt();
        System.out.println(numberOfSong * (average - 1) + 1);
    }
}
