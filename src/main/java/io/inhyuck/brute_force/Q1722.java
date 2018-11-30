/**
 * Date: 30/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 순열의 순서
 * description: N이 주어지면, 아래의 두 소문제 중에 하나를 풀어야 한다. k가 주어지면 k번째 순열을 구하고,
 * 임의의 순열이 주어지면 이 순열이 몇 번째 순열인지를 출력하는 프로그램을 작성하시오.
 * Solution Key: 순열
 * Problem URL: https://www.acmicpc.net/problem/1722
 */

package io.inhyuck.brute_force;

import java.util.*;

public class Q1722 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());

        //k가 주어졌을 때 k번째 순열 찾기
        if (tokenizer.nextToken().equals("1")) {
            long k = Long.parseLong(tokenizer.nextToken());
            Set<Integer> permutation = new LinkedHashSet<>();
            findPermutation(permutation, n, k, n - 1);

            permutation.stream().forEach(x -> System.out.print(x + " "));
            return;
        }

        //순열이 주어졌을 때 몇번째 순열인지 계산
        Queue<Integer> permutation = new LinkedList<>();
        Set<Integer> checkPermutation = new HashSet<>();
        while (tokenizer.hasMoreTokens()) {
            permutation.add(Integer.parseInt(tokenizer.nextToken()));
        }
        System.out.println(computeK(permutation, checkPermutation));
    }

    //k번째 순열 찾기
    private static void findPermutation(Set<Integer> permutation, int n, long k, int factorialCount) {
        if (permutation.size() == n) {
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (permutation.contains(i)) {
                continue;
            }
            if (k > factorial(factorialCount)) {
                k -= factorial(factorialCount);
                continue;
            }
            permutation.add(i);
            findPermutation(permutation, n, k, factorialCount - 1);
            break;
        }
    }

    /**
     * 주어진 순열이 몇번째 순열인지 계산
     * @param permutation 주어진 순열 Queue
     * @param checkPermutation : 이미 지났지만 주어진 순열에 포함되는지 여부를 확인하기 위한 Set
     * @return long 몇번째인지(k)
     */
    private static long computeK(Queue<Integer> permutation, Set<Integer> checkPermutation) {
        int n = permutation.size() + checkPermutation.size(); //원래 주어진 순열의 크기
        if (checkPermutation.size() == n) {
            return 1;
        }

        long sum = 0;
        for (int i = 1; i <= n; i++) {
            if (checkPermutation.contains(i)) {
                continue;
            }
            if (i == permutation.peek()) {
                checkPermutation.add(permutation.poll());
                break;
            }
            sum += factorial(permutation.size() - 1);
        }

        return sum + computeK(permutation, checkPermutation);
    }

    //팩토리얼 계산
    private static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
