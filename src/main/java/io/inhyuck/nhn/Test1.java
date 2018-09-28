/**
 * Date: 2018. 9. 28.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 2018 하반기 기술부문 신입공채 Pre-Test 1차 모의문제 1
 */

package io.inhyuck.nhn;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        String[] list = new Scanner(System.in).nextLine().split(" ");
        List<Integer> pocket = new ArrayList<>();
        StringJoiner result = new StringJoiner("\n");
        int item;

        for (String temp : list) {
            item = Integer.parseInt(temp);
            if (pocket.size() < 3) {
                pocket.add(item);
                continue;
            }
            if (pocket.contains(item)) {
               pocket.remove(Integer.valueOf(item));
               pocket.add(item);
            } else {
                result.add(String.valueOf(pocket.remove(0)));
                pocket.add(item);
            }
        }
        System.out.println((result.length() == 0 ? 0 : result.toString()));
    }
}
