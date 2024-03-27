package com.company.day0;

import java.util.Scanner;
/** 트리 순회 : 전위, 중위, 후위 순회 구현 없
 * 입력 : 노드 개수 / A B C B D .(자식 없음)  C E F E .(E끝) . F . G D . . G . .
 * A -> B -> D .(없음)
 *   -> C -> E ->.
 *             -> F -> G .
 *
 * 코딩하기 쉽게 풀어놓기
 * A left : B, right : C
 * B left : D, right : x
 * C left : E, right : F
 * E left : x, right : x
 * F left : x, right : G
 * D left : x, right : x
 * G left : x, right : x
 *
 * **/
// 매인 실행한다
public class BJ_1997 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //어떤 순회를 할껀지 인스턴스
        Tree tree = new Tree();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            // 현재 노드
            char nodeName = sc.next().charAt(0);
            // 왼쪽 자식
            char left = sc.next().charAt(0);
            // 오른쪽 자식
            char right = sc.next().charAt(0);
            tree.createNode(nodeName, left, right);
        }

        // 출력에서 어려웠다.. 호출 후 개행해주기

        tree.preOrder(tree.root);
        System.out.println();

        tree.inOrder(tree.root);
        System.out.println();

        tree.postOrder(tree.root);
    }

}

// 노드 정의하는 클래스
class Node {

    // A ~ G 까지 정의
    char nodeName;
    // 방향 정의
    Node left;
    Node right;

    Node(char nodeName) {
        this.nodeName = nodeName;
    }
}

//트리 만들고 전위, 중위, 후위에 따른 메서드 만들기
class Tree {

    // 시작점 : 전위 : A, 중위 : D, 후위: D
    public Node root;

    // 첫 노드 생성
    public void createNode(char nodeName, char leftName, char rightName) {

        // 루트 없으면 만들어주기
        if (root == null) {
            root = new Node(nodeName);
            root.left = new Node(leftName);
            root.right = new Node(rightName);
            // 이미 루트 정해지면 ? 탐색 시작
        } else
            // 바로 아래 있는 매서드
            searchNode(root, nodeName, leftName, rightName);
    }

    // 위에서 호출 -> 특정 노드를 찾아서 왼/오른쪽 지정해주기
    public void searchNode(Node node, char nodeName, char leftData, char rightData) {

        // 노드가 없음(해당 노드 없다 : 리턴시켜버)
        if (node == null)
            return;
        // 노드 찾았다 -> 자식들 있는지 지정
        if (node.nodeName == nodeName) {
            node.left = new Node(leftData);
            node.right = new Node(rightData);
            // 재귀로 하위 노드 있나 오른쪽, 왼쪽 가면서 탐색하기
        } else {
            searchNode(node.left, nodeName, leftData, rightData);
            searchNode(node.right, nodeName, leftData, rightData);
        }
    }

    // 전위 순회: 루트 -> 왼쪽 -> 오른쪽 : ABDCEFG
    public void preOrder(Node node) {
        // . 아니면 시작!
        if (node.nodeName != '.') {
            //System.out.println(" 전위 : 나 지금 어디있니 ? " + node.nodeName);
            System.out.print(node.nodeName);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 중위 순회: 왼쪽 -> 루트 -> 오른쪽
    public void inOrder(Node node) {
        if (node.nodeName != '.') {
            inOrder(node.left);
            //System.out.println("중위 : 나 지금 어디있니 ? " + node.nodeName);
            System.out.print(node.nodeName);
            inOrder(node.right);
        }
        //System.out.println("======");
    }

    // 후위 순회: 왼쪽->오른쪽->루트
    public void postOrder(Node node) {
        if (node.nodeName != '.') {
//            System.out.print("후 : 나 지금 어디있니 ? " + node.nodeName);
            postOrder(node.left);
            postOrder(node.right);
            //System.out.println("후 : 나 지금 어디있니 ? " + node.nodeName);
            System.out.print(node.nodeName);

        }
    }
}


    //A B C B D . C E F E . . F . G D . . G . .