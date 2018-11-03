/**
 * Date: 03/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 10부제
 * description: 단순 비교 문제
 * Solution Key: -
 * Problem URL: https://www.acmicpc.net/problem/10797
 */

package io.inhyuck.basic;

import java.util.*;

public class Q10797 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lastNumberOfDay = scanner.nextLine();
        String[] lastNumbersOfCar = scanner.nextLine().split(" ");
        System.out.println(Arrays.stream(lastNumbersOfCar)
                .filter(n -> n.equals(lastNumberOfDay))
                .mapToInt(Integer::parseInt)
                .count());
    }
}
