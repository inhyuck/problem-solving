/**
 * Date: 2018. 9. 1.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 단지번호붙이기
 * Problem: 지도를 입력하여 단지수를 출력하고,
 * 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오
 * URL: https://www.acmicpc.net/problem/2667
 */
package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q2667 {
    static boolean[][] check;
    static int[][] list;
    static ArrayList<Integer> house;
    static int houseCount;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        list = new int[n][n];
        String temp;
        for (int i = 0; i < n; i++) {
            temp = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                list[i][j] = Integer.parseInt(temp.charAt(j) + "");
            }
        }
        check = new boolean[n][n];
        house = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                houseCount = 0;
                if (list[i][j] != 0 && check[i][j] == false) {
                    dfs(i, j, n);
                    house.add(houseCount);
                }
            }
        }
        Collections.sort(house);
        System.out.println(house.size());
        for (int i : house) {
            System.out.println(i);
        }
    }

    private static void dfs(int i, int j, int n) {
        houseCount++;
        check[i][j] = true;
        if (i > 0 && isOk(i-1, j)) {
            dfs(i-1, j, n);
        }
        if (i < n - 1 && isOk(i+1, j)) {
            dfs(i + 1, j, n);
        }
        if (j > 0 && isOk(i, j-1)) {
            dfs(i, j-1, n);
        }
        if (j < n - 1 && isOk(i, j+1)) {
            dfs(i, j + 1, n);
        }
    }

    private static boolean isOk(int i, int j) {
        if (list[i][j] == 1 && check[i][j] == false) {
            return true;
        }
        return false;
    }
}
