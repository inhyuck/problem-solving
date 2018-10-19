/**
 * Date: 2018. 10. 18.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 방 번호
 * description:  한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다. 다솜이의 방 번호가 주어졌을 때,
 * 필요한 세트의 개수의 최솟값을 출력하시오. (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)
 * Problem URL: https://www.acmicpc.net/problem/1475
 */

package io.inhyuck.basic;

import java.util.Scanner;

public class Q1475 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        int[] numberCount = new int[10];
        for (char c : input.toCharArray()) {
            numberCount[Character.getNumericValue(c)]++;
        }

        int maxCountExceptSixAndNine = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) {
                continue;
            }
            maxCountExceptSixAndNine = Math.max(maxCountExceptSixAndNine, numberCount[i]);
        }
        int countOfMiddleSixAndNine = (int)Math.ceil((numberCount[6] + numberCount[9]) / 2.0);

        System.out.println(Math.max(maxCountExceptSixAndNine, countOfMiddleSixAndNine));
    }
}
