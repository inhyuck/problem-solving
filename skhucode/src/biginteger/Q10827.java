/**
 * Date: 2018. 07. 18.
 * URL: https://www.acmicpc.net/problem/10827
 * Title: a^b
 * Problem: 실수 a와 정수 b가 주어졌을 때, a의 b제곱을 정확하게 계산하는 프로그램을 작성하시오.
 */
package biginteger;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Q10827 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal a = scanner.nextBigDecimal();
        int b = scanner.nextInt();

        System.out.println(a.pow(b).toPlainString());
    }
}