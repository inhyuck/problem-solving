/**
 * Date: 2018. 9. 11.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 최소, 최대
 * Problem: N개의 정수가 주어진다. 이 때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/10818
 */
package io;

import java.util.Scanner;

public class Q10818 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num;
        int maxNum = -1000000, minNum = 1000000;
        for (int i = 0; i < n; i++) {
            num = scanner.nextInt();
            if (num > maxNum) {
                maxNum = num;
            }
            if( num < minNum) {
                minNum = num;
            }
        }
        System.out.printf("%d %d", minNum, maxNum);
    }
}