/**
 * Date: 2018. 10. 3.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 음계
 * description: 연주한 순서가 주어졌을 때, 이것이 ascending인지,
 * descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/2920
 */

package io.inhyuck.basic;

import java.util.Scanner;

public class Q2920 {
    static final int COUNT = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputNumber = new int[COUNT];
        for (int i = 0; i < COUNT; i++) {
            inputNumber[i] = scanner.nextInt();
        }

        if (inputNumber[0] > inputNumber[1]) {
            for (int i = 1; i <= inputNumber.length - 2; i++) {
                if (inputNumber[i] < inputNumber[i + 1]) {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("descending");
            return;
        }
        for (int i = 1; i <= inputNumber.length - 2; i++) {
            if (inputNumber[i] > inputNumber[i + 1]) {
                System.out.println("mixed");
                return;
            }
        }
        System.out.println("ascending");
    }
}
