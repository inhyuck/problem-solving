/**
 * Date: 2018. 07. 09.
 * URL: https://www.acmicpc.net/problem/10822
 * Title: 더하기
 * Problem: 숫자와 콤마로만 이루어진 문자열 S가 주어진다. 이 때, S에 포함되어있는 자연수의 합을 구하는 프로그램을 작성하시오.
 * S의 첫 문자와 마지막 문자는 항상 숫자이고, 콤마는 연속해서 주어지지 않는다. 주어지는 수는 항상 자연수이다.
 */
package q10822;

import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = bufferedReader.readLine().split(",");

        int sum = 0;
        for (String a : numbers) {
            sum += Integer.valueOf(a);
        }
        System.out.println(sum);
    }
}
