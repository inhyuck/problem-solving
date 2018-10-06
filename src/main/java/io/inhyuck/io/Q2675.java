/**
 * Date: 2018. 10. 5.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 문자열 반복
 * description: 입력 받고 반복문자열 출력
 * Problem URL: https://www.acmicpc.net/problem/2675
 */

package io.inhyuck.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Q2675 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = scanner.nextInt();
        int repeatNumber;
        String input;
        while (t-- > 0) {
            repeatNumber = scanner.nextInt();
            input = scanner.nextLine().trim();
            for (int i = 0; i < input.length(); i++) {
                for (int j = 0; j < repeatNumber; j++) {
                    writer.write(input.charAt(i));
                }
            }
            writer.write("\n");
        }
        writer.flush();
    }
}
