/**
 * Date: 17/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 2진수 8진수
 * description: 2진수가 주어졌을 때, 8진수로 변환하는 프로그램을 작성하시오.
 * Solution Key: -
 * Problem URL: https://www.acmicpc.net/problem/1373
 */

package io.inhyuck.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1373 {
    public static void main(String[] args) {
        String inputString = new Scanner(System.in).nextLine();

        String binaryString = getBinaryString(inputString);
        List<String> octalList = new ArrayList<>();
        for (int i = 0; i < binaryString.length(); i += 3) {
            octalList.add(getOctalNumber(binaryString, i));
        }

        System.out.println(listToString(octalList));
    }

    /**
     * 이진수 3개를 묶어서 8진수로 변환
     */
    private static String getOctalNumber(String binaryString, int startIndex) {
        int decimalNumber = 0;
        for (int j = 0; j < 3; j++) {
            decimalNumber += Character.getNumericValue(binaryString.charAt(startIndex + j)) * (1 << (2 - j));
        }
        return Integer.toOctalString(decimalNumber);
    }

    /**
     * 8진수로 쉽게 변환하기 위해 자릿수를 3의 배수개로 맞춰준다.
     */
    private static String getBinaryString(String string) {
        StringBuilder builder = new StringBuilder(string);
        while (builder.length() % 3 != 0) {
            builder.insert(0, "0");
        }
        return builder.toString();
    }

    private static String listToString(List<String> list) {
        StringBuilder builder = new StringBuilder();
        list.forEach(x -> builder.append(x));
        return builder.toString();
    }
}
