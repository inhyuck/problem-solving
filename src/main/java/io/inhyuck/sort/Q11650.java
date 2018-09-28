/**
 * Date: 2018. 07. 18.
 * URL: https://www.acmicpc.net/problem/11650
 * Title: 좌표 정렬하기
 * Problem: 2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로,
 * x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 */
package io.inhyuck.sort;

import java.io.*;
import java.util.*;

public class Q11650 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Point> list = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        String[] line = new String[2];
        for (int i = 0; i < n; i++) {
            line = reader.readLine().split(" ");
            list.add(new Point(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }

        Collections.sort(list);

        StringBuilder builder = new StringBuilder();
        for (Point point : list) {
            builder.append(point.toString() + "\n");
        }
        System.out.println(builder);

    }

    //Point Class
    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

        @Override
        public int compareTo(Point that) {
            int r = this.x - that.x;
            if (r != 0) return r;
            return this.y - that.y;
        }
    }
}
