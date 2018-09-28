/**
 * Date: 2018. 9. 28.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 병든 나이트
 * Problem: 체스판의 크기가 주어졌을 때, 병든 나이트가 방문할 수 있는 칸의 최대 개수를 출력하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/1783
 */

package io.inhyuck.greedy;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

public class Q1783Test {
    @Test
    public void solutionTest() {
        assertThat(Q1783.solution(100, 50), is(48));
        assertThat(Q1783.solution(1, 1), is(1));
        assertThat(Q1783.solution(17, 5), is(4));
        assertThat(Q1783.solution(2, 4), is(2));
    }
}
