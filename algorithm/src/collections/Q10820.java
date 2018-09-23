/**
 * Date: 2018. 07. 30.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 문자열 분석
 * Problem: 문자열 N개가 주어진다.
 * 이 때, 문자열에 포함되어 있는 소문자, 대문자, 숫자, 공백의 개수를 구하는 프로그램을 작성하시오.
 * 각 문자열은 알파벳 소문자, 대문자, 숫자, 공백으로만 이루어져 있다.
 * URL: https://www.acmicpc.net/problem/10820
 */
package collections;

import java.util.*;

public class Q10820 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        int[] counts;
        while (scanner.hasNext()) {
            counts = new int[4];
            line = scanner.nextLine();
            for (char c : line.toCharArray()) {
                if ( c < 48 ) { //space
                    counts[3]++;
                    continue;
                }
                if ( c < 65 ) { //숫자
                    counts[2]++;
                    continue;
                }
                if ( c < 97 ) { //대문자
                    counts[1]++;
                    continue;
                }
                counts[0]++; //소문자
            }

            for (int i = 0; i < 4; i++) {
                System.out.print(counts[i] + " ");
            }
            System.out.println();
        }
    }
}