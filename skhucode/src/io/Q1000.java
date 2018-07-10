/**
 * Date: 2018. 07. 06.
 * URL: https://www.acmicpc.net/problem/1000
 * Title: A+B
 * Problem: 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 */
package baekjoon;

import java.util.Scanner;

public class Q1000 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(a+b);
    }
}
