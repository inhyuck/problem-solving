/**
 * Date: 02/12/2018
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/problem-solving
 * Title:
 * description:
 * Solution Key:
 * Problem URL: https://www.acmicpc.net/problem/
 * Test Code URL: htpps://github.com/inhyuck/algorithm/blob/master/src/test/java/io/inhyuck/pakageName/Q1107TestTest.java
 */

package io.inhyuck.brute_force;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Q1107Test {
    @Test
    public void isPossibleChannelTest() {
        assertThat(Q1107_1.isPossibleChannel(123, new int[]{2}), is(false));
        assertThat(Q1107_1.isPossibleChannel(123, new int[]{4, 5, 6}), is(true));
        assertThat(Q1107_1.isPossibleChannel(123, new int[]{0}), is(true));
        assertThat(Q1107_1.isPossibleChannel(123, new int[]{3, 4}), is(false));
        assertThat(Q1107_1.isPossibleChannel(123, new int[]{2, 5}), is(false));
        assertThat(Q1107_1.isPossibleChannel(0, new int[]{0, 1}), is(false));
        assertThat(Q1107_1.isPossibleChannel(90999, new int[]{0, 1}), is(false));
    }

}
