/**
 * Date: 2018. 9. 1.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 섬의 개수
 * Problem: 정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/4963
 */
package io.inhyuck.graph;

import java.util.Arrays;
import java.util.Scanner;

public class Q4963 {
    static int[][] list;
    static boolean[][] check;
    static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w, h;
        while (true) {
            w = scanner.nextInt();
            h = scanner.nextInt();
            if (w == 0 && h == 0) {
                return;
            }
            list = new int[h][w];
            check = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    list[i][j] = scanner.nextInt();
                }
            }
            count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (list[i][j] != 0 && check[i][j] == false) {
                        count++;
                        dfs(i, j, h, w);
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int i, int j, int h, int w) {
//        System.out.println(i +" "+ j + " " + h + " " +w);
        check[i][j] = true;
        if (i > 0 && isOk(i-1, j)) { //상
            dfs(i-1, j, h, w);
        }
        if (i < h - 1 && isOk(i+1, j)) { //하
            dfs(i + 1, j, h, w);
        }
        if (j > 0 && isOk(i, j-1)) { //좌
            dfs(i, j-1, h, w);
        }
        if (j < w - 1 && isOk(i, j+1)) { //우
            dfs(i, j + 1, h, w);
        }
        if (i > 0 && j > 0 && isOk(i-1,  j-1)) { //좌상
            dfs(i-1, j-1, h, w);
        }
        if (i < h - 1 && j > 0 && isOk(i+1,  j-1)) { //좌하
            dfs(i+1, j-1, h, w);
        }
        if (i > 0 && j < w - 1 && isOk(i-1,  j+1)) { //우상
            dfs(i-1, j+1, h, w);
        }
        if (i < h - 1 && j < w - 1 && isOk(i+1,  j+1)) { //우하
            dfs(i+1, j+1, h, w);
        }
    }

    private static boolean isOk(int i, int j) {
        if (list[i][j] == 1 && check[i][j] == false) {
            return true;
        }
        return false;
    }
}
