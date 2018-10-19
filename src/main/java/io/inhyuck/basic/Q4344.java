/**
 * Date: 2018. 10. 19.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 평균은 넘겠지
 * description: 대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
 * Problem URL: https://www.acmicpc.net/problem/4344
 */

package io.inhyuck.basic;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;
        int n;
        int[] numbers;
        long countOfWinnerStudent;
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            n = Integer.parseInt(tokenizer.nextToken());
            numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(tokenizer.nextToken());
            }
            double average = Arrays.stream(numbers).average().getAsDouble();
            countOfWinnerStudent = Arrays.stream(numbers).filter(x -> x > average).count();
            writer.write(String.format("%.3f%%\n",  countOfWinnerStudent * 100.0 / n));
        }
        writer.flush();
    }
}
