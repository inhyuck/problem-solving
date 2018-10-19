/**
 * Date: 2018. 10. 19.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: OX퀴즈
 * description: OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오. 링크 참조.
 * Problem URL: https://www.acmicpc.net/problem/8958
 */

package io.inhyuck.strings;

import java.io.*;

public class Q8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        String input;
        int sum, point;
        while (t-- > 0) {
            sum = 0;
            point = 0;
            input = reader.readLine();
            for (char c : input.toCharArray()) {
                if (c == 'X') {
                    sum += point;
                    point = 0;
                    continue;
                }
                sum += point++;
            }
            sum += point;
            writer.write(sum + "\n");
        }
        writer.flush();
    }
}
