/**
 * Date: 2018. 10. 23.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 대소문자 바꾸기
 * description: 대문자는 소문자로, 소문자는 대문자로 바꾸는 문제
 * Problem URL: https://www.acmicpc.net/problem/2744
 */

package io.inhyuck.basic;

import java.util.Scanner;

public class Q2744 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        StringBuilder builder = new StringBuilder();
        char temp;
        for (int i = 0; i < input.length(); i++) {
            temp = input.charAt(i);
            if (temp < 97) {
                builder.append(String.valueOf((char)(temp + 32)));
            } else {
                builder.append(String.valueOf((char)(temp - 32)));
            }
        }
        System.out.println(builder);
    }
}
