/**
 * Date: 2018. 07. 09.
 * URL: https://www.acmicpc.net/problem/10845
 * Title: 큐
 * Problem: 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 *
 * 명령은 총 여섯 가지이다.
 * push X: 정수 X를 큐에 넣는 연산이다.
 * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 큐에 들어있는 정수의 개수를 출력한다.
 * empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
 * front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q10845 {
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(reader.readLine());
        while (num-- > 0) {
            String[] messages = reader.readLine().split(" ");
            switch (messages[0]) {
                case "push":
                    queue.offer(Integer.valueOf(messages[1]));
                    break;
                case "pop":
                    if (queue.size() == 0) {
                        System.out.println("-1");
                        break;
                    }
                    System.out.println(queue.poll());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println((queue.isEmpty() ? "1" : "0"));
                    break;
                case "front":
                    if (queue.size() == 0) {
                        System.out.println("-1");
                        break;
                    }
                    System.out.println(queue.peek());
                    break;
                case "back":
                    if (queue.size() == 0) {
                        System.out.println("-1");
                        break;
                    }
                    System.out.println(((LinkedList<Integer>) queue).peekLast());
                    break;
            }
        }
    }
}
