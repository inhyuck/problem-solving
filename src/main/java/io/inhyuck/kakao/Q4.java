/**
 * Date: 2018. 9. 15.
 * Author: inhyuck | https://github.com/inhyuck
 * Title: 2019 카카오 신입채용 1차 코딩테스트 문제 3
 * 일반 문제 통과, 효율성 테스트 일부 통과x
 */
package io.inhyuck.kakao;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Q4 {
    public static void main(String[] args) {
        int[] tc1 = {3, 1, 2};
        System.out.println(Solution.solution(tc1, 5));
    }

    static class Solution {
        public static int solution(int[] food_times, long k) {
            long num = 0;
            if (k > 2000000) {
                num = k / food_times.length;
                k = k % food_times.length;
            }
            long time;
            Queue<Food> queue = new LinkedList<>();
            for (int i = 0; i < food_times.length; i++) {
                time = food_times[i] - num;
                if (time > 0) {
                    queue.offer(new Food(time));
                }
            }
//            System.out.println(queue.toString());
            Food food;
            while(k-- > 0) {
                if (queue.isEmpty()) {
                    return -1;
                }
                food = queue.poll();
                food.time -= 1;
                if (food.time != 0) {
                    queue.offer(food);
                }
//                System.out.println(queue.toString());
            }

            return (queue.isEmpty() ? -1 : queue.peek().num);
        }

        static class Food {
            static int count = 0;
            int num;
            long time;

            public Food(long time) {
                this.num = ++count;
                this.time = time;
            }

            @Override
            public String toString() {
                return "Food{" +
                        "" + num +
                        ", time=" + time +
                        '}';
            }
        }
    }
}
