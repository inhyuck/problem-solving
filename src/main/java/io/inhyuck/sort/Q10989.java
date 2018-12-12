/**
 * Date: 2018. 12. 12.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 수 정렬하기 3
 * Problem: N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/10989
 */
package io.inhyuck.sort;

import java.io.*;

public class Q10989 {
    static final int MAX_NUMBER = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] counts = new int[MAX_NUMBER + 1];
        int number;
        for (int i = 0; i < n; i++) {
            number = Integer.parseInt(reader.readLine());
            counts[number]++;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < MAX_NUMBER + 1; i++) {
            if (counts[i] != 0) {
                for (int j = 0; j < counts[i]; j++) {
                    builder.append(i).append("\n");
                }
            }
        }

        System.out.println(builder.toString());
    }
}
