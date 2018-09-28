/**
 * Date: 2018. 9. 28.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 행렬
 * description: 0과 1로만 이루어진 행렬 A와 행렬 B가 있다.
 * 이때, 행렬 A를 행렬 B로 바꾸는데 필요한 연산의 횟수의 최솟값을 구하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/1080
 */

package io.inhyuck.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Q1080 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[][] matrixA = new int[n][m];
        int[][] matrixB = new int[n][m];
        String temp;
        for (int i = 0; i < n; i++) {
            temp = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                matrixA[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }
        for (int i = 0; i < n; i++) {
            temp = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                matrixB[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
            }
        }

        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    reverseMatrix(matrixA, i, j);
                    count++;
                }
            }
        }
        System.out.println(Arrays.deepEquals(matrixA, matrixB) ? count : -1);
    }

    private static void reverseMatrix(int[][] matrix, int i, int j) {
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                matrix[i + k][j + l] = matrix[i + k][j + l] == 0 ? 1 : 0;
            }
        }
    }
}
