package src.com.company.week2.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_24479_깊이우선탐색1 {
    /**
     * 메모리 초과
     * */
    // 방문 순서를 저장할 배열
    static int[] order;
    static int count = 1; // 방문하는 순서를 나타내는 변수, 처음 방문하는 노드는 1부터 시작

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        // 정점의 수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 간선의 수
        int M = Integer.parseInt(stringTokenizer.nextToken());
        // 시작 정점
        int R = Integer.parseInt(stringTokenizer.nextToken());

        // 인접행렬 그래프 그리기
        int[][] graph = new int[N + 1][N + 1];
        // 방문 했는지 확인
        boolean[] isVisited = new boolean[N + 1];
        // 방문 순서 저장
        order = new int[N + 1];

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        showDfs(graph, isVisited, R);

        // 모든 노드에 대해 방문 순서 출력
        for (int i = 1; i < order.length; i++) {
            System.out.println(order[i]);
        }
    }

    private static void showDfs(int[][] graph, boolean[] isVisited, int R) {
        Stack<Integer> stack = new Stack<>();
        // 시작 정점을 스택에 푸시
        stack.push(R);
        //시작 정점 방문표시
        isVisited[R] = true;

        while (!stack.isEmpty()) {
            // 현재 방문하는 노드
            int now = stack.pop();
            order[now] = count++; // 현재 노드의 방문 순서를 기록

            // 출력을 위해.. 높은 번호부터 낮은번호 순으로 탐색
            for (int i = graph.length - 1; i >= 1; i--) { // 역순으로 순회해야 문제의 요구사항에 맞는 순서대로 방문 순서가 기록됨
                // i번 노드와 연결되어 있고 아직 방문 전이라면
                if (graph[now][i] == 1 && !isVisited[i]) {
                    // i번 벙문표사
                    isVisited[i] = true;
                    // 스택에 값 넣기
                    stack.push(i);
                }
            }
        }
    }
}
