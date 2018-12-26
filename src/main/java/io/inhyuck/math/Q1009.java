/**
 * Date: 26/12/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 분산처리
 * description: 마지막 데이터가 처리될 컴퓨터의 번호 찾기 (링크 참조)
 * Solution Key: math => (A * B) % N == ( (A % N) * (B % N) ) % N
 * Problem URL: https://www.acmicpc.net/problem/1009
 */

package io.inhyuck.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Q1009 {
    static final int COMPUTER_SIZE = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        StringJoiner joiner = new StringJoiner("\n");
        while (t-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            int result = 1;
            for (int i = 0; i < b; i++) {
                result = (result % COMPUTER_SIZE * a % COMPUTER_SIZE) % COMPUTER_SIZE;
            }
            if (result == 0) {
                result = COMPUTER_SIZE;
            }

            joiner.add(String.valueOf(result));
        }

        System.out.println(joiner.toString());
    }
}
