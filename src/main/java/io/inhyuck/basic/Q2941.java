/**
 * Date: 2018. 10. 6.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 크로아티아 알파벳
 * description: 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 * Problem URL: https://www.acmicpc.net/problem/2941
 */

package io.inhyuck.basic;

import java.util.Scanner;

public class Q2941 {
    static int count = 0;
    static String reverseWord;

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder(new Scanner(System.in).nextLine());
        reverseWord = builder.reverse().toString();
        for (int i = 0; i < reverseWord.length(); i++) {
            if (i == reverseWord.length() - 1) {
                count++;
                break;
            }
            countAlphabet(i);
        }
        System.out.println(count);
    }

    private static void countAlphabet(int i) {
        char nowChar = reverseWord.charAt(i);
        switch (nowChar) {
            case '=':
                if (reverseWord.charAt(i + 1) == 'c'
                        || reverseWord.charAt(i + 1) == 's') {
                    return;
                }
                if (reverseWord.charAt(i + 1) == 'z') {
                    if (i < reverseWord.length() - 2 && reverseWord.charAt(i + 2) == 'd') {
                        count--;
                    }
                    return;
                }
            case '-':
                return;
            case 'j':
                if (reverseWord.charAt(i + 1) == 'l'
                        || reverseWord.charAt(i + 1) == 'n') {
                    return;
                }
            default:
                count++;
        }
    }
}
