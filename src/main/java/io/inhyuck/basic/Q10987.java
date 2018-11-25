/**
 * Date: 25/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 모음의 개수
 * description: 단어가 주어지고 모음의 개수 출력하는 문제
 * Solution Key: -
 * Problem URL: https://www.acmicpc.net/problem/10987
 */

package io.inhyuck.basic;

import java.util.Scanner;

public class Q10987 {
    public static void main(String[] args) {
        String word = new Scanner(System.in).nextLine();

        int count = 0;
        for (char c : word.toCharArray()) {
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    count++;
            }
        }

        System.out.println(count);
    }
}
