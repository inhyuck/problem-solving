/**
 * Date: 2018. 9. 29.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 숫자 카드
 * description: 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다.
 * 숫자 M개가 주어졌을 때, 이 숫자가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/10815
 */

package io.inhyuck.divide_conquer;

import java.util.Arrays;
import java.util.Scanner;

public class Q10815 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ownCards = new int[n];
        for (int i = 0; i < n; i++) {
            ownCards[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] compareCards = new int[m];
        for (int i = 0; i < m; i++) {
            compareCards[i] = scanner.nextInt();
        }

        Arrays.sort(ownCards);
        for (int i = 0; i < m; i++) {
            if (binarySearch(ownCards, 0, n - 1, compareCards[i])) {
                System.out.print("1 ");
            } else {
                System.out.print("0 ");
            }
        }
    }

    private static boolean binarySearch(int[] ownCards, int start, int end, int compareCard) {
        if (start > end) {
            return false;
        }
        int middle = start + (end - start) / 2;
        if (ownCards[middle] < compareCard) {
            return binarySearch(ownCards, middle + 1, end, compareCard);
        }
        if (ownCards[middle] > compareCard) {
            return binarySearch(ownCards, start, middle - 1, compareCard);
        }
        return true;
    }
}
