/**
 * Date: 2018. 10. 24.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 가장 가까운 두 점
 * description: 2차원 평면상에 n개의 점이 주어졌을 때, 이 점들 중 가장 가까운 두 점을 구하는 프로그램을 작성하시오.
 * Solution Key: 분할 정복을 통해 가장 가까운 두 점이 왼쪽 절반에 있는 경우, 오른쪽 절반에 있는 경우, 왼쪽 오른쪽
 * 각각 하나씩 나눠져 있는 경우로 나눈다.
 * Problem URL: https://www.acmicpc.net/problem/2261
 */

/**
 * 1. X좌표 오름차순 정렬
 * 2. 범위 내에서 가운데 점 선정하여 왼쪽 절반과 오른쪽 절반으로 분할
 * 3. 가장 가까운 두 점은 3가지 중 최솟값
 *      A - 왼쪽 절반에서 가장 가까운 두 점(영역 좁혀서 재귀)
 *      B - 오른쪽 절반에서 가장 가까운 두 점(영역 좁혀서 재귀)
 *      C - 왼쪽에서 한개, 오른쪽에서 한개 이렇게 두 점이 가장 가까운 두 점
 *
 *      3-1. A,B 중 작은 값을 D라고 설정. C에 해당하는 점은 중간값 X좌표 기준 좌우로 D 이내에 존재해야 함
 *      3-2. 3-1에 해당하는 점들을 y좌표 기준 정렬
 *      3-3. 3-2에서 정렬된 점들 사이의 간격이 D보다 작은 경우만 두 점 사이의 거리 계산
 *      3-4. 3-3에서 계산한 결과가 D보다 작으면 D값을 변경
 */

package io.inhyuck.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2261 {
    static Point[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        points = new Point[n];
        String[] temp;
        for (int i = 0; i < n; i++) {
            temp = reader.readLine().split(" ");
            points[i] = new Point(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }
        // X좌표 순서로 정렬
        Arrays.parallelSort(points, Comparator.comparing(Point::getX));
        System.out.println(findCloset(0, points.length - 1));
    }

    private static int findCloset(int start, int end) {
        if (start >= end) {
            return Integer.MAX_VALUE;
        }
        int middleIndex = (start + end) / 2;
        int leftShortestDistance = findCloset(start, middleIndex); //왼쪽 절반에서 가장 가까운 두 점 사이의 거리
        int rightShortestDistance = findCloset(middleIndex + 1, end); //오른쪽 절반에서 가장 가까운 두 점 사이의 거리
        int minShortestDistance = Math.min(leftShortestDistance, rightShortestDistance);

        //분할 기준 점 좌우 minShortestDistance 범위내에 있는 점 구한 후 y좌표를 기준으로 정렬
        List<Point> availablePoints = findAvailablePointsByRangeOfX(middleIndex, minShortestDistance, start, end);
        Collections.sort(availablePoints, Comparator.comparing(Point::getY));

        //왼쪽 절반에 한개, 오른쪽 절반에 한개 선택한 가장 가까운 두 점 사이의 거리
        for (int i = 0; i < availablePoints.size() - 1; i++) { //바로 위에 점과의 거리만 비교
            int temp = (int)Math.pow(availablePoints.get(i + 1).y - availablePoints.get(i).y, 2);
            if (temp < minShortestDistance) {
                minShortestDistance = Math.min(Point.getDistance(availablePoints.get(i), availablePoints.get(i + 1)),
                        minShortestDistance);
            }
        }
        return minShortestDistance;
    }

    private static List<Point> findAvailablePointsByRangeOfX(int middleIndex, int minShortestDistance, int start, int end) {
        List<Point> availablePoints = new ArrayList<>();
        for (int i = middleIndex; i >= start; i--) {
            if (Math.pow(points[middleIndex].x - points[i].x, 2) < minShortestDistance) {
                availablePoints.add(points[i]);
            } else {
                break;
            }
        }
        for (int i = middleIndex + 1; i <= end; i++) {
            if (Math.pow(points[middleIndex].x - points[i].x, 2) < minShortestDistance) {
                availablePoints.add(points[i]);
            } else {
                break;
            }
        }
        return availablePoints;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        static int getDistance(Point p1, Point p2) {
            return (int)(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
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
