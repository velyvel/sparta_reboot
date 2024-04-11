package src.com.company.week3.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17086_아기상어 {

    // 입력값(상어위치) 받아올 지도
    static int[][] ocean;
    // 각 칸까지의 최소 거리를 저장할 배열
    static int[][] distance;
    // 시계방향
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1 ,0, 1};
    static int saveCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ocean = new int[N][M];
        distance = new int[N][M];

        Queue<BabyShark> sharkPosition = new ArrayDeque<BabyShark>();


        // 입력
        for(int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int column = 0; column < M; column++ ) {
                ocean[row][column] = Integer.parseInt(st.nextToken());
                distance[row][column] = Integer.MAX_VALUE;

                if(ocean[row][column] == 1) {
                    sharkPosition.add(new BabyShark(row, column));
                    // distance배열에는 상어의 위치가 0로 표시가 되어 있다
                    distance[row][column] = 0;
                }
            }
        }
        // DFS 탐색하는 메서드 만들기
        findSavePoint(N, M, sharkPosition);
        System.out.println(saveCount);
    }

    private static void findSavePoint(int N, int M, Queue<BabyShark> sharkPosition) {
        // 종료조건 : ocean을 다 탐색하면

        while(!sharkPosition.isEmpty()) {
            BabyShark now = sharkPosition.poll();

            for(int i = 0; i < 8; i++) {
                int nextRow = now.row + dx[i];
                int nextColumn = now.column + dy[i];

                // 바다 안에 있고, 아직 방문안한 칸이면?
                if(nextRow >= 0 && nextColumn >= 0 && nextRow < N && nextColumn < M) {
                    if(distance[nextRow][nextColumn] > distance[nextRow][nextColumn] + 1) {
                        distance[nextRow][nextColumn] = distance[now.row][now.column] + 1; // 거리 업데이트
                        sharkPosition.add(new BabyShark(nextRow, nextColumn));
                        saveCount = Math.max(saveCount, distance[nextRow][nextColumn]);
                    }
                }
            }
        }
    }

    // 상어.. 입력값이 일 때의 자리 구하기
    static class BabyShark {
        int row;
        int column;

        public BabyShark(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
