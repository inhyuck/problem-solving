/**
 * Date: 2018. 07. 09.
 * URL: https://www.acmicpc.net/problem/2741
 * Title: N 찍기
 * Problem: 자연수 N이 주어졌을 때, 1부터 N까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
 */
package q2741;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int number = scanner.nextInt();
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= number; i++) {
            builder.append(i + "\n");
        }
        System.out.println(builder.toString());
    }
}
