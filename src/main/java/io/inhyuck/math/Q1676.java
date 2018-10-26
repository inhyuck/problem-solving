/**
 * Date: 2018. 10. 9.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 팩토리얼 0의 개수
 * description: N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/1676
 */

package io.inhyuck.math;

import java.util.Scanner;

public class Q1676 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int countOfFive = 0;
        for (int i = 1; i <= n ; i++) {
            countOfFive += getFive(i);
        }
        System.out.println(countOfFive);
    }

    private static int getFive(int n) {
        if (n % 5 == 0) {
            return getFive(n / 5) + 1;
        }
        return 0;
    }
}
