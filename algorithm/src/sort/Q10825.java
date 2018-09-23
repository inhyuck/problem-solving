/**
 * Date: 2018. 08. 16.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 국영수
 * Problem: 도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어진다.
 * 이 때, 다음과 같은 조건으로 학생의 성적을 정렬하는 프로그램을 작성하시오.
 * 국어 점수가 감소하는 순서로
 * 국어 점수가 같으면 영어 점수가 증가하는 순서로
 * 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
 * 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
 * (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
 * URL: https://www.acmicpc.net/problem/10825
 */
package sort;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Q10825 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        String[] temp;
        Student[] students = new Student[t];
        for (int i = 0; i < t; i++) {
            temp = reader.readLine().split(" ");
            students[i] = new Student(temp[0], Integer.parseInt(temp[1]),
                    Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
        }
        Arrays.sort(students, (Student s1, Student s2) -> {
            int r = s2.korean - s1.korean;
            if (r != 0) return r;
            r = s1.english - s2.english;
            if (r != 0) return r;
            r = s2.math - s1.math;
            if (r != 0) return r;
            return s1.name.compareTo(s2.name);
        });
        for (Student student : students) {
            System.out.println(student.name);
        }
    }

    static class Student {
        private String name;
        private int korean;
        private int english;
        private int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        public String getName() {
            return name;
        }

        public int getKorean() {
            return korean;
        }

        public int getEnglish() {
            return english;
        }

        public int getMath() {
            return math;
        }
    }
}
