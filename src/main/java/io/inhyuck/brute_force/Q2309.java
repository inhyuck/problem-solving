/**
 * Date: 2018. 10. 12.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 일곱 난쟁이
 * description: 아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/2309
 */

package io.inhyuck.brute_force;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Q2309 {
    static final int PEOPLE_COUNT = 9;
    static int[] heights;

    public static void main(String[] args) {
        heights = new int[PEOPLE_COUNT];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < PEOPLE_COUNT; i++) {
            heights[i] = scanner.nextInt();
        }
        List<Integer> realPeople = Arrays.stream(heights).sorted().boxed().collect(Collectors.toList());
        for (int i = 0; i < PEOPLE_COUNT; i++) {
            for (int j = i + 1; j < PEOPLE_COUNT; j++) {
                if (checkSum(i, j)) {
                    realPeople.remove(Integer.valueOf(heights[i]));
                    realPeople.remove(Integer.valueOf(heights[j]));
                    realPeople.forEach(System.out::println);
                    return;
                }
            }
        }
    }

    private static boolean checkSum(int i, int j) { //i번째 원소와 j번째 원소를 제외했을 때 키의 합이 100인지 확인
        int sum = 0;
        for (int k = 0; k < PEOPLE_COUNT; k++) {
            if (k != i && k != j) {
                sum += heights[k];
            }
        }
        return sum == 100;
    }
}
