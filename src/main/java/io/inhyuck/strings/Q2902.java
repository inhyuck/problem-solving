/**
 * Date: 2018. 10. 12.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: KMP는 왜 KMP일까?
 * description: 긴 형태의 알고리즘 이름이 주어졌을 때, 이를 짧은 형태로 바꾸어 출력하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/2902
 */

package io.inhyuck.strings;

import java.util.Scanner;

public class Q2902 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        String regex = "[a-z]+|-";
        System.out.println(input.replaceAll(regex, ""));
    }
}
