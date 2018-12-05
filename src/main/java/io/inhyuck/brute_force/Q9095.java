/**
 * Date: 05/12/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 1, 2, 3 더하기
 * description: 주어진 수를 1, 2, 3의 합으로 나타내는 방법의 수
 * Solution Key: N중 for문
 * Problem URL: https://www.acmicpc.net/problem/9095
 */

package io.inhyuck.brute_force;

import java.util.Scanner;

public class Q9095 {
    static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            count = 0;
            int n = scanner.nextInt();
            System.out.println(countCase(n));
        }
    }

    private static int countCase(int n) {
        for (int i = 1; i <= 3; i++) {
            if (n - i == 0) { //마지막 숫자
                count++;
                break;
            }
            if (n - i > 0) {
                countCase(n - i);
            }
        }
        return count;
    }
}
