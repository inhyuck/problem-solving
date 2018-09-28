/**
 * Date: 2018. 08. 16.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 카드
 * Problem: 준규는 숫자 카드 N장을 가지고 있다.
 * 숫자 카드에는 정수가 하나 적혀있는데, 적혀있는 수는 -262보다 크거나 같고, 262보다 작거나 같다.
 * 준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오.
 * 만약, 가장 많이 가지고 있는 정수가 여러가지라면, 작은 것을 출력한다.
 * URL: https://www.acmicpc.net/problem/11652
 */
package io.inhyuck.sort;

import java.io.*;
import java.util.Arrays;

public class Q11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        long[] numbers = new long[t];
        for (int i = 0; i < t; i++) {
            numbers[i] = Long.parseLong(reader.readLine());
        }
        Arrays.sort(numbers);
        int count = 1;
        int maxCount = 1;
        Long largeSizeNumber = numbers[0];
        for (int i = 1; i < t; i++) {
            if (numbers[i - 1] == numbers[i]) {
                count++;
                continue;
            }
            if (maxCount < count) {
                maxCount = count;
                largeSizeNumber = numbers[i - 1];
            }
            count = 1;
        }
        //마지막 카드가 가장 많이 있는 카드였을 경우
        if (maxCount < count) {
            maxCount = count;
            largeSizeNumber = numbers[numbers.length - 1];
        }

        System.out.println(largeSizeNumber);
    }
}
