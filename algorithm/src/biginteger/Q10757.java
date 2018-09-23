/**
 * Date: 2018. 07. 18.
 * URL: https://www.acmicpc.net/problem/10757
 * Title: 큰 수 A+B
 * Problem: A+B를 계산하시오.
 */
package biginteger;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Q10757 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger a = scanner.nextBigInteger();
        BigInteger b = scanner.nextBigInteger();

        System.out.println(a.add(b));
    }
}