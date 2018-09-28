/**
 * Date: 2018. 07. 30.
 * URL: https://www.acmicpc.net/problem/1406
 * Title: 에디터
 * Problem: 한 줄로 된 간단한 에디터를 구현하려고 한다. 이 편집기는 영어 소문자만을 기록할 수 있는 편집기로,
 * 최대 600,000글자까지 입력할 수 있다.
 * 이 편집기에는 '커서'라는 것이 있는데, 커서는 문장의 맨 앞(첫 번째 문자의 왼쪽),
 * 문장의 맨 뒤(마지막 문자의 오른쪽), 또는 문장 중간 임의의 곳(모든 연속된 두 문자 사이)에 위치할 수 있다.
 * 즉 길이가 L인 문자열이 현재 편집기에 입력되어 있으면, 커서가 위치할 수 있는 곳은 L+1가지 경우가 있다.
 * (링크 참조하여 부가설명 확인할 것)
 */
package io.inhyuck.collections;

import java.io.*;
import java.util.Stack;

public class Q1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine(); //초기 문자열
        int t = Integer.parseInt(reader.readLine()); //명령 횟수
        String command; // 명령어
        char c; // c : 추가 문자
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            left.push(line.charAt(i));
        }

        for (int i = 0; i < t; i++) {
            command = reader.readLine();
            switch (command.charAt(0)) {
                case 'L':
                    if (left.size() != 0) {
                        right.push(left.pop());
                    }
                    break;
                case 'D':
                    if (right.size() != 0) {
                        left.push(right.pop());
                    }
                    break;
                case 'B':
                    if (left.size() != 0) {
                        left.pop();
                    }
                    break;
                case 'P':
                    c = command.charAt(2);
                    left.push(c);
                    break;
            }
        }

        while (left.size() != 0) {
            right.push(left.pop());
        }
        StringBuilder builder = new StringBuilder();
        while (right.size() != 0) {
            builder.append(right.pop());
        }
        System.out.println(builder);
    }
}
