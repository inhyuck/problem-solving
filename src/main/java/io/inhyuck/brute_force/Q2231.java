/**
 * Date: 2018. 10. 13.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 분해합
 * description: 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오. (링크 참조)
 * Problem URL: https://www.acmicpc.net/problem/2231
 */

package io.inhyuck.brute_force;

import java.util.Scanner;

public class Q2231 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int sum;
        for (int i = 0; i < n; i++) {
            sum = i;
            for (char c : String.valueOf(i).toCharArray()) {
                sum += Character.getNumericValue(c);
            }
            if (sum == n) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
