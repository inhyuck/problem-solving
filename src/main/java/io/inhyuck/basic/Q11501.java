/**
 * Date: 14/12/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 주식
 * description: 날짜별 주식가격을 미리알고있는 상태에서 최대 수익 내기
 * Solution Key: -
 * Problem URL: https://www.acmicpc.net/problem/11501
 */

package io.inhyuck.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            int[] price = new int[n];
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                price[i] = Integer.parseInt(tokenizer.nextToken());
            }
//            System.out.printf("n: %d\nprice: %s", n, Arrays.toString(price)); //input Log

            long result = computePrice(price, 0, n - 1);
            builder.append(result).append("\n");
        }

        System.out.println(builder.toString());
    }

    private static long computePrice(int[] price, int start, int end) {
        if (start >= end) {
            return 0L;
        }
        int maxIndex = start;
        long maxPrice = price[start];
        for (int i = start; i <= end; i++) { //범위 내 최대가격과 그 index 찾기
            if (price[i] >= maxPrice) {
                maxIndex = i;
                maxPrice = price[i];
            }
        }

        long cost = 0; //maxIndex 이전 값들은 모두 구매
        int samePriceCount = 0;
        for (int i = start; i < maxIndex; i++) {
            if (price[i] == maxPrice) { //최댓값과 같은 가격은 구매하지 않음
                samePriceCount++;
                continue;
            }
            cost += price[i];
        }

        //주식을 산 날짜갯수(같은 가격 제외)만큼 maxPrice가격으로 판매
        long result = maxPrice * (maxIndex - start - samePriceCount) - cost;
        //최댓값 이후 범위 재귀로 계산하여 더해줌
        return result + computePrice(price, maxIndex + 1, end);
    }
}
