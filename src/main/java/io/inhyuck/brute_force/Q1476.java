/**
 * Date: 08/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 날짜 계산
 * description: E, S, M이 주어졌고, 1년이 준규가 사는 나라에서 1 1 1일때,
 * 준규가 사는 나라에서 E S M이 우리가 알고 있는 연도로 몇 년인지 구하는 프로그램을 작성하시오.
 * Solution Key: Brute Force
 * Problem URL: https://www.acmicpc.net/problem/1476
 */

package io.inhyuck.brute_force;

import java.util.Scanner;

public class Q1476 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int e = scanner.nextInt();
        int s = scanner.nextInt();
        int m = scanner.nextInt();

        System.out.println(computeDate(e, s, m));
    }

    public static int computeDate(int e, int s, int m) {
        Date today = new Date();
        Date targetDay = new Date(e, s, m);
        int countOfDay = 1;
        while (!today.equals(targetDay)) {
            today.next();
            countOfDay++;
        }
        return countOfDay;
    }

    static class Date {
        static final int MAX_E = 15;
        static final int MAX_S = 28;
        static final int MAX_M = 19;
        int e, s, m;

        public Date() {
            this.e = 1;
            this.s = 1;
            this.m = 1;
        }

        public Date(int e, int s, int m) {
            this.e = e;
            this.s = s;
            this.m = m;
        }

        public void next() {
            e = (e == MAX_E) ? 1 : e + 1;
            s = (s == MAX_S) ? 1 : s + 1;
            m = (m == MAX_M) ? 1 : m + 1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Date)) return false;

            Date date = (Date) o;

            if (e != date.e) return false;
            if (s != date.s) return false;
            return m == date.m;
        }

        @Override
        public int hashCode() {
            int result = e;
            result = 31 * result + s;
            result = 31 * result + m;
            return result;
        }
    }
}
