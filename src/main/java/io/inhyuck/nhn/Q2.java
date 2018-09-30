/**
 * Date: 2018. 9. 29.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 2018 하반기 기술부문 신입공채 Pre-Test 1차 문제 Q2 전광판 광고
 */

package io.inhyuck.nhn;

import java.util.*;
import java.util.stream.Collectors;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        boolean direction = (w > 0 ? true : false); //시계방향이면 true
        w = Math.abs(w);
        String[][] names = new String[n][n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                names[i][j] = scanner.next();
            }
        }
//        System.out.println(Arrays.deepToString(names) + " w : " + w);
        int rotation = w, rowLength;
        List<String> list;
        for (int i = 0; i < n / 2; i++) {
            list = new ArrayList<>();
            rowLength = n - i;
            int temp = 4 * (rowLength - 1);
            while (rotation >= temp) {
                rotation -= temp;
            }
            for (int j = i; j < n - i; j++) {
                list.add(names[i][j]);
            }
            for (int j = i + 1; j < n - 1 - i; j++) {
                list.add(names[j][n - 1 - i]);
            }
            for (int j = n - 1 - i; j >= i; j--) {
                list.add(names[n - 1 - i][j]);
            }
            for (int j = n - 2 - i; j > i; j--) {
                list.add(names[j][i]);
            }
//            System.out.println(list + " " + rotation);
            int index = 0;
            if (direction) {
                index = index - rotation;
                index = (index < 0 ? index + list.size() : index);
            } else {
                index += rotation;
            }
//            System.out.println("index: " + index);
            for (int j = i; j < n - i; j++) {
                names[i][j] = list.get(index % list.size());
                index++;
            }
            for (int j = i + 1; j < n - 1 - i; j++) {
                names[j][n - 1 - i] = list.get(index % list.size());
                index++;
            }
            for (int j = n - 1 - i; j >= i; j--) {
                names[n - 1 - i][j] = list.get(index % list.size());
                index++;
            }
            for (int j = n - 2 - i; j > i; j--) {
                names[j][i] = list.get(index % list.size());
                index++;
            }
            direction = !direction;
        }

//        System.out.println(Arrays.deepToString(names) + " w : " + w);

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.stream(names[i]).collect(Collectors.joining(" ")));
        }
    }
}
