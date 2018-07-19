/**
 * Date: 2018. 07. 19.
 * URL: https://www.acmicpc.net/problem/10952
 * Title: A+B - 5
 * Problem: 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 */
package io;

import java.io.*;
import java.util.*;

public class Q10952 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b;
        while (scanner.hasNext()) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            if (a == 0 && b == 0)
                break;
            System.out.println(a + b);
        }
    }
}

