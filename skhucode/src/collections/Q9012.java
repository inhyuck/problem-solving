/**
 * Date: 2018. 07. 28.
 * URL: https://www.acmicpc.net/problem/9012
 * Title: 괄호
 * Problem: 괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
 * 그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다. 한 쌍의 괄호
 * 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다. 만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열
 * “(x)”도 VPS 가 된다. 그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다. 예를 들어
 * “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다.
 * 여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다.
 */
package collections;

import java.io.*;

public class Q9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        String line;
        int count;

        for (int i = 0; i < t; i++) {
            count = 0;
            line = reader.readLine();
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '(') {
                    count++;
                } else {
                    count--;
                    if (count < 0) { //여는 괄호가 남아있지 않는경우
                        System.out.println("NO");
                        break;
                    }
                }
            }
            if (count == 0) { //짝이 제대로 맞은 경우
                System.out.println("YES");
            } else if (count > 0) { //여는 괄호가 남은 경우
                System.out.println("NO");
            }
        }
    }
}
