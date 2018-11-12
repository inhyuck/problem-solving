/**
 * Date: 12/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 사다리
 * description: 두 빌딩 사이의 빗변과 그 교차지점의 높이가 주어졌을 때, 빌딩 사이의 거리 구하기
 * Solution Key: Math, Binary Search (실수범위에서 이분탐색으로 정답 찾기)
 * Problem URL: https://www.acmicpc.net/problem/2022
 */

/**
 * 두 빌딩 사이의 거리를 d라고 할 때
 * 왼쪽 빌딩의 높이 : h1 = sqrt(x^2 - d^2)
 * 오른쪽 빌딩의 높이 : h2 = sqrt(y^2 - d^2)
 * y를 빗변으로 가지는 직선의 방정식 : f(x) = h2 * x / d
 * x를 빗변으로 가지는 직선의 방정식 : g(x) = (-h1 * x / d) + h1
 * 두 점이 만나는 지점의 x 좌표를 a, y 좌표를 b라 하면,
 * h = f(a)
 * h = h2 * a / d
 * a = h * d / h2 ==> 1번식
 * 마찬가지로
 * h = g(a)
 * h = (-h1 * a / d) + h1
 * 1번식에서 구한 a를 대입하면
 * h = (-h1 * (h * d / h2) / d) + h1
 * 정리하면
 * h = (h1 * h2) / (h1 + h2)
 */

package io.inhyuck.binary_search;

import java.util.Scanner;

public class Q2022 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        double c = scanner.nextDouble();

        double left = 0, right = Math.min(x, y);
        double distance, h1, h2, h;
        while (Math.abs(left - right) > 1e-6) {
            distance = (left + right) / 2;
            h1 = Math.sqrt(x * x - distance * distance);
            h2 = Math.sqrt(y * y - distance * distance);
            h = (h1 * h2) / (h1 + h2);
            if (h < c) {
                right = distance; //h < c 인경우 distance down
                continue;
            }
            left = distance; //distance up
        }

        System.out.printf("%.3f", left);
    }
}
