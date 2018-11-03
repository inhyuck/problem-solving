/**
 * Date: 03/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 0 = not cute / 1 = cute
 * description: 설문조사 결과를 입력받아 결과 출력
 * Solution Key: -
 * Problem URL: https://www.acmicpc.net/problem/10886
 */

package io.inhyuck.basic;

import java.util.Scanner;

public class Q10886 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cuteCount = 0;
        for (int i = 0; i < n; i++) {
            cuteCount += scanner.nextInt();
        }
        if (cuteCount > n - cuteCount) {
            System.out.println("Junhee is cute!");
            return;
        }
        System.out.println("Junhee is not cute!");
    }
}
