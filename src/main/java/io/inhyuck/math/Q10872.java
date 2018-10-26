/**
 * Date: 2018. 10. 9.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 팩토리얼
 * description: 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/10872
 */

package io.inhyuck.math;

import java.util.Scanner;

public class Q10872 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println(result);
    }
}