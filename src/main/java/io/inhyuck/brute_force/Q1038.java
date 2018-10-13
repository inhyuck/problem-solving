/**
 * Date: 2018. 10. 13.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 감소하는 수
 * description: 음이 아닌 정수 X의 자릿수가 가장 큰 자릿수부터 작은 자릿수까지 감소한다면, 그 수를 감소하는 수라고 한다.
 * N번째 감소하는 수를 출력하는 프로그램을 작성하시오. 0은 0번째 감소하는 수이고, 1은 1번째 감소하는 수이다.
 * 만약 N번째 감소하는 수가 없다면 -1을 출력한다.
 * Problem URL: https://www.acmicpc.net/problem/1038
 */

/**
 * brute force 알고리즘으로 풀려고 했는데 모든 경우의 수를 무식하게 계산하려다 시간초과 ㅠㅠ
 * 불필요하게 계산하는 부분을 제외하도록 해서 다시 도전해보자!!!
 */

package io.inhyuck.brute_force;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q1038 {
    static final long MAX_NUMBER = 9876543210L;
    static Map<String, Boolean> memo = new HashMap<>();

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int count = -1;
        for (long i = 0; i <= MAX_NUMBER; i++) {
            if (isDescendNumber(String.valueOf(i))) {
                count++;
                if (count == n) {
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    private static boolean isDescendNumber(String stringNumber) {
        if (stringNumber.length() == 1) {
            return true;
        }
        if (stringNumber.charAt(0) > stringNumber.charAt(1)) {
            return isDescendNumber(stringNumber.substring(1));
        }
        return false;
    }
}
