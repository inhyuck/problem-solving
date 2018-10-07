/**
 * Date: 2018. 10. 5.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 다이얼
 * description: 할머니가 외운 단어가 주어졌을 때, 이 전화를 걸기 위해서 필요한 시간을 구하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/5622
 */

package io.inhyuck.basic;

import java.util.Scanner;

public class Q5622 {
    static String word;

    public static void main(String[] args) {
        word = new Scanner(System.in).nextLine();
        int time = 0;
        for (int i = 0; i < word.length(); i++) {
            time += countTime(i);
        }
        System.out.println(time);
    }

    private static int countTime(int i) {
        char c = word.charAt(i);
        switch (c) {
            case 'A': case'B': case 'C':
                return 3;
            case 'D': case'E': case 'F':
                return 4;
            case 'G': case'H': case 'I':
                return 5;
            case 'J': case'K': case 'L':
                return 6;
            case 'M': case'N': case 'O':
                return 7;
            case 'P': case'Q': case 'R': case 'S':
                return 8;
            case 'T': case'U': case 'V':
                return 9;
            default:
                return 10;
        }
    }
}
