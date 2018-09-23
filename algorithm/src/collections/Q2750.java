/**
 * Date: 2018. 07. 09.
 * URL: https://www.acmicpc.net/problem/2750
 * Title: 수 정렬하기
 * Problem: N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 */
package collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Q2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(bufferedReader.readLine());

        TreeSet<Integer> set = new TreeSet<>();
        while (num-- > 0) {
            set.add(Integer.valueOf(bufferedReader.readLine()));
        }
        for (Integer i : set) {
            System.out.println(i);
        }
    }
}
