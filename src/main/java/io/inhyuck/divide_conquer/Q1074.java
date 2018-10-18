/**
 * Date: 2018. 10. 17.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: Z
 * description: Z 모양으로 순회할 때 탐색 순서
 * Problem URL: https://www.acmicpc.net/problem/1074
 */

package io.inhyuck.divide_conquer;

import java.util.Scanner;

public class Q1074 {
    static Point target;

    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        target = new Point(r, c);
        System.out .println(findVisitOrder(new Point(0, 0, 0), 1 << n));
    }

    private static int findVisitOrder(Point start, int size) throws CloneNotSupportedException {
        if (start.equals(target)) {
            return start.order;
        }
        int newSize = size / 2;
        Point middlePoint = start.plusX(newSize).plusY(newSize);

        if (target.x < middlePoint.x && target.y < middlePoint.y)  // 2사분면
            return findVisitOrder(start, newSize);
        if (target.x < middlePoint.x) // 1사분면
            return findVisitOrder(start.plusY(newSize).plusOrder((int)Math.pow((double)newSize, 2)), newSize);
        if (target.y < middlePoint.y) // 3사분면
            return findVisitOrder(start.plusX(newSize).plusOrder((int)Math.pow((double)newSize, 2) * 2), newSize);
        return findVisitOrder(start.plusX(newSize).plusY(newSize).plusOrder((int)Math.pow((double)newSize, 2) * 3), newSize); // 4사분면
    }

    static class Point implements Cloneable {
        int x, y, order;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int order) {
            this.x = x;
            this.y = y;
            this.order = order;
        }

        public Point plusX(int x) throws CloneNotSupportedException {
            Point temp = (Point)this.clone();
            temp.x += x;
            return temp;
        }

        public Point plusY(int y) throws CloneNotSupportedException {
            Point temp = (Point)this.clone();
            temp.y += y;
            return temp;
        }

        public Point plusOrder(int order) throws CloneNotSupportedException {
            Point temp = (Point)this.clone();
            temp.order += order;
            return temp;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", order=" + order +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            if (y != point.y) return false;
            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
