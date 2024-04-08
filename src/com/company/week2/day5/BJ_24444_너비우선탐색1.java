package src.com.company.week2.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_24444_너비우선탐색1 {
    /**
     * 메모리 : 103868KB, 시간: 1888ms
     * */

    static int[] order;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        // 정점의 수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 간선의 수
        int M = Integer.parseInt(stringTokenizer.nextToken());
        // 시작 정점
        int R = Integer.parseInt(stringTokenizer.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean[] isVisited = new boolean[N + 1];
        order = new int[N + 1]; // 각 노드의 방문 순서를 저장할 배열 초기화

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // 출력때문에 오름차순으로 정렬
        for (ArrayList<Integer> list : graph) {
            Collections.sort(list);
        }

        showBfs(graph, isVisited, R, N);
        for (int i = 1; i < order.length; i++) {
            System.out.println(order[i]);
        }

    }

    private static void showBfs(ArrayList<ArrayList<Integer>> graph, boolean[] isVisited, int R, int N) {
        Queue<Integer> queue = new LinkedList<>();
        //Queue<Integer> queue1 = new ArrayDeque<>();
        queue.offer(R);

        while (!queue.isEmpty()) {
           int now = queue.poll();
           if(!isVisited[now]) {
               isVisited[now] = true;
               order[now] = count++;
           }
            for (int nextNode : graph.get(now)) {
                if (!isVisited[nextNode]) {
                    queue.offer(nextNode);
                }
            }
        }

    }
}
