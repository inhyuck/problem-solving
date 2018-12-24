/**
 * Date: 24/12/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 연속합
 * description: 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구한다. 단, 수는 한 개 이상 선택해야 한다.
 * Solution Key: dp
 * Problem URL: https://www.acmicpc.net/problem/1912
 */

package io.inhyuck.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }
//        System.out.printf("n: %d\n%s\n", n, Arrays.toString(numbers)); //Input Log

        int[] memo = new int[n]; //memo[i] => i번째 수를 마지막으로 하는 연속합의 최댓값
        memo[0] = numbers[0];
        for (int i = 1; i < n; i++) {
            //이전 연속합에 현재값을 더한경우와 현재값만 선택한 경우 비교
            memo[i] = Math.max(memo[i - 1] + numbers[i], numbers[i]);
        }
        int maxValue = Arrays.stream(memo).max().getAsInt();

        System.out.println(maxValue);
    }
}
