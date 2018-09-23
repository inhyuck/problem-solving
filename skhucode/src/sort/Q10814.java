/**
 * Date: 2018. 08. 16.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 나이순 정렬
 * Problem: 온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다. 이 때, 회원들을 나이가
 * 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/10814
 */
package sort;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Q10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        String[] temp;
        Person[] people = new Person[t];
        for (int i = 0; i < t; i++) {
            temp = reader.readLine().split(" ");
            people[i] = new Person(Integer.parseInt(temp[0]), temp[1]);
        }
        //Arrays.sort는 기본적으로 stable sort이므로 자동적으로 가입순 유지됨!
        Arrays.sort(people, Comparator.comparing(Person::getAge));
        for (Person person : people) {
            System.out.println(person);
        }
    }

    static class Person {
        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
}
