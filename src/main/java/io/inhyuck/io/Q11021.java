/**
 * Date: 2018. 07. 19.
 * URL: https://www.acmicpc.net/problem/11021
 * Title: A+B - 7
 * Problem: 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 */
package io.inhyuck.io;

import java.io.*;
import java.util.*;

public class Q11021 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        String[] numbers = new String[2];
        for (int i = 0; i < t; i++) {
            numbers = reader.readLine().split(" ");
            System.out.println("Case #" + (i+1) + ": " +
                    (Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1])));
        }
    }
}

