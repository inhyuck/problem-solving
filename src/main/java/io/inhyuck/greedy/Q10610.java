/**
 * Date: 2018. 9. 27.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title:
 * Problem:
 * URL: https://www.acmicpc.net/problem/
 */
package io.inhyuck.greedy;

import java.util.*;
import java.util.stream.Collectors;

public class Q10610 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers = scanner.nextInt();
        int result = Solution.solution(numbers);
        System.out.println(result);
    }

    static class Solution {
        public static int solution(int numbers) {
            String stringNumbers = String.valueOf(numbers);
            int[] numbersArray = new int[stringNumbers.length()];
            for (int i = 0; i < numbersArray.length; i++) {
                numbersArray[i] = Integer.parseInt(String.valueOf(stringNumbers.charAt(i)));
            }

            List<Integer> numberList = Arrays.stream(numbersArray).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
            if ( !numberList.contains(0)
                    || (numberList.stream().mapToInt(Integer::intValue)).sum() % 3 != 0 ) {
                return -1;
            }
            StringBuilder stringBuilder = new StringBuilder();
            numberList.stream().forEach(x -> stringBuilder.append(x));
            return Integer.parseInt(stringBuilder.toString());
        }
    }
}
