/**
 * Date: 2018. 10. 3.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 2018 SW 교육 페스티벌 디지털 과거 Code + 문제 1번
 * description: 문장에서 날짜 추출해서 정렬하고 다시 출력
 */

package io.inhyuck.codeplus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = new String[3];
        for (int i = 0; i < 3; i++) {
            inputs[i] = reader.readLine();
        }
        int[] date = new int[3];
        String temp;

        for (int i = 0; i < 3; i++) {
            temp = "";
            for (int j = 0; j < inputs[i].length(); j++) {
                if (Character.isDigit(inputs[i].charAt(j))) {
                    temp += inputs[i].charAt(j);
                }
                if (temp.length() == 4 && temp.charAt(0) != '2' && temp.charAt(1) != '0') {
                    temp = "20" + temp;
                }

                if (temp.length() == 6
                        && Integer.parseInt(temp.substring(4, 6)) > 12) {
                    temp = temp.substring(0, 4) + "0" + temp.charAt(4) + temp.charAt(5);
                }
            }
            if (temp.length() == 7) {
                temp = temp.substring(0, 6) + "0" + temp.charAt(6);
            }
            date[i] = Integer.parseInt(temp);
        }

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            map.put(date[i], inputs[i]);
        }
        Arrays.sort(date);
        for (int i = 0; i < 3; i++) {
            System.out.println(map.get(date[i]));
        }


    }
}
