/**
 * Date: 2018. 9. 17.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: ATM
 * Problem: 링크참조
 * URL: https://www.acmicpc.net/problem/11399
 */
package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Q11399 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = scanner.nextInt();
        }

        Arrays.parallelSort(time);
        int result = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            num = num + time[i];
            result += num;
        }
        System.out.println(result);
    }
}
