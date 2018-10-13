/**
 * Date: 2018. 10. 13.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 달팽이는 올라가고 싶다
 * description: 달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/2869
 */

package io.inhyuck.math;

import java.util.Scanner;

public class Q2869 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int v = scanner.nextInt();

        //낮을 기준으로 n번만큼 a-b를 더해서 v 이상이 되어야 하므로 식을 세우면 a + n(a-b) >= v
        //따라서 n >= (v - a) / (a - b)
        //여기에 처음 낮 날짜를 포함하면 총 n + 1 일이 걸린다

        int oneDayWorking = a - b;
        int n = (int)Math.ceil((double)(v - a) / oneDayWorking);
        System.out.println(n + 1);
    }
}
