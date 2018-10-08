/**
 * Date: 2018. 10. 8.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 통계학
 * description:
 * 산술평균 : N개의 수들의 합을 N으로 나눈 값
 * 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
 * 최빈값 : N개의 수들 중 가장 많이 나타나는 값
 * 범위 : N개의 수들 중 최댓값과 최솟값의 차이
 * N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/2108
 */

package io.inhyuck.basic;

import java.util.*;

public class Q2108 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int average = Math.round((float)Arrays.stream(numbers).sum() / n);
        Arrays.sort(numbers);
        int middleNumber = numbers[n / 2];
        int range = numbers[n - 1] - numbers[0];

        int manyNumber = 8001; //최빈값
        int[] countsOfNumber = new int[8001];
        int maxCountOfNumber = 0;
        for (int i = 0; i < n; i++) {
            countsOfNumber[numbers[i] + 4000]++;
            maxCountOfNumber = Math.max(maxCountOfNumber, countsOfNumber[numbers[i] + 4000]);
        }
        for (int i = 0; i < 8001; i++) {
            if (countsOfNumber[i] == maxCountOfNumber) {
                if (manyNumber == 8001) { //최빈값 중 가장 작은 값
                    manyNumber = i;
                    continue;
                }
                manyNumber = i; //최빈값 중 두번째 작은 값
                break;
            }
        }

        System.out.println(average);
        System.out.println(middleNumber);
        System.out.println(manyNumber - 4000);
        System.out.println(range);
    }
}
