/**
 * Date: 2018. 9. 30.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 트리의 순회
 * description: n개의 정점을 갖는 이진 트리의 정점에 1부터 n까지의 번호가 중복 없이 매겨져 있다.
 * 이와 같은 이진 트리의 인오더와 포스트오더가 주어졌을 때, 프리오더를 구하는 프로그램을 작성하시오.
 * Problem URL: https://www.acmicpc.net/problem/2263
 */

package io.inhyuck.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q2263 {
    static int[] inorder;
    static int[] postorder;
    static List<Integer> preorder = new ArrayList<>();
    static int[] valueToIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        inorder = new int[n];
        valueToIndex = new int[n + 1];
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(tokenizer.nextToken());
            valueToIndex[inorder[i]] = i;
        }
        tokenizer = new StringTokenizer(reader.readLine());
        postorder = new int[n];
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(tokenizer.nextToken());
        }

        findPreorder(0, n - 1, 0, n - 1);
        preorder.stream().forEach(x -> System.out.print(x + " "));
    }

    private static void findPreorder(int inorderFirst, int inorderLast, int postorderFirst, int postorderLast) {
        if (postorderFirst > postorderLast) {
            return;
        }
        //루트 방문
        int root = postorder[postorderLast];
        preorder.add(root);
//        System.out.println(inorderFirst + " " + inorderLast + " " + postorderFirst + " " + postorderLast);
        int rootIndex = valueToIndex[root];
        int leftNodeSize = rootIndex - inorderFirst;
        //Left 방문
        findPreorder(inorderFirst, rootIndex - 1,
                postorderFirst, postorderFirst + leftNodeSize - 1);
        //Right 방문
        findPreorder(rootIndex + 1, inorderLast,
                postorderFirst + leftNodeSize, postorderLast - 1);
    }
}
