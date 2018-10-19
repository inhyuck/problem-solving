/**
 * Date: 2018. 10. 18.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 부녀회장이 될테야
 * description: 규칙찾아서 해결하기. 링크 참조
 * Problem URL: https://www.acmicpc.net/problem/2775
 */

package io.inhyuck.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2775 {
    public static void main(String[] args) throws IOException {
        int[][] personCount = new int[15][15]; //personCount[i][j] => i층 j호에 살고 있는 인원 수
        for (int j = 0; j < 15; j++) {
            personCount[0][j] = j;
            personCount[j][1] = 1;
        }
        for (int i = 1; i < 15; i++) { //층
            for (int j = 2; j < 15 ; j++) { //호
                for (int k = 1; k <= j; k++) { //이전층의 호
                    personCount[i][j] += personCount[i - 1][k];
                }
            }
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        int k, n;
        while (t-- > 0) {
            k = Integer.parseInt(reader.readLine());
            n = Integer.parseInt(reader.readLine());
            System.out.println(personCount[k][n]);
        }
    }
}
