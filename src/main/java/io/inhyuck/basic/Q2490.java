/**
 * Date: 2018. 10. 9.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 윷놀이
 * description: 우리나라 고유의 윷놀이는 네 개의 윷짝을 던져서 배(0)와 등(1)이 나오는
 * 숫자를 세어 도, 개, 걸, 윷, 모를 결정한다. 네 개 윷짝을 던져서 나온 각 윷짝의 배 혹은 등
 * 정보가 주어질 때 도(배 한 개, 등 세 개), 개(배 두 개, 등 두 개), 걸(배 세 개, 등 한 개),
 * 윷(배 네 개), 모(등 네 개) 중 어떤 것인지를 결정하는 프로그램을 작성하라.
 * Problem URL: https://www.acmicpc.net/problem/2490
 */

package io.inhyuck.basic;

import java.util.Arrays;
import java.util.Scanner;

public class Q2490 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfOne;
        for (int i = 0; i < 3; i++) {
            countOfOne = 0;
            for (int j = 0; j < 4; j++) {
                if (scanner.nextInt() == 1) {
                    countOfOne++;
                }
            }
            System.out.println(Type.valueOf(countOfOne).toString());
        }
    }

    enum Type {
        E(4), A(3), B(2), C(1), D(0);

        int countOfOne;

        Type(int  countOfOne) {
            this.countOfOne = countOfOne;
        }

        public static Type valueOf(int countOfOne) {
            return Arrays.stream(Type.values()).filter(type -> type.countOfOne == countOfOne)
                    .findFirst().get();
        }

    }
}
