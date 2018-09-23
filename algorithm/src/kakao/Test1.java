/**
 * Date: 2018. 9. 15.
 * Author: inhyuck | https://github.com/inhyuck
 * Title: 2019 카카오 신입채용 1차 코딩테스트 연습문제1
 * Problem: 길이가 n인 배열에 1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는지를 확인하려고 합니다.
 * 1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는 경우 true를, 아닌 경우 false를 반환하도록
 * 함수 solution을 완성해주세요.
 */
package kakao;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        int[] arr1 = {4, 1, 3, 2};
        int[] arr2 = {4, 1, 3};
        int[] arr3 = {4, 4, 1, 2, 3};

        System.out.println(Solution.solution(arr1)); //test1
        System.out.println(Solution.solution(arr2)); //test2
        System.out.println(Solution.solution(arr3)); //test3
    }

    static class Solution {
        public static boolean solution(int[] arr) {
            Set<Integer> set = new HashSet();
            int n = arr.length;
            for (int item : arr) {
                if (item > n || set.contains(item)) {
                    return false;
                }
                set.add(item);
            }
            return set.size() == n;
        }
    }
}
