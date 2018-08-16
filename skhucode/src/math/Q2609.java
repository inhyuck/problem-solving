/**
 * Date: 2018. 08. 14.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 최대공약수와 최소공배수
 * Problem:
 * 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/2609
 */
package math;

import java.util.*;

public class Q2609 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int minNum = Math.min(a, b);
        int gcd = 1;
        for (int i = minNum; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
                break;
            }
        }
        //int gcd = gcd(a, b);

        int lcm = (a * b) / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }

    //유클리드 호제법
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}