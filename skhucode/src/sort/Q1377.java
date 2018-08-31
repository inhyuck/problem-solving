/**
 * Date: 2018. 08. 17.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 버블 소트
 * Problem: 위와 같은 소스를 실행시켰을 때, 어떤 값이 출력되는지 구하는 프로그램을 작성하시오.
 * (정렬 다 될 때까지 몇 단계를 거쳐야 하는지)
 * URL: https://www.acmicpc.net/problem/1377
 */
package sort;

import java.util.Scanner;

public class Q1377 {
    static int[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        boolean change;
        for (int i = 0; i < n; i++) {
            change = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    change = true;
                    swap(j, j+1);
                }
            }
            if (change == false) {
                System.out.println(i + 1);
                return;
            }
        }

    }

    private static void swap(int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}
