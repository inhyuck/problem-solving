/**
 * Date: 2018. 9. 1.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/skhucode/skhucode-inhyuck
 * Title: 트리 순회
 * Problem: 이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal),
 * 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.
 * URL: https://www.acmicpc.net/problem/1991
 */
package tree;

import java.util.Scanner;

public class Q1991 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Node root = new Node(scanner.next(), new Node(scanner.next()), new Node(scanner.next()));
        for (int i = 0; i < n - 1; i++) {
            Node node = findNode(root, scanner.next());
            node.left = new Node(scanner.next());
            node.right = new Node(scanner.next());
        }
        root.preorder();
        System.out.println();
        root.inorder();
        System.out.println();
        root.postorder();
    }

    private static Node findNode(Node node, String s) {
        if (node == null) {
            return null;
        }
        if (node.data.equals(s)) {
            return node;
        }
        Node findedNode = findNode(node.right, s);
        if (findedNode == null) {
            return findNode(node.left, s);
        }
        return findedNode;
    }

    private static class Node {
        String data;
        Node left;
        Node right;

        public Node(String data) {
            this.data = data;
        }

        public Node(String data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public void preorder() {
            if (this.data.equals(".")) {
                return;
            }
            System.out.print(this.data);
            if (this.left != null) {
                left.preorder();
            }
            if (this.right != null) {
                right.preorder();
            }
        }

        public void inorder() {
            if (this.data.equals(".")) {
                return;
            }
            if (this.left != null) {
                left.inorder();
            }
            System.out.print(this.data);
            if (this.right != null) {
                right.inorder();
            }
        }

        public void postorder() {
            if (this.data.equals(".")) {
                return;
            }
            if (this.left != null) {
                left.postorder();
            }
            if (this.right != null) {
                right.postorder();
            }
            System.out.print(this.data);
        }
    }
}
