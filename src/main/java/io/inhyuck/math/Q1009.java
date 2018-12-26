/**
 * Date: 26/12/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title:
 * description:
 * Solution Key:
 * Problem URL: https://www.acmicpc.net/problem/
 * Test Code URL: htpps://github.com/inhyuck/algorithm/blob/master/src/test/java/io/inhyuck/pakageName/Q1009Test.java
 */

package io.inhyuck.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            long result = a % 10;
            for (int i = 1; i < b; i++) {
                result = (result * (a % 10)) % 10;
            }
            System.out.println(result % 10);
        }
    }
}
