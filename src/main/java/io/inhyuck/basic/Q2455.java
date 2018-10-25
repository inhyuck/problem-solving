/**
 * Date: 2018. 10. 25.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 지능형 기차
 * description: 역을 지나며 승객이 타고 내린다. 이때 순간 최대 탑승 인원 구하라.
 * Solution Key: -
 * Problem URL: https://www.acmicpc.net/problem/2455
 */

package io.inhyuck.basic;

import java.util.Scanner;

public class Q2455 {
    static final int STATION_NUM = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxCount = 0;
        int nowCount = 0;
        for (int i = 0; i < STATION_NUM; i++) {
            nowCount -= scanner.nextInt();
            if (nowCount < 0) {
                nowCount = 0;
            }
            nowCount += scanner.nextInt();
            if (nowCount > 10000) {
                nowCount = 10000;
            }
            maxCount = Math.max(nowCount, maxCount);
        }
        System.out.println(maxCount);
    }
}
