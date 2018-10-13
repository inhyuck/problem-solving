/**
 * Date: 2018. 10. 13.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: Java vs C++
 * description: Java -> C++, C++ -> Java 변수 convention 변환
 * Problem URL: https://www.acmicpc.net/problem/3613
 */

package io.inhyuck.strings;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Q3613 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        StringTokenizer tokenizer;
        StringBuilder builder = new StringBuilder();
        String regexJava = "[a-z]+([A-Z][a-z]*)*";
        String regexC = "[a-z]+([_][a-z]+)*";

        String temp;
        if (input.matches(regexC)) {
            tokenizer = new StringTokenizer(input, "_");
            builder.append(tokenizer.nextToken());
            while (tokenizer.hasMoreTokens()) {
                temp = tokenizer.nextToken();
                builder.append(String.valueOf(temp.substring(0, 1).toUpperCase() + temp.substring(1)));
            }
            System.out.println(builder);
            return;
        } else if (input.matches(regexJava)) {
            for (char c : input.toCharArray()) {
                if (c < 97) {
                    builder.append("_").append((c + "").toLowerCase());
                } else {
                    builder.append(c + "");
                }
            }
            System.out.println(builder);
            return;
        }
        System.out.println("Error!");
    }
}
