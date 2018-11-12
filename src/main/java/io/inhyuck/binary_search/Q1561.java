/**
 * Date: 11/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 놀이 공원
 * description: 놀이기구가 모두 비어 있는 상태에서 첫 번째 아이가 놀이기구에 탑승한다고 할 때,
 * 줄의 마지막 아이가 타게 되는 놀이기구의 번호를 구하는 프로그램을 작성하시오.
 * Solution Key: binary search
 * Problem URL: https://www.acmicpc.net/problem/1561
 */

package io.inhyuck.binary_search;

import java.util.*;

public class Q1561 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine());
        int[] games = new int[m]; //놀이기구 소요시간 배열
        for (int i = 0; i < m; i++) {
            games[i] = Integer.parseInt(tokenizer.nextToken());
        }

        /**
         * minute 분에 몇 번째 학생부터 몇 번째 학생이 놀이기구를 타는가?
         */
        int resultNumber = 0;
        long left = 0, right = 60000000000L; //최악의 경우 : 기구 1대 * 1대에 30분 소요 * 20억명 대기
        while (left <= right) {
            long minute = (left + right) >> 1; //기준 minute
            long countAllOfPerson = computeCountAllOfPerson(games, minute); //총 탑승인원
            long countOneOfPerson = computeCountOneOfPerson(games, minute); //새롭게 탑승한 인원

            if (include(n, countAllOfPerson, countOneOfPerson)) { //탑승순서 범위에 n이 포함되면
                //n번째 사람이 탑승한 놀이기구 번호 찾아서 return
                resultNumber = findNumberOfGame(games, minute, n);
                break;
            }
            if (countAllOfPerson < n) {
                left = minute + 1;
                continue;
            }
            right = minute - 1;
        }

        System.out.println(resultNumber + 1);
    }

    private static int findNumberOfGame(int[] games, long minute, int n) {
        //범위 내 탑승 순서중 가장 첫번째 순서로 초기화
        long orderNumberOfPerson = computeCountAllOfPerson(games, minute) - computeCountOneOfPerson(games, minute) + 1;
        for (int i = 0; i < games.length; i++) {
            if (minute % games[i] == 0) { //minute 에 탑승한 놀이기구
                if (orderNumberOfPerson == n) {
                    return i; //놀이기구 번호 return
                }
                orderNumberOfPerson++;
            }
        }
        return -1;
    }

    private static boolean include(int n, long countAllOfPerson, long countOneOfPerson) {
        if (countAllOfPerson - countOneOfPerson < n && n <= countAllOfPerson) {
            return true;
        }
        return false;
    }

    private static long computeCountAllOfPerson(int[] games, long minute) {
        return games.length + Arrays.stream(games).mapToLong(x -> minute / x).sum();
    }

    private static long computeCountOneOfPerson(int[] games, long minute) {
        return Arrays.stream(games).filter(x -> minute % x == 0).count();
    }
}
