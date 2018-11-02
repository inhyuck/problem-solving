/**
 * Date: 02/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 변수명
 * description: 한 표기법을 사용한 변수명이 주어졌을 때, 이를 다른 표기법으로 변환하는 프로그램을 작성하시오.
 * Solution Key: String
 * Problem URL: https://www.acmicpc.net/problem/16205
 */

package io.inhyuck.strings;

import java.util.*;

public class Q16205 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] temp = scanner.nextLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        List<String> words = stringToList(temp[1]);

        System.out.println(toCamel(words));
        System.out.println(toSnake(words));
        System.out.println(toPascal(words));
    }

    private static List<String> stringToList(String string) {
        if (string.contains("_")) {
            return Arrays.asList(string.split("_"));
        }
        List<String> list = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (c < 97) {
                list.add(temp.toString());
                temp.setLength(0);
                c += 32;
            }
            temp.append(c);
        }
        list.add(temp.toString());

        //Pascal인경우 리스트 0번째 인덱스에 삽입된 공백문자열 제거
        if (list.get(0).equals("")) {
            list.remove(0);
        }
        return list;
    }

    private static String toCamel(List<String> words) {
        StringBuilder builder = new StringBuilder();
        builder.append(words.get(0));
        for (int i = 1; i < words.size(); i++) {
            builder.append((char)(words.get(i).charAt(0) - 32));
            builder.append(words.get(i).substring(1));
        }
        return builder.toString();
    }

    private static String toSnake(List<String> words) {
        StringJoiner joiner = new StringJoiner("_");
        words.stream().forEach(s -> joiner.add(s));
        return joiner.toString();
    }

    private static String toPascal(List<String> words) {
        String camelString = toCamel(words);
        return (char)(camelString.charAt(0) - 32) + camelString.substring(1);
    }
}
