/**
 * Date: 2018. 07. 30.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 알파벳 찾기
 * Problem: 알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서,
 * 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/10809
 */
package collections;

import java.util.*;

public class Q10809 {
    static final int alphabetSize = 26;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int[] alphabet = new int[alphabetSize];
        for (int i = 0; i < alphabetSize; i++) {
            alphabet[i] = line.indexOf(97 + i);
        }
        for (int i = 0; i < alphabet.length; i++) {
            System.out.print(alphabet[i] + " ");
        }
    }
}