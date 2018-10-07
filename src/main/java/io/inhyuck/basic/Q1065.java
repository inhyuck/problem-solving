/**
 * Date: 2018. 10. 5.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 한수
 * description: 어떤 양의 정수 X의 자리수가 등차수열을 이룬다면, 그 수를 한수라고 한다.
 * 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고,
 * N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/1065
 */

package io.inhyuck.basic;

import java.util.Scanner;

public class Q1065 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 100) {
            System.out.println(n);
            return;
        }
        int count = 99;
        for (int i = 100; i <= n; i++) {
            if (checkNumber(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean checkNumber(int number) {
        String stringNumber = String.valueOf(number);
        int differenceNumber = stringNumber.charAt(0) - stringNumber.charAt(1);
        for (int i = 1; i < stringNumber.length() - 1; i++) {
            if (stringNumber.charAt(i) - stringNumber.charAt(i + 1) != differenceNumber) {
                return false;
            }
        }
        return true;
    }
}
