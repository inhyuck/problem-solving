/**
 * Date: 2018. 10. 6.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 그룹 단어 체커
 * description: 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/1316
 */

package io.inhyuck.basic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q1316 {
    static int count = 0;
    static Set<Character> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        while (n-- > 0) {
            if (checkGroupWord(scanner.nextLine())) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean checkGroupWord(String word) {
        set.clear();
        char previousChar = word.charAt(0);
        set.add(previousChar);
        char nowChar;
        for (int i = 1; i < word.length(); i++) {
            nowChar = word.charAt(i);
            if (previousChar != nowChar) {
                if (set.contains(nowChar)) {
                    return false;
                }
                set.add(nowChar);
                previousChar = nowChar;
            }
        }
        return true;
    }
}
