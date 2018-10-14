/**
 * Date: 2018. 10. 14.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 나머지
 * description: 수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다.
 * 그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/3052
 */

package io.inhyuck.basic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q3052 {
    static final int NUMBER_SIZE = 10;
    static final int DIVISOR = 42;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < NUMBER_SIZE; i++) {
            number = scanner.nextInt();
            set.add(number % DIVISOR);
        }
        System.out.println(set.size());
    }
}
