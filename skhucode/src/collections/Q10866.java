/**
 * Date: 2018. 07. 30.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 덱
 * Problem: 정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 * 명령은 총 여덟 가지이다.
 * push_front X: 정수 X를 덱의 앞에 넣는다.
 * push_back X: 정수 X를 덱의 뒤에 넣는다.
 * pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 덱에 들어있는 정수의 개수를 출력한다.
 * empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
 * front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *
 * URL: https://www.acmicpc.net/problem/10866
 */
package collections;

import java.io.*;

/**
 * int형 배열을 이용했지만 LinkedList를 이용하는 것이 훨씬 낫다 ㅠㅠ
 */
public class Q10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        String[] command;
        int n;
        int[] deque = new int[20000];
        int front = 10000;
        int end = 10000;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < t; i++) {
            command = reader.readLine().split(" ");
            switch (command[0]) {
                case "push_front":
                    deque[--front] = Integer.parseInt(command[1]);
                    break;
                case "push_back":
                    deque[end++] = Integer.parseInt(command[1]);
                    break;
                case "pop_front":
                    if (front == end) {
                        builder.append("-1\n");
                    } else {
                        builder.append(deque[front++] + "\n");
                    }
                    break;
                case "pop_back":
                    if (front == end) {
                        builder.append("-1\n");
                    } else {
                        builder.append(deque[--end] + "\n");
                    }
                    break;
                case "size":
                    builder.append(end - front + "\n");
                    break;
                case "empty":
                    if (front == end) {
                        builder.append("1\n");
                    } else {
                        builder.append("0\n");
                    }
                    break;
                case "front":
                    if (front == end) {
                        builder.append("-1\n");
                    } else {
                        builder.append(deque[front] +"\n");
                    }
                    break;
                case "back":
                    if (front == end) {
                        builder.append("-1\n");
                    } else {
                        builder.append(deque[end - 1] +"\n");
                    }
                    break;
            }
        }

        System.out.println(builder);
    }
}
