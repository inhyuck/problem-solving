/**
 * Date: 2018. 10. 5.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 셀프 넘버
 * description: 10000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/4673
 */

package io.inhyuck.basic;

public class Q4673 {
    static boolean[] isSelfNumber = new boolean[10001];

    public static void main(String[] args) {
        for (int i = 1; i <= 10000; i++) {
            isSelfNumber[i] = true;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            if (isSelfNumber[i] == false) {
                continue;
            }
            builder.append(i + "\n");
            checkSelfNumber(i);
        }
        System.out.println(builder);
    }

    private static void checkSelfNumber(int nowNumber) {
        int nextNumber = nowNumber;
        int n = 1;
        while (nowNumber / n > 0) {
            nextNumber += (nowNumber % (n * 10)) / n;
            n *= 10;
        }
        if (nextNumber > 10000 || isSelfNumber[nextNumber] == false) {
            return;
        }
        isSelfNumber[nextNumber] = false;
        checkSelfNumber(nextNumber);
    }
}
