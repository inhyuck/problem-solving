/**
 * Date: 2018. 07. 18.
 * URL: https://www.acmicpc.net/problem/2750
 * Title: 수 정렬하기
 * Problem: N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 */

package sort;

import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

//public class Q2750 {
//    public static void main(String[] args) throws IOException{
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(reader.readLine()); //수의 개수
//        int[] numbers = new int[n];
//        for (int i = 0; i < n; i++) {
//            numbers[i] = Integer.parseInt(reader.readLine());
//        }
//
//        Arrays.sort(numbers);
//
//        StringBuilder builder = new StringBuilder();
//        for (int number : numbers) {
//            builder.append(number + "\n");
//        }
//        System.out.println(builder.toString());
//    }
//}

/**
 * TreeSet 이용
 */
public class Q2750 {
    public static void main(String[] args) throws IOException{
        Set<Integer> set = new TreeSet<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine()); //수의 개수
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            set.add(Integer.valueOf(reader.readLine()));
        }

        StringBuilder builder = new StringBuilder();
        for (Integer i : set) {
            builder.append(i + "\n");
        }
        System.out.println(builder.toString());
    }
}