/**
 * Date: 2018. 07. 19.
 * URL: https://www.acmicpc.net/problem/10951
 * Title: A+B - 4
 * Problem: 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 */
package io.inhyuck.io;

import java.io.*;
import java.util.*;

public class Q10951 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextInt() + scanner.nextInt());
        }
    }
}

