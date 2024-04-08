package src.com.company.week2.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 메모리:65888KB 시간:308ms
 * 나이트가 움직일 수 있는 경로를 dx, dy에 담고 BFS 탐색, 이동 가능하면 count를 더해주면서 풀었다.
 * 시간복잡도 : 입력(체스판의 수) + 이동거리의 수(최대 8번) 해서 O(N^2) + O(8N^2) = O(N^2)
 * 시간복잡도 계산 어렵네요..
 * */
public class BJ_7562_나이트의이동 {
    // 오른쪽 위 기준 시계 방향
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스의 수
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            // 체스판의 수
            int N = Integer.parseInt(br.readLine());
            // 나이트가 현재 있는 칸
            int[] start = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            // 나이트가 목표로 하는 칸
            int[] target = new int[2];
            st = new StringTokenizer(br.readLine());
            target[0] = Integer.parseInt(st.nextToken());
            target[1] = Integer.parseInt(st.nextToken());

            int count = showBfs(N, start, target);
            System.out.println(count);
        }
    }

    private static int showBfs(int N, int[] start, int[] target) {
        //BFS 시작하면서 초기화 해준다
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        boolean[][] isVisited = new boolean[N][N];
        isVisited[start[0]][start[1]] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                // 현재 위치가 목표 위치와 같으면 탐색 종료 후 이동 횟수 반환 : case3
                if (cur[0] == target[0] && cur[1] == target[1]) {
                    return count;
                }
                // 현재 위치에서 이동 가능한 모든 위치를 탐색, 큐에 추가
                for (int j = 0; j < 8; j++) {
                    // cur : queue 에서 빼낸 현재의 좌표 -> x좌표 y좌표 빼낸거에서 j 만큼 이동시키기!
                    int moveX = cur[0] + dx[j];
                    int moveY = cur[1] + dy[j];

                    // 이동한게 0 ~ 체스판 크기 사이에 있으면 큐에 추가해줌, isVisited 업데이트
                    if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < N && !isVisited[moveX][moveY]) {
                        queue.offer(new int[]{moveX, moveY});
                        isVisited[moveX][moveY] = true;
                    }
                }
            }
            count++;
        }
        // 목표 위치에 도달할 수 없는 경우 : 이건 문제에 안나와있어서 안해도 되는데 불안해서 함
        return -1;
    }
}
