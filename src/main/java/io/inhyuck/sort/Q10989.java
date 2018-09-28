/**
 * Date: 2018. 08. 16.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 수 정렬하기 3
 * Problem: N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/10989
 */
package io.inhyuck.sort;

import java.io.*;

public class Q10989 {
    static final int MAX_NUMBER = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        int[] counts = new int[MAX_NUMBER + 1];
        int number;
        for (int i = 0; i < t; i++) {
            number = Integer.parseInt(reader.readLine());
            counts[number]++;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < MAX_NUMBER + 1; i++) {
            if (counts[i] != 0) {
                for (int j = 0; j < counts[i]; j++) {
                    builder.append(i + "\n");
                }
            }
        }
        System.out.println(builder);
    }
}
