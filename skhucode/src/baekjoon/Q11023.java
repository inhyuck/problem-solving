/**
 * Date: 2018. 07. 09.
 * URL: https://www.acmicpc.net/problem/11023
 * Title: 더하기 3
 * Problem: 수 N개가 주어졌을 때, N개의 합을 구하는 프로그램을 작성하시오.
 */
package baekjoon;

import java.io.*;

public class Q11023 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = bufferedReader.readLine().split(" ");

        int sum = 0;
        for (String a : numbers) {
            sum += Integer.valueOf(a);
        }
        System.out.println(sum);
    }
}