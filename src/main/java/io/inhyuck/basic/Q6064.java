/**
 * Date: 2018. 10. 18.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 카잉 달력
 * description: 규칙찾아서 문제해결. 링크 참조.
 * Problem URL: https://www.acmicpc.net/problem/6064
 */

package io.inhyuck.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Q6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        String[] temp;
        while (t-- > 0) {
            temp = reader.readLine().split(" ");
            System.out.println(computeCalendar(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]),
                    Integer.parseInt(temp[2]), Integer.parseInt(temp[3])));
        }
    }

    private static int computeCalendar(int m, int n, int x, int y) {
        int yearCount = 0; //몇번째 해
        Calendar nowCalendar = new Calendar(0, 0); //카잉달력으로 계산시 지금 날짜

        //우선 firstYear를 x에 일치 시킴
        nowCalendar.firstYear += x;
        nowCalendar.secondYear += x;
        nowCalendar.secondYear = nowCalendar.secondYear % n == 0 ? n : nowCalendar.secondYear % n;
        yearCount += x;

        //secondYear이 반복되면 해당 날짜는 앞으로도 표현되지 않음.
        Set<Integer> check = new HashSet<>();
        while (true) {
            if(nowCalendar.secondYear == y) {
                return yearCount;
            }
            check.add(nowCalendar.secondYear);
            nowCalendar.secondYear += m;
            nowCalendar.secondYear = nowCalendar.secondYear % n == 0 ? n : nowCalendar.secondYear % n;
            yearCount += m;
            if (check.contains(nowCalendar.secondYear)) {
                break;
            }
        }
        return -1;
    }

    static class Calendar {
        int firstYear;
        int secondYear;

        public Calendar(int firstYear, int secondYear) {
            this.firstYear = firstYear;
            this.secondYear = secondYear;
        }

        @Override
        public String toString() {
            return "Calendar{" +
                    "firstYear=" + firstYear +
                    ", secondYear=" + secondYear +
                    '}';
        }
    }
}
