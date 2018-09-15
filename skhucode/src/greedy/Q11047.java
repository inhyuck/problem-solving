/**
 * Date: 2018. 9. 15.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 동전 0
 * Problem: 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
 * 동전을 적절히 사용해서 그 가치의 합을 k로 만드랴고 한다. 이때 필요한 동전 개수의 최솟값을 구하라.
 * URL: https://www.acmicpc.net/problem/11047
 */
package greedy;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Q11047 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(scanner.nextInt());
        }
        int count = 0;
        int item;
//        System.out.println(stack.toString());
        while (k != 0 && !stack.empty()) {
            item = stack.pop();
            while( k >= item ) {
                k -= item;
                count++;
            }
        }
        System.out.println(count);
    }
}
