/**
 * Date: 2018. 9. 15.
 * Author: inhyuck | https://github.com/inhyuck
 * Title: 2019 카카오 신입채용 1차 코딩테스트 문제 2
 * 일부 케이스 통과 X
 */
package kakao;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        int[] tc1 = {2, 1, 2, 6, 2, 4, 3, 3};
        System.out.println(Arrays.toString(Solution.solution(5, tc1)));
        int[] tc2= {4, 4, 4, 4, 4};
        System.out.println(Arrays.toString(Solution.solution(4, tc2)));
//        int[] tc3= {1, 1, 1, 1, 1, 5, 3};
//        System.out.println(Arrays.toString(Solution.solution(4, tc3)));
//        int[] tc4= {1, 1, 1, 1, 7, 7, 3};
//        System.out.println(Arrays.toString(Solution.solution(6, tc4)));

    }

    static class Solution {
        public static int[] solution(int N, int[] stages) {
            int[] answer = new int[N];
            Node[] result = new Node[N + 2];
            int[] list = new int[N + 2];
            for (int i = 0; i < stages.length; i++) {
                list[stages[i]]++;
            }
//            System.out.println(Arrays.toString(list));
            int num = stages.length;
            for (int i = 0; i < result.length; i++) {
                result[i] = new Node(0, -2.0);
            }
            for (int i = 1; i <= N; i++) {
                if (num == 0) {
                        result[i] = new Node(i, 0.0);
                } else {
                    result[i] = new Node(i, list[i] / (double) num);
                    num -= list[i];
                }
            }
//            for (int i = 0; i <= N; i++) {
//                System.out.println(result[i].toString());
//            }
            Arrays.sort(result, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return (o2.result - o1.result >= 0 ? 1 : -1);
                }
            });
//            for (int i = 0; i <= N; i++) {
//                System.out.println(result[i].toString());
//            }
            for (int i = 0; i < N; i++) {
                answer[i] = result[i].num;
            }
            return answer;
        }

        static class Node {
            int num;
            double result;

            public Node(int num, double result) {
                this.num = num;
                this.result = result;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "num=" + num +
                        ", result=" + result +
                        '}';
            }
        }
    }
}
