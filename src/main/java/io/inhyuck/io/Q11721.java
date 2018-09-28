/**
 * Date: 2018. 07. 19.
 * URL: https://www.acmicpc.net/problem/11721
 * Title: 열 개씩 끊어 출력하기
 * Problem: 알파벳 소문자와 대문자로만 이루어진 길이가 N인 단어가 주어진다.
 * 한 줄에 10글자씩 끊어서 출력하는 프로그램을 작성하시오.
 */
package io.inhyuck.io;

import java.io.*;
import java.util.*;

public class Q11721 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        //열개씩 끊어서 출력
        /*int t = word.length() / 10 + 1;
        for (int i = 0; i < t; i++) {
            if (t - 1 == i) { //마지막 단어
                System.out.println(word.substring(i * 10, word.length()));
                return;
            }
            System.out.println(word.substring(i * 10, (i * 10) + 10));
        }*/

        //한글자씩 출력
        for (int i = 1; i < word.length() + 1; i++) {
            System.out.print(word.charAt(i - 1));
            if (i % 10 == 0)
                System.out.println();
        }

    }
}
