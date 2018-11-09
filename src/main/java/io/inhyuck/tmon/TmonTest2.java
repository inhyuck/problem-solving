/**
 * Date: 08/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: Tmon Test 2
 * description:
 * int 형 숫자를 하나 입력받아 1인 비트 개수를 세는 매서드를 작성하세요.
 * 단 Integer.toBinaryString 또는 Interger.toString 함수를 사용하지 않고 구현합니다.
 * Ex) 입력 7 -> 0111
 * 결과 : 3
 * Solution Key: -
 */

package io.inhyuck.tmon;

public class TmonTest2 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(countBits(i) == Integer.bitCount(i));
        }
    }

    public static int countBits(int number){
        if (number < 0) {
            return -1;
        }
        if (number == 0 || number == 1) {
            return number;
        }
        return number % 2 + countBits(number / 2);
    }
}
