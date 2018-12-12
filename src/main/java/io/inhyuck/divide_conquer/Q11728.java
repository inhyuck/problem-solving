/**
 * Date: 2018. 12. 12.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 배열 합치기
 * description: 정렬되어있는 두 배열 A와 B가 주어진다. 두 배열을 합친 다음 정렬해서 출력하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/11728
 */

package io.inhyuck.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int[] a = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(tokenizer.nextToken());
        }
        int[] b = new int[m];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] result = merge(a, b);

        StringJoiner joiner = new StringJoiner(" ");
        Arrays.stream(result).forEach(x -> joiner.add(String.valueOf(x)));
        System.out.println(joiner.toString());
    }

    private static int[] merge(int[] a, int[] b) {
        int[] mergedArray = new int[a.length + b.length];
        int ai = 0, bi = 0, mi = 0;
        while (ai < a.length && bi < b.length) {
            if (a[ai] <= b[bi]) {
                mergedArray[mi++] = a[ai++];
            } else {
                mergedArray[mi++] = b[bi++];
            }
        }
        while (ai < a.length) mergedArray[mi++] = a[ai++];
        while (bi < b.length) mergedArray[mi++] = b[bi++];

        return mergedArray;
    }
}
