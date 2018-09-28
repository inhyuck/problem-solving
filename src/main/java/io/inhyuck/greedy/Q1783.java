/**
 * Date: 2018. 9. 28.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 병든 나이트
 * Problem: 체스판의 크기가 주어졌을 때, 병든 나이트가 방문할 수 있는 칸의 최대 개수를 출력하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/1783
 * Test Code URL: https://github.com/inhyuck/algorithm/blob/master/src/test/java/io/inhyuck/greedy/Q1783Test.java
 */

package io.inhyuck.greedy;

import java.util.Scanner;

public class Q1783 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(solution(n, m));
    }

    public static int solution(int n, int m) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return Math.min(4, (m + 1) / 2);
        }
        if (m < 7) {
            return Math.min(4, m);
        }
        return m - 2; //m >= 7 인 경우 (1,1), (2,3), (3,1), (5,2) 4칸 + (7,1)을 시작으로 m - 6칸
    }
}
