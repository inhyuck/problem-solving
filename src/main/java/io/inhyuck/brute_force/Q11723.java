/**
 * Date: 09/11/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title: 집합
 * description: 비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.
 * add, remove, check, toggle, all, empty
 * Solution Key: bitmask, BitSet
 * Problem URL: https://www.acmicpc.net/problem/11723
 */

package io.inhyuck.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Q11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer;
        StringJoiner result = new StringJoiner("\n");
        MyBitSet bitset = new MyBitSet();
        while (m-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            switch (tokenizer.nextToken()) {
                case "add":
                    bitset.add(Integer.parseInt(tokenizer.nextToken()));
                    break;
                case "remove":
                    bitset.remove(Integer.parseInt(tokenizer.nextToken()));
                    break;
                case "check":
                    result.add(bitset.check(Integer.parseInt(tokenizer.nextToken())));
                    break;
                case "toggle":
                    bitset.toggle(Integer.parseInt(tokenizer.nextToken()));
                    break;
                case "all":
                    bitset.all();
                    break;
                case "empty":
                    bitset.empty();
                    break;
                default:
                    return;
            }
        }
        System.out.println(result.toString());
    }

    /**
     * bitmask 구현
     */
    private static class MyBitSet {
        int s;

        public MyBitSet() {
            this.s = 0;
        }

        public void add(int i) {
            s |= (1 << i);
        }

        public void remove(int i) {
            s &= ~(1 << i);
        }

        public String check(int i) {
            int result = (s & (1 << i));
            return result != 0 ? "1" : "0";
        }

        public void toggle(int i) {
            s ^= (1 << i);
        }

        public void all() {
            s = (1 << 21) - 1 - 1; // 1, 2, ... , 20
        }

        public void empty() {
            s = 0;
        }
    }

    /** java.util.BitSet 이용
    private static class MyBitSet {
        BitSet bitSet;

        public MyBitSet() {
            bitSet = new BitSet();
        }

        public void add(int i) {
            bitSet.set(i);
        }

        public void remove(int i) {
            bitSet.clear(i);
        }

        public String check(int i) {
            return bitSet.get(i) ? "1" : "0";
        }

        public void toggle(int i) {
            bitSet.flip(i);
        }

        public void all() {
            bitSet.set(1, 21);
        }

        public void empty() {
            bitSet.clear();
        }
    }
    */
}
