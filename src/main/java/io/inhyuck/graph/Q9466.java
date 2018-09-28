/**
 * Date: 2018. 9. 1.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 텀 프로젝트
 * Problem: 선택의 결과를 보고 어느 프로젝트 팀에도 속하지 않는 학생들의 수를 계산하는 프로그램을 작성하라.
 * URL: https://www.acmicpc.net/problem/9466
 */
package io.inhyuck.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Q9466 {
    static ArrayList<Integer>[] list;
    static boolean[] check;
    static ArrayList<Integer> line;
    static int teamPersonCount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n;
        while (t-- > 0) {
            n = scanner.nextInt();
            list = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 1; i < n + 1; i++) {
                list[i].add(scanner.nextInt());
            }
            teamPersonCount = 0;
            check = new boolean[n + 1];
            for (int i = 1; i < n + 1; i++) {
                if (check[i] == false) {
                    line = new ArrayList<>();
                    dfs(i);
                }
            }
            System.out.println(n - teamPersonCount);
        }
    }

    private static void dfs(int i) {
        check[i] = true;
        line.add(i);
        int nextNumber = list[i].get(0);
        if (check[nextNumber] == false) { //아직 방문 안함
            dfs(nextNumber);
        } else if (i == nextNumber) { //방문한적 있고 혼자 팀
            teamPersonCount++;
        } else if (line.contains(nextNumber)){ //방문한적 있고 연결된 요소중에 방문했던 놈임
            teamPersonCount += line.indexOf(i) - line.indexOf(nextNumber) + 1;
        }
    }
}
