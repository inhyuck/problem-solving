/**
 * Date: 2018. 9. 27.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 30
 * Problem: 어느날, 미르코는 우연히 길거리에서 양수 N을 보았다. 미르코는 30이란 수를 존경하기 때문에,
 * 그는 길거리에서 찾은 수에 포함된 숫자들을 섞어 30의 배수가 되는 가장 큰 수를 만들고 싶어한다.
 * 미르코를 도와 그가 만들고 싶어하는 수를 계산하는 프로그램을 작성하라.
 * URL: https://www.acmicpc.net/problem/10610
 */
package io.inhyuck.greedy;

import java.util.*;
import java.util.stream.Collectors;

public class Q10610 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringNumbers = scanner.nextLine();
        int[] numbers = new int[stringNumbers.length()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(String.valueOf(stringNumbers.charAt(i)));
        }

        List<Integer> numberList = Arrays.stream(numbers).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        if ( !numberList.contains(0)
                || (numberList.stream().mapToInt(Integer::intValue)).sum() % 3 != 0 ) {
            System.out.println("-1");
            return;
        }
        numberList.stream().forEach(System.out::print);
    }
}
