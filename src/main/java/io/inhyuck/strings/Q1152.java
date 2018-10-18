/**
 * Date: 2018. 10. 18.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 단어의 개수
 * description: 영어 대소문자와 띄어쓰기만으로 이루어진 문자열이 주어진다.
 * 이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/1152
 */

package io.inhyuck.strings;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1152 {
    public static void main(String[] args) {
        System.out.println(new StringTokenizer(new Scanner(System.in).nextLine()).countTokens());
    }
}
