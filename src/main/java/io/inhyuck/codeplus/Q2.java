/**
 * Date: 2018. 10. 3.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 2018 SW 교육 페스티벌 디지털 과거 Code + 문제 2번
 * description: 최댓값이 각각 다른 계수기
 */

package io.inhyuck.codeplus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2 {
    static int[] maxNumbers;
    static int[] resultNumbers;
    static int m;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(reader.readLine().split(" ")[0]);
        maxNumbers = new int[m];
        String[] temps = reader.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            maxNumbers[i] = Integer.parseInt(temps[i]);
        }
        resultNumbers = new int[m];
        temps = reader.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            resultNumbers[i] = Integer.parseInt(temps[i]);
        }

        for (int i = 0; i < m; i++) {
            if (maxNumbers[i] < resultNumbers[i]) {
                System.out.println("-1");
                return;
            }
        }

        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++) {
            plus(m - 1);
        }
        Arrays.stream(resultNumbers).forEach(System.out::print);
    }

    private static void plus(int i) {
//        Arrays.stream(resultNumbers).forEach(System.out::print);
//        System.out.println();
        if (resultNumbers[i] == maxNumbers[i]) {
            resultNumbers[i] = 0;
            if (i != 0) {
                plus(i - 1);
            }
            return;
        }
        resultNumbers[i]++;
    }
}
