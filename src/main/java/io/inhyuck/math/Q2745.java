/**
 * Date: 20/12/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 진법 변환
 * description: B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.
 * Solution Key: Math
 * Problem URL: https://www.acmicpc.net/problem/2745
 */

package io.inhyuck.math;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q2745 {
    public static void main(String[] args) {
        StringTokenizer tokenizer = new StringTokenizer(new Scanner(System.in).nextLine());
        String n = tokenizer.nextToken();
        int b = Integer.parseInt(tokenizer.nextToken());

        String reverseN = new StringBuilder(n).reverse().toString();
        int result = 0;
        for (int i = 0; i < reverseN.length(); i++) {
            int number = transfer(reverseN.charAt(i));
            result += (Math.pow(b, i) * number);
        }

        System.out.println(result);
    }

    private static int transfer(char c) {
        if (Character.isAlphabetic(c)) {
            return c - 55;
        }
        return Character.getNumericValue(c);
    }
}
