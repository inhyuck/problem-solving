/**
 * Date: 2018. 9. 1.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 반복수열
 * Problem: 반복되는 부분을 제외했을 때, 수열에 남게 되는 수들의 개수를 구하는 프로그램을 작성하시오
 * URL: https://www.acmicpc.net/problem/2331
 */
package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2331 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int p = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(a);
        int nextNumber;
        int preNumber;
        while (true) {
            preNumber = list.get(list.size() - 1);
            nextNumber = fun(preNumber, p);
            if (list.contains(nextNumber)) {
                break;
            }
            list.add(nextNumber);
        }
        System.out.println(list.indexOf(nextNumber));
    }

    private static int fun(int preNumber, int p) {
        String number = preNumber + "";
        int result = 0;
        for (char c : number.toCharArray()) {
            result += Math.pow(Integer.valueOf(c + ""), p);
        }
        return result;
    }
}
