package src.com.company.week2.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 메모리:16592KB 시간:168ms
 * 같은 문자가 있는 경우 땅을 넓혀간다! 라는 생각으로 풀었다
 * 색약이 없는 경우, 색약이 있는 경우를 나누어 dfs 로직 태워 구현하였다.
 * 시간복잡도 : 입력(체스판의 수) + 이동거리의 수(최대 4번) 해서 O(N^2) + O(4N^2) = O(N^2)
 * */

public class BJ_10026_적록색약 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 이차원 배열로 풀기 + dfs로 적록색약 아닌사람 구하고 -> replace로 문자열 바꾸고 구역 구하기
        int N = Integer.parseInt(br.readLine());
        // 이차원배열 선언
        char[][] array = new char[N][N];
        boolean[][] isVisited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<int[]>();

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                array[i][j] = str.charAt(j);
            }
        }

        // 적록색약x 일반배열
        int answer = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!isVisited[i][j]) {
                    showBfs(queue, array, i, j, array[i][j], isVisited);
                    answer++;
                }
            }
        }

        // 적록색약 => R울 G로 replace 안되서 쌩으로 바꿔치기
        // isVisited 초기화 하고 실행
        isVisited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++){
                if(array[i][j] == 'R') {
                    array[i][j] = 'G';
                }
            }
        }

        int answer2 = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++) {
                if(!isVisited[i][j]) {
                    showBfs(queue, array, i, j, array[i][j], isVisited);
                    answer2++;
                }
            }
        }
        System.out.println(answer + " " + answer2);
    }

    private static void showBfs(Queue<int[]> queue, char[][] array,
                                int i, int j, char color, boolean[][] isVisited) {

        // 시계방향을 기준으로 두었음(위, 오른, 아래, 왼)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        // 큐에 시작할 문자 넣어주기
        queue.offer(new int[] {i, j});
        isVisited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            // 위, 아래, 오, 왼
            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                // 배열의 범위를 벗어나는 경우 무시
                if(nx < 0 || nx >= array.length || ny < 0 || ny >= array[0].length)
                    continue;

                // 지금 색깔과 같고 isVisited false 인 곳만 탐색하기
                if(array[nx][ny] == color && !isVisited[nx][ny]) {
                    isVisited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}

