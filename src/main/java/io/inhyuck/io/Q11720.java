/**
 * Date: 2018. 07. 19.
 * URL: https://www.acmicpc.net/problem/11720
 * Title: 숫자의 합
 * Problem: N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
 */
package io.inhyuck.io;

import java.io.*;
import java.util.*;

public class Q11720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        String line = scanner.next();

        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum += Integer.parseInt(line.charAt(i) + "");
        }
        System.out.println(sum);

    }
}