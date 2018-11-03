/**
 * Date: 03/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 검증수
 * description: 단순 계산
 * Solution Key: -
 * Problem URL: https://www.acmicpc.net/problem/2475
 */

package io.inhyuck.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2475 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            numbers.add(scanner.nextInt());
        }
        System.out.println(numbers.stream().mapToInt(x -> x * x).sum() % 10);
    }
}
