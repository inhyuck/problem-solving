/**
 * Date: 2018. 10. 19.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: X보다 작은 수
 * description: 정수 N개로 이루어진 수열 A와 정수 X가 주어진다.
 * 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/10871
 */

package io.inhyuck.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Q10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int x = Integer.parseInt(tokenizer.nextToken());

        StringJoiner joiner = new StringJoiner(" ");
        tokenizer = new StringTokenizer(reader.readLine());
        int temp;
        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(tokenizer.nextToken());
            if (temp < x) {
                joiner.add(String.valueOf(temp));
            }
        }
        System.out.println(joiner);
    }
}
