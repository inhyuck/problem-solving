/**
 * Date: 2018. 9. 16.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 회의실배정
 * Problem: 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의들에 대하여 회의실 사용표를 만들려고 한다.
 * 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고,
 * 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 * 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
 * URL: https://www.acmicpc.net/problem/1931
 */
package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q1931 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Session[] sessions = new Session[n];
        for (int i = 0; i < n; i++) {
            sessions[i] = new Session(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.parallelSort(sessions, new Comparator<Session>() {
            @Override
            public int compare(Session o1, Session o2) {
                int r = o1.endTime - o2.endTime;
                if (r != 0) return r;
                return o1.startTime - o2.startTime;
            }
        });
//        System.out.println(Arrays.toString(sessions));
        Session session = sessions[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (sessions[i].startTime >= session.endTime) {
                session = sessions[i];
                count++;
            }
        }
        System.out.println(count);
    }

    static class Session {
        int startTime;
        int endTime;

        public Session(int startTime, int enTIme) {
            this.startTime = startTime;
            this.endTime = enTIme;
        }

        @Override
        public String toString() {
            return "Session{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }
}
