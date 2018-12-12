/**
 * Date: 2018. 12. 12.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 롤러코스터
 * description: 링크 참조
 * Problem URL: https://www.acmicpc.net/problem/2873
 */

package io.inhyuck.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2873 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int r = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());
        int[][] lands = new int[r][c];
        for (int i = 0; i < r; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < c; j++) {
                lands[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
//        Arrays.stream(lands).forEach(x -> System.out.println(Arrays.toString(x))); //input Log

        if (r % 2 == 0 && c % 2 == 0) { //r짝수 x c짝수
            Point minPoint = findMinPoint(r, c, lands);
            List<String> routeFromStart = makeNarrowFromStartPoint(minPoint, c);
            List<String> routeFromEnd = makeNarrowFromEndPoint(minPoint, r, c);
            routeFromStart.addAll(routeFromEnd);

            StringBuilder builder = new StringBuilder();
            routeFromStart.stream().forEach(x -> builder.append(x));
            System.out.println(builder.toString());
            return;
        }
        if (r % 2 == 1) { //r홀수 x c짝수, r홀수 x c홀수
            StringJoiner route = new StringJoiner("D");
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < r; i++) {
                temp.setLength(0);
                for (int j = 0; j < c - 1; j++) {
                    temp.append(i % 2 == 0 ? "R" : "L");
                }
                route.add(temp);
            }
            System.out.println(route.toString());
            return;
        }
        //r짝수 x c홀수
        StringJoiner route = new StringJoiner("R");
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < c; i++) {
            temp.setLength(0);
            for (int j = 0; j < r - 1; j++) {
                temp.append(i % 2 == 0 ? "D" : "U");
            }
            route.add(temp);
        }
        System.out.println(route.toString());
    }

    //제외할 칸 탐색
    private static Point findMinPoint(int r, int c, int[][] lands) {
        Point minPoint = new Point(0, 0);
        int minNumber = 1001;
        int number;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                //시작점과 끝점 제외 + 시작점과 끝점을 검은색이라 하면 흰색에서 찾아야하므로 검은색 제외
                if ((i == 0 && j == 0) || (i == r - 1 && j == c - 1) || (i + j) % 2 == 0) {
                    continue;
                }
                number = lands[i][j];
                if (minNumber > number) {
                    minNumber = number;
                    minPoint.x = i;
                    minPoint.y = j;
                }
            }
        }
        return minPoint;
    }
    private static List<String> makeNarrowFromStartPoint(Point minPoint, int c) {
        List<String> routeFromStart = new ArrayList<>();
        Point startPoint = new Point(0, 0);
        while (startPoint.x <= minPoint.x - 2) {
            for (int i = 0; i < c - 1; i++) {
                routeFromStart.add("R");
            }
            routeFromStart.add("D");
            for (int i = 0; i < c - 1; i++) {
                routeFromStart.add("L");
            }
            routeFromStart.add("D");
            startPoint.x += 2;
        }
        while (startPoint.y <= minPoint.y - 2) {
            routeFromStart.add("D");
            routeFromStart.add("R");
            routeFromStart.add("U");
            routeFromStart.add("R");
            startPoint.y += 2;
        }
        //마지막 ㄱ 혹은 ㄴ 방향으로 범위 좁히기
        if (startPoint.y == minPoint.y) {
            routeFromStart.add("R");
            routeFromStart.add("D");
        } else {
            routeFromStart.add("D");
            routeFromStart.add("R");
        }
        return routeFromStart;
    }

    private static List<String> makeNarrowFromEndPoint(Point minPoint, int r, int c) {
        List<String> routeFromEnd = new ArrayList<>();
        Point endPoint = new Point(r - 1, c - 1);
        while (endPoint.x >= minPoint.x + 2) {
            for (int i = 0; i < c - 1; i++) {
                routeFromEnd.add("R");
            }
            routeFromEnd.add("D");
            for (int i = 0; i < c - 1; i++) {
                routeFromEnd.add("L");
            }
            routeFromEnd.add("D");
            endPoint.x -= 2;
        }
        while (endPoint.y >= minPoint.y + 2) {
            routeFromEnd.add("D");
            routeFromEnd.add("R");
            routeFromEnd.add("U");
            routeFromEnd.add("R");
            endPoint.y -= 2;
        }
        Collections.reverse(routeFromEnd);
        return routeFromEnd;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
