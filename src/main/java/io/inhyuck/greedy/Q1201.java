/**
 * Date: 2018. 9. 28.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: NMK
 * description: 1부터 N까지의 수를 한 번씩 이용해서 최대 부분 증가 수열의 길이가 M이고,
 * 최대 부분 감소 수열의 길이가 K인 수열을 출력한다.
 * Problem URL: https://www.acmicpc.net/problem/1201
 */

package io.inhyuck.greedy;

import java.util.*;
import java.util.stream.Collectors;

public class Q1201 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        if (m + k - 1 > n || m * k < n) {
            System.out.println(-1);
            return;
        }
        Integer[] permutation = new Integer[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = i + 1;
        }
        List<Integer> boundaries = new ArrayList<>();
        divide(boundaries, n, m , k);
        int start = 0;
        for (int boundary : boundaries) {
            Arrays.sort(permutation, start, boundary, Comparator.reverseOrder());
            start = boundary;
        }
        System.out.println(Arrays.stream(permutation)
                .map(x -> x.toString()).collect(Collectors.joining(" ")));
    }

    private static void divide(List<Integer> boundaries, int n, int m, int k) {
        int remainderN = n;
        int remainderM = m;

        boundaries.add(k);
        remainderN -= k;
        remainderM--;

        while (remainderM != 0 && remainderN / remainderM >= k) {
            boundaries.add(boundaries.get(boundaries.size() - 1) + k);
            remainderN -= k;
            remainderM--;
        }
        int remainderNDivideM = (remainderM == 0 ? 0 : remainderN % remainderM);
        for (int i = 0; i < remainderM; i++) {
            boundaries.add(boundaries.get(boundaries.size() - 1) + remainderN / remainderM
                + (remainderNDivideM-- <= 0 ? 0 : 1));
        }
    }
}
