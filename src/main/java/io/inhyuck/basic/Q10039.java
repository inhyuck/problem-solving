/**
 * Date: 2018. 10. 3.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 평균 점수
 * description: 학생 5명의 점수가 주어졌을 때, 평균 점수를 구하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/10039
 */

package io.inhyuck.basic;

import java.util.Arrays;
import java.util.Scanner;

public class Q10039 {
    static final int STUDENT_SIZE = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] points = new int[STUDENT_SIZE];
        for (int i = 0; i < STUDENT_SIZE; i++) {
            points[i] = scanner.nextInt();
        }

        System.out.println((int)Arrays.stream(points).map(x -> {
            if (x < 40) {
                return 40;
            }
            return x;
        }).average().getAsDouble());
    }
}
