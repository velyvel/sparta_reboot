package src.com.company.week2.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_24479_깊이우선탐색1_2 {
    /**
     * 메모리 : 98508KB, 시간 1912ms
     * 처음에 이중배열[][]로 풀었다가 메모리 초과
     * 자료형을 ArrayList<<ArrayList<Integer>>로 바꿔 톧과, 그래도 시간이 오래걸림..
     * 1 -> 2-> 3
     *     |  /
     *      4
     *      이런 구조
     * */

    // 방문 순서를 저장할 배열 -> 다 풀고와서 생각해보니.. isVisited 를 order 대신 써도 되었겠다..
        static int[] order;
        static int count = 1; // 방문 순서 카운트

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());
            int R = Integer.parseInt(stringTokenizer.nextToken());

            // 인접 리스트 초기화
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) { // 정점의 수만큼 ArrayList를 추가
                graph.add(new ArrayList<>());
            }

            boolean[] isVisited = new boolean[N + 1];
            order = new int[N + 1];

            for (int i = 0; i < M; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());

                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            // 각 정점별로 연결된 정점을 오름차순으로 정렬
            for (ArrayList<Integer> list : graph) {
                Collections.sort(list);
            }

            showDfs(graph, isVisited, R, N);

            for (int i = 1; i < order.length; i++) {
                System.out.println(order[i]);
            }
        }

        private static void showDfs(ArrayList<ArrayList<Integer>> graph, boolean[] isVisited, int R, int N) {
            Stack<Integer> stack = new Stack<>();
            stack.push(R);

            while (!stack.isEmpty()) {
                int now = stack.pop();
                if (!isVisited[now]) {
                    isVisited[now] = true;
                    order[now] = count++; // 현재 노드의 방문 순서를 기록

                    // 스택에 현재 노드와 연결된 노드들을 역순으로 넣기
                    ArrayList<Integer> nodes = graph.get(now);
                    for (int i = nodes.size() - 1; i >= 0; i--) {
                        int nextNode = nodes.get(i);
                        if (!isVisited[nextNode]) {
                            stack.push(nextNode);
                        }
                    }
                }
            }
        }
    }

