/**
 * Date: 2018. 9. 17.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 대회 or 인턴
 * Problem: 링크 참조
 * URL: https://www.acmicpc.net/problem/2875
 */
package greedy;

import java.util.Scanner;

public class Q2875 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int count = 0;

        while (true) {
            if (n < 2 || m < 1) {
                break;
            }
            n -= 2;
            m -= 1;
            if (n + m < k) {
                break;
            }
            count++;
        }

        System.out.println(count);
    }
}
