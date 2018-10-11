/**
 * Date: 2018. 10. 10.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 피보나치 함수
 * description: N이 주어졌을 때, fibonacci(N)을 호출했을 때,
 * 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/1003
 */

package io.inhyuck.dp;

import java.util.Scanner;

public class Q1003 {
    static CountNumber[] memoOfCountNumber; //memoOfCountNumber[i] => i번째 피보나치수에서 0이 출력되는 횟수와 1이 출력되는 횟수
    static final int MAX_NUMBER = 40;

    public static void main(String[] args) {
        memoOfCountNumber = new CountNumber[MAX_NUMBER + 1];
        memoOfCountNumber[0] = new CountNumber(1, 0);
        memoOfCountNumber[1] = new CountNumber(0, 1);
        computeCountNumber(MAX_NUMBER);

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(), n;
        while (t-- > 0) {
            n = scanner.nextInt();
            System.out.println(memoOfCountNumber[n].toString());
        }
    }

    private static CountNumber computeCountNumber(int n) {
        if (memoOfCountNumber[n] != null) {
            return memoOfCountNumber[n];
        }
        return memoOfCountNumber[n] = CountNumber.add(computeCountNumber(n - 1), computeCountNumber(n - 2));
    }

    static class CountNumber {
        int zeroCount;
        int oneCount;

        public CountNumber(int zeroCount, int oneCount) {
            this.zeroCount = zeroCount;
            this.oneCount = oneCount;
        }

        @Override
        public String toString() {
            return zeroCount + " " + oneCount;
        }

        static CountNumber add(CountNumber a, CountNumber b) {
            return new CountNumber(a.zeroCount + b.zeroCount, a.oneCount + b.oneCount);
        }
    }
}
