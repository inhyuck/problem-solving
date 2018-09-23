/**
 * Date: 2018. 9. 11.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 2007년
 * Problem: 오늘은 2007년 1월 1일 월요일이다.
 * 그렇다면 2007년 x월 y일은 무슨 요일일까? 이를 알아내는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/1924
 */
package io;

import java.util.Scanner;

public class Q1924 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int dayCount = 0;
        int[] monthCount = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfWeek = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        for (int i = 1; i < x; i++) {
            dayCount += monthCount[i];
        }
        dayCount += y - 1;
        System.out.println(dayOfWeek[dayCount % 7]);
    }
}
