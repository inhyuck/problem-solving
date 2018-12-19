/**
 * Date: 19/12/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 진법 변환 2
 * description: 10진법 수 N이 주어진다. 이 수를 B진법으로 바꿔 출력하는 프로그램을 작성하시오.
 * Solution Key: Math
 * Problem URL: https://www.acmicpc.net/problem/11005
 */

package io.inhyuck.math;

import java.util.Scanner;

public class Q11005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int b = scanner.nextInt();

        String result = convert(n, b); //10진수 n을 b진법으로 변환

        System.out.println(result);
    }

    private static String convert(int n, int b) {
        if (n < b) {
            return transfer(n);
        }
        return new StringBuilder(convert(n / b, b)).append(transfer(n % b)).toString();
    }

    //number >= 10 인 경우 알파벳으로 변환
    private static String transfer(int number) {
        if (number >= 10) {
            return String.valueOf((char) (number + 55));
        }
        return String.valueOf(number);
    }
}
