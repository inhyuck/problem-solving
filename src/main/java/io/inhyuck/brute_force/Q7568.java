/**
 * Date: 2018. 10. 12.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 덩치
 * description: 덩치 순위 매기기 - 문제링크 참조
 * Problem URL: https://www.acmicpc.net/problem/7568
 */

package io.inhyuck.brute_force;

import java.util.Arrays;
import java.util.Scanner;

public class Q7568 {
    static int n;
    static Person[] people;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        people = new Person[n];
        for (int i = 0; i < n; i++) {
            people[i] = new Person(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.stream(people).forEach(person -> {
            System.out.print(computeRank(person) + " ");
        });
    }

    private static int computeRank(Person person) {
        int count = 0; //덩치가 더 큰 사람들 count
        for (int i = 0; i < n; i++) {
            if (Person.compare(people[i], person) > 0) {
                count++;
            }
        }
        return count + 1;
    }

    static class Person {
        int weight;
        int height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        static int compare(Person p1, Person p2) {
            if (p1.weight > p2.weight && p1.height > p2.height) {
                return 1;
            }
            if (p1.weight < p2.weight && p1.height < p2.height) {
                return -1;
            }
            return 0;
        }
    }
}
