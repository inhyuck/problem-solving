/**
 * Date: 2018. 9. 2.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 트리의 부모 찾기
 * Problem: 루트 없는 트리가 주어진다. 이 때, 트리의 루트를 1이라고 정했을 때,
 * 각 노드의 부모를 구하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/11725
 */
package io.inhyuck.tree;

import java.util.*;

public class Q11725 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int u, v;
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            u = scanner.nextInt();
            v = scanner.nextInt();
            list[u].add(v);
            list[v].add(u);
        }
        boolean[] check = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        int[] parentList = new int[n + 1];
        queue.offer(1);
        check[1] = true;
        while (!queue.isEmpty()) {
            int item = queue.poll();
            for (int a : list[item]) {
                if (check[a] == false) {
                    check[a] = true;
                    parentList[a] = item;
                    queue.offer(a);
                }
            }
        }
        for (int i = 2; i < n + 1; i++) {
            System.out.println(parentList[i]);
        }
    }
}

///**
// * Date: 2018. 9. 2.
// * Author: inhyuck | https://github.com/inhyuck
// * Solution URL: https://github.com/skhucode/skhucode-inhyuck
// * Title: 트리의 부모 찾기
// * Problem: 루트 없는 트리가 주어진다. 이 때, 트리의 루트를 1이라고 정했을 때,
// * 각 노드의 부모를 구하는 프로그램을 작성하시오.
// * URL: https://www.acmicpc.net/problem/11725
// */
//package tree;
//
//import java.util.*;
//
//public class Q11725 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int u, v;
//        ArrayList<Integer>[] list = new ArrayList[n + 1];
//        for (int i = 0; i < n + 1; i++) {
//            list[i] = new ArrayList<>();
//        }
//        for (int i = 0; i < n - 1; i++) {
//            u = scanner.nextInt();
//            v = scanner.nextInt();
//            list[u].add(v);
//            list[v].add(u);
//        }
//        boolean[] check = new boolean[n + 1];
//        Queue<Integer> queue = new LinkedList<>();
//        Map<Integer, Integer> parentList = new HashMap();
//        queue.offer(1);
//        check[1] = true;
//        while (!queue.isEmpty()) {
//               int item = queue.poll();
//               for (int a : list[item]) {
//                   if (check[a] == false) {
//                       check[a] = true;
//                       parentList.put(a, item);
//                       queue.offer(a);
//                   }
//               }
//        }
//        for (int index : parentList.keySet()) {
//            System.out.println(parentList.get(index));
//        }
//    }
//}
