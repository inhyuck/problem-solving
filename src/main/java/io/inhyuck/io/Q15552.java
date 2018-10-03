/**
 * Date: 2018. 10. 2.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 빠른 A+B
 * description: -
 * Problem URL: https://www.acmicpc.net/problem/15552
 */

package io.inhyuck.io;

import java.io.*;

public class Q15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        String[] temp;
        while (t-- > 0) {
            temp = reader.readLine().split(" ");
            writer.write(Integer.toString(Integer.parseInt(temp[0]) + Integer.parseInt(temp[1])) + "\n");
        }
        writer.flush();
    }
}
