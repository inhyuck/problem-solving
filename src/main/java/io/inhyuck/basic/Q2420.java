/**
 * Date: 2018. 10. 13.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 사파리월드
 * description: 두 서브도메인의 유명도가 주어졌을 때, 그 차이를 구하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/2420
 */

package io.inhyuck.basic;

import java.util.Scanner;

public class Q2420 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(Math.abs(n - m));
    }
}
