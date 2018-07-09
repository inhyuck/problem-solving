/**
 * Date: 2018. 07. 09.
 * URL: https://www.acmicpc.net/problem/10815
 * Title: 숫자 카드
 * Problem: 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 숫자 M개가 주어졌을 때,
 * 이 숫자가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public class Q10815 {
    public static void main(String[] args) throws IOException {
        Set set = new HashSet<String>();
        StringJoiner joiner = new StringJoiner(" ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());
        String[] numbers = reader.readLine().split(" ");
        for (String s : numbers) {
            set.add(s);
        }
        int m = Integer.valueOf(reader.readLine());
        numbers = reader.readLine().split(" ");
        for (String s : numbers) {
            if (set.contains(s)) {
                joiner.add("1");
                continue;
            }
            joiner.add("0");
        }
        System.out.println(joiner.toString());
    }
}
