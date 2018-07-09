/**
 * Date: 2018. 07. 09.
 * URL: https://www.acmicpc.net/problem/1076
 * Title: 저항
 * Problem: 전자 제품에는 저항이 들어간다. 저항은 색 3개를 이용해서 그 저항이 몇 옴인지 나타낸다.
 * 처음 색 2개는 저항의 값이고, 마지막 색은 곱해야 하는 값이다.
 * 저항의 값은 다음 표를 이용해서 구한다.
 * 색	    값	곱
 * black	0	1
 * brown	1	10
 * red  	2	100
 * orange	3	1000
 * yellow	4	10000
 * green	5	100000
 * blue 	6	1000000
 * violet	7	10000000
 * grey	    8	100000000
 * white	9	1000000000
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        /*Map<String, Integer> map = new HashMap<>();

        map.put("black", 0);
        map.put("brown", 1);
        map.put("red", 2);
        map.put("orange", 3);
        map.put("yellow", 4);
        map.put("green", 5);
        map.put("blue", 6);
        map.put("violet", 7);
        map.put("grey", 8);
        map.put("white", 9);

        String one = map.get(reader.readLine()).toString();
        String two = map.get(reader.readLine()).toString();
        int three = map.get(reader.readLine());
        String result = one + two;
        while (three-- > 0) {
            result += "0";
        }
        System.out.println(result);
        */

        Map<String, Integer[]> map = new HashMap<>();

        map.put("black", new Integer[] {0, 1});
        map.put("brown", new Integer[] {1, 10});
        map.put("red", new Integer[] {2, 100});
        map.put("orange", new Integer[] {3, 1000});
        map.put("yellow", new Integer[] {4, 10000});
        map.put("green", new Integer[] {5, 100000});
        map.put("blue", new Integer[] {6, 1000000});
        map.put("violet", new Integer[] {7, 10000000});
        map.put("grey", new Integer[] {8, 100000000});
        map.put("white", new Integer[] {9, 1000000000});

        String one = map.get(reader.readLine())[0].toString();
        String two = map.get(reader.readLine())[0].toString();
        int result = Integer.valueOf(one + two);
        int i = Integer.valueOf(map.get(reader.readLine())[1].toString());
        System.out.println(result * i);

    }
}