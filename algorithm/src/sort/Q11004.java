/**
 * Date: 2018. 08. 16.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: K번째 수
 * Problem: 수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때,
 * 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/11004
 */
package sort;

import java.util.Scanner;

public class Q11004 {
    static int[] numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int result = find(k, 0, numbers.length - 1);
        System.out.println(result);
    }

    private static int find(int k, int start, int end) {
        if (start == end) {
            return numbers[start];
        }
        int middle = pivot(start, end);
        if (middle + 1 > k) {
            return find(k, start, middle - 1);
        }
        if (middle + 1 < k) {
            return find(k, middle + 1, end);
        }
        return numbers[middle];
    }

    private static int pivot(int start, int end) {
        swap((start + end) / 2, end);
        int pivot = numbers[end];
        int index = start - 1; //피봇보다 작거나 같은 숫자중 마지막 인덱스
        for (int i = start; i < end; i++) {
            if (numbers[i] <= pivot) {
                swap(i, ++index);
            }
            //System.out.println(Arrays.toString(numbers)  + "start: " + start +"/end"+ end);
        }
        swap(end, ++index);
        //System.out.println(Arrays.toString(numbers)  + "start: " + start +"/end"+ end + "/middle: "+ index);
        return index;
    }

    private static void swap(int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}
