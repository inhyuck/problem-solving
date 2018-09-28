/**
 * Date: 2018. 9. 17.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 수 묶기
 * Problem: 링크 참조
 * URL: https://www.acmicpc.net/problem/1744
 */
package io.inhyuck.greedy;

import java.util.*;

public class Q1744 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Queue<Integer> positiveNumber = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> negativeNumber = new PriorityQueue<>();
        int temp, result = 0;
        for (int i = 0; i < n; i++) {
            temp = scanner.nextInt();
            if (temp == 1) {
                result += 1;
            } else if (temp <= 0) {
                negativeNumber.add(temp);
            } else if (temp > 1) {
                positiveNumber.add(temp);
            }
        }

//        System.out.println(positiveNumber.toString());
//        System.out.println(negativeNumber.toString());

        int sizeOfNegetiveNumber = negativeNumber.size();
        int sizeOfPositiveNumber = positiveNumber.size();

        for (int i = 0; i < sizeOfNegetiveNumber / 2; i++) {
            result += negativeNumber.poll() * negativeNumber.poll();
        }
        if (!negativeNumber.isEmpty()) {
            result += negativeNumber.poll();
        }

        for (int i = 0; i < sizeOfPositiveNumber / 2; i++) {
            result += positiveNumber.poll() * positiveNumber.poll();
        }
        if (!positiveNumber.isEmpty()) {
            result += positiveNumber.poll();
        }
        System.out.println(result);
    }
}
