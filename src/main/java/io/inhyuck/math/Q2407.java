/**
 * Date: 2018. 10. 13.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 조합
 * description: nCm을 출력한다.
 * Problem URL: https://www.acmicpc.net/problem/2407
 */

package io.inhyuck.math;

import java.math.BigInteger;
import java.util.Scanner;

public class Q2407 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(computeFactorial(n, Math.max(m + 1, n - m + 1))
                .divide(computeFactorial(Math.min(n - m, m), 1)).toString());
    }

    private static BigInteger computeFactorial(int first, int last) {
        BigInteger result = BigInteger.ONE;
        for (int i = first; i >= last; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
