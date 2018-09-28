/**
 * Date: 2018. 07. 18.
 * URL: https://www.acmicpc.net/problem/10826
 * Title: 피보나치 수 4
 * Problem: 피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다.
 * 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
 * 이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n>=2)가 된다.
 * n=17일때 까지 피보나치 수를 써보면 다음과 같다.
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
 * n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
 */
package io.inhyuck.biginteger;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Q10826 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        BigInteger[] numbers = new BigInteger[Math.max(n+1, 2)];
        numbers[0] = BigInteger.ZERO;
        numbers[1] = BigInteger.ONE;
        for (int i = 2; i < n+1; i++) {
            numbers[i] = numbers[i-2].add(numbers[i-1]);
        }

        System.out.println(numbers[n]);
    }
}
