/**
 * Date: 2018. 9. 30.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 하노이 탑 이동 순서
 * description: 하노이 탑 이동하는데 필요한 순서를 출력하는 프로그램을 작성
 * Problem URL: https://www.acmicpc.net/problem/11729
 */

package io.inhyuck.divide_conquer;

import java.util.Scanner;

public class Q11729 {
    static int count = 0;
    static StringBuilder route = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        move(1, 3, n); //1번 장대에서 3번 장대로 n부터 1까지의 원판을 이동한다
        System.out.println(count);
        System.out.println(route);
    }

    private static void move(int from, int to, int n) {
        if (n == 0) {
            return;
        }
        move(from, 6 - from - to, n - 1);
        route.append(from + " " + to + "\n");
        count++;
        move(6 - from - to, to, n - 1);
    }
}
