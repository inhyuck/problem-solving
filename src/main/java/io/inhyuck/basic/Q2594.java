/**
 * Date: 09/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 놀이공원
 * description: 놀이기구 운영 일정이 주어질 때,
 * 그 날 세혁이와 근영이가 함께할 수 있는 가장 긴 시간을 구하는 프로그램을 작성하시오.
 * Solution Key: -
 * Problem URL: https://www.acmicpc.net/problem/2594
 */

package io.inhyuck.basic;

import java.util.Arrays;
import java.util.Scanner;

public class Q2594 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        RunningTime[] runningTimes = new RunningTime[n];
        for (int i = 0; i < n; i++) {
            runningTimes[i] = new RunningTime(scanner.nextInt(), scanner.nextInt());
        }

        Arrays.parallelSort(runningTimes, (x, y) -> x.startTime - y.startTime);
        int nowTime = 600; // 10:00
        int maxTimeSize = 0;
        for (RunningTime runningTime : runningTimes) {
            if (runningTime.startTime >= 1330) { //22:10
                break;
            }
            if (nowTime < runningTime.startTime - 10) {
                maxTimeSize = Math.max(runningTime.startTime - 10 - nowTime, maxTimeSize);
            }
            if (nowTime <= runningTime.endTime) {
                nowTime = runningTime.endTime + 10;
                if (nowTime >= 1320) {
                    break;
                }
            }
        }
        maxTimeSize = Math.max(1320 - nowTime, maxTimeSize);

        System.out.println(maxTimeSize);
    }

    static class RunningTime {
        int startTime;
        int endTime;

        public RunningTime(int startTime, int endTime) {
            this.startTime = (startTime / 100) * 60 + startTime % 100;
            this.endTime = (endTime / 100) * 60 + endTime % 100;
        }

        @Override
        public String toString() {
            return "RunningTime{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }
}
