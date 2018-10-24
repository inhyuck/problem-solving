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

package io.inhyuck.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2261 {
    static Point[] points;

    public static void main(String[] args) throws IOException {
        // data 입력
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Set<Point> pointsTemp = new HashSet<>();
        String[] temp;
        for (int i = 0; i < n; i++) {
            temp = reader.readLine().split(" ");
            pointsTemp.add(new Point(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }
        points = (Point[])pointsTemp.toArray();

        // X좌표 순서로 정렬
        Arrays.parallelSort(points, Comparator.comparing(Point::getX));
        Arrays.stream(points).forEach(System.out::println); // Log

        // 가장 가까운 두점 최단 거리 구한 후 출력
        int shortestDistance = findCloset(0, n - 1);
        System.out.println((int)Math.pow(shortestDistance, 2));
    }

    private static int findCloset(int start, int end) {
        int middleIndex = (start + end) / 2;
        int leftShortestDistance = findCloset(start, middleIndex); //왼쪽 절반에서 가장 가까운 두 점 사이의 거리
        int rightShortestDistance = findCloset(middleIndex + 1, end); //오른쪽 절반에서 가장 가까운 두 점 사이의 거리
        int minShortestDistance = Math.min(leftShortestDistance, rightShortestDistance);

        //분할 기준 점 좌우로 minShortestDistance 만큼의 범위내에 있는 점 구한 후 y좌표를 기준으로 정렬
        List<Point> availablePoints = findAvailablePointsByRangeOfX(middleIndex, minShortestDistance, start, end);
        Collections.sort(availablePoints, Comparator.comparing(Point::getY));

        //왼쪽 절반에 한개, 오른쪽 절반에 한개 선택한 가장 가까운 두 점 사이의 거리
        int bothSidesShortestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < availablePoints.size() - 1; i++) {
            for (int j = i + 1; j < availablePoints.size(); j++) {
                int temp = availablePoints.get(j).y - availablePoints.get(i).y;
                if (temp >= minShortestDistance) {
                    break;
                }
                bothSidesShortestDistance = Math.min(Point.getDistance(availablePoints.get(i), availablePoints.get(j)),
                        bothSidesShortestDistance);
            }
        }
        return Math.min(minShortestDistance, bothSidesShortestDistance);
    }

    private static List<Point> findAvailablePointsByRangeOfX(int middleIndex, int minShortestDistance, int start, int end) {
        List<Point> availablePoints = new ArrayList<>();
        for (int i = middleIndex; i >= start; i--) {
            if (Math.abs(points[middleIndex].x - points[i].x) <= minShortestDistance) {
                availablePoints.add(points[i]);
            } else {
                break;
            }
        }
        for (int i = middleIndex + 1; i <= end; i++) {
            if (Math.abs(points[middleIndex].x - points[i].x) <= minShortestDistance) {
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

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        static int getDistance(Point p1, Point p2) {

        }
    }
}
