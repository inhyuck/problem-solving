/**
 * Date: 2018. 07. 18.
 * URL: https://www.acmicpc.net/problem/11651
 * Title: 좌표 정렬하기 2
 * Problem: 2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로,
 * y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 */
package sort;

import java.io.*;
import java.util.*;

public class Q11651 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Point> list = new ArrayList<>();
        int n = Integer.parseInt(reader.readLine());
        String[] line = new String[2];
        for (int i = 0; i < n; i++) {
            line = reader.readLine().split(" ");
            list.add(new Point(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }

        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if(p1.y < p2.y)
                    return -1;
                if(p1.y == p2.y) {
                    if(p1.x < p2.x)
                        return -1;
                    if(p1.x == p2.x)
                        return 0;
                    return 1;
                }
                return 1;
            }
        });

        StringBuilder builder = new StringBuilder();
        for (Point point : list) {
            builder.append(point.toString() + "\n");
        }
        System.out.println(builder);

    }

    //Point Class
    static class Point {
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
    }
}
