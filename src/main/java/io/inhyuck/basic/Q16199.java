/**
 * Date: 2018. 10. 17.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 나이 계산하기
 * description: 만 나이, 세는 나이, 연 나이 계산하기
 * Problem URL: https://www.acmicpc.net/problem/16199
 */

package io.inhyuck.basic;

import java.time.LocalDate;
import java.util.Scanner;

public class Q16199 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate birthday = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        LocalDate nowDate = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

        LocalDate temp = nowDate.withYear(birthday.getYear()); //연도를 동일하게 설정한 임시객체 생성
        //만 나이
        System.out.println(nowDate.getYear() - birthday.getYear() - 1 +
                (temp.isEqual(birthday) || temp.isAfter(birthday) ? 1 : 0)); //생일이거나 이후 날짜면 + 1

        //세는 나이
        System.out.println(nowDate.getYear() - birthday.getYear() + 1);
        //연 나이
        System.out.println(nowDate.getYear() - birthday.getYear());
    }
}
