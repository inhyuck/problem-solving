/**
 * Date: 18/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 8진수 2진수
 * description: 8진수가 주어졌을 때, 2진수로 변환하는 프로그램을 작성하시오.
 * Solution Key: -
 * Problem URL: https://www.acmicpc.net/problem/1212
 */

package io.inhyuck.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1212 {
    public static void main(String[] args) {
        String octalString = new Scanner(System.in).nextLine();

        List<String> binaryList = new ArrayList<>();
        for (int i = 0; i < octalString.length(); i++) {
            binaryList.add(getBinaryNumber(octalString, i));
        }

        System.out.println(listToString(binaryList));
    }

    /**
     * 8진수 숫자 1개를 2진수 숫자 3개로 변환(앞자리 0포함)
     */
    private static String getBinaryNumber(String octalString, int index) {
        int decimalNumber = Character.getNumericValue(octalString.charAt(index));
        StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(decimalNumber));
        while (binaryString.length() != 3) {
            binaryString.insert(0, "0");
        }
        return binaryString.toString();
    }

    private static String listToString(List<String> list) {
        StringBuilder builder = new StringBuilder();
        list.forEach(x -> builder.append(x));
        while (builder.indexOf("0") == 0 && builder.length() != 1) { //앞자리 0제거
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }
}
