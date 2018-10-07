/**
 * Date: 2018. 10. 5.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 아스키 코드
 * description: 알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때,
 * 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/11654
 */

package io.inhyuck.basic;

import java.util.Scanner;

public class Q11654 {
    public static void main(String[] args) {
        System.out.println((int)(new Scanner(System.in).nextLine().charAt(0)));
    }
}
