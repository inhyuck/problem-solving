/**
 * Date: 2018. 07. 30.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 알파벳 개수
 * Problem: 알파벳 소문자로만 이루어진 단어 S가 주어진다.
 * 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/10808
 */
package collections;

import java.util.*;

public class Q10808 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] alphabet = new int[26];
        for (int i = 0; i < line.length(); i++) {
            alphabet[line.charAt(i) - 97]++;
        }
        for (int i = 0; i < alphabet.length; i++) {
            System.out.print(alphabet[i] + " ");
        }
    }
}