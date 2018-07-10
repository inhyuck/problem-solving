/**
 * Date: 2018. 07. 09.
 * URL: https://www.acmicpc.net/problem/1764
 * Title: 듣보잡
 * Problem: 김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때,
 * 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.
 */
package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Q1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new TreeMap<>();
        StringBuilder builder = new StringBuilder();
        int count = 0;

        String[] numbers = reader.readLine().split(" ");
        int n = Integer.valueOf(numbers[0]);
        int m = Integer.valueOf(numbers[1]);
        String temp;
        while (n-- > 0) {
            map.put(reader.readLine(), 1);
        }
        while (m-- > 0) {
            temp = reader.readLine();
            if(map.get(temp) != null)
                map.put(temp, 2);
        }
        for (String s : map.keySet()) {
            if (map.get(s) == 2) {
                builder.append(s + "\n");
                count++;
            }
        }

        System.out.println(count);
        System.out.println(builder.toString());
    }
}