/**
 * Date: 2018. 07. 09.
 * URL: https://www.acmicpc.net/problem/11279
 * Title: 최대 힙
 * Problem: 널리 잘 알려진 자료구조 중 최대 힙이라는 것이 있다. 최대 힙을 이용하여
 * 다음과 같은 연산을 지원하는 프로그램을 작성하시오.
 * 배열에 자연수 x를 넣는다.
 * 배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거한다.
 * 프로그램은 처음에 비어있는 배열에서 시작하게 된다.
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q11279 {
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int num = Integer.valueOf(reader.readLine());
        int i;

        while (num-- > 0) {
            i = Integer.parseInt(reader.readLine());
            if (i == 0) {
                if (queue.isEmpty())
                    builder.append("0\n");
                else
                    builder.append(queue.poll()+"\n");
            }
            else
                queue.offer(i);
        }
        System.out.println(builder.toString());

    }
}
