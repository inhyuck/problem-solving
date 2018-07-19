/**
 * Date: 2018. 07. 19.
 * URL: https://www.acmicpc.net/problem/10950
 * Title: A+B - 3
 * Problem: 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 */
package io;

import java.io.*;
import java.util.*;

public class Q10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        String[] numbers = new String[2];
        for (int i = 0; i < t; i++) {
            numbers = reader.readLine().split(" ");
            System.out.println(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
        }
    }
}

