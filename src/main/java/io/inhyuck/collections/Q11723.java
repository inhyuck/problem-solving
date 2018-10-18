/**
 * Date: 2018. 10. 18.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 집합
 * description: 비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.
 * add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
 * remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
 * check x: S에 x가 있으면 1을, 없으면 0을 출력한다.
 * toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
 * all: S를 {1, 2, ..., 20} 으로 바꾼다.
 * empty: S를 공집합으로 바꾼다.
 * Problem URL: https://www.acmicpc.net/problem/11723
 */

package io.inhyuck.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        Set<String> set = new HashSet<>();
        String[] setAll = new String[20];
        for (int i = 0; i < 20; i++) {
            setAll[i] = String.valueOf(i + 1);
        }
        String temp[];
        StringBuilder builder = new StringBuilder();
        while (m-- > 0) {
            temp = reader.readLine().split(" ");
            switch (temp[0]) {
                case "add" :
                    set.add(temp[1]);
                    break;
                case "remove" :
                    set.remove(temp[1]);
                    break;
                case "check" :
                    builder.append(set.contains(temp[1]) ? 1 : 0).append("\n");
                    break;
                case "toggle" :
                    if (set.contains(temp[1])) {
                        set.remove(temp[1]);
                        break;
                    }
                    set.add(temp[1]);
                    break;
                case "all" :
                    set = new HashSet<>(Arrays.asList(setAll));
                    break;
                case "empty" :
                    set.clear();
                    break;
            }
        }
        System.out.println(builder);
    }
}
