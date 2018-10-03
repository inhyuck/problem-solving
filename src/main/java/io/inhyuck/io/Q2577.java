/**
 * Date: 2018. 10. 2.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 숫자의 개수
 * description: 세 개의 자연수 A, B, C가 주어질 때
 * A×B×C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/2577
 */

package io.inhyuck.io;

import java.util.Scanner;

public class Q2577 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = Integer.toString(scanner.nextInt() * scanner.nextInt() * scanner.nextInt());
        int[] countArray = new int[10];

        for (int j = 0; j < result.length(); j++) {
            countArray[Character.getNumericValue(result.charAt(j))]++;
        }
        for (int i = 0; i <= 9; i++) {
            System.out.println(countArray[i]);
        }
    }
}
