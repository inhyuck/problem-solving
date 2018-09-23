/**
 * Date: 2018. 9. 17.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 잃어버린 괄호
 * Problem: 세준이는 양수와 +, -, 그리고 괄호를 가지고 길이가 최대 50인 식을 만들었다.
 * 그리고 나서 세준이는 괄호를 모두 지웠다.
 * 그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만드려고 한다.
 * 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/1541
 */
package greedy;

import java.util.Scanner;

public class Q1541 {
    static int result;

    public static void main(String[] args) {
        String sentence = new Scanner(System.in).nextLine();
        int index = plus(sentence);
        if (index != sentence.length()) {
            minum(sentence, index);
        }
        System.out.println(result);
}

    private static void minum(String sentence, int index) {
        String temp = "";
        for (int i = index + 1; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if ( c == 45 || c == 43 ) {
                result -= Integer.parseInt(temp);
                temp = "";
            } else {
                temp += c;
            }
        }
        result -= Integer.parseInt(temp);
    }

    private static int plus(String sentence) {
        String temp = "";
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if ( c == 45 ) {
                result += Integer.parseInt(temp);
                return i;
            } else if ( c == 43 ) {
                result += Integer.parseInt(temp);
                temp = "";
            } else {
                temp += c;
            }
        }
        result += Integer.parseInt(temp);
        return sentence.length();
    }
}
