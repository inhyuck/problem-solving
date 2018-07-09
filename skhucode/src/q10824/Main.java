/**
 * Date: 2018. 07. 09.
 * URL: https://www.acmicpc.net/problem/10824
 * Title: 네 수
 * Problem: 네 자연수 A, B, C, D가 주어진다. 이 때, A와 B를 붙인 수와 C와 D를 붙인 수의 합을 구하는 프로그램을 작성하시오.
 * 두 수 A와 B를 합치는 것은 A의 뒤에 B를 붙이는 것을 의미한다. 즉, 20과 30을 붙이면 2030이 된다.
 */
package q10824;

import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       String[] numbers = bufferedReader.readLine().split(" ");
       String a = numbers[0] + numbers[1];
       String b = numbers[2] + numbers[3];

       System.out.println(Long.valueOf(a) + Long.valueOf(b));
    }
}