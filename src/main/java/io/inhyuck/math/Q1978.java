/**
 * Date: 29/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 소수 찾기
 * description: 주어진 수들 중 소수의 개수 출력
 * Solution Key: Math
 * Problem URL: https://www.acmicpc.net/problem/1978
 */

package io.inhyuck.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int count = 0;
        while (tokenizer.hasMoreTokens()) {
            if (isPrimeNumber(Integer.parseInt(tokenizer.nextToken()))) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isPrimeNumber(int number) {
        if (number == 1) {
            return false;
        }

        int middleNumber = (int)Math.sqrt(number);
        for (int i = 2; i <= middleNumber; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
